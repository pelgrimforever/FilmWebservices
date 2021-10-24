/*
 * Mainmenu.java
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
import film.interfaces.logicentity.IMainmenu;
import film.interfaces.servlet.IMainmenuOperation;
import film.interfaces.searchentity.IMainmenusearch;
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
@WebServlet(name="Mainmenu", urlPatterns={"/film.Mainmenu"})
public class Mainmenu extends SecurityDataServlet {
   
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
        BLmainmenu blmainmenu = new BLmainmenu();
        blmainmenu.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IMainmenuPK mainmenuPK;
                    IMainmenu mainmenu;
                    switch(this.operation) {
                        case IMainmenuOperation.SELECT_ALL:
                            dataobject = blmainmenu.getMainmenus();
                            break;
                        case IMainmenuOperation.SELECT_MAINMENU:
                            mainmenuPK = (IMainmenuPK)parser.getJavaObject("mainmenupk");
                            dataobject = blmainmenu.getMainmenu(mainmenuPK);
                            break;
                        case IMainmenuOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
                            dataobject = blmainmenu.getMenu(menuPK);
                            break;
                        case IMainmenuOperation.SELECT_SEARCH:
                            IMainmenusearch search = (IMainmenusearch)parser.getJavaObject("search");
                            dataobject = blmainmenu.search(search);
                            break;
                        case IMainmenuOperation.SELECT_SEARCHCOUNT:
                            IMainmenusearch mainmenusearch = (IMainmenusearch)parser.getJavaObject("search");
                            dataobject = blmainmenu.searchcount(mainmenusearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IMainmenuOperation.INSERT_MAINMENU:
                            mainmenu = (IMainmenu)parser.getJavaObject("mainmenu");
                            blmainmenu.insertMainmenu(mainmenu);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IMainmenuOperation.UPDATE_MAINMENU:
                            mainmenu = (IMainmenu)parser.getJavaObject("mainmenu");
                            blmainmenu.updateMainmenu(mainmenu);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IMainmenuOperation.DELETE_MAINMENU:
                            mainmenu = (IMainmenu)parser.getJavaObject("mainmenu");
                            blmainmenu.deleteMainmenu(mainmenu);
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
        return "mainmenu";
    }

}

