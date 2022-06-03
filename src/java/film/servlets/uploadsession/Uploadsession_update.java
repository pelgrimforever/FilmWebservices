/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.uploadsession;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IUploadsession;
import film.interfaces.servlet.IUploadsessionOperation;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Uploadsession_usecases;
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
@WebServlet(name="Uploadsession_update", urlPatterns={"/film.Uploadsession_update"})
public class Uploadsession_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUploadsessionOperation.UPDATE_UPLOADSESSION:
                    update_uploadsession(uploadsessionusecases);
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

    private void update_uploadsession(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        IUploadsession uploadsession = (IUploadsession)parser.getJavaObject("uploadsession");
        uploadsessionusecases.secureupdateUploadsession(uploadsession);
    }
    
    @Override
    public String getServletInfo() {
        return "uploadsession_insert";
    }

}

