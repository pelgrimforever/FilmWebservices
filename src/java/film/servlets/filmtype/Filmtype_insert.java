/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.filmtype;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Filmtype_insert", urlPatterns={"/film.Filmtype_insert"})
public class Filmtype_insert extends SecurityDataServlet {
   
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
                case IFilmtypeOperation.INSERT_FILMTYPE:
                    insert_filmtype(filmtypeusecases);
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

    private void insert_filmtype(Filmtype_usecases filmtypeusecases) throws CustomException {
        IFilmtype filmtype = (IFilmtype)parser.getJavaObject("filmtype");
        filmtypeusecases.secureinsertFilmtype(filmtype);
    }
    
    @Override
    public String getServletInfo() {
        return "filmtype_insert";
    }

}

