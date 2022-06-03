/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.country;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ICountry;
import film.interfaces.servlet.ICountryOperation;
import film.interfaces.searchentity.ICountrysearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Country_usecases;
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
@WebServlet(name="Country_select", urlPatterns={"/film.Country_select"})
public class Country_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Country_usecases countryusecases = new Country_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ICountryOperation.SELECT_ALL:
                    dataobject = countryusecases.get_all();
                    break;
                case ICountryOperation.SELECT_COUNTRY:
                    dataobject = get_country_with_primarykey(countryusecases);
                    break;
                case ICountryOperation.SELECT_Arealevel1:
                    dataobject = get_country_with_externalforeignkey_arealevel1(countryusecases);
                    break;
                case ICountryOperation.SELECT_SEARCH:
                    dataobject = search_country(countryusecases);
                    break;
                case ICountryOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_country_count(countryusecases);
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

    private Object get_country_with_primarykey(Country_usecases countryusecases) throws DBException {
        ICountryPK countryPK = (ICountryPK)parser.getJavaObject("countrypk");
        return countryusecases.get_country_by_primarykey(countryPK);
    }

    private Object get_country_with_externalforeignkey_arealevel1(Country_usecases countryusecases) throws CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
        return countryusecases.get_country_with_externalforeignkey_arealevel1(arealevel1PK);
    }
    
    private Object search_country(Country_usecases countryusecases) throws CustomException {
        ICountrysearch search = (ICountrysearch)parser.getJavaObject("search");
        return countryusecases.search_country(search);
    }
    
    private Object search_country_count(Country_usecases countryusecases) throws CustomException {
        ICountrysearch countrysearch = (ICountrysearch)parser.getJavaObject("search");
        return countryusecases.search_country_count(countrysearch);
    }

    @Override
    public String getServletInfo() {
        return "country_select";
    }

}

