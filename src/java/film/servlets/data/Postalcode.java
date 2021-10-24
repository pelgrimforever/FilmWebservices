/*
 * Postalcode.java
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
import film.interfaces.logicentity.IPostalcode;
import film.interfaces.servlet.IPostalcodeOperation;
import film.interfaces.searchentity.IPostalcodesearch;
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
@WebServlet(name="Postalcode", urlPatterns={"/film.Postalcode"})
public class Postalcode extends SecurityDataServlet {
   
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
        BLpostalcode blpostalcode = new BLpostalcode();
        blpostalcode.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IPostalcodePK postalcodePK;
                    IPostalcode postalcode;
                    switch(this.operation) {
                        case IPostalcodeOperation.SELECT_ALL:
                            dataobject = blpostalcode.getPostalcodes();
                            break;
                        case IPostalcodeOperation.SELECT_POSTALCODE:
                            postalcodePK = (IPostalcodePK)parser.getJavaObject("postalcodepk");
                            dataobject = blpostalcode.getPostalcode(postalcodePK);
                            break;
                        case IPostalcodeOperation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
                            dataobject = blpostalcode.getPostalcodes4arealevel3(arealevel3PK);
                            break;
                        case IPostalcodeOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
                            dataobject = blpostalcode.getLocality(localityPK);
                            break;
                        case IPostalcodeOperation.SELECT_SEARCH:
                            IPostalcodesearch search = (IPostalcodesearch)parser.getJavaObject("search");
                            dataobject = blpostalcode.search(search);
                            break;
                        case IPostalcodeOperation.SELECT_SEARCHCOUNT:
                            IPostalcodesearch postalcodesearch = (IPostalcodesearch)parser.getJavaObject("search");
                            dataobject = blpostalcode.searchcount(postalcodesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IPostalcodeOperation.INSERT_POSTALCODE:
                            postalcode = (IPostalcode)parser.getJavaObject("postalcode");
                            blpostalcode.insertPostalcode(postalcode);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IPostalcodeOperation.UPDATE_POSTALCODE:
                            postalcode = (IPostalcode)parser.getJavaObject("postalcode");
                            blpostalcode.updatePostalcode(postalcode);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IPostalcodeOperation.DELETE_POSTALCODE:
                            postalcode = (IPostalcode)parser.getJavaObject("postalcode");
                            blpostalcode.deletePostalcode(postalcode);
                            break;
                        case IPostalcodeOperation.DELETE_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
                            blpostalcode.delete4arealevel3(arealevel3PK);
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
        return "postalcode";
    }

}

