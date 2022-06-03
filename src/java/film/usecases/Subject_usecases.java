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
import film.logicentity.Subject;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Subject_usecases {

    private boolean loggedin = false;
    private BLsubject blsubject = new BLsubject();
    
    public Subject_usecases() {
        this(false);
    }
    
    public Subject_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsubject.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsubject.count();
    }
    
    public ArrayList<Subject> get_all() throws DBException {
        return blsubject.getSubjects();
    }
    
    public boolean getSubjectExists(ISubjectPK subjectPK) throws DBException {
        return blsubject.getEntityExists(subjectPK);
    }
    
    public Subject get_subject_by_primarykey(ISubjectPK subjectPK) throws DBException {
        return blsubject.getSubject(subjectPK);
    }

    public ArrayList<Subject> get_subject_with_foreignkey_subjectcatCat1(ISubjectcatPK subjectcatCat1PK) throws CustomException {
        return blsubject.getSubjects4subjectcatCat1(subjectcatCat1PK);
    }
    
    public ArrayList<Subject> get_subject_with_foreignkey_tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return blsubject.getSubjects4tree7subject(tree7subjectPK);
    }
    
    public ArrayList<Subject> get_subject_with_foreignkey_subjectcatCat2(ISubjectcatPK subjectcatCat2PK) throws CustomException {
        return blsubject.getSubjects4subjectcatCat2(subjectcatCat2PK);
    }
    
    public Subject get_subject_with_externalforeignkey_filmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        return blsubject.getFilmsubjects(filmsubjectsPK);
    }
    
    public Subject get_subject_with_externalforeignkey_photosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        return blsubject.getPhotosubjects(photosubjectsPK);
    }
    
    public ArrayList<Subject> search_subject(ISubjectsearch subjectsearch) throws CustomException {
        return blsubject.search(subjectsearch);
    }
    
    public long search_subject_count(ISubjectsearch subjectsearch) throws CustomException {
        return blsubject.searchcount(subjectsearch);
    }

    public void secureinsertSubject(ISubject subject) throws DBException, DataException {
        blsubject.secureinsertSubject(subject);
    }

    public void secureupdateSubject(ISubject subject) throws DBException, DataException {
        blsubject.secureupdateSubject(subject);
    }

    public void securedeleteSubject(ISubject subject) throws DBException, DataException {
        blsubject.securedeleteSubject(subject);
    }
}

