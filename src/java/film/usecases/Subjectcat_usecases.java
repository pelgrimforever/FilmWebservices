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
import film.logicentity.Subjectcat;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Subjectcat_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsubjectcat blsubjectcat = new BLsubjectcat(sqlreader);
    
    public Subjectcat_usecases() {
        this(false);
    }
    
    public Subjectcat_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsubjectcat.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Subjectcat> getSubjects_category_1() throws DBException {
        return blsubjectcat.getSubjectcats1();
    }

    public ArrayList<Subjectcat> getSubjects_category_2() throws DBException {
        return blsubjectcat.getSubjectcats2();
    }

    public ArrayList<Subjectcat> insert_subject_category_1_getSubjects_category_1(ISubjectcat subjectcat1) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubjectcat.insertSubjectcat(tq, subjectcat1);
        sqlwriter.Commit2DB(tq);
        return blsubjectcat.getSubjectcats1();
    }

    public ArrayList<Subjectcat> insert_subject_category_2_getSubjects_category_2(ISubjectcat subjectcat2) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubjectcat.insertSubjectcat(tq, subjectcat2);
        return blsubjectcat.getSubjectcats2();
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsubjectcat.count();
    }
    
    public ArrayList<Subjectcat> get_all() throws DBException {
        return blsubjectcat.getSubjectcats();
    }
    
    public boolean getSubjectcatExists(ISubjectcatPK subjectcatPK) throws DBException {
        return blsubjectcat.getSubjectcatExists(subjectcatPK);
    }
    
    public Subjectcat get_subjectcat_by_primarykey(ISubjectcatPK subjectcatPK) throws DBException {
        return blsubjectcat.getSubjectcat(subjectcatPK);
    }

    public Subjectcat get_subjectcat_with_externalforeignkey_subjectCat1(ISubjectPK subjectCat1PK) throws CustomException {
        return blsubjectcat.getSubjectcat1(subjectCat1PK);
    }
    
    public Subjectcat get_subjectcat_with_externalforeignkey_subjectCat2(ISubjectPK subjectCat2PK) throws CustomException {
        return blsubjectcat.getSubjectcat2(subjectCat2PK);
    }
    
    public ArrayList<Subjectcat> search_subjectcat(ISubjectcatsearch subjectcatsearch) throws CustomException {
        return blsubjectcat.search(subjectcatsearch);
    }
    
    public long search_subjectcat_count(ISubjectcatsearch subjectcatsearch) throws CustomException {
        return blsubjectcat.searchcount(subjectcatsearch);
    }

    public void insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubjectcat.insertSubjectcat(tq, subjectcat);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubjectcat.updateSubjectcat(tq, subjectcat);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsubjectcat.deleteSubjectcat(tq, subjectcat);
        sqlwriter.Commit2DB(tq);
    }

}

