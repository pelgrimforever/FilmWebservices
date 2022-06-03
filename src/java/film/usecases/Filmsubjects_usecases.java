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
import film.logicentity.Filmsubjects;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Filmsubjects_usecases {

    private boolean loggedin = false;
    private BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
    
    public Filmsubjects_usecases() {
        this(false);
    }
    
    public Filmsubjects_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfilmsubjects.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blfilmsubjects.count();
    }
    
    public ArrayList<Filmsubjects> get_all() throws DBException {
        return blfilmsubjects.getFilmsubjectss();
    }
    
    public boolean getFilmsubjectsExists(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return blfilmsubjects.getEntityExists(filmsubjectsPK);
    }
    
    public Filmsubjects get_filmsubjects_by_primarykey(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return blfilmsubjects.getFilmsubjects(filmsubjectsPK);
    }

    public ArrayList<Filmsubjects> get_filmsubjects_with_foreignkey_subject(ISubjectPK subjectPK) throws CustomException {
        return blfilmsubjects.getFilmsubjectss4subject(subjectPK);
    }
    
    public ArrayList<Filmsubjects> get_filmsubjects_with_foreignkey_film(IFilmPK filmPK) throws CustomException {
        return blfilmsubjects.getFilmsubjectss4film(filmPK);
    }
    
    public ArrayList<Filmsubjects> search_filmsubjects(IFilmsubjectssearch filmsubjectssearch) throws CustomException {
        return blfilmsubjects.search(filmsubjectssearch);
    }
    
    public long search_filmsubjects_count(IFilmsubjectssearch filmsubjectssearch) throws CustomException {
        return blfilmsubjects.searchcount(filmsubjectssearch);
    }

    public void secureinsertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        blfilmsubjects.secureinsertFilmsubjects(filmsubjects);
    }

    public void secureupdateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        blfilmsubjects.secureupdateFilmsubjects(filmsubjects);
    }

    public void securedeleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        blfilmsubjects.securedeleteFilmsubjects(filmsubjects);
    }
}

