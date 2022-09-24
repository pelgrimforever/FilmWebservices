/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.sublocality;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISublocality;
import film.interfaces.servlet.ISublocalityOperation;
import film.interfaces.searchentity.ISublocalitysearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Sublocality_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Sublocality_update", urlPatterns={"/film.Sublocality_update"})
public class Sublocality_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Sublocality_usecases sublocalityusecases = new Sublocality_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISublocalityOperation.UPDATE_SUBLOCALITY:
                    update_sublocality(sublocalityusecases);
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

    private void update_sublocality(Sublocality_usecases sublocalityusecases) throws CustomException {
        ISublocality sublocality = (ISublocality)parser.getJavaObject("sublocality");
        sublocalityusecases.updateSublocality(sublocality);
    }
    
    @Override
    public String getServletInfo() {
        return "sublocality_insert";
    }

}

