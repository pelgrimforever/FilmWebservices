/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.uploadsessionsettings;

import general.exception.*;
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
@WebServlet(name="Uploadsessionsettings_select", urlPatterns={"/film.Uploadsessionsettings_select"})
public class Uploadsessionsettings_select extends SecurityDataServlet {
   
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
                case IUploadsessionsettingsOperation.SELECT_ALL:
                    dataobject = uploadsessionsettingsusecases.get_all();
                    break;
                case IUploadsessionsettingsOperation.SELECT_UPLOADSESSIONSETTINGS:
                    dataobject = get_uploadsessionsettings_with_primarykey(uploadsessionsettingsusecases);
                    break;
                case IUploadsessionsettingsOperation.SELECT_SEARCH:
                    dataobject = search_uploadsessionsettings(uploadsessionsettingsusecases);
                    break;
                case IUploadsessionsettingsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_uploadsessionsettings_count(uploadsessionsettingsusecases);
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

    private Object get_uploadsessionsettings_with_primarykey(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws DBException {
        IUploadsessionsettingsPK uploadsessionsettingsPK = (IUploadsessionsettingsPK)parser.getJavaObject("uploadsessionsettingspk");
        return uploadsessionsettingsusecases.get_uploadsessionsettings_by_primarykey(uploadsessionsettingsPK);
    }

    private Object search_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws CustomException {
        IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)parser.getJavaObject("search");
        return uploadsessionsettingsusecases.search_uploadsessionsettings(search);
    }
    
    private Object search_uploadsessionsettings_count(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws CustomException {
        IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)parser.getJavaObject("search");
        return uploadsessionsettingsusecases.search_uploadsessionsettings_count(uploadsessionsettingssearch);
    }

    @Override
    public String getServletInfo() {
        return "uploadsessionsettings_select";
    }

}

