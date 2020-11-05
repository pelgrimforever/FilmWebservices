/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilm;
import film.interfaces.servlet.IFilmOperation;
import film.interfaces.searchentity.IFilmsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Film", urlPatterns={"/film.Film"})
public class Film extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLfilm blfilm = new BLfilm();
        blfilm.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IFilmPK filmPK;
                    IFilm film;
                    switch(this.operation) {
                        case IFilmOperation.SELECT_ALL:
                            dataobject = blfilm.getFilms();
                            break;
                        case IFilmOperation.SELECT_FILM:
                            filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = blfilm.getFilm(filmPK);
                            break;
                        case IFilmOperation.SELECT_Filmtype:
                            IFilmtypePK filmtypePK = (IFilmtypePK)parser.getJavaObject("filmtypepk");
                            dataobject = blfilm.getFilms4filmtype(filmtypePK);
                            break;
                        case IFilmOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
                            dataobject = blfilm.getFilmsubjects(filmsubjectsPK);
                            break;
                        case IFilmOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blfilm.getPhoto(photoPK);
                            break;
                        case IFilmOperation.SELECT_SEARCH:
                            IFilmsearch search = (IFilmsearch)parser.getJavaObject("search");
                            dataobject = blfilm.search(search);
                            break;
                        case IFilmOperation.SELECT_SEARCHCOUNT:
                            IFilmsearch filmsearch = (IFilmsearch)parser.getJavaObject("search");
                            dataobject = blfilm.searchcount(filmsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IFilmOperation.SELECT_ALL4EDIT:
                            ArrayList films4edit = blfilm.getFilms4Edit(userprofile);
                            dataobject = films4edit;
                            break;
                        case IFilmOperation.SELECT_GROUPS:
                            ArrayList groups = blfilm.getGroups();
                            dataobject = groups;
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IFilmOperation.INSERT_FILM:
                            film = (IFilm)parser.getJavaObject("film");
                            blfilm.insertFilm(film);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IFilmOperation.UPDATE_FILM:
                            film = (IFilm)parser.getJavaObject("film");
                            blfilm.updateFilm(film);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IFilmOperation.UPDATE_PROPERTIES:
                            film = (IFilm)parser.getJavaObject("film");
                            //ArrayList subjects = (ArrayList)parser.getJavaObject("subjects");
                            blfilm.updateFilm(userprofile, film);
                            break;
                        case IFilmOperation.UPDATE_LOADJPGPROPERTIES:
                            film = (IFilm)parser.getJavaObject("film");
                            blfilm.updateFilm_LoadJPGproperties(userprofile, film);
                            break;
                        case IFilmOperation.UPDATE_LOADGPSTRACKS:
                            film = (IFilm)parser.getJavaObject("film");
                            ArrayList<film.logicentity.GPSTrackpoint> gpstrackpoints = (ArrayList<film.logicentity.GPSTrackpoint>)parser.getJavaObject("gpstrackpoints");
                            blfilm.updateFilm_LoadGPSproperties(userprofile, film, gpstrackpoints);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IFilmOperation.DELETE_FILM:
                            film = (IFilm)parser.getJavaObject("film");
                            blfilm.deleteFilm(film);
                            break;
                        case IFilmOperation.DELETE_Filmtype:
                            IFilmtypePK filmtypePK = (IFilmtypePK)parser.getJavaObject("filmtypepk");
                            blfilm.delete4filmtype(this.getServletName(), filmtypePK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
                        case IFilmOperation.BACKUP_PHOTOIMAGE:
                            filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            blfilm.backupPhoto(this.getServletName(), filmPK);
                            break;
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "film";
    }

}

