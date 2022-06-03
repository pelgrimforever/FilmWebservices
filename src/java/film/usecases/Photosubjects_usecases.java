/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Photosubjects;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Photosubjects_usecases {

    private boolean loggedin = false;
    private BLphotosubjects blphotosubjects = new BLphotosubjects();
    
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
        blphotosubjects.insertPhotosubjects(photosubjects);
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
        return blphotosubjects.getEntityExists(photosubjectsPK);
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

    public void secureinsertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        blphotosubjects.secureinsertPhotosubjects(photosubjects);
    }

    public void secureupdatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        blphotosubjects.secureupdatePhotosubjects(photosubjects);
    }

    public void securedeletePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        blphotosubjects.securedeletePhotosubjects(photosubjects);
    }
}

