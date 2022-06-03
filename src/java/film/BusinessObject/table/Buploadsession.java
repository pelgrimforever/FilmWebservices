/*
 * Buploadsession.java
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
import film.conversion.json.JSONUploadsession;
import film.conversion.entity.EMuploadsession;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.logicentity.Uploadsession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Buploadsession
 *
 * Superclass for manipulating data- and database objects
 * for Entity Uploadsession and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Buploadsession extends BLtable {

    /**
     * Constructor, sets Uploadsession as default Entity
     */
    public Buploadsession() {
        super(new Uploadsession(), new EMuploadsession());
    }

    /**
     * Constructor, sets Uploadsession as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Buploadsession(BLtable transactionobject) {
        super(transactionobject, new Uploadsession(), new EMuploadsession());
    }

    /**
     * create new empty Uploadsession object
     * @return empty IUploadsession
     */
    public IUploadsession newUploadsession() {
    	return new Uploadsession();
    }
    
    /**
     * create new empty Uploadsession object
     * create new primary key with given parameters
     * @param filename primary key field
     * @return IUploadsession with primary key
     */
    public IUploadsession newUploadsession(java.lang.String filename) {
        return new Uploadsession(filename);
    }

    /**
     * create new empty Uploadsession object with given primary key
     * @param uploadsessionPK: primary key for Uploadsession
     * @return IUploadsession with primary key
     */
    public IUploadsession newUploadsession(IUploadsessionPK uploadsessionPK) {
        return new Uploadsession((UploadsessionPK)uploadsessionPK);
    }

    /**
     * create new empty primary key
     * @return empty UploadsessionPK
     */
    public IUploadsessionPK newUploadsessionPK() {
        return new UploadsessionPK();
    }

    /**
     * create new primary key with given parameters
     * @param filename primary key field
     * @return new IUploadsessionPK
     */
    public IUploadsessionPK newUploadsessionPK(java.lang.String filename) {
        return new UploadsessionPK(filename);
    }

    /**
     * get all Uploadsession objects from database
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    public ArrayList<Uploadsession> getUploadsessions() throws DBException {
        return (ArrayList<Uploadsession>)super.getEntities(EMuploadsession.SQLSelectAll);
    }

    /**
     * search Uploadsession for primary key
     * @param uploadsessionPK: Uploadsession primary key
     * @return Uploadsession object
     * @throws DBException
     */
    public Uploadsession getUploadsession(IUploadsessionPK uploadsessionPK) throws DBException {
        return (Uploadsession)super.getEntity((UploadsessionPK)uploadsessionPK);
    }

    /**
     * search uploadsession with IUploadsessionsearch parameters
     * @param search IUploadsessionsearch
     * @return ArrayList of Uploadsession
     * @throws DBException 
     */
    public ArrayList<Uploadsession> searchuploadsessions(IUploadsessionsearch search) throws DBException {
        return (ArrayList<Uploadsession>)this.search(search);
    }

    /**
     * search uploadsession with IUploadsessionsearch parameters, order by orderby sql clause
     * @param search IUploadsessionsearch
     * @param orderby sql order by string
     * @return ArrayList of Uploadsession
     * @throws DBException 
     */
    public ArrayList<Uploadsession> searchuploadsessions(IUploadsessionsearch search, String orderby) throws DBException {
        return (ArrayList<Uploadsession>)this.search(search, orderby);
    }

    /**
     * Search uploadsession in database for uploadsessionPK:
     * @param uploadsessionPK: Uploadsession Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUploadsessionExists(IUploadsessionPK uploadsessionPK) throws DBException {
        return super.getEntityExists((UploadsessionPK)uploadsessionPK);
    }

    /**
     * try to insert Uploadsession in database
     * @param uploadsession Uploadsession object
     * @throws DBException
     * @throws DataException
     */
    public void insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.insertEntity(uploadsession);
    }

    /**
     * check if UploadsessionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param uploadsession Uploadsession object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        if(this.getUploadsessionExists(uploadsession.getPrimaryKey())) {
            super.updateEntity(uploadsession);
        } else {
            super.insertEntity(uploadsession);
        }
    }

    /**
     * try to update Uploadsession in database
     * @param uploadsession Uploadsession object
     * @throws DBException
     * @throws DataException
     */
    public void updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.updateEntity(uploadsession);
    }

    /**
     * try to delete Uploadsession in database
     * @param uploadsession Uploadsession object
     * @throws DBException
     */
    public void deleteUploadsession(IUploadsession uploadsession) throws DBException {
        cascadedeleteUploadsession(uploadsession.getPrimaryKey());
        super.deleteEntity(uploadsession);
    }

    /**
     * check data rules in Uploadsession, throw DataException with customized message if rules do not apply
     * @param uploadsession Uploadsession object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUploadsession uploadsession) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(uploadsession.getCreatorPK()!=null && uploadsession.getCreatorPK().getCreatorid()!=null && uploadsession.getCreatorPK().getCreatorid().length()>IUploadsession.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_CREATOR + "\n");
        }

        if(uploadsession.getFilmgroupid()!=null && uploadsession.getFilmgroupid().length()>IUploadsession.SIZE_FILMGROUPID) {
            message.append("Filmgroupid is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_FILMGROUPID).append("\n");
        }
        if(uploadsession.getPhotosubjects()!=null && uploadsession.getPhotosubjects().length()>IUploadsession.SIZE_PHOTOSUBJECTS) {
            message.append("Photosubjects is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_PHOTOSUBJECTS).append("\n");
        }
        if(uploadsession.getDescription()!=null && uploadsession.getDescription().length()>IUploadsession.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where uploadsessionPK is used in a primary key
     * @param uploadsessionPK: Uploadsession primary key
     */
    public void cascadedeleteUploadsession(IUploadsessionPK uploadsessionPK) {
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @delete all Uploadsession Entity objects for Creator in database
     */
    public void delete4creator(ICreatorPK creatorPK) {
        super.addStatement(EMuploadsession.SQLDelete4creator, creatorPK.getSQLprimarykey());
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @return all Uploadsession Entity objects for Creator
     * @throws CustomException
     */
    public ArrayList<Uploadsession> getUploadsessions4creator(ICreatorPK creatorPK) throws CustomException {
        return super.getEntities(EMuploadsession.SQLSelect4creator, creatorPK.getSQLprimarykey());
    }

    /**
     * get all Uploadsession objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    public ArrayList<Uploadsession> getUploadsessions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuploadsession.SQLSelect);
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
        return (ArrayList<Uploadsession>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Uploadsession objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delUploadsession(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Uploadsession.table);
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
