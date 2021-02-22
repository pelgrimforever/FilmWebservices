/*
 * Bfilmsubjects.java
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
import film.conversion.json.JSONFilmsubjects;
import film.data.ProjectConstants;
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
public abstract class Bfilmsubjects extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Filmsubjects as default Entity
     */
    public Bfilmsubjects() {
        super(new SQLMapper_pgsql(connectionpool, "Filmsubjects"), new Filmsubjects());
    }

    /**
     * Constructor, sets Filmsubjects as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilmsubjects(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Filmsubjects());
    }

    /**
     * Map ResultSet Field values to Filmsubjects
     * @param dbresult: Database ResultSet
     */
    public Filmsubjects mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmsubjectsPK filmsubjectsPK = null;
        Filmsubjects filmsubjects;
        if(dbresult==null) {
            filmsubjects = new Filmsubjects(filmsubjectsPK);
        } else {
            try {
                filmsubjectsPK = new FilmsubjectsPK(dbresult.getString("film"), dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("subject"));
                filmsubjects = new Filmsubjects(filmsubjectsPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, filmsubjects);
        return filmsubjects;
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
    public ArrayList getFilmsubjectss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Filmsubjects.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Filmsubjects for primary key
     * @param filmsubjectsPK: Filmsubjects primary key
     * @return Filmsubjects object
     * @throws DBException
     */
    public Filmsubjects getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Filmsubjects)super.getEntity((FilmsubjectsPK)filmsubjectsPK);
        } else return null;
    }

    public ArrayList searchfilmsubjectss(IFilmsubjectssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchfilmsubjectss(IFilmsubjectssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search filmsubjects in database for filmsubjectsPK:
     * @param filmsubjectsPK: Filmsubjects Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmsubjectsExists(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((FilmsubjectsPK)filmsubjectsPK);
        } else return false;
    }

    /**
     * try to insert Filmsubjects in database
     * @param film: Filmsubjects object
     * @throws DBException
     */
    public void insertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(filmsubjects);
        }
    }

    /**
     * check if FilmsubjectsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Filmsubjects object
     * @throws DBException
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
     * @param film: Filmsubjects object
     * @throws DBException
     */
    public void updateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(filmsubjects);
        }
    }

    /**
     * try to delete Filmsubjects in database
     * @param film: Filmsubjects object
     * @throws DBException
     */
    public void deleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteFilmsubjects(filmsubjects.getOwnerobject(), filmsubjects.getPrimaryKey());
            super.deleteEntity(filmsubjects);
        }
    }

    /**
     * check data rules in Filmsubjects, throw DataException with customized message if rules do not apply
     * @param film: Filmsubjects object
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
    public void cascadedeleteFilmsubjects(String senderobject, IFilmsubjectsPK filmsubjectsPK) {
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @delete all Filmsubjects Entity objects for Subject in database
     * @throws film.general.exception.CustomException
     */
    public void delete4subject(String senderobject, ISubjectPK subjectPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Filmsubjects.SQLDelete4subject, subjectPK.getKeyFields());
        }
    }

    /**
     * @param subjectPK: foreign key for Subject
     * @return all Filmsubjects Entity objects for Subject
     * @throws film.general.exception.CustomException
     */
    public ArrayList getFilmsubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Filmsubjects.SQLSelect4subject, subjectPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param filmPK: foreign key for Film
     * @delete all Filmsubjects Entity objects for Film in database
     * @throws film.general.exception.CustomException
     */
    public void delete4film(String senderobject, IFilmPK filmPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Filmsubjects.SQLDelete4film, filmPK.getKeyFields());
        }
    }

    /**
     * @param filmPK: foreign key for Film
     * @return all Filmsubjects Entity objects for Film
     * @throws film.general.exception.CustomException
     */
    public ArrayList getFilmsubjectss4film(IFilmPK filmPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Filmsubjects.SQLSelect4film, filmPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Filmsubjects objects for sqlparameters
     * @return ArrayList of Filmsubjects objects
     * @throws DBException
     */
    public ArrayList getFilmsubjectss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Filmsubjects.SQLSelect;
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
     * delete all Filmsubjects objects for sqlparameters
     * @throws DBException
     */
    public void delFilmsubjects(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Filmsubjects.table;
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
