/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IMenuitem;
import film.interfaces.servlet.IMenuitemOperation;
import film.interfaces.searchentity.IMenuitemsearch;
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
@WebServlet(name="Menuitem", urlPatterns={"/film.Menuitem"})
public class Menuitem extends SecurityDataServlet {
   
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
        BLmenuitem blmenuitem = new BLmenuitem();
        blmenuitem.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IMenuitemPK menuitemPK;
                    IMenuitem menuitem;
                    switch(this.operation) {
                        case IMenuitemOperation.SELECT_ALL:
                            dataobject = blmenuitem.getMenuitems();
                            break;
                        case IMenuitemOperation.SELECT_MENUITEM:
                            menuitemPK = (IMenuitemPK)parser.getJavaObject("menuitempk");
                            dataobject = blmenuitem.getMenuitem(menuitemPK);
                            break;
                        case IMenuitemOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
                            dataobject = blmenuitem.getMenuitems4menu(menuPK);
                            break;
                        case IMenuitemOperation.SELECT_SEARCH:
                            IMenuitemsearch search = (IMenuitemsearch)parser.getJavaObject("search");
                            dataobject = blmenuitem.search(search);
                            break;
                        case IMenuitemOperation.SELECT_SEARCHCOUNT:
                            IMenuitemsearch menuitemsearch = (IMenuitemsearch)parser.getJavaObject("search");
                            dataobject = blmenuitem.searchcount(menuitemsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IMenuitemOperation.INSERT_MENUITEM:
                            menuitem = (IMenuitem)parser.getJavaObject("menuitem");
                            blmenuitem.insertMenuitem(menuitem);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IMenuitemOperation.UPDATE_MENUITEM:
                            menuitem = (IMenuitem)parser.getJavaObject("menuitem");
                            blmenuitem.updateMenuitem(menuitem);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IMenuitemOperation.DELETE_MENUITEM:
                            menuitem = (IMenuitem)parser.getJavaObject("menuitem");
                            blmenuitem.deleteMenuitem(menuitem);
                            break;
                        case IMenuitemOperation.DELETE_Menu:
                            IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
                            blmenuitem.delete4menu(this.getServletName(), menuPK);
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
        return "menuitem";
    }

}

