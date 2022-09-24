/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.menuitem;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IMenuitem;
import film.interfaces.servlet.IMenuitemOperation;
import film.interfaces.searchentity.IMenuitemsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Menuitem_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Menuitem_select", urlPatterns={"/film.Menuitem_select"})
public class Menuitem_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Menuitem_usecases menuitemusecases = new Menuitem_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IMenuitemOperation.SELECT_ALL:
                    dataobject = menuitemusecases.get_all();
                    break;
                case IMenuitemOperation.SELECT_MENUITEM:
                    dataobject = get_menuitem_with_primarykey(menuitemusecases);
                    break;
                case IMenuitemOperation.SELECT_Menu:
                    dataobject = get_menuitem_with_foreignkey_menu(menuitemusecases);
                    break;
                case IMenuitemOperation.SELECT_SEARCH:
                    dataobject = search_menuitem(menuitemusecases);
                    break;
                case IMenuitemOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_menuitem_count(menuitemusecases);
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

    private Object get_menuitem_with_primarykey(Menuitem_usecases menuitemusecases) throws DBException {
        IMenuitemPK menuitemPK = (IMenuitemPK)parser.getJavaObject("menuitempk");
        return menuitemusecases.get_menuitem_by_primarykey(menuitemPK);
    }

    private Object get_menuitem_with_foreignkey_menu(Menuitem_usecases menuitemusecases) throws CustomException {
        IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
        return menuitemusecases.get_menuitem_with_foreignkey_menu(menuPK);
    }
    
    private Object search_menuitem(Menuitem_usecases menuitemusecases) throws CustomException {
        IMenuitemsearch search = (IMenuitemsearch)parser.getJavaObject("search");
        return menuitemusecases.search_menuitem(search);
    }
    
    private Object search_menuitem_count(Menuitem_usecases menuitemusecases) throws CustomException {
        IMenuitemsearch menuitemsearch = (IMenuitemsearch)parser.getJavaObject("search");
        return menuitemusecases.search_menuitem_count(menuitemsearch);
    }

    @Override
    public String getServletInfo() {
        return "menuitem_select";
    }

}

