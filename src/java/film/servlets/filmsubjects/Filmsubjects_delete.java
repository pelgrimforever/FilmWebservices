/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.filmsubjects;

import general.exception.CustomException;
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

@WebServlet(name="Filmsubjects_delete", urlPatterns={"/film.Filmsubjects_delete"})
public class Filmsubjects_delete extends SecurityDataServlet {
   
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
                case IFilmsubjectsOperation.DELETE_FILMSUBJECTS:
                    delete_filmsubjects(filmsubjectsusecases);
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

    private void delete_filmsubjects(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)parser.getJavaObject("filmsubjects");
        filmsubjectsusecases.deleteFilmsubjects(filmsubjects);
    }
    
    @Override
    public String getServletInfo() {
        return "filmsubjects_insert";
    }

}

