/*
 * Generated on 27.6.2022 16:45
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Film;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Film_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfilm blfilm = new BLfilm(sqlreader);
    
    public Film_usecases() {
        this(false);
    }
    
    public Film_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfilm.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Film> getFilms4Edit(film.logic.Userprofile userprofile) throws DBException {
        return blfilm.getFilms4Edit(userprofile);
    }

    public ArrayList<String> getFilmGroups() throws DBException {
        return blfilm.getGroups();
    }
    
    public void update_properties(film.logic.Userprofile userprofile, IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm(tq, userprofile, film);
        sqlwriter.Commit2DB(tq);
    }
    
    public void updateFilm_LoadJPGproperties(film.logic.Userprofile userprofile, IFilm film) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm_LoadJPGproperties(tq, userprofile, film);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFilm_LoadGPSproperties(film.logic.Userprofile userprofile, IFilm film, ArrayList<film.logicentity.GPSTrackpoint> gpstrackpoints) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm_LoadGPSproperties(tq, userprofile, film, gpstrackpoints);
        sqlwriter.Commit2DB(tq);
    }

    public void backupPhotos(IFilmPK filmPK) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.backupPhoto(tq, "Film_usecases.backupPhotos", filmPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public ArrayList<String> Checkbackup() throws DBException, CustomException {
        return blfilm.Checkbackup();
    }

//Custom code, do not change this line   

    public long count() throws DBException {
        return blfilm.count();
    }
    
    public ArrayList<Film> get_all() throws DBException {
        return blfilm.getFilms();
    }
    
    public boolean getFilmExists(IFilmPK filmPK) throws DBException {
        return blfilm.getFilmExists(filmPK);
    }
    
    public Film get_film_by_primarykey(IFilmPK filmPK) throws DBException {
        return blfilm.getFilm(filmPK);
    }

    public ArrayList<Film> get_film_with_foreignkey_filmtype(IFilmtypePK filmtypePK) throws CustomException {
        return blfilm.getFilms4filmtype(filmtypePK);
    }
    
    public Film get_film_with_externalforeignkey_filmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        return blfilm.getFilmsubjects(filmsubjectsPK);
    }
    
    public Film get_film_with_externalforeignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blfilm.getPhoto(photoPK);
    }
    
    public ArrayList<Film> search_film(IFilmsearch filmsearch) throws CustomException {
        return blfilm.search(filmsearch);
    }
    
    public long search_film_count(IFilmsearch filmsearch) throws CustomException {
        return blfilm.searchcount(filmsearch);
    }

    public void insertFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.insertFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.deleteFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Filmtype(IFilmtypePK filmtypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.delete4filmtype(tq, filmtypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

