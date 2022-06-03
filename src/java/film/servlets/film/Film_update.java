/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.film;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilm;
import film.interfaces.servlet.IFilmOperation;
import film.interfaces.searchentity.IFilmsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Film_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Film_update", urlPatterns={"/film.Film_update"})
public class Film_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Film_usecases filmusecases = new Film_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFilmOperation.UPDATE_FILM:
                    update_film(filmusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IFilmOperation.UPDATE_PROPERTIES:
                    update_properties(filmusecases);
                    break;
                case IFilmOperation.UPDATE_LOADJPGPROPERTIES:
                    updateFilm_LoadJPGproperties(filmusecases);
                    break;
                case IFilmOperation.UPDATE_LOADGPSTRACKS:
                    updateFilm_LoadGPSproperties(filmusecases);
                    break;
//Custom code, do not change this line   
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
    private void update_properties(Film_usecases filmusecases) throws CustomException {
        IFilm film = (IFilm)parser.getJavaObject("film");
        filmusecases.update_properties(userprofile, film);
    }

    private void updateFilm_LoadJPGproperties(Film_usecases filmusecases) throws CustomException {
        IFilm film = (IFilm)parser.getJavaObject("film");
        filmusecases.updateFilm_LoadJPGproperties(userprofile, film);
    }

    private void updateFilm_LoadGPSproperties(Film_usecases filmusecases) throws CustomException {
        IFilm film = (IFilm)parser.getJavaObject("film");
        ArrayList<film.logicentity.GPSTrackpoint> gpstrackpoints = (ArrayList<film.logicentity.GPSTrackpoint>)parser.getJavaObject("gpstrackpoints");
        filmusecases.updateFilm_LoadGPSproperties(userprofile, film, gpstrackpoints);
    }
//Custom code, do not change this line   

    private void update_film(Film_usecases filmusecases) throws CustomException {
        IFilm film = (IFilm)parser.getJavaObject("film");
        filmusecases.secureupdateFilm(film);
    }
    
    @Override
    public String getServletInfo() {
        return "film_insert";
    }

}

