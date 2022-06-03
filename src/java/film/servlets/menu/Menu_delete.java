/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.menu;

import general.exception.CustomException;
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
@WebServlet(name="Menu_delete", urlPatterns={"/film.Menu_delete"})
public class Menu_delete extends SecurityDataServlet {
   
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
                case IMenuOperation.DELETE_MENU:
                    delete_menu(menuusecases);
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

    private void delete_menu(Menu_usecases menuusecases) throws CustomException {
        IMenu menu = (IMenu)parser.getJavaObject("menu");
        menuusecases.securedeleteMenu(menu);
    }
    
    @Override
    public String getServletInfo() {
        return "menu_insert";
    }

}

