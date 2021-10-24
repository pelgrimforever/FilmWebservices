/*
 * Bphototree7subject.java
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
import film.conversion.json.JSONPhototree7subject;
import film.conversion.entity.EMphototree7subject;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.logicentity.Phototree7subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bphototree7subject
 *
 * Superclass for manipulating data- and database objects
 * for Entity Phototree7subject and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphototree7subject extends BLtable {

    /**
     * Constructor, sets Phototree7subject as default Entity
     */
    public Bphototree7subject() {
        super(new Phototree7subject(), new EMphototree7subject());
    }

    /**
     * Constructor, sets Phototree7subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphototree7subject(BLtable transactionobject) {
        super(transactionobject, new Phototree7subject(), new EMphototree7subject());
    }

    /**
     * create new empty Phototree7subject object
     * @return empty IPhototree7subject
     */
    public IPhototree7subject newPhototree7subject() {
    	return new Phototree7subject();
    }
    
    /**
     * create new empty Phototree7subject object
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param subjectid primary key field
     * @return IPhototree7subject with primary key
     */
    public IPhototree7subject newPhototree7subject(java.lang.String film, int id, long subjectid) {
        return new Phototree7subject(film, id, subjectid);
    }

    /**
     * create new empty Phototree7subject object with given primary key
     * @param phototree7subjectPK: primary key for Phototree7subject
     * @return IPhototree7subject with primary key
     */
    public IPhototree7subject newPhototree7subject(IPhototree7subjectPK phototree7subjectPK) {
        return new Phototree7subject((Phototree7subjectPK)phototree7subjectPK);
    }

    /**
     * create new empty primary key
     * @return empty Phototree7subjectPK
     */
    public IPhototree7subjectPK newPhototree7subjectPK() {
        return new Phototree7subjectPK();
    }

    /**
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param subjectid primary key field
     * @return new IPhototree7subjectPK
     */
    public IPhototree7subjectPK newPhototree7subjectPK(java.lang.String film, int id, long subjectid) {
        return new Phototree7subjectPK(film, id, subjectid);
    }

    /**
     * get all Phototree7subject objects from database
     * @return ArrayList of Phototree7subject objects
     * @throws DBException
     */
    public ArrayList<Phototree7subject> getPhototree7subjects() throws DBException {
        return (ArrayList<Phototree7subject>)super.getEntities(EMphototree7subject.SQLSelectAll);
    }

    /**
     * search Phototree7subject for primary key
     * @param phototree7subjectPK: Phototree7subject primary key
     * @return Phototree7subject object
     * @throws DBException
     */
    public Phototree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return (Phototree7subject)super.getEntity((Phototree7subjectPK)phototree7subjectPK);
    }

    /**
     * search phototree7subject with IPhototree7subjectsearch parameters
     * @param search IPhototree7subjectsearch
     * @return ArrayList of Phototree7subject
     * @throws DBException 
     */
    public ArrayList<Phototree7subject> searchphototree7subjects(IPhototree7subjectsearch search) throws DBException {
        return (ArrayList<Phototree7subject>)this.search(search);
    }

    /**
     * search phototree7subject with IPhototree7subjectsearch parameters, order by orderby sql clause
     * @param search IPhototree7subjectsearch
     * @param orderby sql order by string
     * @return ArrayList of Phototree7subject
     * @throws DBException 
     */
    public ArrayList<Phototree7subject> searchphototree7subjects(IPhototree7subjectsearch search, String orderby) throws DBException {
        return (ArrayList<Phototree7subject>)this.search(search, orderby);
    }

    /**
     * Search phototree7subject in database for phototree7subjectPK:
     * @param phototree7subjectPK: Phototree7subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhototree7subjectExists(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return super.getEntityExists((Phototree7subjectPK)phototree7subjectPK);
    }

    /**
     * try to insert Phototree7subject in database
     * @param phototree7subject Phototree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        super.insertEntity(phototree7subject);
    }

    /**
     * check if Phototree7subjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param phototree7subject Phototree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        if(this.getPhototree7subjectExists(phototree7subject.getPrimaryKey())) {
            super.updateEntity(phototree7subject);
        } else {
            super.insertEntity(phototree7subject);
        }
    }

    /**
     * try to update Phototree7subject in database
     * @param phototree7subject Phototree7subject object
     * @throws DBException
     * @throws DataException
     */
    public void updatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        super.updateEntity(phototree7subject);
    }

    /**
     * try to delete Phototree7subject in database
     * @param phototree7subject Phototree7subject object
     * @throws DBException
     */
    public void deletePhototree7subject(IPhototree7subject phototree7subject) throws DBException {
        cascadedeletePhototree7subject(phototree7subject.getPrimaryKey());
        super.deleteEntity(phototree7subject);
    }

    /**
     * check data rules in Phototree7subject, throw DataException with customized message if rules do not apply
     * @param phototree7subject Phototree7subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhototree7subject phototree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototree7subject.Film - Photo.Film
        //foreign key Phototree7subject.Id - Photo.Id
        //foreign key Phototree7subject.Subjectid - Tree7subject.Subjectid
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where phototree7subjectPK is used in a primary key
     * @param phototree7subjectPK: Phototree7subject primary key
     */
    public void cascadedeletePhototree7subject(IPhototree7subjectPK phototree7subjectPK) {
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Phototree7subject Entity objects for Tree7subject in database
     */
    public void delete4tree7subject(ITree7subjectPK tree7subjectPK) {
        super.addStatement(EMphototree7subject.SQLDelete4tree7subject, tree7subjectPK.getSQLprimarykey());
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Phototree7subject Entity objects for Tree7subject
     * @throws CustomException
     */
    public ArrayList<Phototree7subject> getPhototree7subjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return super.getEntities(EMphototree7subject.SQLSelect4tree7subject, tree7subjectPK.getSQLprimarykey());
    }
    /**
     * @param photoPK: foreign key for Photo
     * @delete all Phototree7subject Entity objects for Photo in database
     */
    public void delete4photo(IPhotoPK photoPK) {
        super.addStatement(EMphototree7subject.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Phototree7subject Entity objects for Photo
     * @throws CustomException
     */
    public ArrayList<Phototree7subject> getPhototree7subjects4photo(IPhotoPK photoPK) throws CustomException {
        return super.getEntities(EMphototree7subject.SQLSelect4photo, photoPK.getSQLprimarykey());
    }

    /**
     * get all Phototree7subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Phototree7subject objects
     * @throws DBException
     */
    public ArrayList<Phototree7subject> getPhototree7subjects(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphototree7subject.SQLSelect);
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
        return (ArrayList<Phototree7subject>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Phototree7subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delPhototree7subject(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Phototree7subject.table);
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
