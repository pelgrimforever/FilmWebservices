/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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
@WebServlet(name="Securityprofile_insert", urlPatterns={"/film.Securityprofile_insert"})
public class Securityprofile_insert extends SecurityDataServlet {
   
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
                case ISecurityprofileOperation.INSERT_SECURITYPROFILE:
                    insert_securityprofile(securityprofileusecases);
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

    private void insert_securityprofile(Securityprofile_usecases securityprofileusecases) throws CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)parser.getJavaObject("securityprofile");
        securityprofileusecases.secureinsertSecurityprofile(securityprofile);
    }
    
    @Override
    public String getServletInfo() {
        return "securityprofile_insert";
    }

}

