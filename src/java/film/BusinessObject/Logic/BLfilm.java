/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import XML.XMLElement;
import XML.XMLfile;
import data.interfaces.db.Filedata;
import db.SQLTqueue;
import db.SQLparameters;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IFilm;
import film.logicentity.Film;
import film.BusinessObject.table.Bfilm;
import film.conversion.entity.EMfilm;
import film.conversion.xml.XMLFilm;
import film.conversion.xml.XMLPhoto;
import film.conversion.xml.XMLSubject;
import film.conversion.xml.XMLTree7subject;
import film.entity.pk.FilmPK;
import film.interfaces.entity.pk.IFilmPK;
import film.logic.Userprofile;
import film.logicentity.GPSTrackpoint;
import film.logicentity.Photo;
import film.logicentity.Subject;
import film.logicentity.Tree7subject;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import general.log.ProjectLog;
import graphic.jpeg.Graphicfile;
import graphic.jpeg.Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jdom2.Element;
import text.Conversion;

/**
 * @author Franky Laseure
 */
public class BLfilm extends Bfilm {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data

    //Photo directory on server
    public final static String PHOTOSUBROOT = "photos" + File.separator;

    //root backup directory
    private static final String backupdir = "/media/serverbackup/autobackup/";
    //private static final String backupdir = "/home/pelgrim/autobackup/";

    private Object[][] publiconly = { { "public", true } };

    public BLfilm(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLfilm(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getFilms(Userprofile userprofile) throws DBException {
        if(userprofile!=null && userprofile.privateaccess())
            return this.getEntities(EMfilm.SQLSelectAll);
        else {
            SQLparameters parameters = new SQLparameters(publiconly);
            return this.getEntities(EMfilm.SQLSelectAll4Public, parameters);
        }
    }

    public ArrayList getFilms4Edit(Userprofile userprofile) throws DBException {
        ArrayList films4edit = new ArrayList();
        if(userprofile!=null && userprofile.isEditor()) {
            films4edit = getFilms(userprofile);
        }
        return films4edit;
    }

    public Film getFilm(Userprofile userprofile, IFilmPK filmPK) throws DBException {
        Film returnfilm = super.getFilm(filmPK);
        if(!userprofile.privateaccess() && !returnfilm.getPublic()) returnfilm = null;
        return returnfilm;
    }

    public static StringBuffer getRootImagePath(IFilmPK filmPK) {
        StringBuffer filepath = new StringBuffer(PHOTOSUBROOT);
        String filmid = Film.getDirectoryName(filmPK);
        filepath.append(filmid).append(File.separator);
        return filepath;
    }

    public ArrayList getGroups() throws DBException {
        //get all filmgroups
        ArrayList filmgroups = this.getEntities(EMfilm.SQLSelectGroups);
        //filter first 3 characters and put them in hashmap
        HashMap groupshashmap = new HashMap();
        ArrayList groups = new ArrayList();
        Film film;
        String groupid;
        for(int i=0; i<filmgroups.size(); i++) {
            film = (Film)filmgroups.get(i);
            groupid = film.getPrimaryKey().getId().substring(0, 3);
            //put found groupid's in ArrayList
            if(!groups.contains(groupid)) {
                groups.add(groupid);
            }
            groupshashmap.put(groupid, groupid);
        }
        return groups;
    }

    @Override
    public void insertFilm(SQLTqueue transactionqueue, IFilm film) throws DBException, DataException {
        if(this.getFilm(film.getPrimaryKey())==null) {
            super.insertFilm(transactionqueue, film);
        }
    }
    
    public void updateFilm(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film, ArrayList subjects) throws DBException, DataException {
        //check if user is allowed to edit
        if(userprofile.isEditor()) {
            //check if user is allowed to manage this film (privateaccess check)
            if(getFilm(userprofile, film.getPrimaryKey())!=null) {
                updateFilm(transactionqueue, film);
                BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
                blfilmsubjects.linkFilm_with_Subjects(transactionqueue, film.getPrimaryKey(), subjects);
            }
        }
    }

    public void updateFilm(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film) throws DBException, DataException {
        //check if user is allowed to edit
        if(userprofile.isEditor()) {
            //check if user is allowed to manage this film (privateaccess check)
            if(getFilm(userprofile, film.getPrimaryKey())!=null) {
                film.setBackup(true);
                updateFilm(transactionqueue, film);
            }
        }
    }

    public void updateFilm_LoadJPGproperties(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film) throws DBException, CustomException {
        try {
            //check if user is allowed to edit
            if(userprofile.isEditor()) {
                //check if user is allowed to manage this film (privateaccess check)
                if(getFilm(userprofile, film.getPrimaryKey())!=null) {
                    BLphoto blphoto = new BLphoto(this);
                    BLphototags blphototags = new BLphototags(this);
                    ArrayList photos = blphoto.getPhotos4photo_film(userprofile.isEditor(), film.getPrimaryKey(), false);
                    Iterator<Photo> photosI = photos.iterator();
                    Photo photo;
                    Filedata filedata;
                    while(photosI.hasNext()) {
                        photo = photosI.next();
                        //check if phototags are present
                        if(blphototags.getPhototagss4photo(photo.getPrimaryKey()).size()==0) {
                            //not, so get them from the jpg file
                            filedata = blphoto.getRootfiledata(photo.getPrimaryKey());
                            if(filedata==null) {
                                filedata = blphoto.getSmallfiledata(photo.getPrimaryKey());
                            }
                            if(filedata!=null) {
                                Graphicfile gf = null;
                                gf = filedata.getGraphicfile();
                                Tag datetimetag = blphototags.findTag(gf.getMetadataTaglist(), Tag.DATETIMEORIGINAL);
                                if(datetimetag!=null) {
                                    photo.setPhotodate(datetimetag.getDateValue());
                                    photo.setPhototime(datetimetag.getTimeValue());
                                    blphoto.updatePhoto(transactionqueue, photo);
                                }
                                blphototags.insertGraphicfileMetatags(transactionqueue, gf, photo);
                            }
                        }
                    }
                }
            }
        }
        catch(IOException e) {
            throw new DataException(e.getMessage());
        }
    }

    public void updateFilm_LoadGPSproperties(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film, ArrayList<GPSTrackpoint> gpstrackpoints) throws DBException, CustomException {
        //check if user is allowed to edit
        if(userprofile.isEditor()) {
            //check if user is allowed to manage this film (privateaccess check)
            if(getFilm(userprofile, film.getPrimaryKey())!=null) {
                BLphoto blphoto = new BLphoto(this);
                ArrayList photos = blphoto.getPhotos4photo_film(userprofile.isEditor(), film.getPrimaryKey(), false);
                Iterator<Photo> photosI = photos.iterator();
                Photo photo;
                long photodatetime;

                int gpsarraypos = 1;
                int gpsarraylength = gpstrackpoints.size();
                GPSTrackpoint gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
                GPSTrackpoint gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
                GPSTrackpoint gpstrackpoint4photo;
                while(photosI.hasNext()) {
                    photo = photosI.next();
                    photodatetime = photo.getPhotodate().getTime() + photo.getPhototime().getTime();
                    //check if photo has geographical information
                    if(photo.getLocation()==null) {
                        //not, so get them from the gps array
                        while(gpstrackpoint1.getDate().getTime()>photodatetime && gpsarraypos>1) {
                            gpsarraypos--;
                            gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
                            gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
                        }
                        while(gpstrackpoint2.getDate().getTime()<photodatetime && gpsarraypos<gpsarraylength) {
                            gpsarraypos++;
                            gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
                            gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
                        }
                        //found datetime between 2 gps points
                        if(gpstrackpoint1.getDate().getTime()<=photodatetime && gpstrackpoint2.getDate().getTime()>=photodatetime) {
                            //find nearest point in time
                            gpstrackpoint4photo = gpstrackpoint1;
                            if(photodatetime-gpstrackpoint1.getDate().getTime() < gpstrackpoint2.getDate().getTime()-photodatetime) {
                                gpstrackpoint4photo = gpstrackpoint2;
                            }
                            photo.setLocation(gpstrackpoint4photo.getPoint());
                            photo.setReversegeocode(this.reversegeocode(gpstrackpoint4photo.getPoint().getY(), gpstrackpoint4photo.getPoint().getX()));
                            blphoto.updateGeolocation(transactionqueue, photo);
                        }
                    }
                }
            }
        }
    }

    private static final String urlreversegeocode = "http://maps.googleapis.com/maps/api/geocode/json?latlng=:lat:,:lng:&sensor=false";

    public String reversegeocode(double lat, double lng) {        
        String url = urlreversegeocode;
        url = Conversion.replaceAll(url, ":lat:", String.valueOf(lat));
        url = Conversion.replaceAll(url, ":lng:", String.valueOf(lng));
        return request(url);
    }
    
    private static String CHARSET = "ISO-8859-1,utf-8;q=0.7,*;q=0.7";
    private static String CONTENT_TYPE = "text/xml;charset=" + CHARSET;    
    
    public String request(String url) {
        return request(url, null);
    }
    
    public String request(String url, String content) {
        String returnstring = "";
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", CONTENT_TYPE);
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Accept", "*/*");
            if(content!=null) {
                PrintWriter pw = new PrintWriter(connection.getOutputStream());  
                pw.write(content);  
                pw.close();            }
            InputStream response = connection.getInputStream();
            InputStreamReader input = new InputStreamReader(response);
            final int CHARS_PER_PAGE = 5000; //counting spaces
            final char[] buffer = new char[CHARS_PER_PAGE];
            StringBuilder output = new StringBuilder(CHARS_PER_PAGE);
            try {
                for(int read = input.read(buffer, 0, buffer.length);
                        read != -1;
                        read = input.read(buffer, 0, buffer.length)) {
                    output.append(buffer, 0, read);
                }
            } 
            catch (IOException ignore) { }
            returnstring = output.toString();
        }
        catch(MalformedURLException e) {
        }
        catch(IOException e) {
        }
        return returnstring;
    }

    public void backupPhoto(SQLTqueue transactionqueue, String senderobject, IFilmPK filmpk) throws DBException, CustomException {
        ProjectLog log = new ProjectLog(this);
        BLphoto blphoto = new BLphoto(this);
        Film film = getFilm(filmpk);
        ArrayList photobackups = blphoto.getPhotos4photo_film_imagebackup(filmpk);
        if(photobackups.size()>0) {
            Photo photo = (Photo)photobackups.get(0);
            blphoto.backupImages(transactionqueue, film, photo, backupdir);
        } else {
            photobackups = blphoto.getPhotos4photo_film_backup(filmpk);
            if(photobackups.size()>0) {
                ArrayList photos = blphoto.getPhotos4photo_film(true, filmpk, false);
                Photo photo;
                Subject subject;
                BLsubject blsubject = new BLsubject(this);
                BLtree7subject bltree7subject = new BLtree7subject(this);
                ArrayList tree7subjects;
                Tree7subject tree7subject;

                //create XML
                XMLfile filmxml = new XMLfile();
                //filename
                String dirname = backupdir + this.getRootImagePath(filmpk);
                File dir = new File(dirname);
                if(!dir.exists()) dir.mkdirs();
                String xmlfilename = dirname + filmpk.getId() +  ".xml";
                File xmlfile = new File(xmlfilename);
                filmxml.Replace(xmlfilename);

                filmxml.initialize("properties", "");
                Element rootelement = filmxml.getDocument().getRootElement();
                //XML Film properties
                Element filmselement = XMLElement.newContent("film", "");
                XMLFilm.addXML(filmselement, film);
                rootelement.addContent(filmselement);
                //XML Film Subjects
                Element subjectselement = XMLElement.newContent("subjects", "");
                filmselement.addContent(subjectselement);
                ArrayList subjects = blsubject.getSubjects(filmpk);
                Element filmsubjectelement;
                for(int i=0; i<subjects.size(); i++) {
                    subject = (Subject)subjects.get(i);
                    //XML subject properties
                    filmsubjectelement = XMLElement.newContent("subject", "");
                    XMLSubject.addXML(filmsubjectelement, subject);
                    subjectselement.addContent(filmsubjectelement);                        
                }

                //XML photos
                Element photoelements = XMLElement.newContent("photos", "");
                rootelement.addContent(photoelements);
                Element photoelement;
                Element photosubjectelement;
                Element tree7subjectselement;
                Element phototree7subjectelement;
                for(int i=0; i<photos.size(); i++) {
                    photo = (Photo)photos.get(i);
                    //XML photo properties
                    photoelement = XMLElement.newContent("photo", "");
                    XMLPhoto.addXML(photoelement, photo);
                    photoelements.addContent(photoelement);

                    //XML Photo Subjects
                    subjectselement = XMLElement.newContent("subjects", "");
                    photoelement.addContent(subjectselement);
                    subjects = blsubject.getSubjects(photo.getPrimaryKey());
                    for(int s=0; s<subjects.size(); s++) {
                        subject = (Subject)subjects.get(s);
                        //XML subject properties
                        photosubjectelement = XMLElement.newContent("subject", "");
                        XMLSubject.addXML(photosubjectelement, subject);
                        subjectselement.addContent(photosubjectelement);                        
                    }

                    tree7subjectselement = XMLElement.newContent("tree7subjects", "");
                    photoelement.addContent(tree7subjectselement);
                    tree7subjects = bltree7subject.getTree7subjects(photo.getPrimaryKey());
                    for(int t=0; t<tree7subjects.size(); t++) {
                        tree7subject = (Tree7subject)tree7subjects.get(t);
                        //XML subject properties
                        phototree7subjectelement = XMLElement.newContent("tree7subject", "");
                        XMLTree7subject.addXML(phototree7subjectelement, tree7subject);
                        tree7subjectselement.addContent(phototree7subjectelement);                        
                    }
                }
                try {
                    filmxml.Write();
                }
                catch(FileNotFoundException e) {
                    throw new CustomException(e);
                }
                catch(IOException e) {
                    throw new CustomException(e);
                }
                blphoto.setBackedup(transactionqueue, senderobject, filmpk);
            }
        }
    }
    
    public ArrayList<String> Checkbackup() throws DBException, CustomException {
        ArrayList<String> list = new ArrayList();
        BLphoto blphoto = new BLphoto(this);
        Iterator<film.logicentity.Film> filmsI = getFilms().iterator();
        Iterator<film.logicentity.Photo> photoI;
        film.logicentity.Film film;
        film.logicentity.Photo photo;
        String backuppath;
        String backupfullname;
        File backupfile;
        while(filmsI.hasNext()) {
            film = filmsI.next();
            photoI = blphoto.getPhotos4film(film.getPrimaryKey()).iterator();
            while(photoI.hasNext()) {
                photo = photoI.next();
                backuppath = backupdir + getRootImagePath(film.getPrimaryKey()).toString() + "/";
                backupfullname = backuppath + blphoto.getFilename(photo.getPrimaryKey());
                backupfile = new File(backupfullname);
                if(!backupfile.exists()) {
                    list.add(backupfullname);
                }
            }
        }        
        return list;
    }
}
