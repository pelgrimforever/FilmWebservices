/*
 * Country.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ICountry;
import film.interfaces.servlet.ICountryOperation;
import film.interfaces.searchentity.ICountrysearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Country", urlPatterns={"/film.Country"})
public class Country extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLcountry blcountry = new BLcountry();
        blcountry.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ICountryPK countryPK;
                    ICountry country;
                    switch(this.operation) {
                        case ICountryOperation.SELECT_ALL:
                            dataobject = blcountry.getCountrys();
                            break;
                        case ICountryOperation.SELECT_COUNTRY:
                            countryPK = (ICountryPK)parser.getJavaObject("countrypk");
                            dataobject = blcountry.getCountry(countryPK);
                            break;
                        case ICountryOperation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
                            dataobject = blcountry.getArealevel1(arealevel1PK);
                            break;
                        case ICountryOperation.SELECT_SEARCH:
                            ICountrysearch search = (ICountrysearch)parser.getJavaObject("search");
                            dataobject = blcountry.search(search);
                            break;
                        case ICountryOperation.SELECT_SEARCHCOUNT:
                            ICountrysearch countrysearch = (ICountrysearch)parser.getJavaObject("search");
                            dataobject = blcountry.searchcount(countrysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ICountryOperation.INSERT_COUNTRY:
                            country = (ICountry)parser.getJavaObject("country");
                            blcountry.insertCountry(country);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ICountryOperation.INSERTCHECK_COUNTRY:
                            country = (ICountry)parser.getJavaObject("country");
                            blcountry.insertcheckCountry(country);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ICountryOperation.UPDATE_COUNTRY:
                            country = (ICountry)parser.getJavaObject("country");
                            blcountry.updateCountry(country);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ICountryOperation.DELETE_COUNTRY:
                            country = (ICountry)parser.getJavaObject("country");
                            blcountry.deleteCountry(country);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "country";
    }

}

