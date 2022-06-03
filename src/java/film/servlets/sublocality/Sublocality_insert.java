/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.sublocality;

import general.exception.CustomException;
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Sublocality_insert", urlPatterns={"/film.Sublocality_insert"})
public class Sublocality_insert extends SecurityDataServlet {
   
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
                case ISublocalityOperation.INSERT_SUBLOCALITY:
                    insert_sublocality(sublocalityusecases);
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

    private void insert_sublocality(Sublocality_usecases sublocalityusecases) throws CustomException {
        ISublocality sublocality = (ISublocality)parser.getJavaObject("sublocality");
        sublocalityusecases.secureinsertSublocality(sublocality);
    }
    
    @Override
    public String getServletInfo() {
        return "sublocality_insert";
    }

}

