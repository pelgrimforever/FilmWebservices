/*
 * Bart_group.java
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
import film.conversion.json.JSONArt_group;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_groupsearch;
import film.logicentity.Art_group;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bart_group
 *
 * Superclass for manipulating data- and database objects
 * for Entity Art_group and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bart_group extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Art_group as default Entity
     */
    public Bart_group() {
        super(new SQLMapper_pgsql(connectionpool, "Art_group"), new Art_group());
    }

    /**
     * Constructor, sets Art_group as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_group(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Art_group());
    }

    /**
     * Map ResultSet Field values to Art_group
     * @param dbresult: Database ResultSet
     */
    public Art_group mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_groupPK art_groupPK = null;
        Art_group art_group;
        if(dbresult==null) {
            art_group = new Art_group(art_groupPK);
        } else {
            try {
                art_groupPK = new Art_groupPK(dbresult.getLong("groupid"));
                art_group = new Art_group(art_groupPK);
                art_group.initGroupname(dbresult.getString("groupname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, art_group);
        return art_group;
    }

    /**
     * create new empty Art_group object
     * @return empty IArt_group
     */
    public IArt_group newArt_group() {
    	return new Art_group();
    }
    
    /**
     * create new empty Art_group object
     * create new primary key with given parameters
     * @return IArt_group with primary key
     */
    public IArt_group newArt_group(long groupid) {
        return new Art_group(groupid);
    }

    /**
     * create new empty Art_group object with given primary key
     * @param art_groupPK: primary key for Art_group
     * @return IArt_group with primary key
     */
    public IArt_group newArt_group(IArt_groupPK art_groupPK) {
        return new Art_group((Art_groupPK)art_groupPK);
    }

    /**
     * create new empty primary key
     * @return empty Art_groupPK
     */
    public IArt_groupPK newArt_groupPK() {
        return new Art_groupPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArt_groupPK
     */
    public IArt_groupPK newArt_groupPK(long groupid) {
        return new Art_groupPK(groupid);
    }

    /**
     * get all Art_group objects from database
     * @return ArrayList of Art_group objects
     * @throws DBException
     */
    public ArrayList getArt_groups() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_group.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Art_group for primary key
     * @param art_groupPK: Art_group primary key
     * @return Art_group object
     * @throws DBException
     */
    public Art_group getArt_group(IArt_groupPK art_groupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Art_group)super.getEntity((Art_groupPK)art_groupPK);
        } else return null;
    }

    public ArrayList searchart_groups(IArt_groupsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchart_groups(IArt_groupsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search art_group in database for art_groupPK:
     * @param art_groupPK: Art_group Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_groupExists(IArt_groupPK art_groupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Art_groupPK)art_groupPK);
        } else return false;
    }

    /**
     * try to insert Art_group in database
     * @param film: Art_group object
     * @throws DBException
     */
    public void insertArt_group(IArt_group art_group) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(art_group);
        }
    }

    /**
     * check if Art_groupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Art_group object
     * @throws DBException
     */
    public void insertupdateArt_group(IArt_group art_group) throws DBException, DataException {
        if(this.getArt_groupExists(art_group.getPrimaryKey())) {
            super.updateEntity(art_group);
        } else {
            super.insertEntity(art_group);
        }
    }

    /**
     * try to update Art_group in database
     * @param film: Art_group object
     * @throws DBException
     */
    public void updateArt_group(IArt_group art_group) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(art_group);
        }
    }

    /**
     * try to delete Art_group in database
     * @param film: Art_group object
     * @throws DBException
     */
    public void deleteArt_group(IArt_group art_group) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArt_group(art_group.getOwnerobject(), art_group.getPrimaryKey());
            super.deleteEntity(art_group);
        }
    }

    /**
     * check data rules in Art_group, throw DataException with customized message if rules do not apply
     * @param film: Art_group object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_group art_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_group.getGroupname()!=null && art_group.getGroupname().length()>IArt_group.SIZE_GROUPNAME) {
            message.append("Groupname is langer dan toegestaan. Max aantal karakters: " + IArt_group.SIZE_GROUPNAME + "\n");
        }
        if(art_group.getGroupname()==null) {
            message.append("Groupname mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where art_groupPK is used in a primary key
     * @param art_groupPK: Art_group primary key
     */
    public void cascadedeleteArt_group(String senderobject, IArt_groupPK art_groupPK) {
    }


    /**
     * get all Art_group objects for sqlparameters
     * @return ArrayList of Art_group objects
     * @throws DBException
     */
    public ArrayList getArt_groups(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Art_group.SQLSelect;
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
     * delete all Art_group objects for sqlparameters
     * @throws DBException
     */
    public void delArt_group(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Art_group.table;
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
