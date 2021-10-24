/*
 * Arealevel1.java
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
import film.interfaces.logicentity.IArealevel1;
import film.interfaces.servlet.IArealevel1Operation;
import film.interfaces.searchentity.IArealevel1search;
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
@WebServlet(name="Arealevel1", urlPatterns={"/film.Arealevel1"})
public class Arealevel1 extends SecurityDataServlet {
   
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
        BLarealevel1 blarealevel1 = new BLarealevel1();
        blarealevel1.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArealevel1PK arealevel1PK;
                    IArealevel1 arealevel1;
                    switch(this.operation) {
                        case IArealevel1Operation.SELECT_ALL:
                            dataobject = blarealevel1.getArealevel1s();
                            break;
                        case IArealevel1Operation.SELECT_AREALEVEL1:
                            arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
                            dataobject = blarealevel1.getArealevel1(arealevel1PK);
                            break;
                        case IArealevel1Operation.SELECT_Country:
                            ICountryPK countryPK = (ICountryPK)parser.getJavaObject("countrypk");
                            dataobject = blarealevel1.getArealevel1s4country(countryPK);
                            break;
                        case IArealevel1Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
                            dataobject = blarealevel1.getArealevel2(arealevel2PK);
                            break;
                        case IArealevel1Operation.SELECT_SEARCH:
                            IArealevel1search search = (IArealevel1search)parser.getJavaObject("search");
                            dataobject = blarealevel1.search(search);
                            break;
                        case IArealevel1Operation.SELECT_SEARCHCOUNT:
                            IArealevel1search arealevel1search = (IArealevel1search)parser.getJavaObject("search");
                            dataobject = blarealevel1.searchcount(arealevel1search);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArealevel1Operation.INSERT_AREALEVEL1:
                            arealevel1 = (IArealevel1)parser.getJavaObject("arealevel1");
                            blarealevel1.insertArealevel1(arealevel1);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArealevel1Operation.UPDATE_AREALEVEL1:
                            arealevel1 = (IArealevel1)parser.getJavaObject("arealevel1");
                            blarealevel1.updateArealevel1(arealevel1);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArealevel1Operation.DELETE_AREALEVEL1:
                            arealevel1 = (IArealevel1)parser.getJavaObject("arealevel1");
                            blarealevel1.deleteArealevel1(arealevel1);
                            break;
                        case IArealevel1Operation.DELETE_Country:
                            ICountryPK countryPK = (ICountryPK)parser.getJavaObject("countrypk");
                            blarealevel1.delete4country(countryPK);
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
        return "arealevel1";
    }

}

