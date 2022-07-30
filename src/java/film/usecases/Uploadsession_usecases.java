/*
 * Generated on 27.6.2022 16:45
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
import film.logicentity.Uploadsession;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Uploadsession_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLuploadsession bluploadsession = new BLuploadsession(sqlreader);
    
    public Uploadsession_usecases() {
        this(false);
    }
    
    public Uploadsession_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bluploadsession.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Uploadsession> get_uploadsession_with_tree7subjects() throws DBException {
        BLtree7subject blsubject = new BLtree7subject(sqlreader);
        blsubject.setAuthenticated(loggedin);
        ArrayList<Uploadsession> uploadsessions = bluploadsession.getUploadsessions();
        for(Uploadsession uploadsession: uploadsessions)
            add_tree7subjects_to_uploadsession(uploadsession, blsubject);
        return uploadsessions;
    }

    private void add_tree7subjects_to_uploadsession(Uploadsession uploadsession, BLtree7subject blsubject) throws DBException {
        ITree7subjectPK[] subjectpks = uploadsession.getPhotosubjectkeys();
        ArrayList subjectpkarraylist = new ArrayList();
        for(ITree7subjectPK tree7subjectpk: subjectpks)
            subjectpkarraylist.add(tree7subjectpk);
        ArrayList subjects = blsubject.getTree7subjects(subjectpkarraylist);
        uploadsession.setSubjects(subjects);
    }
    
    public void insert_uploadsessions(ArrayList<IUploadsession> uploadsessions) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsession.insertCompletesession(tq, uploadsessions);
        sqlwriter.Commit2DB(tq);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bluploadsession.count();
    }
    
    public ArrayList<Uploadsession> get_all() throws DBException {
        return bluploadsession.getUploadsessions();
    }
    
    public boolean getUploadsessionExists(IUploadsessionPK uploadsessionPK) throws DBException {
        return bluploadsession.getUploadsessionExists(uploadsessionPK);
    }
    
    public Uploadsession get_uploadsession_by_primarykey(IUploadsessionPK uploadsessionPK) throws DBException {
        return bluploadsession.getUploadsession(uploadsessionPK);
    }

    public ArrayList<Uploadsession> get_uploadsession_with_foreignkey_creator(ICreatorPK creatorPK) throws CustomException {
        return bluploadsession.getUploadsessions4creator(creatorPK);
    }
    
    public ArrayList<Uploadsession> search_uploadsession(IUploadsessionsearch uploadsessionsearch) throws CustomException {
        return bluploadsession.search(uploadsessionsearch);
    }
    
    public long search_uploadsession_count(IUploadsessionsearch uploadsessionsearch) throws CustomException {
        return bluploadsession.searchcount(uploadsessionsearch);
    }

    public void insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsession.insertUploadsession(tq, uploadsession);
        sqlwriter.Commit2DB(tq);
    }

    public void updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsession.updateUploadsession(tq, uploadsession);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsession.deleteUploadsession(tq, uploadsession);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Creator(ICreatorPK creatorPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsession.delete4creator(tq, creatorPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

