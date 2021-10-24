/*
 * Bphotosubjects.java
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
import film.conversion.json.JSONPhotosubjects;
import film.conversion.entity.EMphotosubjects;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.logicentity.Photosubjects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bphotosubjects
 *
 * Superclass for manipulating data- and database objects
 * for Entity Photosubjects and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphotosubjects extends BLtable {

    /**
     * Constructor, sets Photosubjects as default Entity
     */
    public Bphotosubjects() {
        super(new Photosubjects(), new EMphotosubjects());
    }

    /**
     * Constructor, sets Photosubjects as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphotosubjects(BLtable transactionobject) {
        super(transactionobject, new Photosubjects(), new EMphotosubjects());
    }

    /**
     * create new empty Photosubjects object
     * @return empty IPhotosubjects
     */
    public IPhotosubjects newPhotosubjects() {
    	return new Photosubjects();
    }
    
    /**
     * create new empty Photosubjects object
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param subject primary key field
     * @return IPhotosubjects with primary key
     */
    public IPhotosubjects newPhotosubjects(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new Photosubjects(film, id, cat1, cat2, subject);
    }

    /**
     * create new empty Photosubjects object with given primary key
     * @param photosubjectsPK: primary key for Photosubjects
     * @return IPhotosubjects with primary key
     */
    public IPhotosubjects newPhotosubjects(IPhotosubjectsPK photosubjectsPK) {
        return new Photosubjects((PhotosubjectsPK)photosubjectsPK);
    }

    /**
     * create new empty primary key
     * @return empty PhotosubjectsPK
     */
    public IPhotosubjectsPK newPhotosubjectsPK() {
        return new PhotosubjectsPK();
    }

    /**
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param subject primary key field
     * @return new IPhotosubjectsPK
     */
    public IPhotosubjectsPK newPhotosubjectsPK(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new PhotosubjectsPK(film, id, cat1, cat2, subject);
    }

    /**
     * get all Photosubjects objects from database
     * @return ArrayList of Photosubjects objects
     * @throws DBException
     */
    public ArrayList<Photosubjects> getPhotosubjectss() throws DBException {
        return (ArrayList<Photosubjects>)super.getEntities(EMphotosubjects.SQLSelectAll);
    }

    /**
     * search Photosubjects for primary key
     * @param photosubjectsPK: Photosubjects primary key
     * @return Photosubjects object
     * @throws DBException
     */
    public Photosubjects getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return (Photosubjects)super.getEntity((PhotosubjectsPK)photosubjectsPK);
    }

    /**
     * search photosubjects with IPhotosubjectssearch parameters
     * @param search IPhotosubjectssearch
     * @return ArrayList of Photosubjects
     * @throws DBException 
     */
    public ArrayList<Photosubjects> searchphotosubjectss(IPhotosubjectssearch search) throws DBException {
        return (ArrayList<Photosubjects>)this.search(search);
    }

    /**
     * search photosubjects with IPhotosubjectssearch parameters, order by orderby sql clause
     * @param search IPhotosubjectssearch
     * @param orderby sql order by string
     * @return ArrayList of Photosubjects
     * @throws DBException 
     */
    public ArrayList<Photosubjects> searchphotosubjectss(IPhotosubjectssearch search, String orderby) throws DBException {
        return (ArrayList<Photosubjects>)this.search(search, orderby);
    }

    /**
     * Search photosubjects in database for photosubjectsPK:
     * @param photosubjectsPK: Photosubjects Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhotosubjectsExists(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return super.getEntityExists((PhotosubjectsPK)photosubjectsPK);
    }

    /**
     * try to insert Photosubjects in database
     * @param photosubjects Photosubjects object
     * @throws DBException
     * @throws DataException
     */
    public void insertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        super.insertEntity(photosubjects);
    }

    /**
     * check if PhotosubjectsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param photosubjects Photosubjects object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        if(this.getPhotosubjectsExists(photosubjects.getPrimaryKey())) {
            super.updateEntity(photosubjects);
        } else {
            super.insertEntity(photosubjects);
        }
    }

    /**
     * try to update Photosubjects in database
     * @param photosubjects Photosubjects object
     * @throws DBException
     * @throws DataException
     */
    public void updatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        super.updateEntity(photosubjects);
    }

    /**
     * try to delete Photosubjects in database
     * @param photosubjects Photosubjects object
     * @throws DBException
     */
    public void deletePhotosubjects(IPhotosubjects photosubjects) throws DBException {
        cascadedeletePhotosubjects(photosubjects.getPrimaryKey());
        super.deleteEntity(photosubjects);
    }

    /**
     * check data rules in Photosubjects, throw DataException with customized message if rules do not apply
     * @param photosubjects Photosubjects object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhotosubjects photosubjects) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photosubjects.Film - Photo.Film
        //foreign key Photosubjects.Id - Photo.Id
        //foreign key Photosubjects.Cat1 - Subject.Cat1
        //foreign key Photosubjects.Cat2 - Subject.Cat2
        //foreign key Photosubjects.Subject - Subject.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where photosubjectsPK is used in a primary key
     * @param photosubjectsPK: Photosubjects primary key
     */
    public void cascadedeletePhotosubjects(IPhotosubjectsPK photosubjectsPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Photosubjects Entity objects for Photo in database
     */
    public void delete4photo(IPhotoPK photoPK) {
        super.addStatement(EMphotosubjects.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Photosubjects Entity objects for Photo
     * @throws CustomException
     */
    public ArrayList<Photosubjects> getPhotosubjectss4photo(IPhotoPK photoPK) throws CustomException {
        return super.getEntities(EMphotosubjects.SQLSelect4photo, photoPK.getSQLprimarykey());
    }
    /**
     * @param subjectPK: foreign key for Subject
     * @delete all Photosubjects Entity objects for Subject in database
     */
    public void delete4subject(ISubjectPK subjectPK) {
        super.addStatement(EMphotosubjects.SQLDelete4subject, subjectPK.getSQLprimarykey());
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @return all Photosubjects Entity objects for Subject
     * @throws CustomException
     */
    public ArrayList<Photosubjects> getPhotosubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        return super.getEntities(EMphotosubjects.SQLSelect4subject, subjectPK.getSQLprimarykey());
    }

    /**
     * get all Photosubjects objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Photosubjects objects
     * @throws DBException
     */
    public ArrayList<Photosubjects> getPhotosubjectss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphotosubjects.SQLSelect);
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
        return (ArrayList<Photosubjects>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Photosubjects objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delPhotosubjects(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Photosubjects.table);
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
