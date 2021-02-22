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
import film.interfaces.logicentity.IArt_subgroup;
import film.interfaces.servlet.IArt_subgroupOperation;
import film.interfaces.searchentity.IArt_subgroupsearch;
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
@WebServlet(name="Art_subgroup", urlPatterns={"/film.Art_subgroup"})
public class Art_subgroup extends SecurityDataServlet {
   
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
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        blart_subgroup.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArt_subgroupPK art_subgroupPK;
                    IArt_subgroup art_subgroup;
                    switch(this.operation) {
                        case IArt_subgroupOperation.SELECT_ALL:
                            dataobject = blart_subgroup.getArt_subgroups();
                            break;
                        case IArt_subgroupOperation.SELECT_ART_SUBGROUP:
                            art_subgroupPK = (IArt_subgroupPK)parser.getJavaObject("art_subgrouppk");
                            dataobject = blart_subgroup.getArt_subgroup(art_subgroupPK);
                            break;
                        case IArt_subgroupOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
                            dataobject = blart_subgroup.getArt_subgroups4art_group(art_groupPK);
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCH:
                            IArt_subgroupsearch search = (IArt_subgroupsearch)parser.getJavaObject("search");
                            dataobject = blart_subgroup.search(search);
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCHCOUNT:
                            IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)parser.getJavaObject("search");
                            dataobject = blart_subgroup.searchcount(art_subgroupsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArt_subgroupOperation.INSERT_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)parser.getJavaObject("art_subgroup");
                            blart_subgroup.insertArt_subgroup(art_subgroup);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArt_subgroupOperation.UPDATE_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)parser.getJavaObject("art_subgroup");
                            blart_subgroup.updateArt_subgroup(art_subgroup);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArt_subgroupOperation.DELETE_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)parser.getJavaObject("art_subgroup");
                            blart_subgroup.deleteArt_subgroup(art_subgroup);
                            break;
                        case IArt_subgroupOperation.DELETE_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
                            blart_subgroup.delete4art_group(this.getServletName(), art_groupPK);
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
        return "art_subgroup";
    }

}

