/*
 * Bfilm.java
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
import film.conversion.json.JSONFilm;
import film.conversion.entity.EMfilm;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bfilm extends BLtable {

    /**
     * Constructor, sets Film as default Entity
     */
    public Bfilm() {
        super(new Film(), new EMfilm());
    }

    /**
     * Constructor, sets Film as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilm(BLtable transactionobject) {
        super(transactionobject, new Film(), new EMfilm());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Film> getFilms() throws DBException {
        return (ArrayList<Film>)super.getEntities(EMfilm.SQLSelectAll);
    }

    /**
     * search Film for primary key
     * @param filmPK: Film primary key
     * @return Film object
     * @throws DBException
     */
    public Film getFilm(IFilmPK filmPK) throws DBException {
        return (Film)super.getEntity((FilmPK)filmPK);
    }

    /**
     * search film with IFilmsearch parameters
     * @param search IFilmsearch
     * @return ArrayList of Film
     * @throws DBException 
     */
    public ArrayList<Film> searchfilms(IFilmsearch search) throws DBException {
        return (ArrayList<Film>)this.search(search);
    }

    /**
     * search film with IFilmsearch parameters, order by orderby sql clause
     * @param search IFilmsearch
     * @param orderby sql order by string
     * @return ArrayList of Film
     * @throws DBException 
     */
    public ArrayList<Film> searchfilms(IFilmsearch search, String orderby) throws DBException {
        return (ArrayList<Film>)this.search(search, orderby);
    }

    /**
     * Search film in database for filmPK:
     * @param filmPK: Film Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmExists(IFilmPK filmPK) throws DBException {
        return super.getEntityExists((FilmPK)filmPK);
    }

    /**
     * try to insert Film in database
     * @param film Film object
     * @throws DBException
     * @throws DataException
     */
    public void insertFilm(IFilm film) throws DBException, DataException {
        super.insertEntity(film);
    }

    /**
     * check if FilmPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film Film object
     * @throws DBException
     * @throws DataException
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
     * @param film Film object
     * @throws DBException
     * @throws DataException
     */
    public void updateFilm(IFilm film) throws DBException, DataException {
        super.updateEntity(film);
    }

    /**
     * try to delete Film in database
     * @param film Film object
     * @throws DBException
     */
    public void deleteFilm(IFilm film) throws DBException {
        cascadedeleteFilm(film.getPrimaryKey());
        super.deleteEntity(film);
    }

    /**
     * check data rules in Film, throw DataException with customized message if rules do not apply
     * @param film Film object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFilm film) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(film.getFilmtypePK()!=null && film.getFilmtypePK().getType()!=null && film.getFilmtypePK().getType().length()>IFilm.SIZE_TYPE) {
            message.append("Type is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_TYPE + "\n");
        }
        if(film.getFilmtypePK()==null || film.getFilmtypePK().getType()==null) {
            message.append("Type mag niet leeg zijn.\n");
        }

        if(film.getIso()!=null && film.getIso().length()>IFilm.SIZE_ISO) {
            message.append("Iso is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_ISO).append("\n");
        }
        if(film.getOwner()!=null && film.getOwner().length()>IFilm.SIZE_OWNER) {
            message.append("Owner is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_OWNER).append("\n");
        }
        if(film.getCd()!=null && film.getCd().length()>IFilm.SIZE_CD) {
            message.append("Cd is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_CD).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where filmPK is used in a primary key
     * @param filmPK: Film primary key
     */
    public void cascadedeleteFilm(IFilmPK filmPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.delete4film(filmPK);
        BLphoto blphoto = new BLphoto(this);
        blphoto.delete4film(filmPK);
    }

    /**
     * @param filmtypePK: foreign key for Filmtype
     * @delete all Film Entity objects for Filmtype in database
     */
    public void delete4filmtype(IFilmtypePK filmtypePK) {
        super.addStatement(EMfilm.SQLDelete4filmtype, filmtypePK.getSQLprimarykey());
    }

    /**
     * @param filmtypePK: foreign key for Filmtype
     * @return all Film Entity objects for Filmtype
     * @throws CustomException
     */
    public ArrayList<Film> getFilms4filmtype(IFilmtypePK filmtypePK) throws CustomException {
        return super.getEntities(EMfilm.SQLSelect4filmtype, filmtypePK.getSQLprimarykey());
    }
    /**
     * @param filmsubjectsPK: parent Filmsubjects for child object Film Entity
     * @return child Film Entity object
     * @throws CustomException
     */
    public Film getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        FilmPK filmPK = new FilmPK(filmsubjectsPK.getFilm());
        return this.getFilm(filmPK);
    }

    /**
     * @param photoPK: parent Photo for child object Film Entity
     * @return child Film Entity object
     * @throws CustomException
     */
    public Film getPhoto(IPhotoPK photoPK) throws CustomException {
        FilmPK filmPK = new FilmPK(photoPK.getFilm());
        return this.getFilm(filmPK);
    }


    /**
     * get all Film objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Film objects
     * @throws DBException
     */
    public ArrayList<Film> getFilms(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilm.SQLSelect);
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
        return (ArrayList<Film>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Film objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFilm(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Film.table);
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
