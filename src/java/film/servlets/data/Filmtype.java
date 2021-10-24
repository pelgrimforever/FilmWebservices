/*
 * Filmtype.java
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
import film.interfaces.logicentity.IFilmtype;
import film.interfaces.servlet.IFilmtypeOperation;
import film.interfaces.searchentity.IFilmtypesearch;
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
@WebServlet(name="Filmtype", urlPatterns={"/film.Filmtype"})
public class Filmtype extends SecurityDataServlet {
   
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
        BLfilmtype blfilmtype = new BLfilmtype();
        blfilmtype.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IFilmtypePK filmtypePK;
                    IFilmtype filmtype;
                    switch(this.operation) {
                        case IFilmtypeOperation.SELECT_ALL:
                            dataobject = blfilmtype.getFilmtypes();
                            break;
                        case IFilmtypeOperation.SELECT_FILMTYPE:
                            filmtypePK = (IFilmtypePK)parser.getJavaObject("filmtypepk");
                            dataobject = blfilmtype.getFilmtype(filmtypePK);
                            break;
                        case IFilmtypeOperation.SELECT_SEARCH:
                            IFilmtypesearch search = (IFilmtypesearch)parser.getJavaObject("search");
                            dataobject = blfilmtype.search(search);
                            break;
                        case IFilmtypeOperation.SELECT_SEARCHCOUNT:
                            IFilmtypesearch filmtypesearch = (IFilmtypesearch)parser.getJavaObject("search");
                            dataobject = blfilmtype.searchcount(filmtypesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IFilmtypeOperation.INSERT_FILMTYPE:
                            filmtype = (IFilmtype)parser.getJavaObject("filmtype");
                            blfilmtype.insertFilmtype(filmtype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IFilmtypeOperation.UPDATE_FILMTYPE:
                            filmtype = (IFilmtype)parser.getJavaObject("filmtype");
                            blfilmtype.updateFilmtype(filmtype);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IFilmtypeOperation.DELETE_FILMTYPE:
                            filmtype = (IFilmtype)parser.getJavaObject("filmtype");
                            blfilmtype.deleteFilmtype(filmtype);
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
        return "filmtype";
    }

}

