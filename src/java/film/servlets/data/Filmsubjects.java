/*
 * Filmsubjects.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilmsubjects;
import film.interfaces.servlet.IFilmsubjectsOperation;
import film.interfaces.searchentity.IFilmsubjectssearch;
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
@WebServlet(name="Filmsubjects", urlPatterns={"/film.Filmsubjects"})
public class Filmsubjects extends SecurityDataServlet {
   
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
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        blfilmsubjects.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IFilmsubjectsPK filmsubjectsPK;
                    IFilmsubjects filmsubjects;
                    switch(this.operation) {
                        case IFilmsubjectsOperation.SELECT_ALL:
                            dataobject = blfilmsubjects.getFilmsubjectss();
                            break;
                        case IFilmsubjectsOperation.SELECT_FILMSUBJECTS:
                            filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
                            dataobject = blfilmsubjects.getFilmsubjects(filmsubjectsPK);
                            break;
                        case IFilmsubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            dataobject = blfilmsubjects.getFilmsubjectss4subject(subjectPK);
                            break;
                        case IFilmsubjectsOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = blfilmsubjects.getFilmsubjectss4film(filmPK);
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCH:
                            IFilmsubjectssearch search = (IFilmsubjectssearch)parser.getJavaObject("search");
                            dataobject = blfilmsubjects.search(search);
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCHCOUNT:
                            IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)parser.getJavaObject("search");
                            dataobject = blfilmsubjects.searchcount(filmsubjectssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IFilmsubjectsOperation.INSERT_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)parser.getJavaObject("filmsubjects");
                            blfilmsubjects.insertFilmsubjects(filmsubjects);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IFilmsubjectsOperation.UPDATE_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)parser.getJavaObject("filmsubjects");
                            blfilmsubjects.updateFilmsubjects(filmsubjects);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IFilmsubjectsOperation.DELETE_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)parser.getJavaObject("filmsubjects");
                            blfilmsubjects.deleteFilmsubjects(filmsubjects);
                            break;
                        case IFilmsubjectsOperation.DELETE_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            blfilmsubjects.delete4subject(subjectPK);
                            break;
                        case IFilmsubjectsOperation.DELETE_Film:
                            IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            blfilmsubjects.delete4film(filmPK);
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
        return "filmsubjects";
    }

}

