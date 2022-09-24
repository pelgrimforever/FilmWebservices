/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.menuitem;

import general.exception.CustomException;
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

@WebServlet(name="Menuitem_delete", urlPatterns={"/film.Menuitem_delete"})
public class Menuitem_delete extends SecurityDataServlet {
   
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
                case IMenuitemOperation.DELETE_MENUITEM:
                    delete_menuitem(menuitemusecases);
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

    private void delete_menuitem(Menuitem_usecases menuitemusecases) throws CustomException {
        IMenuitem menuitem = (IMenuitem)parser.getJavaObject("menuitem");
        menuitemusecases.deleteMenuitem(menuitem);
    }
    
    @Override
    public String getServletInfo() {
        return "menuitem_insert";
    }

}

