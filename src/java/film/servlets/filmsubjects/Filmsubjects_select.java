/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.filmsubjects;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilmsubjects;
import film.interfaces.servlet.IFilmsubjectsOperation;
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Filmsubjects_usecases;
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
@WebServlet(name="Filmsubjects_select", urlPatterns={"/film.Filmsubjects_select"})
public class Filmsubjects_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFilmsubjectsOperation.SELECT_ALL:
                    dataobject = filmsubjectsusecases.get_all();
                    break;
                case IFilmsubjectsOperation.SELECT_FILMSUBJECTS:
                    dataobject = get_filmsubjects_with_primarykey(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_Subject:
                    dataobject = get_filmsubjects_with_foreignkey_subject(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_Film:
                    dataobject = get_filmsubjects_with_foreignkey_film(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_SEARCH:
                    dataobject = search_filmsubjects(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_filmsubjects_count(filmsubjectsusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
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
//Custom code, do not change this line   

    private Object get_filmsubjects_with_primarykey(Filmsubjects_usecases filmsubjectsusecases) throws DBException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
        return filmsubjectsusecases.get_filmsubjects_by_primarykey(filmsubjectsPK);
    }

    private Object get_filmsubjects_with_foreignkey_subject(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
        return filmsubjectsusecases.get_filmsubjects_with_foreignkey_subject(subjectPK);
    }
    
    private Object get_filmsubjects_with_foreignkey_film(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        return filmsubjectsusecases.get_filmsubjects_with_foreignkey_film(filmPK);
    }
    
    private Object search_filmsubjects(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        IFilmsubjectssearch search = (IFilmsubjectssearch)parser.getJavaObject("search");
        return filmsubjectsusecases.search_filmsubjects(search);
    }
    
    private Object search_filmsubjects_count(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)parser.getJavaObject("search");
        return filmsubjectsusecases.search_filmsubjects_count(filmsubjectssearch);
    }

    @Override
    public String getServletInfo() {
        return "filmsubjects_select";
    }

}

