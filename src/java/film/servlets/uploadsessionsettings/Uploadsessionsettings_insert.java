/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.uploadsessionsettings;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IUploadsessionsettings;
import film.interfaces.servlet.IUploadsessionsettingsOperation;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Uploadsessionsettings_usecases;
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
@WebServlet(name="Uploadsessionsettings_insert", urlPatterns={"/film.Uploadsessionsettings_insert"})
public class Uploadsessionsettings_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUploadsessionsettingsOperation.INSERT_UPLOADSESSIONSETTINGS:
                    insert_uploadsessionsettings(uploadsessionsettingsusecases);
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

    private void insert_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws CustomException {
        IUploadsessionsettings uploadsessionsettings = (IUploadsessionsettings)parser.getJavaObject("uploadsessionsettings");
        uploadsessionsettingsusecases.secureinsertUploadsessionsettings(uploadsessionsettings);
    }
    
    @Override
    public String getServletInfo() {
        return "uploadsessionsettings_insert";
    }

}

