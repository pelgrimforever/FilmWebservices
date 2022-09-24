/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

@WebServlet(name="Menu_insert", urlPatterns={"/film.Menu_insert"})
public class Menu_insert extends SecurityDataServlet {
   
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
                case IMenuOperation.INSERT_MENU:
                    insert_menu(menuusecases);
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

    private void insert_menu(Menu_usecases menuusecases) throws CustomException {
        IMenu menu = (IMenu)parser.getJavaObject("menu");
        menuusecases.insertMenu(menu);
    }
    
    @Override
    public String getServletInfo() {
        return "menu_insert";
    }

}

