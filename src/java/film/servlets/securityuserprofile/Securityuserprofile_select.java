/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.securityuserprofile;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISecurityuserprofile;
import film.interfaces.servlet.ISecurityuserprofileOperation;
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Securityuserprofile_usecases;
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
@WebServlet(name="Securityuserprofile_select", urlPatterns={"/film.Securityuserprofile_select"})
public class Securityuserprofile_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISecurityuserprofileOperation.SELECT_ALL:
                    dataobject = securityuserprofileusecases.get_all();
                    break;
                case ISecurityuserprofileOperation.SELECT_SECURITYUSERPROFILE:
                    dataobject = get_securityuserprofile_with_primarykey(securityuserprofileusecases);
                    break;
                case ISecurityuserprofileOperation.SELECT_Securityprofile:
                    dataobject = get_securityuserprofile_with_foreignkey_securityprofile(securityuserprofileusecases);
                    break;
                case ISecurityuserprofileOperation.SELECT_SEARCH:
                    dataobject = search_securityuserprofile(securityuserprofileusecases);
                    break;
                case ISecurityuserprofileOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_securityuserprofile_count(securityuserprofileusecases);
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

    private Object get_securityuserprofile_with_primarykey(Securityuserprofile_usecases securityuserprofileusecases) throws DBException {
        ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)parser.getJavaObject("securityuserprofilepk");
        return securityuserprofileusecases.get_securityuserprofile_by_primarykey(securityuserprofilePK);
    }

    private Object get_securityuserprofile_with_foreignkey_securityprofile(Securityuserprofile_usecases securityuserprofileusecases) throws CustomException {
        ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)parser.getJavaObject("securityprofilepk");
        return securityuserprofileusecases.get_securityuserprofile_with_foreignkey_securityprofile(securityprofilePK);
    }
    
    private Object search_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases) throws CustomException {
        ISecurityuserprofilesearch search = (ISecurityuserprofilesearch)parser.getJavaObject("search");
        return securityuserprofileusecases.search_securityuserprofile(search);
    }
    
    private Object search_securityuserprofile_count(Securityuserprofile_usecases securityuserprofileusecases) throws CustomException {
        ISecurityuserprofilesearch securityuserprofilesearch = (ISecurityuserprofilesearch)parser.getJavaObject("search");
        return securityuserprofileusecases.search_securityuserprofile_count(securityuserprofilesearch);
    }

    @Override
    public String getServletInfo() {
        return "securityuserprofile_select";
    }

}

