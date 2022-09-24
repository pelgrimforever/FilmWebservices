/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.securityuserprofile;

import general.exception.CustomException;
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

@WebServlet(name="Securityuserprofile_delete", urlPatterns={"/film.Securityuserprofile_delete"})
public class Securityuserprofile_delete extends SecurityDataServlet {
   
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
                case ISecurityuserprofileOperation.DELETE_SECURITYUSERPROFILE:
                    delete_securityuserprofile(securityuserprofileusecases);
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

    private void delete_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases) throws CustomException {
        ISecurityuserprofile securityuserprofile = (ISecurityuserprofile)parser.getJavaObject("securityuserprofile");
        securityuserprofileusecases.deleteSecurityuserprofile(securityuserprofile);
    }
    
    @Override
    public String getServletInfo() {
        return "securityuserprofile_insert";
    }

}

