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
import film.logicentity.Phototree7subject;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Phototree7subject_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLphototree7subject blphototree7subject = new BLphototree7subject(sqlreader);
    
    public Phototree7subject_usecases() {
        this(false);
    }
    
    public Phototree7subject_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphototree7subject.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<ITree7subject> get_phototree7subject_from_photo(IPhotoPK photopk) throws DBException {
        BLtree7subject bltree7subject = new BLtree7subject(sqlreader);
        bltree7subject.setAuthenticated(loggedin);
        return bltree7subject.getTree7subjects(photopk);
    }

    public ArrayList<Phototree7subject> insert_phototree7subject_get_phototree7subject_with_foreignkey_photo(IPhototree7subject phototree7subject) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.insertPhototree7subject(tq, phototree7subject);
        sqlwriter.Commit2DB(tq);
        IPhotoPK photopk = phototree7subject.getPrimaryKey().getPhotoPK();
        return blphototree7subject.getPhototree7subjects4photo(photopk);
    }
    
    public ArrayList<Phototree7subject> getPhototree7subjects4photo(IPhotoPK photoPK) throws CustomException {
        return blphototree7subject.getPhototree7subjects4photo(photoPK);
    }
    
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphototree7subject.count();
    }
    
    public ArrayList<Phototree7subject> get_all() throws DBException {
        return blphototree7subject.getPhototree7subjects();
    }
    
    public boolean getPhototree7subjectExists(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return blphototree7subject.getPhototree7subjectExists(phototree7subjectPK);
    }
    
    public Phototree7subject get_phototree7subject_by_primarykey(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return blphototree7subject.getPhototree7subject(phototree7subjectPK);
    }

    public ArrayList<Phototree7subject> get_phototree7subject_with_foreignkey_tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK);
    }
    
    public ArrayList<Phototree7subject> get_phototree7subject_with_foreignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blphototree7subject.getPhototree7subjects4photo(photoPK);
    }
    
    public ArrayList<Phototree7subject> search_phototree7subject(IPhototree7subjectsearch phototree7subjectsearch) throws CustomException {
        return blphototree7subject.search(phototree7subjectsearch);
    }
    
    public long search_phototree7subject_count(IPhototree7subjectsearch phototree7subjectsearch) throws CustomException {
        return blphototree7subject.searchcount(phototree7subjectsearch);
    }

    public void insertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.insertPhototree7subject(tq, phototree7subject);
        sqlwriter.Commit2DB(tq);
    }

    public void updatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.updatePhototree7subject(tq, phototree7subject);
        sqlwriter.Commit2DB(tq);
    }

    public void deletePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.deletePhototree7subject(tq, phototree7subject);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.delete4tree7subject(tq, tree7subjectPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Photo(IPhotoPK photoPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphototree7subject.delete4photo(tq, photoPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

