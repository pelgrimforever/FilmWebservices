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
import film.interfaces.logicentity.IArealevel2;
import film.interfaces.servlet.IArealevel2Operation;
import film.interfaces.searchentity.IArealevel2search;
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
@WebServlet(name="Arealevel2", urlPatterns={"/film.Arealevel2"})
public class Arealevel2 extends SecurityDataServlet {
   
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
        BLarealevel2 blarealevel2 = new BLarealevel2();
        blarealevel2.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArealevel2PK arealevel2PK;
                    IArealevel2 arealevel2;
                    switch(this.operation) {
                        case IArealevel2Operation.SELECT_ALL:
                            dataobject = blarealevel2.getArealevel2s();
                            break;
                        case IArealevel2Operation.SELECT_AREALEVEL2:
                            arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
                            dataobject = blarealevel2.getArealevel2(arealevel2PK);
                            break;
                        case IArealevel2Operation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
                            dataobject = blarealevel2.getArealevel2s4arealevel1(arealevel1PK);
                            break;
                        case IArealevel2Operation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
                            dataobject = blarealevel2.getArealevel3(arealevel3PK);
                            break;
                        case IArealevel2Operation.SELECT_SEARCH:
                            IArealevel2search search = (IArealevel2search)parser.getJavaObject("search");
                            dataobject = blarealevel2.search(search);
                            break;
                        case IArealevel2Operation.SELECT_SEARCHCOUNT:
                            IArealevel2search arealevel2search = (IArealevel2search)parser.getJavaObject("search");
                            dataobject = blarealevel2.searchcount(arealevel2search);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArealevel2Operation.INSERT_AREALEVEL2:
                            arealevel2 = (IArealevel2)parser.getJavaObject("arealevel2");
                            blarealevel2.insertArealevel2(arealevel2);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArealevel2Operation.UPDATE_AREALEVEL2:
                            arealevel2 = (IArealevel2)parser.getJavaObject("arealevel2");
                            blarealevel2.updateArealevel2(arealevel2);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArealevel2Operation.DELETE_AREALEVEL2:
                            arealevel2 = (IArealevel2)parser.getJavaObject("arealevel2");
                            blarealevel2.deleteArealevel2(arealevel2);
                            break;
                        case IArealevel2Operation.DELETE_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
                            blarealevel2.delete4arealevel1(this.getServletName(), arealevel1PK);
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
        return "arealevel2";
    }

}

