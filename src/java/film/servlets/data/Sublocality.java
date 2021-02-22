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
import film.interfaces.logicentity.ISublocality;
import film.interfaces.servlet.ISublocalityOperation;
import film.interfaces.searchentity.ISublocalitysearch;
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
@WebServlet(name="Sublocality", urlPatterns={"/film.Sublocality"})
public class Sublocality extends SecurityDataServlet {
   
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
        BLsublocality blsublocality = new BLsublocality();
        blsublocality.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISublocalityPK sublocalityPK;
                    ISublocality sublocality;
                    switch(this.operation) {
                        case ISublocalityOperation.SELECT_ALL:
                            dataobject = blsublocality.getSublocalitys();
                            break;
                        case ISublocalityOperation.SELECT_SUBLOCALITY:
                            sublocalityPK = (ISublocalityPK)parser.getJavaObject("sublocalitypk");
                            dataobject = blsublocality.getSublocality(sublocalityPK);
                            break;
                        case ISublocalityOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
                            dataobject = blsublocality.getSublocalitys4locality(localityPK);
                            break;
                        case ISublocalityOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
                            dataobject = blsublocality.getRoute(routePK);
                            break;
                        case ISublocalityOperation.SELECT_SEARCH:
                            ISublocalitysearch search = (ISublocalitysearch)parser.getJavaObject("search");
                            dataobject = blsublocality.search(search);
                            break;
                        case ISublocalityOperation.SELECT_SEARCHCOUNT:
                            ISublocalitysearch sublocalitysearch = (ISublocalitysearch)parser.getJavaObject("search");
                            dataobject = blsublocality.searchcount(sublocalitysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISublocalityOperation.INSERT_SUBLOCALITY:
                            sublocality = (ISublocality)parser.getJavaObject("sublocality");
                            blsublocality.insertSublocality(sublocality);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISublocalityOperation.UPDATE_SUBLOCALITY:
                            sublocality = (ISublocality)parser.getJavaObject("sublocality");
                            blsublocality.updateSublocality(sublocality);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISublocalityOperation.DELETE_SUBLOCALITY:
                            sublocality = (ISublocality)parser.getJavaObject("sublocality");
                            blsublocality.deleteSublocality(sublocality);
                            break;
                        case ISublocalityOperation.DELETE_Locality:
                            ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
                            blsublocality.delete4locality(this.getServletName(), localityPK);
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
        return "sublocality";
    }

}

