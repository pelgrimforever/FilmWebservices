/*
 * Bfilm.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
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
import film.conversion.json.JSONFilm;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmsearch;
import film.logicentity.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bfilm
 *
 * Superclass for manipulating data- and database objects
 * for Entity Film and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfilm extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Film as default Entity
     */
    public Bfilm() {
        super(new SQLMapper_pgsql(connectionpool, "Film"), new Film());
    }

    /**
     * Constructor, sets Film as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilm(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Film());
    }

    /**
     * Map ResultSet Field values to Film
     * @param dbresult: Database ResultSet
     */
    public Film mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmPK filmPK = null;
        Film film;
        if(dbresult==null) {
            film = new Film(filmPK);
        } else {
            try {
                filmPK = new FilmPK(dbresult.getString("id"));
                film = new Film(filmPK);
                film.initFilmtypePK(new FilmtypePK(dbresult.getString("type")));
                if(dbresult.wasNull()) film.setFilmtypePK(null);                
                film.initIso(dbresult.getString("iso"));
                film.initStartdate(dbresult.getDate("startdate"));
                film.initEnddate(dbresult.getDate("enddate"));
                film.initOwner(dbresult.getString("owner"));
                film.initCd(dbresult.getString("cd"));
                film.initPublic(dbresult.getBoolean("public"));
                film.initBackup(dbresult.getBoolean("backup"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, film);
        return film;
    }

    /**
     * create new empty Film object
     * @return empty IFilm
     */
    public IFilm newFilm() {
    	return new Film();
    }
    
    /**
     * create new empty Film object
     * create new primary key with given parameters
     * @return IFilm with primary key
     */
    public IFilm newFilm(java.lang.String id) {
        return new Film(id);
    }

    /**
     * create new empty Film object with given primary key
     * @param filmPK: primary key for Film
     * @return IFilm with primary key
     */
    public IFilm newFilm(IFilmPK filmPK) {
        return new Film((FilmPK)filmPK);
    }

    /**
     * create new empty primary key
     * @return empty FilmPK
     */
    public IFilmPK newFilmPK() {
        return new FilmPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IFilmPK
     */
    public IFilmPK newFilmPK(java.lang.String id) {
        return new FilmPK(id);
    }

    /**
     * get all Film objects from database
     * @return ArrayList of Film objects
     * @throws DBException
     */
    public ArrayList getFilms() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Film.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Film for primary key
     * @param filmPK: Film primary key
     * @return Film object
     * @throws DBException
     */
    public Film getFilm(IFilmPK filmPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Film)super.getEntity((FilmPK)filmPK);
        } else return null;
    }

    public ArrayList searchfilms(IFilmsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchfilms(IFilmsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search film in database for filmPK:
     * @param filmPK: Film Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmExists(IFilmPK filmPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((FilmPK)filmPK);
        } else return false;
    }

    /**
     * try to insert Film in database
     * @param film: Film object
     * @throws DBException
     */
    public void insertFilm(IFilm film) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(film);
        }
    }

    /**
     * check if FilmPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Film object
     * @throws DBException
     */
    public void insertupdateFilm(IFilm film) throws DBException, DataException {
        if(this.getFilmExists(film.getPrimaryKey())) {
            super.updateEntity(film);
        } else {
            super.insertEntity(film);
        }
    }

    /**
     * try to update Film in database
     * @param film: Film object
     * @throws DBException
     */
    public void updateFilm(IFilm film) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(film);
        }
    }

    /**
     * try to delete Film in database
     * @param film: Film object
     * @throws DBException
     */
    public void deleteFilm(IFilm film) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteFilm(film.getOwnerobject(), film.getPrimaryKey());
            super.deleteEntity(film);
        }
    }

    /**
     * check data rules in Film, throw DataException with customized message if rules do not apply
     * @param film: Film object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFilm film) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
	//if(film.getFilmtypePK()!=null && film.getFilmtypePK().getType()!=null && film.getFilmtypePK().getType().length()>IFilm.SIZE_TYPE) {
        if(film.getFilmtypePK()!=null && film.getFilmtypePK().getType()!=null && film.getFilmtypePK().getType().length()>IFilm.SIZE_TYPE) {
            message.append("Type is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_TYPE + "\n");
        }
	//if(film.getFilmtypePK()==null || film.getFilmtypePK().getType()==null) {
        if(film.getFilmtypePK()==null || film.getFilmtypePK().getType()==null) {
            message.append("Type mag niet leeg zijn.\n");
        }

        if(film.getIso()!=null && film.getIso().length()>IFilm.SIZE_ISO) {
            message.append("Iso is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_ISO + "\n");
        }
        if(film.getOwner()!=null && film.getOwner().length()>IFilm.SIZE_OWNER) {
            message.append("Owner is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_OWNER + "\n");
        }
        if(film.getCd()!=null && film.getCd().length()>IFilm.SIZE_CD) {
            message.append("Cd is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_CD + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where filmPK is used in a primary key
     * @param filmPK: Film primary key
     */
    public void cascadedeleteFilm(String senderobject, IFilmPK filmPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.delete4film(senderobject, filmPK);
        BLphoto blphoto = new BLphoto(this);
        blphoto.delete4film(senderobject, filmPK);
    }

    /**
     * @param filmtypePK: foreign key for Filmtype
     * @delete all Film Entity objects for Filmtype in database
     * @throws film.general.exception.CustomException
     */
    public void delete4filmtype(String senderobject, IFilmtypePK filmtypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Film.SQLDelete4filmtype, filmtypePK.getKeyFields());
        }
    }

    /**
     * @param filmtypePK: foreign key for Filmtype
     * @return all Film Entity objects for Filmtype
     * @throws film.general.exception.CustomException
     */
    public ArrayList getFilms4filmtype(IFilmtypePK filmtypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Film.SQLSelect4filmtype, filmtypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param filmsubjectsPK: parent Filmsubjects for child object Film Entity
     * @return child Film Entity object
     * @throws film.general.exception.CustomException
     */
    public IFilm getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            FilmPK filmPK = new FilmPK(filmsubjectsPK.getFilm());
            return this.getFilm(filmPK);
        } else return null;
    }

    /**
     * @param photoPK: parent Photo for child object Film Entity
     * @return child Film Entity object
     * @throws film.general.exception.CustomException
     */
    public IFilm getPhoto(IPhotoPK photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            FilmPK filmPK = new FilmPK(photoPK.getFilm());
            return this.getFilm(filmPK);
        } else return null;
    }


    /**
     * get all Film objects for sqlparameters
     * @return ArrayList of Film objects
     * @throws DBException
     */
    public ArrayList getFilms(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Film.SQLSelect;
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
     * delete all Film objects for sqlparameters
     * @throws DBException
     */
    public void delFilm(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Film.table;
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
