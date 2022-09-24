/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import XML.XMLElement;
import XML.XMLfile;
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
import film.interfaces.entity.pk.IFilmPK;
import film.logic.Userprofile;
import film.logicentity.Photo;
import film.logicentity.Subject;
import film.logicentity.Tree7subject;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import general.log.ProjectLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jdom2.Element;
import request.HTTPrequest;
import text.Conversion;

public class BLfilm extends Bfilm {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data

    //Photo directory on server
    public final static String PHOTOSUBROOT = "photos" + File.separator;

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
        else
            return getFilms_public();
    }

    private ArrayList getFilms_public() throws DBException {
        SQLparameters parameters = new SQLparameters(publiconly);
        return this.getEntities(EMfilm.SQLSelectAll4Public, parameters);
    }

    public ArrayList getFilms4Edit(Userprofile userprofile) throws DBException {
        ArrayList films4edit = new ArrayList();
        if(userprofile!=null && userprofile.isEditor())
            films4edit = getFilms(userprofile);
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

    private HashMap groupshashmap;
    
    public ArrayList<String> getGroups() throws DBException {
        ArrayList<Film> filmgroups = this.getEntities(EMfilm.SQLSelectGroups);
        //filter first 3 characters and put them in hashmap
        groupshashmap = new HashMap();
        ArrayList<String> groups = new ArrayList<>();
        String groupid;
        for(Film film: filmgroups)
            getGroups_add_uniquegroup(film, groups);
        return groups;
    }

    private void getGroups_add_uniquegroup(Film film, ArrayList<String> groups) {
        String groupid;
        groupid = film.getPrimaryKey().getId().substring(0, 3);
        if(!groups.contains(groupid))
            groups.add(groupid);
        groupshashmap.put(groupid, groupid);
    }

    @Override
    public void insertFilm(SQLTqueue transactionqueue, IFilm film) throws DBException, DataException {
        if(this.getFilm(film.getPrimaryKey())==null) {
            super.insertFilm(transactionqueue, film);
        }
    }

    public boolean isAuthorised_for_edit(Userprofile userprofile, IFilm film) throws DBException {
        return userprofile.isEditor() && getFilm(userprofile, film.getPrimaryKey())!=null;
    }   
    
    public void updateFilm(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film, ArrayList subjects) throws DBException, DataException {
        if(isAuthorised_for_edit(userprofile, film))
            updateFilm_and_subjects(transactionqueue, film, subjects);
    }

    private void updateFilm_and_subjects(SQLTqueue transactionqueue, IFilm film, ArrayList subjects) throws DataException, DBException {
        updateFilm(transactionqueue, film);
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.linkFilm_with_Subjects(transactionqueue, film.getPrimaryKey(), subjects);
    }

    public void updateFilm(SQLTqueue transactionqueue, Userprofile userprofile, IFilm film) throws DBException, DataException {
        if(isAuthorised_for_edit(userprofile, film))
            updateFilm_setBackup(film, transactionqueue);
    }

    private void updateFilm_setBackup(IFilm film, SQLTqueue transactionqueue) throws DataException, DBException {
        film.setBackup(true);
        updateFilm(transactionqueue, film);
    }
}
