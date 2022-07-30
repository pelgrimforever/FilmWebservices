/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.securityprofile;

import general.exception.CustomException;
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
@WebServlet(name="Securityprofile_delete", urlPatterns={"/film.Securityprofile_delete"})
public class Securityprofile_delete extends SecurityDataServlet {
   
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
                case ISecurityprofileOperation.DELETE_SECURITYPROFILE:
                    delete_securityprofile(securityprofileusecases);
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

    private void delete_securityprofile(Securityprofile_usecases securityprofileusecases) throws CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)parser.getJavaObject("securityprofile");
        securityprofileusecases.deleteSecurityprofile(securityprofile);
    }
    
    @Override
    public String getServletInfo() {
        return "securityprofile_insert";
    }

}

