/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.filmtype;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilmtype;
import film.interfaces.servlet.IFilmtypeOperation;
import film.interfaces.searchentity.IFilmtypesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Filmtype_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Filmtype_select", urlPatterns={"/film.Filmtype_select"})
public class Filmtype_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Filmtype_usecases filmtypeusecases = new Filmtype_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFilmtypeOperation.SELECT_ALL:
                    dataobject = filmtypeusecases.get_all();
                    break;
                case IFilmtypeOperation.SELECT_FILMTYPE:
                    dataobject = get_filmtype_with_primarykey(filmtypeusecases);
                    break;
                case IFilmtypeOperation.SELECT_SEARCH:
                    dataobject = search_filmtype(filmtypeusecases);
                    break;
                case IFilmtypeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_filmtype_count(filmtypeusecases);
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

    private Object get_filmtype_with_primarykey(Filmtype_usecases filmtypeusecases) throws DBException {
        IFilmtypePK filmtypePK = (IFilmtypePK)parser.getJavaObject("filmtypepk");
        return filmtypeusecases.get_filmtype_by_primarykey(filmtypePK);
    }

    private Object search_filmtype(Filmtype_usecases filmtypeusecases) throws CustomException {
        IFilmtypesearch search = (IFilmtypesearch)parser.getJavaObject("search");
        return filmtypeusecases.search_filmtype(search);
    }
    
    private Object search_filmtype_count(Filmtype_usecases filmtypeusecases) throws CustomException {
        IFilmtypesearch filmtypesearch = (IFilmtypesearch)parser.getJavaObject("search");
        return filmtypeusecases.search_filmtype_count(filmtypesearch);
    }

    @Override
    public String getServletInfo() {
        return "filmtype_select";
    }

}

