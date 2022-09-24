/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.film;

import general.exception.*;
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

@WebServlet(name="Film_select", urlPatterns={"/film.Film_select"})
public class Film_select extends SecurityDataServlet {
   
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
                case IFilmOperation.SELECT_ALL:
                    dataobject = filmusecases.get_all();
                    break;
                case IFilmOperation.SELECT_FILM:
                    dataobject = get_film_with_primarykey(filmusecases);
                    break;
                case IFilmOperation.SELECT_Filmtype:
                    dataobject = get_film_with_foreignkey_filmtype(filmusecases);
                    break;
                case IFilmOperation.SELECT_Filmsubjects:
                    dataobject = get_film_with_externalforeignkey_filmsubjects(filmusecases);
                    break;
                case IFilmOperation.SELECT_Photo:
                    dataobject = get_film_with_externalforeignkey_photo(filmusecases);
                    break;
                case IFilmOperation.SELECT_SEARCH:
                    dataobject = search_film(filmusecases);
                    break;
                case IFilmOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_film_count(filmusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IFilmOperation.SELECT_ALL4EDIT:
                    dataobject = getFilms4Edit(filmusecases);
                    break;
                case IFilmOperation.SELECT_GROUPS:
                    dataobject = getFilmGroups(filmusecases);
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
    private Object getFilms4Edit(Film_usecases filmusecases) throws DBException {
        return filmusecases.getFilms4Edit(userprofile);
    }

    private Object getFilmGroups(Film_usecases filmusecases) throws DBException {
        return filmusecases.getFilmGroups();
    }
//Custom code, do not change this line   

    private Object get_film_with_primarykey(Film_usecases filmusecases) throws DBException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        return filmusecases.get_film_by_primarykey(filmPK);
    }

    private Object get_film_with_foreignkey_filmtype(Film_usecases filmusecases) throws CustomException {
        IFilmtypePK filmtypePK = (IFilmtypePK)parser.getJavaObject("filmtypepk");
        return filmusecases.get_film_with_foreignkey_filmtype(filmtypePK);
    }
    
    private Object get_film_with_externalforeignkey_filmsubjects(Film_usecases filmusecases) throws CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
        return filmusecases.get_film_with_externalforeignkey_filmsubjects(filmsubjectsPK);
    }
    
    private Object get_film_with_externalforeignkey_photo(Film_usecases filmusecases) throws CustomException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return filmusecases.get_film_with_externalforeignkey_photo(photoPK);
    }
    
    private Object search_film(Film_usecases filmusecases) throws CustomException {
        IFilmsearch search = (IFilmsearch)parser.getJavaObject("search");
        return filmusecases.search_film(search);
    }
    
    private Object search_film_count(Film_usecases filmusecases) throws CustomException {
        IFilmsearch filmsearch = (IFilmsearch)parser.getJavaObject("search");
        return filmusecases.search_film_count(filmsearch);
    }

    @Override
    public String getServletInfo() {
        return "film_select";
    }

}

