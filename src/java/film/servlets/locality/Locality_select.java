/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.locality;

import general.exception.*;
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
@WebServlet(name="Locality_select", urlPatterns={"/film.Locality_select"})
public class Locality_select extends SecurityDataServlet {
   
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
                case ILocalityOperation.SELECT_ALL:
                    dataobject = localityusecases.get_all();
                    break;
                case ILocalityOperation.SELECT_LOCALITY:
                    dataobject = get_locality_with_primarykey(localityusecases);
                    break;
                case ILocalityOperation.SELECT_Postalcode:
                    dataobject = get_locality_with_foreignkey_postalcode(localityusecases);
                    break;
                case ILocalityOperation.SELECT_Sublocality:
                    dataobject = get_locality_with_externalforeignkey_sublocality(localityusecases);
                    break;
                case ILocalityOperation.SELECT_SEARCH:
                    dataobject = search_locality(localityusecases);
                    break;
                case ILocalityOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_locality_count(localityusecases);
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

    private Object get_locality_with_primarykey(Locality_usecases localityusecases) throws DBException {
        ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
        return localityusecases.get_locality_by_primarykey(localityPK);
    }

    private Object get_locality_with_foreignkey_postalcode(Locality_usecases localityusecases) throws CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)parser.getJavaObject("postalcodepk");
        return localityusecases.get_locality_with_foreignkey_postalcode(postalcodePK);
    }
    
    private Object get_locality_with_externalforeignkey_sublocality(Locality_usecases localityusecases) throws CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)parser.getJavaObject("sublocalitypk");
        return localityusecases.get_locality_with_externalforeignkey_sublocality(sublocalityPK);
    }
    
    private Object search_locality(Locality_usecases localityusecases) throws CustomException {
        ILocalitysearch search = (ILocalitysearch)parser.getJavaObject("search");
        return localityusecases.search_locality(search);
    }
    
    private Object search_locality_count(Locality_usecases localityusecases) throws CustomException {
        ILocalitysearch localitysearch = (ILocalitysearch)parser.getJavaObject("search");
        return localityusecases.search_locality_count(localitysearch);
    }

    @Override
    public String getServletInfo() {
        return "locality_select";
    }

}

