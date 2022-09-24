/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.mainmenu;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IMainmenu;
import film.interfaces.servlet.IMainmenuOperation;
import film.interfaces.searchentity.IMainmenusearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Mainmenu_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Mainmenu_select", urlPatterns={"/film.Mainmenu_select"})
public class Mainmenu_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IMainmenuOperation.SELECT_ALL:
                    dataobject = mainmenuusecases.get_all();
                    break;
                case IMainmenuOperation.SELECT_MAINMENU:
                    dataobject = get_mainmenu_with_primarykey(mainmenuusecases);
                    break;
                case IMainmenuOperation.SELECT_Menu:
                    dataobject = get_mainmenu_with_externalforeignkey_menu(mainmenuusecases);
                    break;
                case IMainmenuOperation.SELECT_SEARCH:
                    dataobject = search_mainmenu(mainmenuusecases);
                    break;
                case IMainmenuOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_mainmenu_count(mainmenuusecases);
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

    private Object get_mainmenu_with_primarykey(Mainmenu_usecases mainmenuusecases) throws DBException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)parser.getJavaObject("mainmenupk");
        return mainmenuusecases.get_mainmenu_by_primarykey(mainmenuPK);
    }

    private Object get_mainmenu_with_externalforeignkey_menu(Mainmenu_usecases mainmenuusecases) throws CustomException {
        IMenuPK menuPK = (IMenuPK)parser.getJavaObject("menupk");
        return mainmenuusecases.get_mainmenu_with_externalforeignkey_menu(menuPK);
    }
    
    private Object search_mainmenu(Mainmenu_usecases mainmenuusecases) throws CustomException {
        IMainmenusearch search = (IMainmenusearch)parser.getJavaObject("search");
        return mainmenuusecases.search_mainmenu(search);
    }
    
    private Object search_mainmenu_count(Mainmenu_usecases mainmenuusecases) throws CustomException {
        IMainmenusearch mainmenusearch = (IMainmenusearch)parser.getJavaObject("search");
        return mainmenuusecases.search_mainmenu_count(mainmenusearch);
    }

    @Override
    public String getServletInfo() {
        return "mainmenu_select";
    }

}

