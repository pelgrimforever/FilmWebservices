/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.country;

import general.exception.CustomException;
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
@WebServlet(name="Country_insert", urlPatterns={"/film.Country_insert"})
public class Country_insert extends SecurityDataServlet {
   
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
                case ICountryOperation.INSERT_COUNTRY:
                    insert_country(countryusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ICountryOperation.INSERTCHECK_COUNTRY:
                    insert_country_with_check(countryusecases);
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
    private void insert_country_with_check(Country_usecases countryusecases) throws CustomException {
        ICountry country = (ICountry)parser.getJavaObject("country");
        countryusecases.insert_country_with_check(country);
    }

//Custom code, do not change this line   

    private void insert_country(Country_usecases countryusecases) throws CustomException {
        ICountry country = (ICountry)parser.getJavaObject("country");
        countryusecases.insertCountry(country);
    }
    
    @Override
    public String getServletInfo() {
        return "country_insert";
    }

}

