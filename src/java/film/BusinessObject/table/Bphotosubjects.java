/*
 * Bphotosubjects.java
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
import film.conversion.json.JSONPhotosubjects;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.logicentity.Photosubjects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bphotosubjects
 *
 * Superclass for manipulating data- and database objects
 * for Entity Photosubjects and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphotosubjects extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Photosubjects as default Entity
     */
    public Bphotosubjects() {
        super(new SQLMapper_pgsql(connectionpool, "Photosubjects"), new Photosubjects());
    }

    /**
     * Constructor, sets Photosubjects as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphotosubjects(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Photosubjects());
    }

    /**
     * Map ResultSet Field values to Photosubjects
     * @param dbresult: Database ResultSet
     */
    public Photosubjects mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhotosubjectsPK photosubjectsPK = null;
        Photosubjects photosubjects;
        if(dbresult==null) {
            photosubjects = new Photosubjects(photosubjectsPK);
        } else {
            try {
                photosubjectsPK = new PhotosubjectsPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("subject"));
                photosubjects = new Photosubjects(photosubjectsPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, photosubjects);
        return photosubjects;
    }

    /**
     * create new empty Photosubjects object
     * @return empty IPhotosubjects
     */
    public IPhotosubjects newPhotosubjects() {
    	return new Photosubjects();
    }
    
    /**
     * create new empty Photosubjects object
     * create new primary key with given parameters
     * @return IPhotosubjects with primary key
     */
    public IPhotosubjects newPhotosubjects(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new Photosubjects(film, id, cat1, cat2, subject);
    }

    /**
     * create new empty Photosubjects object with given primary key
     * @param photosubjectsPK: primary key for Photosubjects
     * @return IPhotosubjects with primary key
     */
    public IPhotosubjects newPhotosubjects(IPhotosubjectsPK photosubjectsPK) {
        return new Photosubjects((PhotosubjectsPK)photosubjectsPK);
    }

    /**
     * create new empty primary key
     * @return empty PhotosubjectsPK
     */
    public IPhotosubjectsPK newPhotosubjectsPK() {
        return new PhotosubjectsPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IPhotosubjectsPK
     */
    public IPhotosubjectsPK newPhotosubjectsPK(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new PhotosubjectsPK(film, id, cat1, cat2, subject);
    }

    /**
     * get all Photosubjects objects from database
     * @return ArrayList of Photosubjects objects
     * @throws DBException
     */
    public ArrayList getPhotosubjectss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photosubjects.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Photosubjects for primary key
     * @param photosubjectsPK: Photosubjects primary key
     * @return Photosubjects object
     * @throws DBException
     */
    public Photosubjects getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Photosubjects)super.getEntity((PhotosubjectsPK)photosubjectsPK);
        } else return null;
    }

    public ArrayList searchphotosubjectss(IPhotosubjectssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchphotosubjectss(IPhotosubjectssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search photosubjects in database for photosubjectsPK:
     * @param photosubjectsPK: Photosubjects Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhotosubjectsExists(IPhotosubjectsPK photosubjectsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((PhotosubjectsPK)photosubjectsPK);
        } else return false;
    }

    /**
     * try to insert Photosubjects in database
     * @param film: Photosubjects object
     * @throws DBException
     */
    public void insertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(photosubjects);
        }
    }

    /**
     * check if PhotosubjectsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Photosubjects object
     * @throws DBException
     */
    public void insertupdatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        if(this.getPhotosubjectsExists(photosubjects.getPrimaryKey())) {
            super.updateEntity(photosubjects);
        } else {
            super.insertEntity(photosubjects);
        }
    }

    /**
     * try to update Photosubjects in database
     * @param film: Photosubjects object
     * @throws DBException
     */
    public void updatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(photosubjects);
        }
    }

    /**
     * try to delete Photosubjects in database
     * @param film: Photosubjects object
     * @throws DBException
     */
    public void deletePhotosubjects(IPhotosubjects photosubjects) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeletePhotosubjects(photosubjects.getOwnerobject(), photosubjects.getPrimaryKey());
            super.deleteEntity(photosubjects);
        }
    }

    /**
     * check data rules in Photosubjects, throw DataException with customized message if rules do not apply
     * @param film: Photosubjects object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhotosubjects photosubjects) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photosubjects.Film - Photo.Film
        //foreign key Photosubjects.Id - Photo.Id
        //foreign key Photosubjects.Cat1 - Subject.Cat1
        //foreign key Photosubjects.Cat2 - Subject.Cat2
        //foreign key Photosubjects.Subject - Subject.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where photosubjectsPK is used in a primary key
     * @param photosubjectsPK: Photosubjects primary key
     */
    public void cascadedeletePhotosubjects(String senderobject, IPhotosubjectsPK photosubjectsPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Photosubjects Entity objects for Photo in database
     * @throws film.general.exception.CustomException
     */
    public void delete4photo(String senderobject, IPhotoPK photoPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Photosubjects.SQLDelete4photo, photoPK.getKeyFields());
        }
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Photosubjects Entity objects for Photo
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhotosubjectss4photo(IPhotoPK photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photosubjects.SQLSelect4photo, photoPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param subjectPK: foreign key for Subject
     * @delete all Photosubjects Entity objects for Subject in database
     * @throws film.general.exception.CustomException
     */
    public void delete4subject(String senderobject, ISubjectPK subjectPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Photosubjects.SQLDelete4subject, subjectPK.getKeyFields());
        }
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @return all Photosubjects Entity objects for Subject
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhotosubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photosubjects.SQLSelect4subject, subjectPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Photosubjects objects for sqlparameters
     * @return ArrayList of Photosubjects objects
     * @throws DBException
     */
    public ArrayList getPhotosubjectss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Photosubjects.SQLSelect;
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
     * delete all Photosubjects objects for sqlparameters
     * @throws DBException
     */
    public void delPhotosubjects(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Photosubjects.table;
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
