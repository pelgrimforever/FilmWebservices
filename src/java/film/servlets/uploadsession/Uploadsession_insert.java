/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.uploadsession;

import general.exception.*;
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

@WebServlet(name="Uploadsession_insert", urlPatterns={"/film.Uploadsession_insert"})
public class Uploadsession_insert extends SecurityDataServlet {
   
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
                case IUploadsessionOperation.INSERT_UPLOADSESSION:
                    insert_uploadsession(uploadsessionusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IUploadsessionOperation.INSERT_UPLOADSESSIONS:
                    insert_uploadsessions(uploadsessionusecases);
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
    private void insert_uploadsessions(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        ArrayList<IUploadsession> uploadsessions = (ArrayList)parser.getJavaObject("uploadsessions");
        uploadsessionusecases.insert_uploadsessions(uploadsessions);
    }
//Custom code, do not change this line   

    private void insert_uploadsession(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        IUploadsession uploadsession = (IUploadsession)parser.getJavaObject("uploadsession");
        uploadsessionusecases.insertUploadsession(uploadsession);
    }
    
    @Override
    public String getServletInfo() {
        return "uploadsession_insert";
    }

}

