/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.menu;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IMenu;
import film.interfaces.servlet.IMenuOperation;
import film.interfaces.searchentity.IMenusearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Menu_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Menu_select", urlPatterns={"/film.Menu_select"})
public class Menu_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Menu_usecases menuusecases = new Menu_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IMenuOperation.SELECT_ALL:
                    dataobject = menuusecases.get_all();
                    break;
                case IMenuOperation.SELECT_MENU:
                    dataobject = get_menu_with_primarykey(menuusecases);
                    break;
                case IMenuOperation.SELECT_Mainmenu:
                    dataobject = get_menu_with_foreignkey_mainmenu(menuusecases);
                    break;
                case IMenuOperation.SELECT_Menuitem:
                    dataobject = get_menu_with_externalforeignkey_menuitem(menuusecases);
                    break;
                case IMenuOperation.SELECT_SEARCH:
                    dataobject = search_menu(menuusecases);
                    break;
                case IMenuOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_menu_count(menuusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_menu_with_primarykey(Menu_usecases menuusecases) throws DBException {
        IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
        return menuusecases.get_menu_by_primarykey(menuPK);
    }

    private Object get_menu_with_foreignkey_mainmenu(Menu_usecases menuusecases) throws CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)parser.getJavaObject("mainmenupk");
        return menuusecases.get_menu_with_foreignkey_mainmenu(mainmenuPK);
    }
    
    private Object get_menu_with_externalforeignkey_menuitem(Menu_usecases menuusecases) throws CustomException {
        IMenuitemPK menuitemPK = (IMenuitemPK)parser.getJavaObject("menuitempk");
        return menuusecases.get_menu_with_externalforeignkey_menuitem(menuitemPK);
    }
    
    private Object search_menu(Menu_usecases menuusecases) throws CustomException {
        IMenusearch search = (IMenusearch)parser.getJavaObject("search");
        return menuusecases.search_menu(search);
    }
    
    private Object search_menu_count(Menu_usecases menuusecases) throws CustomException {
        IMenusearch menusearch = (IMenusearch)parser.getJavaObject("search");
        return menuusecases.search_menu_count(menusearch);
    }

    @Override
    public String getServletInfo() {
        return "menu_select";
    }

}

