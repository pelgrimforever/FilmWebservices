/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArt_academy;
import film.interfaces.servlet.IArt_academyOperation;
import film.interfaces.searchentity.IArt_academysearch;
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
@WebServlet(name="Art_academy", urlPatterns={"/film.Art_academy"})
public class Art_academy extends SecurityDataServlet {
   
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
        BLart_academy blart_academy = new BLart_academy();
        blart_academy.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArt_academyPK art_academyPK;
                    IArt_academy art_academy;
                    switch(this.operation) {
                        case IArt_academyOperation.SELECT_ALL:
                            dataobject = blart_academy.getArt_academys();
                            break;
                        case IArt_academyOperation.SELECT_ART_ACADEMY:
                            art_academyPK = (IArt_academyPK)parser.getJavaObject("art_academypk");
                            dataobject = blart_academy.getArt_academy(art_academyPK);
                            break;
                        case IArt_academyOperation.SELECT_SEARCH:
                            IArt_academysearch search = (IArt_academysearch)parser.getJavaObject("search");
                            dataobject = blart_academy.search(search);
                            break;
                        case IArt_academyOperation.SELECT_SEARCHCOUNT:
                            IArt_academysearch art_academysearch = (IArt_academysearch)parser.getJavaObject("search");
                            dataobject = blart_academy.searchcount(art_academysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArt_academyOperation.INSERT_ART_ACADEMY:
                            art_academy = (IArt_academy)parser.getJavaObject("art_academy");
                            blart_academy.insertArt_academy(art_academy);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArt_academyOperation.UPDATE_ART_ACADEMY:
                            art_academy = (IArt_academy)parser.getJavaObject("art_academy");
                            blart_academy.updateArt_academy(art_academy);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArt_academyOperation.DELETE_ART_ACADEMY:
                            art_academy = (IArt_academy)parser.getJavaObject("art_academy");
                            blart_academy.deleteArt_academy(art_academy);
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
        return "art_academy";
    }

}

