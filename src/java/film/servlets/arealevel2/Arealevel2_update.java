/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.arealevel2;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel2;
import film.interfaces.servlet.IArealevel2Operation;
import film.interfaces.searchentity.IArealevel2search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel2_usecases;
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
@WebServlet(name="Arealevel2_update", urlPatterns={"/film.Arealevel2_update"})
public class Arealevel2_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel2Operation.UPDATE_AREALEVEL2:
                    update_arealevel2(arealevel2usecases);
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

    private void update_arealevel2(Arealevel2_usecases arealevel2usecases) throws CustomException {
        IArealevel2 arealevel2 = (IArealevel2)parser.getJavaObject("arealevel2");
        arealevel2usecases.secureupdateArealevel2(arealevel2);
    }
    
    @Override
    public String getServletInfo() {
        return "arealevel2_insert";
    }

}

