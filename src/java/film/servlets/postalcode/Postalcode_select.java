/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.postalcode;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPostalcode;
import film.interfaces.servlet.IPostalcodeOperation;
import film.interfaces.searchentity.IPostalcodesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Postalcode_usecases;
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
@WebServlet(name="Postalcode_select", urlPatterns={"/film.Postalcode_select"})
public class Postalcode_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Postalcode_usecases postalcodeusecases = new Postalcode_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPostalcodeOperation.SELECT_ALL:
                    dataobject = postalcodeusecases.get_all();
                    break;
                case IPostalcodeOperation.SELECT_POSTALCODE:
                    dataobject = get_postalcode_with_primarykey(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_Arealevel3:
                    dataobject = get_postalcode_with_foreignkey_arealevel3(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_Locality:
                    dataobject = get_postalcode_with_externalforeignkey_locality(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_SEARCH:
                    dataobject = search_postalcode(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_postalcode_count(postalcodeusecases);
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

    private Object get_postalcode_with_primarykey(Postalcode_usecases postalcodeusecases) throws DBException {
        IPostalcodePK postalcodePK = (IPostalcodePK)parser.getJavaObject("postalcodepk");
        return postalcodeusecases.get_postalcode_by_primarykey(postalcodePK);
    }

    private Object get_postalcode_with_foreignkey_arealevel3(Postalcode_usecases postalcodeusecases) throws CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
        return postalcodeusecases.get_postalcode_with_foreignkey_arealevel3(arealevel3PK);
    }
    
    private Object get_postalcode_with_externalforeignkey_locality(Postalcode_usecases postalcodeusecases) throws CustomException {
        ILocalityPK localityPK = (ILocalityPK)parser.getJavaObject("localitypk");
        return postalcodeusecases.get_postalcode_with_externalforeignkey_locality(localityPK);
    }
    
    private Object search_postalcode(Postalcode_usecases postalcodeusecases) throws CustomException {
        IPostalcodesearch search = (IPostalcodesearch)parser.getJavaObject("search");
        return postalcodeusecases.search_postalcode(search);
    }
    
    private Object search_postalcode_count(Postalcode_usecases postalcodeusecases) throws CustomException {
        IPostalcodesearch postalcodesearch = (IPostalcodesearch)parser.getJavaObject("search");
        return postalcodeusecases.search_postalcode_count(postalcodesearch);
    }

    @Override
    public String getServletInfo() {
        return "postalcode_select";
    }

}

