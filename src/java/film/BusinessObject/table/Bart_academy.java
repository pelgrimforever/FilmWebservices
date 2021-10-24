/*
 * Bart_academy.java
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
import film.conversion.json.JSONArt_academy;
import film.conversion.entity.EMart_academy;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bart_academy extends BLtable {

    /**
     * Constructor, sets Art_academy as default Entity
     */
    public Bart_academy() {
        super(new Art_academy(), new EMart_academy());
    }

    /**
     * Constructor, sets Art_academy as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_academy(BLtable transactionobject) {
        super(transactionobject, new Art_academy(), new EMart_academy());
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
     * @param academyid primary key field
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
     * @param academyid primary key field
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
    public ArrayList<Art_academy> getArt_academys() throws DBException {
        return (ArrayList<Art_academy>)super.getEntities(EMart_academy.SQLSelectAll);
    }

    /**
     * search Art_academy for primary key
     * @param art_academyPK: Art_academy primary key
     * @return Art_academy object
     * @throws DBException
     */
    public Art_academy getArt_academy(IArt_academyPK art_academyPK) throws DBException {
        return (Art_academy)super.getEntity((Art_academyPK)art_academyPK);
    }

    /**
     * search art_academy with IArt_academysearch parameters
     * @param search IArt_academysearch
     * @return ArrayList of Art_academy
     * @throws DBException 
     */
    public ArrayList<Art_academy> searchart_academys(IArt_academysearch search) throws DBException {
        return (ArrayList<Art_academy>)this.search(search);
    }

    /**
     * search art_academy with IArt_academysearch parameters, order by orderby sql clause
     * @param search IArt_academysearch
     * @param orderby sql order by string
     * @return ArrayList of Art_academy
     * @throws DBException 
     */
    public ArrayList<Art_academy> searchart_academys(IArt_academysearch search, String orderby) throws DBException {
        return (ArrayList<Art_academy>)this.search(search, orderby);
    }

    /**
     * Search art_academy in database for art_academyPK:
     * @param art_academyPK: Art_academy Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_academyExists(IArt_academyPK art_academyPK) throws DBException {
        return super.getEntityExists((Art_academyPK)art_academyPK);
    }

    /**
     * try to insert Art_academy in database
     * @param art_academy Art_academy object
     * @throws DBException
     * @throws DataException
     */
    public void insertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        super.insertEntity(art_academy);
    }

    /**
     * check if Art_academyPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param art_academy Art_academy object
     * @throws DBException
     * @throws DataException
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
     * @param art_academy Art_academy object
     * @throws DBException
     * @throws DataException
     */
    public void updateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        super.updateEntity(art_academy);
    }

    /**
     * try to delete Art_academy in database
     * @param art_academy Art_academy object
     * @throws DBException
     */
    public void deleteArt_academy(IArt_academy art_academy) throws DBException {
        cascadedeleteArt_academy(art_academy.getPrimaryKey());
        super.deleteEntity(art_academy);
    }

    /**
     * check data rules in Art_academy, throw DataException with customized message if rules do not apply
     * @param art_academy Art_academy object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_academy art_academy) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_academy.getAcademy()!=null && art_academy.getAcademy().length()>IArt_academy.SIZE_ACADEMY) {
            message.append("Academy is langer dan toegestaan. Max aantal karakters: ").append(IArt_academy.SIZE_ACADEMY).append("\n");
        }
        if(art_academy.getAcademy()==null) {
            message.append("Academy mag niet leeg zijn.\n");
        }
        if(art_academy.getAcademylocation()!=null && art_academy.getAcademylocation().length()>IArt_academy.SIZE_ACADEMYLOCATION) {
            message.append("Academylocation is langer dan toegestaan. Max aantal karakters: ").append(IArt_academy.SIZE_ACADEMYLOCATION).append("\n");
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
    public void cascadedeleteArt_academy(IArt_academyPK art_academyPK) {
    }


    /**
     * get all Art_academy objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Art_academy objects
     * @throws DBException
     */
    public ArrayList<Art_academy> getArt_academys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_academy.SQLSelect);
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
        return (ArrayList<Art_academy>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Art_academy objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArt_academy(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_academy.table);
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
