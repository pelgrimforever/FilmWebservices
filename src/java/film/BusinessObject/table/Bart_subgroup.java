/*
 * Bart_subgroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
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
import film.conversion.json.JSONArt_subgroup;
import film.conversion.entity.EMart_subgroup;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bart_subgroup extends BLtable {

    /**
     * Constructor, sets Art_subgroup as default Entity
     */
    public Bart_subgroup() {
        super(new Art_subgroup(), new EMart_subgroup());
    }

    /**
     * Constructor, sets Art_subgroup as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_subgroup(BLtable transactionobject) {
        super(transactionobject, new Art_subgroup(), new EMart_subgroup());
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
     * @param subgroupid primary key field
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
     * @param subgroupid primary key field
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
    public ArrayList<Art_subgroup> getArt_subgroups() throws DBException {
        return (ArrayList<Art_subgroup>)super.getEntities(EMart_subgroup.SQLSelectAll);
    }

    /**
     * search Art_subgroup for primary key
     * @param art_subgroupPK: Art_subgroup primary key
     * @return Art_subgroup object
     * @throws DBException
     */
    public Art_subgroup getArt_subgroup(IArt_subgroupPK art_subgroupPK) throws DBException {
        return (Art_subgroup)super.getEntity((Art_subgroupPK)art_subgroupPK);
    }

    /**
     * search art_subgroup with IArt_subgroupsearch parameters
     * @param search IArt_subgroupsearch
     * @return ArrayList of Art_subgroup
     * @throws DBException 
     */
    public ArrayList<Art_subgroup> searchart_subgroups(IArt_subgroupsearch search) throws DBException {
        return (ArrayList<Art_subgroup>)this.search(search);
    }

    /**
     * search art_subgroup with IArt_subgroupsearch parameters, order by orderby sql clause
     * @param search IArt_subgroupsearch
     * @param orderby sql order by string
     * @return ArrayList of Art_subgroup
     * @throws DBException 
     */
    public ArrayList<Art_subgroup> searchart_subgroups(IArt_subgroupsearch search, String orderby) throws DBException {
        return (ArrayList<Art_subgroup>)this.search(search, orderby);
    }

    /**
     * Search art_subgroup in database for art_subgroupPK:
     * @param art_subgroupPK: Art_subgroup Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_subgroupExists(IArt_subgroupPK art_subgroupPK) throws DBException {
        return super.getEntityExists((Art_subgroupPK)art_subgroupPK);
    }

    /**
     * try to insert Art_subgroup in database
     * @param art_subgroup Art_subgroup object
     * @throws DBException
     * @throws DataException
     */
    public void insertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        super.insertEntity(art_subgroup);
    }

    /**
     * check if Art_subgroupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param art_subgroup Art_subgroup object
     * @throws DBException
     * @throws DataException
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
     * @param art_subgroup Art_subgroup object
     * @throws DBException
     * @throws DataException
     */
    public void updateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        super.updateEntity(art_subgroup);
    }

    /**
     * try to delete Art_subgroup in database
     * @param art_subgroup Art_subgroup object
     * @throws DBException
     */
    public void deleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException {
        cascadedeleteArt_subgroup(art_subgroup.getPrimaryKey());
        super.deleteEntity(art_subgroup);
    }

    /**
     * check data rules in Art_subgroup, throw DataException with customized message if rules do not apply
     * @param art_subgroup Art_subgroup object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_subgroup art_subgroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_subgroup.getSubgroupname()!=null && art_subgroup.getSubgroupname().length()>IArt_subgroup.SIZE_SUBGROUPNAME) {
            message.append("Subgroupname is langer dan toegestaan. Max aantal karakters: ").append(IArt_subgroup.SIZE_SUBGROUPNAME).append("\n");
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
    public void cascadedeleteArt_subgroup(IArt_subgroupPK art_subgroupPK) {
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @delete all Art_subgroup Entity objects for Art_group in database
     */
    public void delete4art_group(IArt_groupPK art_groupPK) {
        super.addStatement(EMart_subgroup.SQLDelete4art_group, art_groupPK.getSQLprimarykey());
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @return all Art_subgroup Entity objects for Art_group
     * @throws CustomException
     */
    public ArrayList<Art_subgroup> getArt_subgroups4art_group(IArt_groupPK art_groupPK) throws CustomException {
        return super.getEntities(EMart_subgroup.SQLSelect4art_group, art_groupPK.getSQLprimarykey());
    }

    /**
     * get all Art_subgroup objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Art_subgroup objects
     * @throws DBException
     */
    public ArrayList<Art_subgroup> getArt_subgroups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_subgroup.SQLSelect);
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
        return (ArrayList<Art_subgroup>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Art_subgroup objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArt_subgroup(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_subgroup.table);
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
