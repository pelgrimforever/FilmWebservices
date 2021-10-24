/*
 * Btree7subject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONTree7subject;
import film.conversion.entity.EMtree7subject;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ITree7subjectsearch;
import film.logicentity.Tree7subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btree7subject
 *
 * Superclass for manipulating data- and database objects
 * for Entity Tree7subject and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btree7subject extends BLtable {

    /**
     * Constructor, sets Tree7subject as default Entity
     */
    public Btree7subject() {
        super(new Tree7subject(), new EMtree7subject());
    }

    /**
     * Constructor, sets Tree7subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btree7subject(BLtable transactionobject) {
        super(transactionobject, new Tree7subject(), new EMtree7subject());
    }

    /**
     * create new empty Tree7subject object
     * @return empty ITree7subject
     */
    public ITree7subject newTree7subject() {
    	return new Tree7subject();
    }
    
    /**
     * create new empty Tree7subject object
     * create new primary key with given parameters
     * @param subjectid primary key field
     * @return ITree7subject with primary key
     */
    public ITree7subject newTree7subject(long subjectid) {
        return new Tree7subject(subjectid);
    }

    /**
     * create new empty Tree7subject object with given primary key
     * @param tree7subjectPK: primary key for Tree7subject
     * @return ITree7subject with primary key
     */
    public ITree7subject newTree7subject(ITree7subjectPK tree7subjectPK) {
        return new Tree7subject((Tree7subjectPK)tree7subjectPK);
    }

    /**
     * create new empty primary key
     * @return empty Tree7subjectPK
     */
    public ITree7subjectPK newTree7subjectPK() {
        return new Tree7subjectPK();
    }

    /**
     * create new primary key with given parameters
     * @param subjectid primary key field
     * @return new ITree7subjectPK
     */
    public ITree7subjectPK newTree7subjectPK(long subjectid) {
        return new Tree7subjectPK(subjectid);
    }

    /**
     * get all Tree7subject objects from database
     * @return ArrayList of Tree7subject objects
     * @throws DBException
     */
    public ArrayList<Tree7subject> getTree7subjects() throws DBException {
        return (ArrayList<Tree7subject>)super.getEntities(EMtree7subject.SQLSelectAll);
    }

    /**
     * search Tree7subject for primary key
     * @param tree7subjectPK: Tree7subject primary key
     * @return Tree7subject object
     * @throws DBException
     */
    public Tree7subject getTree7subject(ITree7subjectPK tree7subjectPK) throws DBException {
        return (Tree7subject)super.getEntity((Tree7subjectPK)tree7subjectPK);
    }

    /**
     * search tree7subject with ITree7subjectsearch parameters
     * @param search ITree7subjectsearch
     * @return ArrayList of Tree7subject
     * @throws DBException 
     */
    public ArrayList<Tree7subject> searchtree7subjects(ITree7subjectsearch search) throws DBException {
        return (ArrayList<Tree7subject>)this.search(search);
    }

    /**
     * search tree7subject with ITree7subjectsearch parameters, order by orderby sql clause
     * @param search ITree7subjectsearch
     * @param orderby sql order by string
     * @return ArrayList of Tree7subject
     * @throws DBException 
     */
    public ArrayList<Tree7subject> searchtree7subjects(ITree7subjectsearch search, String orderby) throws DBException {
        return (ArrayList<Tree7subject>)this.search(search, orderby);
    }

    /**
     * Search tree7subject in database for tree7subjectPK:
     * @param tree7subjectPK: Tree7subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTree7subjectExists(ITree7subjectPK tree7subjectPK) throws DBException {
        return super.getEntityExists((Tree7subjectPK)tree7subjectPK);
    }

    /**
     * try to insert Tree7subject in database
     * @param tree7subject Tree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        super.insertEntity(tree7subject);
    }

    /**
     * check if Tree7subjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param tree7subject Tree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        if(this.getTree7subjectExists(tree7subject.getPrimaryKey())) {
            super.updateEntity(tree7subject);
        } else {
            super.insertEntity(tree7subject);
        }
    }

    /**
     * try to update Tree7subject in database
     * @param tree7subject Tree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void updateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        super.updateEntity(tree7subject);
    }

    /**
     * try to delete Tree7subject in database
     * @param tree7subject Tree7subject object
     * @throws DBException
     */
    public void deleteTree7subject(ITree7subject tree7subject) throws DBException {
        cascadedeleteTree7subject(tree7subject.getPrimaryKey());
        super.deleteEntity(tree7subject);
    }

    /**
     * check data rules in Tree7subject, throw DataException with customized message if rules do not apply
     * @param tree7subject Tree7subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITree7subject tree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(tree7subject.getTree7id()!=null && tree7subject.getTree7id().length()>ITree7subject.SIZE_TREE7ID) {
            message.append("Tree7id is langer dan toegestaan. Max aantal karakters: ").append(ITree7subject.SIZE_TREE7ID).append("\n");
        }
        if(tree7subject.getTree7id()==null) {
            message.append("Tree7id mag niet leeg zijn.\n");
        }
        if(tree7subject.getSubject()!=null && tree7subject.getSubject().length()>ITree7subject.SIZE_SUBJECT) {
            message.append("Subject is langer dan toegestaan. Max aantal karakters: ").append(ITree7subject.SIZE_SUBJECT).append("\n");
        }
        if(tree7subject.getSubject()==null) {
            message.append("Subject mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tree7subjectPK is used in a primary key
     * @param tree7subjectPK: Tree7subject primary key
     */
    public void cascadedeleteTree7subject(ITree7subjectPK tree7subjectPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.delete4tree7subject(tree7subjectPK);
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Tree7subject Entity objects for Tree7subject in database
     */
    public void delete4tree7subjectParentsubjectid(ITree7subjectPK tree7subjectPK) {
        super.addStatement(EMtree7subject.SQLDelete4tree7subjectParentsubjectid, tree7subjectPK.getSQLprimarykey());
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Tree7subject Entity objects for Tree7subject
     * @throws CustomException
     */
    public ArrayList<Tree7subject> getTree7subjects4tree7subjectParentsubjectid(ITree7subjectPK tree7subjectPK) throws CustomException {
        return super.getEntities(EMtree7subject.SQLSelect4tree7subjectParentsubjectid, tree7subjectPK.getSQLprimarykey());
    }
    /**
     * @param phototree7subjectPK: parent Phototree7subject for child object Tree7subject Entity
     * @return child Tree7subject Entity object
     * @throws CustomException
     */
    public Tree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        Tree7subjectPK tree7subjectPK = new Tree7subjectPK(phototree7subjectPK.getSubjectid());
        return this.getTree7subject(tree7subjectPK);
    }


    /**
     * get all Tree7subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Tree7subject objects
     * @throws DBException
     */
    public ArrayList<Tree7subject> getTree7subjects(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtree7subject.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Tree7subject>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Tree7subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTree7subject(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tree7subject.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
