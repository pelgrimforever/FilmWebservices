/*
 * Btree7subject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONTree7subject;
import film.data.ProjectConstants;
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
public abstract class Btree7subject extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Tree7subject as default Entity
     */
    public Btree7subject() {
        super(new SQLMapper_pgsql(connectionpool, "Tree7subject"), new Tree7subject());
    }

    /**
     * Constructor, sets Tree7subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btree7subject(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Tree7subject());
    }

    /**
     * Map ResultSet Field values to Tree7subject
     * @param dbresult: Database ResultSet
     */
    public Tree7subject mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tree7subjectPK tree7subjectPK = null;
        Tree7subject tree7subject;
        if(dbresult==null) {
            tree7subject = new Tree7subject(tree7subjectPK);
        } else {
            try {
                tree7subjectPK = new Tree7subjectPK(dbresult.getLong("subjectid"));
                tree7subject = new Tree7subject(tree7subjectPK);
                tree7subject.initTree7subjectparentsubjectidPK(new Tree7subjectPK(dbresult.getLong("parentsubjectid")));
                if(dbresult.wasNull()) tree7subject.setTree7subjectparentsubjectidPK(null);                
                tree7subject.initTree7id(dbresult.getString("tree7id"));
                tree7subject.initSubject(dbresult.getString("subject"));
                tree7subject.initTreestep(dbresult.getInt("treestep"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, tree7subject);
        return tree7subject;
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
    public ArrayList getTree7subjects() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Tree7subject.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Tree7subject for primary key
     * @param tree7subjectPK: Tree7subject primary key
     * @return Tree7subject object
     * @throws DBException
     */
    public Tree7subject getTree7subject(ITree7subjectPK tree7subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Tree7subject)super.getEntity((Tree7subjectPK)tree7subjectPK);
        } else return null;
    }

    public ArrayList searchtree7subjects(ITree7subjectsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchtree7subjects(ITree7subjectsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search tree7subject in database for tree7subjectPK:
     * @param tree7subjectPK: Tree7subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTree7subjectExists(ITree7subjectPK tree7subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Tree7subjectPK)tree7subjectPK);
        } else return false;
    }

    /**
     * try to insert Tree7subject in database
     * @param film: Tree7subject object
     * @throws DBException
     */
    public void insertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(tree7subject);
        }
    }

    /**
     * check if Tree7subjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Tree7subject object
     * @throws DBException
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
     * @param film: Tree7subject object
     * @throws DBException
     */
    public void updateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(tree7subject);
        }
    }

    /**
     * try to delete Tree7subject in database
     * @param film: Tree7subject object
     * @throws DBException
     */
    public void deleteTree7subject(ITree7subject tree7subject) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteTree7subject(tree7subject.getOwnerobject(), tree7subject.getPrimaryKey());
            super.deleteEntity(tree7subject);
        }
    }

    /**
     * check data rules in Tree7subject, throw DataException with customized message if rules do not apply
     * @param film: Tree7subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITree7subject tree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(tree7subject.getTree7id()!=null && tree7subject.getTree7id().length()>ITree7subject.SIZE_TREE7ID) {
            message.append("Tree7id is langer dan toegestaan. Max aantal karakters: " + ITree7subject.SIZE_TREE7ID + "\n");
        }
        if(tree7subject.getTree7id()==null) {
            message.append("Tree7id mag niet leeg zijn.\n");
        }
        if(tree7subject.getSubject()!=null && tree7subject.getSubject().length()>ITree7subject.SIZE_SUBJECT) {
            message.append("Subject is langer dan toegestaan. Max aantal karakters: " + ITree7subject.SIZE_SUBJECT + "\n");
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
    public void cascadedeleteTree7subject(String senderobject, ITree7subjectPK tree7subjectPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.delete4tree7subject(senderobject, tree7subjectPK);
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Tree7subject Entity objects for Tree7subject in database
     * @throws film.general.exception.CustomException
     */
    public void delete4tree7subjectParentsubjectid(String senderobject, ITree7subjectPK tree7subjectPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Tree7subject.SQLDelete4tree7subjectParentsubjectid, tree7subjectPK.getKeyFields());
        }
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Tree7subject Entity objects for Tree7subject
     * @throws film.general.exception.CustomException
     */
    public ArrayList getTree7subjects4tree7subjectParentsubjectid(ITree7subjectPK tree7subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Tree7subject.SQLSelect4tree7subjectParentsubjectid, tree7subjectPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param phototree7subjectPK: parent Phototree7subject for child object Tree7subject Entity
     * @return child Tree7subject Entity object
     * @throws film.general.exception.CustomException
     */
    public ITree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            Tree7subjectPK tree7subjectPK = new Tree7subjectPK(phototree7subjectPK.getSubjectid());
            return this.getTree7subject(tree7subjectPK);
        } else return null;
    }


    /**
     * get all Tree7subject objects for sqlparameters
     * @return ArrayList of Tree7subject objects
     * @throws DBException
     */
    public ArrayList getTree7subjects(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Tree7subject.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Tree7subject objects for sqlparameters
     * @throws DBException
     */
    public void delTree7subject(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Tree7subject.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
