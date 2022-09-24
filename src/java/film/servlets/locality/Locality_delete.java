/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.locality;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ILocality;
import film.interfaces.servlet.ILocalityOperation;
import film.interfaces.searchentity.ILocalitysearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Locality_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Locality_delete", urlPatterns={"/film.Locality_delete"})
public class Locality_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Locality_usecases localityusecases = new Locality_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ILocalityOperation.DELETE_LOCALITY:
                    delete_locality(localityusecases);
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

    private void delete_locality(Locality_usecases localityusecases) throws CustomException {
        ILocality locality = (ILocality)parser.getJavaObject("locality");
        localityusecases.deleteLocality(locality);
    }
    
    @Override
    public String getServletInfo() {
        return "locality_insert";
    }

}

