/*
 * Bart_group.java
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
import film.conversion.json.JSONArt_group;
import film.conversion.entity.EMart_group;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bart_group extends BLtable {

    /**
     * Constructor, sets Art_group as default Entity
     */
    public Bart_group() {
        super(new Art_group(), new EMart_group());
    }

    /**
     * Constructor, sets Art_group as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_group(BLtable transactionobject) {
        super(transactionobject, new Art_group(), new EMart_group());
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
     * @param groupid primary key field
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
     * @param groupid primary key field
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
    public ArrayList<Art_group> getArt_groups() throws DBException {
        return (ArrayList<Art_group>)super.getEntities(EMart_group.SQLSelectAll);
    }

    /**
     * search Art_group for primary key
     * @param art_groupPK: Art_group primary key
     * @return Art_group object
     * @throws DBException
     */
    public Art_group getArt_group(IArt_groupPK art_groupPK) throws DBException {
        return (Art_group)super.getEntity((Art_groupPK)art_groupPK);
    }

    /**
     * search art_group with IArt_groupsearch parameters
     * @param search IArt_groupsearch
     * @return ArrayList of Art_group
     * @throws DBException 
     */
    public ArrayList<Art_group> searchart_groups(IArt_groupsearch search) throws DBException {
        return (ArrayList<Art_group>)this.search(search);
    }

    /**
     * search art_group with IArt_groupsearch parameters, order by orderby sql clause
     * @param search IArt_groupsearch
     * @param orderby sql order by string
     * @return ArrayList of Art_group
     * @throws DBException 
     */
    public ArrayList<Art_group> searchart_groups(IArt_groupsearch search, String orderby) throws DBException {
        return (ArrayList<Art_group>)this.search(search, orderby);
    }

    /**
     * Search art_group in database for art_groupPK:
     * @param art_groupPK: Art_group Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_groupExists(IArt_groupPK art_groupPK) throws DBException {
        return super.getEntityExists((Art_groupPK)art_groupPK);
    }

    /**
     * try to insert Art_group in database
     * @param art_group Art_group object
     * @throws DBException
     * @throws DataException
     */
    public void insertArt_group(IArt_group art_group) throws DBException, DataException {
        super.insertEntity(art_group);
    }

    /**
     * check if Art_groupPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param art_group Art_group object
     * @throws DBException
     * @throws DataException
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
     * @param art_group Art_group object
     * @throws DBException
     * @throws DataException
     */
    public void updateArt_group(IArt_group art_group) throws DBException, DataException {
        super.updateEntity(art_group);
    }

    /**
     * try to delete Art_group in database
     * @param art_group Art_group object
     * @throws DBException
     */
    public void deleteArt_group(IArt_group art_group) throws DBException {
        cascadedeleteArt_group(art_group.getPrimaryKey());
        super.deleteEntity(art_group);
    }

    /**
     * check data rules in Art_group, throw DataException with customized message if rules do not apply
     * @param art_group Art_group object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_group art_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_group.getGroupname()!=null && art_group.getGroupname().length()>IArt_group.SIZE_GROUPNAME) {
            message.append("Groupname is langer dan toegestaan. Max aantal karakters: ").append(IArt_group.SIZE_GROUPNAME).append("\n");
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
    public void cascadedeleteArt_group(IArt_groupPK art_groupPK) {
    }


    /**
     * get all Art_group objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Art_group objects
     * @throws DBException
     */
    public ArrayList<Art_group> getArt_groups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_group.SQLSelect);
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
        return (ArrayList<Art_group>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Art_group objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArt_group(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_group.table);
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
