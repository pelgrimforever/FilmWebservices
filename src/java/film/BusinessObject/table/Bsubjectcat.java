/*
 * Bsubjectcat.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
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
import film.conversion.json.JSONSubjectcat;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISubjectcatsearch;
import film.logicentity.Subjectcat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bsubjectcat
 *
 * Superclass for manipulating data- and database objects
 * for Entity Subjectcat and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsubjectcat extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Subjectcat as default Entity
     */
    public Bsubjectcat() {
        super(new SQLMapper_pgsql(connectionpool, "Subjectcat"), new Subjectcat());
    }

    /**
     * Constructor, sets Subjectcat as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsubjectcat(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Subjectcat());
    }

    /**
     * Map ResultSet Field values to Subjectcat
     * @param dbresult: Database ResultSet
     */
    public Subjectcat mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SubjectcatPK subjectcatPK = null;
        Subjectcat subjectcat;
        if(dbresult==null) {
            subjectcat = new Subjectcat(subjectcatPK);
        } else {
            try {
                subjectcatPK = new SubjectcatPK(dbresult.getString("cat"));
                subjectcat = new Subjectcat(subjectcatPK);
                subjectcat.initCatno(dbresult.getInt("catno"));
                subjectcat.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, subjectcat);
        return subjectcat;
    }

    /**
     * create new empty Subjectcat object
     * @return empty ISubjectcat
     */
    public ISubjectcat newSubjectcat() {
    	return new Subjectcat();
    }
    
    /**
     * create new empty Subjectcat object
     * create new primary key with given parameters
     * @return ISubjectcat with primary key
     */
    public ISubjectcat newSubjectcat(java.lang.String cat) {
        return new Subjectcat(cat);
    }

    /**
     * create new empty Subjectcat object with given primary key
     * @param subjectcatPK: primary key for Subjectcat
     * @return ISubjectcat with primary key
     */
    public ISubjectcat newSubjectcat(ISubjectcatPK subjectcatPK) {
        return new Subjectcat((SubjectcatPK)subjectcatPK);
    }

    /**
     * create new empty primary key
     * @return empty SubjectcatPK
     */
    public ISubjectcatPK newSubjectcatPK() {
        return new SubjectcatPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISubjectcatPK
     */
    public ISubjectcatPK newSubjectcatPK(java.lang.String cat) {
        return new SubjectcatPK(cat);
    }

    /**
     * get all Subjectcat objects from database
     * @return ArrayList of Subjectcat objects
     * @throws DBException
     */
    public ArrayList getSubjectcats() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Subjectcat.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Subjectcat for primary key
     * @param subjectcatPK: Subjectcat primary key
     * @return Subjectcat object
     * @throws DBException
     */
    public Subjectcat getSubjectcat(ISubjectcatPK subjectcatPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Subjectcat)super.getEntity((SubjectcatPK)subjectcatPK);
        } else return null;
    }

    public ArrayList searchsubjectcats(ISubjectcatsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsubjectcats(ISubjectcatsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search subjectcat in database for subjectcatPK:
     * @param subjectcatPK: Subjectcat Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSubjectcatExists(ISubjectcatPK subjectcatPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SubjectcatPK)subjectcatPK);
        } else return false;
    }

    /**
     * try to insert Subjectcat in database
     * @param film: Subjectcat object
     * @throws DBException
     */
    public void insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(subjectcat);
        }
    }

    /**
     * check if SubjectcatPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Subjectcat object
     * @throws DBException
     */
    public void insertupdateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        if(this.getSubjectcatExists(subjectcat.getPrimaryKey())) {
            super.updateEntity(subjectcat);
        } else {
            super.insertEntity(subjectcat);
        }
    }

    /**
     * try to update Subjectcat in database
     * @param film: Subjectcat object
     * @throws DBException
     */
    public void updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(subjectcat);
        }
    }

    /**
     * try to delete Subjectcat in database
     * @param film: Subjectcat object
     * @throws DBException
     */
    public void deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSubjectcat(subjectcat.getOwnerobject(), subjectcat.getPrimaryKey());
            super.deleteEntity(subjectcat);
        }
    }

    /**
     * check data rules in Subjectcat, throw DataException with customized message if rules do not apply
     * @param film: Subjectcat object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISubjectcat subjectcat) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(subjectcat.getDescription()!=null && subjectcat.getDescription().length()>ISubjectcat.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + ISubjectcat.SIZE_DESCRIPTION + "\n");
        }
        if(subjectcat.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where subjectcatPK is used in a primary key
     * @param subjectcatPK: Subjectcat primary key
     */
    public void cascadedeleteSubjectcat(String senderobject, ISubjectcatPK subjectcatPK) {
        BLsubject blsubjectCat1 = new BLsubject(this);
        blsubjectCat1.delete4subjectcatCat1(senderobject, subjectcatPK);
        BLsubject blsubjectCat2 = new BLsubject(this);
        blsubjectCat2.delete4subjectcatCat2(senderobject, subjectcatPK);
    }

    /**
     * @param subjectPK: parent Subject for child object Subjectcat Entity
     * @return child Subjectcat Entity object
     * @throws film.general.exception.CustomException
     */
    public ISubjectcat getSubjectcat1(ISubjectPK subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat1());
            return this.getSubjectcat(subjectcatPK);
        } else return null;
    }

    /**
     * @param subjectPK: parent Subject for child object Subjectcat Entity
     * @return child Subjectcat Entity object
     * @throws film.general.exception.CustomException
     */
    public ISubjectcat getSubjectcat2(ISubjectPK subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat2());
            return this.getSubjectcat(subjectcatPK);
        } else return null;
    }


    /**
     * get all Subjectcat objects for sqlparameters
     * @return ArrayList of Subjectcat objects
     * @throws DBException
     */
    public ArrayList getSubjectcats(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Subjectcat.SQLSelect;
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
     * delete all Subjectcat objects for sqlparameters
     * @throws DBException
     */
    public void delSubjectcat(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Subjectcat.table;
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
