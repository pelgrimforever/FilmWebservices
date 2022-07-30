/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.arealevel3;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel3;
import film.interfaces.servlet.IArealevel3Operation;
import film.interfaces.searchentity.IArealevel3search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel3_usecases;
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
@WebServlet(name="Arealevel3_delete", urlPatterns={"/film.Arealevel3_delete"})
public class Arealevel3_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel3Operation.DELETE_AREALEVEL3:
                    delete_arealevel3(arealevel3usecases);
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

    private void delete_arealevel3(Arealevel3_usecases arealevel3usecases) throws CustomException {
        IArealevel3 arealevel3 = (IArealevel3)parser.getJavaObject("arealevel3");
        arealevel3usecases.deleteArealevel3(arealevel3);
    }
    
    @Override
    public String getServletInfo() {
        return "arealevel3_insert";
    }

}

