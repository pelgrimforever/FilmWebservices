/*
 * Bart_subgroup.java
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
import film.conversion.json.JSONArt_subgroup;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.logicentity.Art_subgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bart_subgroup
 *
 * Superclass for manipulating data- and database objects
 * for Entity Art_subgroup and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bart_subgroup extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Art_subgroup as default Entity
     */
    public Bart_subgroup() {
        super(new SQLMapper_pgsql(connectionpool, "Art_subgroup"), new Art_subgroup());
    }

    /**
     * Constructor, sets Art_subgroup as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_subgroup(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Art_subgroup());
    }

    /**
     * Map ResultSet Field values to Art_subgroup
     * @param dbresult: Database ResultSet
     */
    public Art_subgroup mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_subgroupPK art_subgroupPK = null;
        Art_subgroup art_subgroup;
        if(dbresult==null) {
            art_subgroup = new Art_subgroup(art_subgroupPK);
        } else {
            try {
                art_subgroupPK = new Art_subgroupPK(dbresult.getInt("subgroupid"));
                art_subgroup = new Art_subgroup(art_subgroupPK);
                art_subgroup.initArt_groupPK(new Art_groupPK(dbresult.getInt("groupid")));
                if(dbresult.wasNull()) art_subgroup.setArt_groupPK(null);                
                art_subgroup.initSubgroupname(dbresult.getString("subgroupname"));
                art_subgroup.initLastseqno(dbresult.getInt("lastseqno"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, art_subgroup);
        return art_subgroup;
    }

    /**
     * create new empty Art_subgroup object
     * @return empty IArt_subgroup
     */
    public IArt_subgroup newArt_subgroup() {
    	return new Art_subgroup();
    }
    
    /**
     * create new empty Art_subgroup object
     * create new primary key with given parameters
     * @return IArt_subgroup with primary key
     */
    public IArt_subgroup newArt_subgroup(int subgroupid) {
        return new Art_subgroup(subgroupid);
    }

    /**
     * create new empty Art_subgroup object with given primary key
     * @param art_subgroupPK: primary key for Art_subgroup
     * @return IArt_subgroup with primary key
     */
    public IArt_subgroup newArt_subgroup(IArt_subgroupPK art_subgroupPK) {
        return new Art_subgroup((Art_subgroupPK)art_subgroupPK);
    }

    /**
     * create new empty primary key
     * @return empty Art_subgroupPK
     */
    public IArt_subgroupPK newArt_subgroupPK() {
        return new Art_subgroupPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArt_subgroupPK
     */
    public IArt_subgroupPK newArt_subgroupPK(int subgroupid) {
        return new Art_subgroupPK(subgroupid);
    }

    /**
     * get all Art_subgroup objects from database
     * @return ArrayList of Art_subgroup objects
     * @throws DBException
     */
    public ArrayList getArt_subgroups() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_subgroup.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Art_subgroup for primary key
     * @param art_subgroupPK: Art_subgroup primary key
     * @return Art_subgroup object
     * @throws DBException
     */
    public Art_subgroup getArt_subgroup(IArt_subgroupPK art_subgroupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Art_subgroup)super.getEntity((Art_subgroupPK)art_subgroupPK);
        } else return null;
    }

    public ArrayList searchart_subgroups(IArt_subgroupsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchart_subgroups(IArt_subgroupsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search art_subgroup in database for art_subgroupPK:
     * @param art_subgroupPK: Art_subgroup Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_subgroupExists(IArt_subgroupPK art_subgroupPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Art_subgroupPK)art_subgroupPK);
        } else return false;
    }

    /**
     * try to insert Art_subgroup in database
     * @param film: Art_subgroup object
     * @throws DBException
     */
    public void insertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(art_subgroup);
        }
    }

    /**
     * check if Art_subgroupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Art_subgroup object
     * @throws DBException
     */
    public void insertupdateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        if(this.getArt_subgroupExists(art_subgroup.getPrimaryKey())) {
            super.updateEntity(art_subgroup);
        } else {
            super.insertEntity(art_subgroup);
        }
    }

    /**
     * try to update Art_subgroup in database
     * @param film: Art_subgroup object
     * @throws DBException
     */
    public void updateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(art_subgroup);
        }
    }

    /**
     * try to delete Art_subgroup in database
     * @param film: Art_subgroup object
     * @throws DBException
     */
    public void deleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArt_subgroup(art_subgroup.getOwnerobject(), art_subgroup.getPrimaryKey());
            super.deleteEntity(art_subgroup);
        }
    }

    /**
     * check data rules in Art_subgroup, throw DataException with customized message if rules do not apply
     * @param film: Art_subgroup object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_subgroup art_subgroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(art_subgroup.getSubgroupname()!=null && art_subgroup.getSubgroupname().length()>IArt_subgroup.SIZE_SUBGROUPNAME) {
            message.append("Subgroupname is langer dan toegestaan. Max aantal karakters: " + IArt_subgroup.SIZE_SUBGROUPNAME + "\n");
        }
        if(art_subgroup.getSubgroupname()==null) {
            message.append("Subgroupname mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where art_subgroupPK is used in a primary key
     * @param art_subgroupPK: Art_subgroup primary key
     */
    public void cascadedeleteArt_subgroup(String senderobject, IArt_subgroupPK art_subgroupPK) {
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @delete all Art_subgroup Entity objects for Art_group in database
     * @throws film.general.exception.CustomException
     */
    public void delete4art_group(String senderobject, IArt_groupPK art_groupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Art_subgroup.SQLDelete4art_group, art_groupPK.getKeyFields());
        }
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @return all Art_subgroup Entity objects for Art_group
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArt_subgroups4art_group(IArt_groupPK art_groupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_subgroup.SQLSelect4art_group, art_groupPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Art_subgroup objects for sqlparameters
     * @return ArrayList of Art_subgroup objects
     * @throws DBException
     */
    public ArrayList getArt_subgroups(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Art_subgroup.SQLSelect;
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
     * delete all Art_subgroup objects for sqlparameters
     * @throws DBException
     */
    public void delArt_subgroup(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Art_subgroup.table;
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
