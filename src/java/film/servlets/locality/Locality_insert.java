/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Locality_insert", urlPatterns={"/film.Locality_insert"})
public class Locality_insert extends SecurityDataServlet {
   
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
                case ILocalityOperation.INSERT_LOCALITY:
                    insert_locality(localityusecases);
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

    private void insert_locality(Locality_usecases localityusecases) throws CustomException {
        ILocality locality = (ILocality)parser.getJavaObject("locality");
        localityusecases.secureinsertLocality(locality);
    }
    
    @Override
    public String getServletInfo() {
        return "locality_insert";
    }

}

