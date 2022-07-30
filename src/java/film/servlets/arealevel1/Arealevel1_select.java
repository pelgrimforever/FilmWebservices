/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.arealevel1;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel1;
import film.interfaces.servlet.IArealevel1Operation;
import film.interfaces.searchentity.IArealevel1search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel1_usecases;
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
@WebServlet(name="Arealevel1_select", urlPatterns={"/film.Arealevel1_select"})
public class Arealevel1_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel1Operation.SELECT_ALL:
                    dataobject = arealevel1usecases.get_all();
                    break;
                case IArealevel1Operation.SELECT_AREALEVEL1:
                    dataobject = get_arealevel1_with_primarykey(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_Country:
                    dataobject = get_arealevel1_with_foreignkey_country(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_Arealevel2:
                    dataobject = get_arealevel1_with_externalforeignkey_arealevel2(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_SEARCH:
                    dataobject = search_arealevel1(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_SEARCHCOUNT:
                    dataobject = search_arealevel1_count(arealevel1usecases);
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

    private Object get_arealevel1_with_primarykey(Arealevel1_usecases arealevel1usecases) throws DBException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
        return arealevel1usecases.get_arealevel1_by_primarykey(arealevel1PK);
    }

    private Object get_arealevel1_with_foreignkey_country(Arealevel1_usecases arealevel1usecases) throws CustomException {
        ICountryPK countryPK = (ICountryPK)parser.getJavaObject("countrypk");
        return arealevel1usecases.get_arealevel1_with_foreignkey_country(countryPK);
    }
    
    private Object get_arealevel1_with_externalforeignkey_arealevel2(Arealevel1_usecases arealevel1usecases) throws CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
        return arealevel1usecases.get_arealevel1_with_externalforeignkey_arealevel2(arealevel2PK);
    }
    
    private Object search_arealevel1(Arealevel1_usecases arealevel1usecases) throws CustomException {
        IArealevel1search search = (IArealevel1search)parser.getJavaObject("search");
        return arealevel1usecases.search_arealevel1(search);
    }
    
    private Object search_arealevel1_count(Arealevel1_usecases arealevel1usecases) throws CustomException {
        IArealevel1search arealevel1search = (IArealevel1search)parser.getJavaObject("search");
        return arealevel1usecases.search_arealevel1_count(arealevel1search);
    }

    @Override
    public String getServletInfo() {
        return "arealevel1_select";
    }

}

