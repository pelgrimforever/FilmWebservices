/*
 * Bcreator.java
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
import film.conversion.json.JSONCreator;
import film.conversion.entity.EMcreator;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ICreatorsearch;
import film.logicentity.Creator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bcreator
 *
 * Superclass for manipulating data- and database objects
 * for Entity Creator and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcreator extends BLtable {

    /**
     * Constructor, sets Creator as default Entity
     */
    public Bcreator() {
        super(new Creator(), new EMcreator());
    }

    /**
     * Constructor, sets Creator as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcreator(BLtable transactionobject) {
        super(transactionobject, new Creator(), new EMcreator());
    }

    /**
     * create new empty Creator object
     * @return empty ICreator
     */
    public ICreator newCreator() {
    	return new Creator();
    }
    
    /**
     * create new empty Creator object
     * create new primary key with given parameters
     * @param creatorid primary key field
     * @return ICreator with primary key
     */
    public ICreator newCreator(java.lang.String creatorid) {
        return new Creator(creatorid);
    }

    /**
     * create new empty Creator object with given primary key
     * @param creatorPK: primary key for Creator
     * @return ICreator with primary key
     */
    public ICreator newCreator(ICreatorPK creatorPK) {
        return new Creator((CreatorPK)creatorPK);
    }

    /**
     * create new empty primary key
     * @return empty CreatorPK
     */
    public ICreatorPK newCreatorPK() {
        return new CreatorPK();
    }

    /**
     * create new primary key with given parameters
     * @param creatorid primary key field
     * @return new ICreatorPK
     */
    public ICreatorPK newCreatorPK(java.lang.String creatorid) {
        return new CreatorPK(creatorid);
    }

    /**
     * get all Creator objects from database
     * @return ArrayList of Creator objects
     * @throws DBException
     */
    public ArrayList<Creator> getCreators() throws DBException {
        return (ArrayList<Creator>)super.getEntities(EMcreator.SQLSelectAll);
    }

    /**
     * search Creator for primary key
     * @param creatorPK: Creator primary key
     * @return Creator object
     * @throws DBException
     */
    public Creator getCreator(ICreatorPK creatorPK) throws DBException {
        return (Creator)super.getEntity((CreatorPK)creatorPK);
    }

    /**
     * search creator with ICreatorsearch parameters
     * @param search ICreatorsearch
     * @return ArrayList of Creator
     * @throws DBException 
     */
    public ArrayList<Creator> searchcreators(ICreatorsearch search) throws DBException {
        return (ArrayList<Creator>)this.search(search);
    }

    /**
     * search creator with ICreatorsearch parameters, order by orderby sql clause
     * @param search ICreatorsearch
     * @param orderby sql order by string
     * @return ArrayList of Creator
     * @throws DBException 
     */
    public ArrayList<Creator> searchcreators(ICreatorsearch search, String orderby) throws DBException {
        return (ArrayList<Creator>)this.search(search, orderby);
    }

    /**
     * Search creator in database for creatorPK:
     * @param creatorPK: Creator Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCreatorExists(ICreatorPK creatorPK) throws DBException {
        return super.getEntityExists((CreatorPK)creatorPK);
    }

    /**
     * try to insert Creator in database
     * @param creator Creator object
     * @throws DBException
     * @throws DataException
     */
    public void insertCreator(ICreator creator) throws DBException, DataException {
        super.insertEntity(creator);
    }

    /**
     * check if CreatorPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param creator Creator object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateCreator(ICreator creator) throws DBException, DataException {
        if(this.getCreatorExists(creator.getPrimaryKey())) {
            super.updateEntity(creator);
        } else {
            super.insertEntity(creator);
        }
    }

    /**
     * try to update Creator in database
     * @param creator Creator object
     * @throws DBException
     * @throws DataException
     */
    public void updateCreator(ICreator creator) throws DBException, DataException {
        super.updateEntity(creator);
    }

    /**
     * try to delete Creator in database
     * @param creator Creator object
     * @throws DBException
     */
    public void deleteCreator(ICreator creator) throws DBException {
        cascadedeleteCreator(creator.getPrimaryKey());
        super.deleteEntity(creator);
    }

    /**
     * check data rules in Creator, throw DataException with customized message if rules do not apply
     * @param creator Creator object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICreator creator) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(creator.getName()!=null && creator.getName().length()>ICreator.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICreator.SIZE_NAME).append("\n");
        }
        if(creator.getSurname()!=null && creator.getSurname().length()>ICreator.SIZE_SURNAME) {
            message.append("Surname is langer dan toegestaan. Max aantal karakters: ").append(ICreator.SIZE_SURNAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where creatorPK is used in a primary key
     * @param creatorPK: Creator primary key
     */
    public void cascadedeleteCreator(ICreatorPK creatorPK) {
    }


    /**
     * get all Creator objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Creator objects
     * @throws DBException
     */
    public ArrayList<Creator> getCreators(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcreator.SQLSelect);
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
        return (ArrayList<Creator>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Creator objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delCreator(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Creator.table);
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
