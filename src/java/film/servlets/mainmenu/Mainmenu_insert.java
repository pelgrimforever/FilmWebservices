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

@WebServlet(name="Mainmenu_insert", urlPatterns={"/film.Mainmenu_insert"})
public class Mainmenu_insert extends SecurityDataServlet {
   
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
                case IMainmenuOperation.INSERT_MAINMENU:
                    insert_mainmenu(mainmenuusecases);
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

    private void insert_mainmenu(Mainmenu_usecases mainmenuusecases) throws CustomException {
        IMainmenu mainmenu = (IMainmenu)parser.getJavaObject("mainmenu");
        mainmenuusecases.insertMainmenu(mainmenu);
    }
    
    @Override
    public String getServletInfo() {
        return "mainmenu_insert";
    }

}

