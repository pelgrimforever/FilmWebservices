/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISecurityuserprofile;
import film.interfaces.servlet.ISecurityuserprofileOperation;
import film.interfaces.searchentity.ISecurityuserprofilesearch;
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
@WebServlet(name="Securityuserprofile", urlPatterns={"/film.Securityuserprofile"})
public class Securityuserprofile extends SecurityDataServlet {
   
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
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        blsecurityuserprofile.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISecurityuserprofilePK securityuserprofilePK;
                    ISecurityuserprofile securityuserprofile;
                    switch(this.operation) {
                        case ISecurityuserprofileOperation.SELECT_ALL:
                            dataobject = blsecurityuserprofile.getSecurityuserprofiles();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SECURITYUSERPROFILE:
                            securityuserprofilePK = (ISecurityuserprofilePK)parser.getJavaObject("securityuserprofilepk");
                            dataobject = blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK);
                            break;
                        case ISecurityuserprofileOperation.SELECT_Securityprofile:
                            ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)parser.getJavaObject("securityprofilepk");
                            dataobject = blsecurityuserprofile.getSecurityuserprofiles4securityprofile(securityprofilePK);
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCH:
                            ISecurityuserprofilesearch search = (ISecurityuserprofilesearch)parser.getJavaObject("search");
                            dataobject = blsecurityuserprofile.search(search);
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityuserprofilesearch securityuserprofilesearch = (ISecurityuserprofilesearch)parser.getJavaObject("search");
                            dataobject = blsecurityuserprofile.searchcount(securityuserprofilesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISecurityuserprofileOperation.INSERT_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)parser.getJavaObject("securityuserprofile");
                            blsecurityuserprofile.insertSecurityuserprofile(securityuserprofile);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISecurityuserprofileOperation.UPDATE_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)parser.getJavaObject("securityuserprofile");
                            blsecurityuserprofile.updateSecurityuserprofile(securityuserprofile);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISecurityuserprofileOperation.DELETE_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)parser.getJavaObject("securityuserprofile");
                            blsecurityuserprofile.deleteSecurityuserprofile(securityuserprofile);
                            break;
                        case ISecurityuserprofileOperation.DELETE_Securityprofile:
                            ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)parser.getJavaObject("securityprofilepk");
                            blsecurityuserprofile.delete4securityprofile(this.getServletName(), securityprofilePK);
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
        return "securityuserprofile";
    }

}

