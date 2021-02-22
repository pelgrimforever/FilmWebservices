/*
 * Bcreator.java
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
import film.conversion.json.JSONCreator;
import film.data.ProjectConstants;
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
public abstract class Bcreator extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Creator as default Entity
     */
    public Bcreator() {
        super(new SQLMapper_pgsql(connectionpool, "Creator"), new Creator());
    }

    /**
     * Constructor, sets Creator as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcreator(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Creator());
    }

    /**
     * Map ResultSet Field values to Creator
     * @param dbresult: Database ResultSet
     */
    public Creator mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CreatorPK creatorPK = null;
        Creator creator;
        if(dbresult==null) {
            creator = new Creator(creatorPK);
        } else {
            try {
                creatorPK = new CreatorPK(dbresult.getString("creatorid"));
                creator = new Creator(creatorPK);
                creator.initName(dbresult.getString("name"));
                creator.initSurname(dbresult.getString("surname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, creator);
        return creator;
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
    public ArrayList getCreators() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Creator.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Creator for primary key
     * @param creatorPK: Creator primary key
     * @return Creator object
     * @throws DBException
     */
    public Creator getCreator(ICreatorPK creatorPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Creator)super.getEntity((CreatorPK)creatorPK);
        } else return null;
    }

    public ArrayList searchcreators(ICreatorsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchcreators(ICreatorsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search creator in database for creatorPK:
     * @param creatorPK: Creator Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCreatorExists(ICreatorPK creatorPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((CreatorPK)creatorPK);
        } else return false;
    }

    /**
     * try to insert Creator in database
     * @param film: Creator object
     * @throws DBException
     */
    public void insertCreator(ICreator creator) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(creator);
        }
    }

    /**
     * check if CreatorPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Creator object
     * @throws DBException
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
     * @param film: Creator object
     * @throws DBException
     */
    public void updateCreator(ICreator creator) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(creator);
        }
    }

    /**
     * try to delete Creator in database
     * @param film: Creator object
     * @throws DBException
     */
    public void deleteCreator(ICreator creator) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteCreator(creator.getOwnerobject(), creator.getPrimaryKey());
            super.deleteEntity(creator);
        }
    }

    /**
     * check data rules in Creator, throw DataException with customized message if rules do not apply
     * @param film: Creator object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICreator creator) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(creator.getName()!=null && creator.getName().length()>ICreator.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ICreator.SIZE_NAME + "\n");
        }
        if(creator.getSurname()!=null && creator.getSurname().length()>ICreator.SIZE_SURNAME) {
            message.append("Surname is langer dan toegestaan. Max aantal karakters: " + ICreator.SIZE_SURNAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where creatorPK is used in a primary key
     * @param creatorPK: Creator primary key
     */
    public void cascadedeleteCreator(String senderobject, ICreatorPK creatorPK) {
    }


    /**
     * get all Creator objects for sqlparameters
     * @return ArrayList of Creator objects
     * @throws DBException
     */
    public ArrayList getCreators(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Creator.SQLSelect;
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
     * delete all Creator objects for sqlparameters
     * @throws DBException
     */
    public void delCreator(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Creator.table;
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
