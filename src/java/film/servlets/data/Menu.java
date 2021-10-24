/*
 * Menu.java
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
import film.interfaces.logicentity.IMenu;
import film.interfaces.servlet.IMenuOperation;
import film.interfaces.searchentity.IMenusearch;
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
@WebServlet(name="Menu", urlPatterns={"/film.Menu"})
public class Menu extends SecurityDataServlet {
   
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
        BLmenu blmenu = new BLmenu();
        blmenu.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IMenuPK menuPK;
                    IMenu menu;
                    switch(this.operation) {
                        case IMenuOperation.SELECT_ALL:
                            dataobject = blmenu.getMenus();
                            break;
                        case IMenuOperation.SELECT_MENU:
                            menuPK = (IMenuPK)parser.getJavaObject("menupk");
                            dataobject = blmenu.getMenu(menuPK);
                            break;
                        case IMenuOperation.SELECT_Mainmenu:
                            IMainmenuPK mainmenuPK = (IMainmenuPK)parser.getJavaObject("mainmenupk");
                            dataobject = blmenu.getMenus4mainmenu(mainmenuPK);
                            break;
                        case IMenuOperation.SELECT_Menuitem:
                            IMenuitemPK menuitemPK = (IMenuitemPK)parser.getJavaObject("menuitempk");
                            dataobject = blmenu.getMenuitem(menuitemPK);
                            break;
                        case IMenuOperation.SELECT_SEARCH:
                            IMenusearch search = (IMenusearch)parser.getJavaObject("search");
                            dataobject = blmenu.search(search);
                            break;
                        case IMenuOperation.SELECT_SEARCHCOUNT:
                            IMenusearch menusearch = (IMenusearch)parser.getJavaObject("search");
                            dataobject = blmenu.searchcount(menusearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IMenuOperation.INSERT_MENU:
                            menu = (IMenu)parser.getJavaObject("menu");
                            blmenu.insertMenu(menu);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IMenuOperation.UPDATE_MENU:
                            menu = (IMenu)parser.getJavaObject("menu");
                            blmenu.updateMenu(menu);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IMenuOperation.DELETE_MENU:
                            menu = (IMenu)parser.getJavaObject("menu");
                            blmenu.deleteMenu(menu);
                            break;
                        case IMenuOperation.DELETE_Mainmenu:
                            IMainmenuPK mainmenuPK = (IMainmenuPK)parser.getJavaObject("mainmenupk");
                            blmenu.delete4mainmenu(mainmenuPK);
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
        return "menu";
    }

}

