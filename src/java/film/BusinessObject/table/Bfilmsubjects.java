/*
 * Bfilmsubjects.java
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
import film.conversion.json.JSONFilmsubjects;
import film.conversion.entity.EMfilmsubjects;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.logicentity.Filmsubjects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bfilmsubjects
 *
 * Superclass for manipulating data- and database objects
 * for Entity Filmsubjects and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfilmsubjects extends BLtable {

    /**
     * Constructor, sets Filmsubjects as default Entity
     */
    public Bfilmsubjects() {
        super(new Filmsubjects(), new EMfilmsubjects());
    }

    /**
     * Constructor, sets Filmsubjects as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilmsubjects(BLtable transactionobject) {
        super(transactionobject, new Filmsubjects(), new EMfilmsubjects());
    }

    /**
     * create new empty Filmsubjects object
     * @return empty IFilmsubjects
     */
    public IFilmsubjects newFilmsubjects() {
    	return new Filmsubjects();
    }
    
    /**
     * create new empty Filmsubjects object
     * create new primary key with given parameters
     * @param film primary key field
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param subject primary key field
     * @return IFilmsubjects with primary key
     */
    public IFilmsubjects newFilmsubjects(java.lang.String film, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new Filmsubjects(film, cat1, cat2, subject);
    }

    /**
     * create new empty Filmsubjects object with given primary key
     * @param filmsubjectsPK: primary key for Filmsubjects
     * @return IFilmsubjects with primary key
     */
    public IFilmsubjects newFilmsubjects(IFilmsubjectsPK filmsubjectsPK) {
        return new Filmsubjects((FilmsubjectsPK)filmsubjectsPK);
    }

    /**
     * create new empty primary key
     * @return empty FilmsubjectsPK
     */
    public IFilmsubjectsPK newFilmsubjectsPK() {
        return new FilmsubjectsPK();
    }

    /**
     * create new primary key with given parameters
     * @param film primary key field
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param subject primary key field
     * @return new IFilmsubjectsPK
     */
    public IFilmsubjectsPK newFilmsubjectsPK(java.lang.String film, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new FilmsubjectsPK(film, cat1, cat2, subject);
    }

    /**
     * get all Filmsubjects objects from database
     * @return ArrayList of Filmsubjects objects
     * @throws DBException
     */
    public ArrayList<Filmsubjects> getFilmsubjectss() throws DBException {
        return (ArrayList<Filmsubjects>)super.getEntities(EMfilmsubjects.SQLSelectAll);
    }

    /**
     * search Filmsubjects for primary key
     * @param filmsubjectsPK: Filmsubjects primary key
     * @return Filmsubjects object
     * @throws DBException
     */
    public Filmsubjects getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return (Filmsubjects)super.getEntity((FilmsubjectsPK)filmsubjectsPK);
    }

    /**
     * search filmsubjects with IFilmsubjectssearch parameters
     * @param search IFilmsubjectssearch
     * @return ArrayList of Filmsubjects
     * @throws DBException 
     */
    public ArrayList<Filmsubjects> searchfilmsubjectss(IFilmsubjectssearch search) throws DBException {
        return (ArrayList<Filmsubjects>)this.search(search);
    }

    /**
     * search filmsubjects with IFilmsubjectssearch parameters, order by orderby sql clause
     * @param search IFilmsubjectssearch
     * @param orderby sql order by string
     * @return ArrayList of Filmsubjects
     * @throws DBException 
     */
    public ArrayList<Filmsubjects> searchfilmsubjectss(IFilmsubjectssearch search, String orderby) throws DBException {
        return (ArrayList<Filmsubjects>)this.search(search, orderby);
    }

    /**
     * Search filmsubjects in database for filmsubjectsPK:
     * @param filmsubjectsPK: Filmsubjects Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmsubjectsExists(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return super.getEntityExists((FilmsubjectsPK)filmsubjectsPK);
    }

    /**
     * try to insert Filmsubjects in database
     * @param filmsubjects Filmsubjects object
     * @throws DBException
     * @throws DataException
     */
    public void insertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        super.insertEntity(filmsubjects);
    }

    /**
     * check if FilmsubjectsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param filmsubjects Filmsubjects object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        if(this.getFilmsubjectsExists(filmsubjects.getPrimaryKey())) {
            super.updateEntity(filmsubjects);
        } else {
            super.insertEntity(filmsubjects);
        }
    }

    /**
     * try to update Filmsubjects in database
     * @param filmsubjects Filmsubjects object
     * @throws DBException
     * @throws DataException
     */
    public void updateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        super.updateEntity(filmsubjects);
    }

    /**
     * try to delete Filmsubjects in database
     * @param filmsubjects Filmsubjects object
     * @throws DBException
     */
    public void deleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException {
        cascadedeleteFilmsubjects(filmsubjects.getPrimaryKey());
        super.deleteEntity(filmsubjects);
    }

    /**
     * check data rules in Filmsubjects, throw DataException with customized message if rules do not apply
     * @param filmsubjects Filmsubjects object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFilmsubjects filmsubjects) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Filmsubjects.Film - Film.Id
        //foreign key Filmsubjects.Cat1 - Subject.Cat1
        //foreign key Filmsubjects.Cat2 - Subject.Cat2
        //foreign key Filmsubjects.Subject - Subject.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where filmsubjectsPK is used in a primary key
     * @param filmsubjectsPK: Filmsubjects primary key
     */
    public void cascadedeleteFilmsubjects(IFilmsubjectsPK filmsubjectsPK) {
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @delete all Filmsubjects Entity objects for Subject in database
     */
    public void delete4subject(ISubjectPK subjectPK) {
        super.addStatement(EMfilmsubjects.SQLDelete4subject, subjectPK.getSQLprimarykey());
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @return all Filmsubjects Entity objects for Subject
     * @throws CustomException
     */
    public ArrayList<Filmsubjects> getFilmsubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        return super.getEntities(EMfilmsubjects.SQLSelect4subject, subjectPK.getSQLprimarykey());
    }
    /**
     * @param filmPK: foreign key for Film
     * @delete all Filmsubjects Entity objects for Film in database
     */
    public void delete4film(IFilmPK filmPK) {
        super.addStatement(EMfilmsubjects.SQLDelete4film, filmPK.getSQLprimarykey());
    }

    /**
     * @param filmPK: foreign key for Film
     * @return all Filmsubjects Entity objects for Film
     * @throws CustomException
     */
    public ArrayList<Filmsubjects> getFilmsubjectss4film(IFilmPK filmPK) throws CustomException {
        return super.getEntities(EMfilmsubjects.SQLSelect4film, filmPK.getSQLprimarykey());
    }

    /**
     * get all Filmsubjects objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Filmsubjects objects
     * @throws DBException
     */
    public ArrayList<Filmsubjects> getFilmsubjectss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilmsubjects.SQLSelect);
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
        return (ArrayList<Filmsubjects>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Filmsubjects objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFilmsubjects(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Filmsubjects.table);
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
