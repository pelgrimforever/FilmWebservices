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
import film.logicentity.Subject;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Subject_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsubject blsubject = new BLsubject(sqlreader);
    
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
        return blsubject.getSubjectExists(subjectPK);
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

    public void insertSubject(ISubject subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.insertSubject(tq, subject);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSubject(ISubject subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.updateSubject(tq, subject);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSubject(ISubject subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.deleteSubject(tq, subject);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Subjectcatcat1(ISubjectcatPK subjectcatCat1PK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.delete4subjectcatCat1(tq, subjectcatCat1PK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.delete4tree7subject(tq, tree7subjectPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Subjectcatcat2(ISubjectcatPK subjectcatCat2PK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsubject.delete4subjectcatCat2(tq, subjectcatCat2PK);
        sqlwriter.Commit2DB(tq);
    }
    
}

