/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.arealevel1;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel1;
import film.interfaces.servlet.IArealevel1Operation;
import film.interfaces.searchentity.IArealevel1search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel1_usecases;
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
@WebServlet(name="Arealevel1_delete", urlPatterns={"/film.Arealevel1_delete"})
public class Arealevel1_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel1Operation.DELETE_AREALEVEL1:
                    delete_arealevel1(arealevel1usecases);
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

    private void delete_arealevel1(Arealevel1_usecases arealevel1usecases) throws CustomException {
        IArealevel1 arealevel1 = (IArealevel1)parser.getJavaObject("arealevel1");
        arealevel1usecases.deleteArealevel1(arealevel1);
    }
    
    @Override
    public String getServletInfo() {
        return "arealevel1_insert";
    }

}

