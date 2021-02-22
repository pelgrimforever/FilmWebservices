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
import film.interfaces.logicentity.ILocality;
import film.interfaces.servlet.ILocalityOperation;
import film.interfaces.searchentity.ILocalitysearch;
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
@WebServlet(name="Locality", urlPatterns={"/film.Locality"})
public class Locality extends SecurityDataServlet {
   
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
        BLlocality bllocality = new BLlocality();
        bllocality.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ILocalityPK localityPK;
                    ILocality locality;
                    switch(this.operation) {
                        case ILocalityOperation.SELECT_ALL:
                            dataobject = bllocality.getLocalitys();
                            break;
                        case ILocalityOperation.SELECT_LOCALITY:
                            localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
                            dataobject = bllocality.getLocality(localityPK);
                            break;
                        case ILocalityOperation.SELECT_Postalcode:
                            IPostalcodePK postalcodePK = (IPostalcodePK)parser.getJavaObject("postalcodepk");
                            dataobject = bllocality.getLocalitys4postalcode(postalcodePK);
                            break;
                        case ILocalityOperation.SELECT_Sublocality:
                            ISublocalityPK sublocalityPK = (ISublocalityPK)parser.getJavaObject("sublocalitypk");
                            dataobject = bllocality.getSublocality(sublocalityPK);
                            break;
                        case ILocalityOperation.SELECT_SEARCH:
                            ILocalitysearch search = (ILocalitysearch)parser.getJavaObject("search");
                            dataobject = bllocality.search(search);
                            break;
                        case ILocalityOperation.SELECT_SEARCHCOUNT:
                            ILocalitysearch localitysearch = (ILocalitysearch)parser.getJavaObject("search");
                            dataobject = bllocality.searchcount(localitysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ILocalityOperation.INSERT_LOCALITY:
                            locality = (ILocality)parser.getJavaObject("locality");
                            bllocality.insertLocality(locality);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ILocalityOperation.UPDATE_LOCALITY:
                            locality = (ILocality)parser.getJavaObject("locality");
                            bllocality.updateLocality(locality);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ILocalityOperation.DELETE_LOCALITY:
                            locality = (ILocality)parser.getJavaObject("locality");
                            bllocality.deleteLocality(locality);
                            break;
                        case ILocalityOperation.DELETE_Postalcode:
                            IPostalcodePK postalcodePK = (IPostalcodePK)parser.getJavaObject("postalcodepk");
                            bllocality.delete4postalcode(this.getServletName(), postalcodePK);
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
        return "locality";
    }

}

