/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
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
@WebServlet(name="Uploadsessionsettings_delete", urlPatterns={"/film.Uploadsessionsettings_delete"})
public class Uploadsessionsettings_delete extends SecurityDataServlet {
   
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
                case IUploadsessionsettingsOperation.DELETE_UPLOADSESSIONSETTINGS:
                    delete_uploadsessionsettings(uploadsessionsettingsusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IUploadsessionsettingsOperation.DELETE_ALL:
                    deleteall(uploadsessionsettingsusecases);
                    break;
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
    private void deleteall(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws CustomException {
        uploadsessionsettingsusecases.deleteall();
    }
//Custom code, do not change this line   

    private void delete_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws CustomException {
        IUploadsessionsettings uploadsessionsettings = (IUploadsessionsettings)parser.getJavaObject("uploadsessionsettings");
        uploadsessionsettingsusecases.deleteUploadsessionsettings(uploadsessionsettings);
    }
    
    @Override
    public String getServletInfo() {
        return "uploadsessionsettings_insert";
    }

}

