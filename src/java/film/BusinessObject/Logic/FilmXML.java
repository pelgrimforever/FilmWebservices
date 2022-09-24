/**
 * @author Franky Laseure
 */
package film.BusinessObject.Logic;

import XML.XMLElement;
import XML.XMLfile;
import db.SQLreader;
import film.conversion.xml.XMLFilm;
import film.conversion.xml.XMLPhoto;
import film.conversion.xml.XMLSubject;
import film.conversion.xml.XMLTree7subject;
import film.entity.pk.FilmPK;
import film.logicentity.Film;
import film.logicentity.Photo;
import film.logicentity.Subject;
import film.logicentity.Tree7subject;
import general.exception.DBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.jdom2.Element;

public class FilmXML {

    private BLphoto blphoto;
    private BLphototags blphototags;
    private BLsubject blsubject;
    private BLtree7subject bltree7subject;
    
    public FilmXML(SQLreader sqlreader) {
        blphoto = new BLphoto(sqlreader);
        blphototags = new BLphototags(sqlreader);
        blsubject = new BLsubject(sqlreader);
        bltree7subject = new BLtree7subject(sqlreader);
    }
    
    public void export_backup_to_xml(Film film, String backupdir, StringBuffer rootimagepath) throws DBException, FileNotFoundException, IOException {
        FilmPK filmPK = film.getPrimaryKey();
        XMLfile filmxml = create_film_xmlfile(filmPK, backupdir + rootimagepath);
        Element rootelement = filmxml.getDocument().getRootElement();
        Element filmselement = film_xml_add_film_properties(film, rootelement);
        Element subjectselement = film_xml_add_film_subjects(filmselement, film);
        Element photoelements = film_xml_add_photos(rootelement, film);
        filmxml.Write();
    }
    
    private XML.XMLfile create_film_xmlfile(FilmPK filmPK, String dirname) {
        XML.XMLfile filmxml = new XMLfile();
        File dir = new File(dirname);
        if(!dir.exists()) dir.mkdirs();
        String xmlfilename = dirname + filmPK.getId() +  ".xml";
        File xmlfile = new File(xmlfilename);
        filmxml.Replace(xmlfilename);
        filmxml.initialize("properties", "");
        return filmxml;
    }
    
    private Element film_xml_add_film_properties(Film film, Element rootelement) throws DBException {
        Element filmselement = XMLElement.newContent("film", "");
        XMLFilm.addXML(filmselement, film);
        rootelement.addContent(filmselement);
        return filmselement;
    }

    private Element film_xml_add_film_subjects(Element filmselement, Film film) throws DBException {
        Element subjectselement = XMLElement.newContent("subjects", "");
        filmselement.addContent(subjectselement);
        ArrayList<Subject> subjects = blsubject.getSubjects(film.getPrimaryKey());
        for(Subject subject: subjects)
            film_xml_add_film_subjects_subjectproperties(subject, subjectselement);
        return subjectselement;
    }

    private void film_xml_add_film_subjects_subjectproperties(Subject subject, Element subjectselement) {
        Element filmsubjectelement = XMLElement.newContent("subject", "");
        XMLSubject.addXML(filmsubjectelement, subject);
        subjectselement.addContent(filmsubjectelement);
    }

    private Element film_xml_add_photos(Element rootelement, Film film) throws DBException {
        boolean loadthumbnails = false;
        boolean function_hasprivateaccess = true;
        
        Element photoelements = XMLElement.newContent("photos", "");
        rootelement.addContent(photoelements);
        ArrayList<Photo> photos = blphoto.getPhotos4photo_film(function_hasprivateaccess, film.getPrimaryKey(), loadthumbnails);
        for(Photo photo: photos)
            film_xml_add_photo(photo, photoelements);
        return photoelements;
    }

    private void film_xml_add_photo(Photo photo, Element photoelements) throws DBException {
        Element photoelement = film_xml_add_photo_properties(photo, photoelements);
        film_xml_add_photo_tree7subjects(photoelement, photo);
    }

    private Element film_xml_add_photo_properties(Photo photo, Element photoelements) {
        Element photoelement = XMLElement.newContent("photo", "");
        XMLPhoto.addXML(photoelement, photo);
        photoelements.addContent(photoelement);
        return photoelement;
    }

    private void film_xml_add_photo_tree7subjects(Element photoelement, Photo photo) throws DBException {
        Element phototree7subjectelement;
        Element tree7subjectselement = XMLElement.newContent("tree7subjects", "");
        photoelement.addContent(tree7subjectselement);
        ArrayList<Tree7subject> tree7subjects = bltree7subject.getTree7subjects(photo.getPrimaryKey());
        for(Tree7subject tree7subject: tree7subjects)
            film_xml_add_photo_tree7subject(tree7subject, tree7subjectselement);
    }

    private void film_xml_add_photo_tree7subject(Tree7subject tree7subject, Element tree7subjectselement) {
        Element phototree7subjectelement = XMLElement.newContent("tree7subject", "");
        XMLTree7subject.addXML(phototree7subjectelement, tree7subject);
        tree7subjectselement.addContent(phototree7subjectelement);
    }
    
}
