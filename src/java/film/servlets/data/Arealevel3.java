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
import film.interfaces.logicentity.IArealevel3;
import film.interfaces.servlet.IArealevel3Operation;
import film.interfaces.searchentity.IArealevel3search;
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
@WebServlet(name="Arealevel3", urlPatterns={"/film.Arealevel3"})
public class Arealevel3 extends SecurityDataServlet {
   
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
        BLarealevel3 blarealevel3 = new BLarealevel3();
        blarealevel3.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArealevel3PK arealevel3PK;
                    IArealevel3 arealevel3;
                    switch(this.operation) {
                        case IArealevel3Operation.SELECT_ALL:
                            dataobject = blarealevel3.getArealevel3s();
                            break;
                        case IArealevel3Operation.SELECT_AREALEVEL3:
                            arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
                            dataobject = blarealevel3.getArealevel3(arealevel3PK);
                            break;
                        case IArealevel3Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
                            dataobject = blarealevel3.getArealevel3s4arealevel2(arealevel2PK);
                            break;
                        case IArealevel3Operation.SELECT_SEARCH:
                            IArealevel3search search = (IArealevel3search)parser.getJavaObject("search");
                            dataobject = blarealevel3.search(search);
                            break;
                        case IArealevel3Operation.SELECT_SEARCHCOUNT:
                            IArealevel3search arealevel3search = (IArealevel3search)parser.getJavaObject("search");
                            dataobject = blarealevel3.searchcount(arealevel3search);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArealevel3Operation.INSERT_AREALEVEL3:
                            arealevel3 = (IArealevel3)parser.getJavaObject("arealevel3");
                            blarealevel3.insertArealevel3(arealevel3);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArealevel3Operation.UPDATE_AREALEVEL3:
                            arealevel3 = (IArealevel3)parser.getJavaObject("arealevel3");
                            blarealevel3.updateArealevel3(arealevel3);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArealevel3Operation.DELETE_AREALEVEL3:
                            arealevel3 = (IArealevel3)parser.getJavaObject("arealevel3");
                            blarealevel3.deleteArealevel3(arealevel3);
                            break;
                        case IArealevel3Operation.DELETE_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
                            blarealevel3.delete4arealevel2(this.getServletName(), arealevel2PK);
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
        return "arealevel3";
    }

}

