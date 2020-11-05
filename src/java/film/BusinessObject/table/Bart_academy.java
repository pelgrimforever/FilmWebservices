/*
 * Bart_academy.java
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
import film.conversion.json.JSONArt_academy;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_academysearch;
import film.logicentity.Art_academy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bart_academy
 *
 * Superclass for manipulating data- and database objects
 * for Entity Art_academy and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bart_academy extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Art_academy as default Entity
     */
    public Bart_academy() {
        super(new SQLMapper_pgsql(connectionpool, "Art_academy"), new Art_academy());
    }

    /**
     * Constructor, sets Art_academy as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_academy(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Art_academy());
    }

    /**
     * Map ResultSet Field values to Art_academy
     * @param dbresult: Database ResultSet
     */
    public Art_academy mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_academyPK art_academyPK = null;
        Art_academy art_academy;
        if(dbresult==null) {
            art_academy = new Art_academy(art_academyPK);
        } else {
            try {
                art_academyPK = new Art_academyPK(dbresult.getLong("academyid"));
                art_academy = new Art_academy(art_academyPK);
                art_academy.initAcademy(dbresult.getString("academy"));
                art_academy.initAcademylocation(dbresult.getString("academylocation"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, art_academy);
        return art_academy;
    }

    /**
     * create new empty Art_academy object
     * @return empty IArt_academy
     */
    public IArt_academy newArt_academy() {
    	return new Art_academy();
    }
    
    /**
     * create new empty Art_academy object
     * create new primary key with given parameters
     * @return IArt_academy with primary key
     */
    public IArt_academy newArt_academy(long academyid) {
        return new Art_academy(academyid);
    }

    /**
     * create new empty Art_academy object with given primary key
     * @param art_academyPK: primary key for Art_academy
     * @return IArt_academy with primary key
     */
    public IArt_academy newArt_academy(IArt_academyPK art_academyPK) {
        return new Art_academy((Art_academyPK)art_academyPK);
    }

    /**
     * create new empty primary key
     * @return empty Art_academyPK
     */
    public IArt_academyPK newArt_academyPK() {
        return new Art_academyPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArt_academyPK
     */
    public IArt_academyPK newArt_academyPK(long academyid) {
        return new Art_academyPK(academyid);
    }

    /**
     * get all Art_academy objects from database
     * @return ArrayList of Art_academy objects
     * @throws DBException
     */
    public ArrayList getArt_academys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_academy.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Art_academy for primary key
     * @param art_academyPK: Art_academy primary key
     * @return Art_academy object
     * @throws DBException
     */
    public Art_academy getArt_academy(IArt_academyPK art_academyPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Art_academy)super.getEntity((Art_academyPK)art_academyPK);
        } else return null;
    }

    public ArrayList searchart_academys(IArt_academysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchart_academys(IArt_academysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search art_academy in database for art_academyPK:
     * @param art_academyPK: Art_academy Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_academyExists(IArt_academyPK art_academyPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Art_academyPK)art_academyPK);
        } else return false;
    }

    /**
     * try to insert Art_academy in database
     * @param film: Art_academy object
     * @throws DBException
     */
    public void insertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(art_academy);
        }
    }

    /**
     * check if Art_academyPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Art_academy object
     * @throws DBException
     */
    public void insertupdateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        if(this.getArt_academyExists(art_academy.getPrimaryKey())) {
            super.updateEntity(art_academy);
        } else {
            super.insertEntity(art_academy);
        }
    }

    /**
     * try to update Art_academy in database
     * @param film: Art_academy object
     * @throws DBException
     */
    public void updateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(art_academy);
        }
    }

    /**
     * try to delete Art_academy in database
     * @param film: Art_academy object
     * @throws DBException
     */
    public void deleteArt_academy(IArt_academy art_academy) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArt_academy(art_academy.getOwnerobject(), art_academy.getPrimaryKey());
            super.deleteEntity(art_academy);
        }
    }

    /**
     * check data rules in Art_academy, throw DataException with customized message if rules do not apply
     * @param film: Art_academy object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_academy art_academy) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_academy.getAcademy()!=null && art_academy.getAcademy().length()>IArt_academy.SIZE_ACADEMY) {
            message.append("Academy is langer dan toegestaan. Max aantal karakters: " + IArt_academy.SIZE_ACADEMY + "\n");
        }
        if(art_academy.getAcademy()==null) {
            message.append("Academy mag niet leeg zijn.\n");
        }
        if(art_academy.getAcademylocation()!=null && art_academy.getAcademylocation().length()>IArt_academy.SIZE_ACADEMYLOCATION) {
            message.append("Academylocation is langer dan toegestaan. Max aantal karakters: " + IArt_academy.SIZE_ACADEMYLOCATION + "\n");
        }
        if(art_academy.getAcademylocation()==null) {
            message.append("Academylocation mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where art_academyPK is used in a primary key
     * @param art_academyPK: Art_academy primary key
     */
    public void cascadedeleteArt_academy(String senderobject, IArt_academyPK art_academyPK) {
    }


    /**
     * get all Art_academy objects for sqlparameters
     * @return ArrayList of Art_academy objects
     * @throws DBException
     */
    public ArrayList getArt_academys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Art_academy.SQLSelect;
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
     * delete all Art_academy objects for sqlparameters
     * @throws DBException
     */
    public void delArt_academy(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Art_academy.table;
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
