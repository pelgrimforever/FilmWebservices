/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Filmsubjects_update", urlPatterns={"/film.Filmsubjects_update"})
public class Filmsubjects_update extends SecurityDataServlet {
   
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
                case IFilmsubjectsOperation.UPDATE_FILMSUBJECTS:
                    update_filmsubjects(filmsubjectsusecases);
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

    private void update_filmsubjects(Filmsubjects_usecases filmsubjectsusecases) throws CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)parser.getJavaObject("filmsubjects");
        filmsubjectsusecases.secureupdateFilmsubjects(filmsubjects);
    }
    
    @Override
    public String getServletInfo() {
        return "filmsubjects_insert";
    }

}

