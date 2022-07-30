/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.securityprofile;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISecurityprofile;
import film.interfaces.servlet.ISecurityprofileOperation;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Securityprofile_usecases;
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
@WebServlet(name="Securityprofile_select", urlPatterns={"/film.Securityprofile_select"})
public class Securityprofile_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISecurityprofileOperation.SELECT_ALL:
                    dataobject = securityprofileusecases.get_all();
                    break;
                case ISecurityprofileOperation.SELECT_SECURITYPROFILE:
                    dataobject = get_securityprofile_with_primarykey(securityprofileusecases);
                    break;
                case ISecurityprofileOperation.SELECT_Securityuserprofile:
                    dataobject = get_securityprofile_with_externalforeignkey_securityuserprofile(securityprofileusecases);
                    break;
                case ISecurityprofileOperation.SELECT_SEARCH:
                    dataobject = search_securityprofile(securityprofileusecases);
                    break;
                case ISecurityprofileOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_securityprofile_count(securityprofileusecases);
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

    private Object get_securityprofile_with_primarykey(Securityprofile_usecases securityprofileusecases) throws DBException {
        ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)parser.getJavaObject("securityprofilepk");
        return securityprofileusecases.get_securityprofile_by_primarykey(securityprofilePK);
    }

    private Object get_securityprofile_with_externalforeignkey_securityuserprofile(Securityprofile_usecases securityprofileusecases) throws CustomException {
        ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)parser.getJavaObject("securityuserprofilepk");
        return securityprofileusecases.get_securityprofile_with_externalforeignkey_securityuserprofile(securityuserprofilePK);
    }
    
    private Object search_securityprofile(Securityprofile_usecases securityprofileusecases) throws CustomException {
        ISecurityprofilesearch search = (ISecurityprofilesearch)parser.getJavaObject("search");
        return securityprofileusecases.search_securityprofile(search);
    }
    
    private Object search_securityprofile_count(Securityprofile_usecases securityprofileusecases) throws CustomException {
        ISecurityprofilesearch securityprofilesearch = (ISecurityprofilesearch)parser.getJavaObject("search");
        return securityprofileusecases.search_securityprofile_count(securityprofilesearch);
    }

    @Override
    public String getServletInfo() {
        return "securityprofile_select";
    }

}

