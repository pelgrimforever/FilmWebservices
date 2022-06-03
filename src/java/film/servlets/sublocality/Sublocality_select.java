/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Sublocality_select", urlPatterns={"/film.Sublocality_select"})
public class Sublocality_select extends SecurityDataServlet {
   
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
                case ISublocalityOperation.SELECT_ALL:
                    dataobject = sublocalityusecases.get_all();
                    break;
                case ISublocalityOperation.SELECT_SUBLOCALITY:
                    dataobject = get_sublocality_with_primarykey(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_Locality:
                    dataobject = get_sublocality_with_foreignkey_locality(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_Route:
                    dataobject = get_sublocality_with_externalforeignkey_route(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_SEARCH:
                    dataobject = search_sublocality(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_sublocality_count(sublocalityusecases);
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

    private Object get_sublocality_with_primarykey(Sublocality_usecases sublocalityusecases) throws DBException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)parser.getJavaObject("sublocalitypk");
        return sublocalityusecases.get_sublocality_by_primarykey(sublocalityPK);
    }

    private Object get_sublocality_with_foreignkey_locality(Sublocality_usecases sublocalityusecases) throws CustomException {
        ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
        return sublocalityusecases.get_sublocality_with_foreignkey_locality(localityPK);
    }
    
    private Object get_sublocality_with_externalforeignkey_route(Sublocality_usecases sublocalityusecases) throws CustomException {
        IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
        return sublocalityusecases.get_sublocality_with_externalforeignkey_route(routePK);
    }
    
    private Object search_sublocality(Sublocality_usecases sublocalityusecases) throws CustomException {
        ISublocalitysearch search = (ISublocalitysearch)parser.getJavaObject("search");
        return sublocalityusecases.search_sublocality(search);
    }
    
    private Object search_sublocality_count(Sublocality_usecases sublocalityusecases) throws CustomException {
        ISublocalitysearch sublocalitysearch = (ISublocalitysearch)parser.getJavaObject("search");
        return sublocalityusecases.search_sublocality_count(sublocalitysearch);
    }

    @Override
    public String getServletInfo() {
        return "sublocality_select";
    }

}

