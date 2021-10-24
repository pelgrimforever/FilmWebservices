/*
 * Art_group.java
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
import film.interfaces.logicentity.IArt_group;
import film.interfaces.servlet.IArt_groupOperation;
import film.interfaces.searchentity.IArt_groupsearch;
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
@WebServlet(name="Art_group", urlPatterns={"/film.Art_group"})
public class Art_group extends SecurityDataServlet {
   
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
        BLart_group blart_group = new BLart_group();
        blart_group.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArt_groupPK art_groupPK;
                    IArt_group art_group;
                    switch(this.operation) {
                        case IArt_groupOperation.SELECT_ALL:
                            dataobject = blart_group.getArt_groups();
                            break;
                        case IArt_groupOperation.SELECT_ART_GROUP:
                            art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
                            dataobject = blart_group.getArt_group(art_groupPK);
                            break;
                        case IArt_groupOperation.SELECT_SEARCH:
                            IArt_groupsearch search = (IArt_groupsearch)parser.getJavaObject("search");
                            dataobject = blart_group.search(search);
                            break;
                        case IArt_groupOperation.SELECT_SEARCHCOUNT:
                            IArt_groupsearch art_groupsearch = (IArt_groupsearch)parser.getJavaObject("search");
                            dataobject = blart_group.searchcount(art_groupsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArt_groupOperation.INSERT_ART_GROUP:
                            art_group = (IArt_group)parser.getJavaObject("art_group");
                            blart_group.insertArt_group(art_group);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArt_groupOperation.UPDATE_ART_GROUP:
                            art_group = (IArt_group)parser.getJavaObject("art_group");
                            blart_group.updateArt_group(art_group);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArt_groupOperation.DELETE_ART_GROUP:
                            art_group = (IArt_group)parser.getJavaObject("art_group");
                            blart_group.deleteArt_group(art_group);
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
        return "art_group";
    }

}

