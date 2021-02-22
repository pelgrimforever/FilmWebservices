/*
 * Bphototree7subject.java
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
import film.conversion.json.JSONPhototree7subject;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.logicentity.Phototree7subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bphototree7subject
 *
 * Superclass for manipulating data- and database objects
 * for Entity Phototree7subject and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphototree7subject extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Phototree7subject as default Entity
     */
    public Bphototree7subject() {
        super(new SQLMapper_pgsql(connectionpool, "Phototree7subject"), new Phototree7subject());
    }

    /**
     * Constructor, sets Phototree7subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphototree7subject(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Phototree7subject());
    }

    /**
     * Map ResultSet Field values to Phototree7subject
     * @param dbresult: Database ResultSet
     */
    public Phototree7subject mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Phototree7subjectPK phototree7subjectPK = null;
        Phototree7subject phototree7subject;
        if(dbresult==null) {
            phototree7subject = new Phototree7subject(phototree7subjectPK);
        } else {
            try {
                phototree7subjectPK = new Phototree7subjectPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getLong("subjectid"));
                phototree7subject = new Phototree7subject(phototree7subjectPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, phototree7subject);
        return phototree7subject;
    }

    /**
     * create new empty Phototree7subject object
     * @return empty IPhototree7subject
     */
    public IPhototree7subject newPhototree7subject() {
    	return new Phototree7subject();
    }
    
    /**
     * create new empty Phototree7subject object
     * create new primary key with given parameters
     * @return IPhototree7subject with primary key
     */
    public IPhototree7subject newPhototree7subject(java.lang.String film, int id, long subjectid) {
        return new Phototree7subject(film, id, subjectid);
    }

    /**
     * create new empty Phototree7subject object with given primary key
     * @param phototree7subjectPK: primary key for Phototree7subject
     * @return IPhototree7subject with primary key
     */
    public IPhototree7subject newPhototree7subject(IPhototree7subjectPK phototree7subjectPK) {
        return new Phototree7subject((Phototree7subjectPK)phototree7subjectPK);
    }

    /**
     * create new empty primary key
     * @return empty Phototree7subjectPK
     */
    public IPhototree7subjectPK newPhototree7subjectPK() {
        return new Phototree7subjectPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IPhototree7subjectPK
     */
    public IPhototree7subjectPK newPhototree7subjectPK(java.lang.String film, int id, long subjectid) {
        return new Phototree7subjectPK(film, id, subjectid);
    }

    /**
     * get all Phototree7subject objects from database
     * @return ArrayList of Phototree7subject objects
     * @throws DBException
     */
    public ArrayList getPhototree7subjects() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Phototree7subject.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Phototree7subject for primary key
     * @param phototree7subjectPK: Phototree7subject primary key
     * @return Phototree7subject object
     * @throws DBException
     */
    public Phototree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Phototree7subject)super.getEntity((Phototree7subjectPK)phototree7subjectPK);
        } else return null;
    }

    public ArrayList searchphototree7subjects(IPhototree7subjectsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchphototree7subjects(IPhototree7subjectsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search phototree7subject in database for phototree7subjectPK:
     * @param phototree7subjectPK: Phototree7subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhototree7subjectExists(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Phototree7subjectPK)phototree7subjectPK);
        } else return false;
    }

    /**
     * try to insert Phototree7subject in database
     * @param film: Phototree7subject object
     * @throws DBException
     */
    public void insertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(phototree7subject);
        }
    }

    /**
     * check if Phototree7subjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Phototree7subject object
     * @throws DBException
     */
    public void insertupdatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        if(this.getPhototree7subjectExists(phototree7subject.getPrimaryKey())) {
            super.updateEntity(phototree7subject);
        } else {
            super.insertEntity(phototree7subject);
        }
    }

    /**
     * try to update Phototree7subject in database
     * @param film: Phototree7subject object
     * @throws DBException
     */
    public void updatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(phototree7subject);
        }
    }

    /**
     * try to delete Phototree7subject in database
     * @param film: Phototree7subject object
     * @throws DBException
     */
    public void deletePhototree7subject(IPhototree7subject phototree7subject) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeletePhototree7subject(phototree7subject.getOwnerobject(), phototree7subject.getPrimaryKey());
            super.deleteEntity(phototree7subject);
        }
    }

    /**
     * check data rules in Phototree7subject, throw DataException with customized message if rules do not apply
     * @param film: Phototree7subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhototree7subject phototree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototree7subject.Film - Photo.Film
        //foreign key Phototree7subject.Id - Photo.Id
        //foreign key Phototree7subject.Subjectid - Tree7subject.Subjectid
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where phototree7subjectPK is used in a primary key
     * @param phototree7subjectPK: Phototree7subject primary key
     */
    public void cascadedeletePhototree7subject(String senderobject, IPhototree7subjectPK phototree7subjectPK) {
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Phototree7subject Entity objects for Tree7subject in database
     * @throws film.general.exception.CustomException
     */
    public void delete4tree7subject(String senderobject, ITree7subjectPK tree7subjectPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Phototree7subject.SQLDelete4tree7subject, tree7subjectPK.getKeyFields());
        }
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Phototree7subject Entity objects for Tree7subject
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhototree7subjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Phototree7subject.SQLSelect4tree7subject, tree7subjectPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param photoPK: foreign key for Photo
     * @delete all Phototree7subject Entity objects for Photo in database
     * @throws film.general.exception.CustomException
     */
    public void delete4photo(String senderobject, IPhotoPK photoPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Phototree7subject.SQLDelete4photo, photoPK.getKeyFields());
        }
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Phototree7subject Entity objects for Photo
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhototree7subjects4photo(IPhotoPK photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Phototree7subject.SQLSelect4photo, photoPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Phototree7subject objects for sqlparameters
     * @return ArrayList of Phototree7subject objects
     * @throws DBException
     */
    public ArrayList getPhototree7subjects(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Phototree7subject.SQLSelect;
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
     * delete all Phototree7subject objects for sqlparameters
     * @throws DBException
     */
    public void delPhototree7subject(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Phototree7subject.table;
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
