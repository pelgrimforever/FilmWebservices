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
import film.logicentity.Filmsubjects;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Filmsubjects_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfilmsubjects blfilmsubjects = new BLfilmsubjects(sqlreader);
    
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
        return blfilmsubjects.getFilmsubjectsExists(filmsubjectsPK);
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

    public void insertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmsubjects.insertFilmsubjects(tq, filmsubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmsubjects.updateFilmsubjects(tq, filmsubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmsubjects.deleteFilmsubjects(tq, filmsubjects);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Subject(ISubjectPK subjectPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilmsubjects.delete4subject(tq, subjectPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Film(IFilmPK filmPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilmsubjects.delete4film(tq, filmPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

