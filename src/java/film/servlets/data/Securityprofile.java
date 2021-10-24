/*
 * Securityprofile.java
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
import film.interfaces.logicentity.ISecurityprofile;
import film.interfaces.servlet.ISecurityprofileOperation;
import film.interfaces.searchentity.ISecurityprofilesearch;
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
@WebServlet(name="Securityprofile", urlPatterns={"/film.Securityprofile"})
public class Securityprofile extends SecurityDataServlet {
   
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
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        blsecurityprofile.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISecurityprofilePK securityprofilePK;
                    ISecurityprofile securityprofile;
                    switch(this.operation) {
                        case ISecurityprofileOperation.SELECT_ALL:
                            dataobject = blsecurityprofile.getSecurityprofiles();
                            break;
                        case ISecurityprofileOperation.SELECT_SECURITYPROFILE:
                            securityprofilePK = (ISecurityprofilePK)parser.getJavaObject("securityprofilepk");
                            dataobject = blsecurityprofile.getSecurityprofile(securityprofilePK);
                            break;
                        case ISecurityprofileOperation.SELECT_Securityuserprofile:
                            ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)parser.getJavaObject("securityuserprofilepk");
                            dataobject = blsecurityprofile.getSecurityuserprofile(securityuserprofilePK);
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCH:
                            ISecurityprofilesearch search = (ISecurityprofilesearch)parser.getJavaObject("search");
                            dataobject = blsecurityprofile.search(search);
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityprofilesearch securityprofilesearch = (ISecurityprofilesearch)parser.getJavaObject("search");
                            dataobject = blsecurityprofile.searchcount(securityprofilesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISecurityprofileOperation.INSERT_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)parser.getJavaObject("securityprofile");
                            blsecurityprofile.insertSecurityprofile(securityprofile);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISecurityprofileOperation.UPDATE_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)parser.getJavaObject("securityprofile");
                            blsecurityprofile.updateSecurityprofile(securityprofile);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISecurityprofileOperation.DELETE_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)parser.getJavaObject("securityprofile");
                            blsecurityprofile.deleteSecurityprofile(securityprofile);
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
        return "securityprofile";
    }

}

