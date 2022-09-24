/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Photosubjects;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Photosubjects_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLphotosubjects blphotosubjects = new BLphotosubjects(sqlreader);
    
    public Photosubjects_usecases() {
        this(false);
    }
    
    public Photosubjects_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphotosubjects.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Photosubjects> insert_photosubjects_and_reload(IPhotosubjects photosubjects) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.insertPhotosubjects(tq, photosubjects);
        sqlwriter.Commit2DB(tq);
        IPhotoPK photopk = photosubjects.getPrimaryKey().getPhotoPK();
        return blphotosubjects.getPhotosubjectss4photo(photopk);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphotosubjects.count();
    }
    
    public ArrayList<Photosubjects> get_all() throws DBException {
        return blphotosubjects.getPhotosubjectss();
    }
    
    public boolean getPhotosubjectsExists(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return blphotosubjects.getPhotosubjectsExists(photosubjectsPK);
    }
    
    public Photosubjects get_photosubjects_by_primarykey(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return blphotosubjects.getPhotosubjects(photosubjectsPK);
    }

    public ArrayList<Photosubjects> get_photosubjects_with_foreignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blphotosubjects.getPhotosubjectss4photo(photoPK);
    }
    
    public ArrayList<Photosubjects> get_photosubjects_with_foreignkey_subject(ISubjectPK subjectPK) throws CustomException {
        return blphotosubjects.getPhotosubjectss4subject(subjectPK);
    }
    
    public ArrayList<Photosubjects> search_photosubjects(IPhotosubjectssearch photosubjectssearch) throws CustomException {
        return blphotosubjects.search(photosubjectssearch);
    }
    
    public long search_photosubjects_count(IPhotosubjectssearch photosubjectssearch) throws CustomException {
        return blphotosubjects.searchcount(photosubjectssearch);
    }

    public void insertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.insertPhotosubjects(tq, photosubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void updatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.updatePhotosubjects(tq, photosubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void deletePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.deletePhotosubjects(tq, photosubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Photo(IPhotoPK photoPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.delete4photo(tq, photoPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Subject(ISubjectPK subjectPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphotosubjects.delete4subject(tq, subjectPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

