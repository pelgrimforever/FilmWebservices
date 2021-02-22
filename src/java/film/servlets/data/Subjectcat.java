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
import film.interfaces.logicentity.ISubjectcat;
import film.interfaces.servlet.ISubjectcatOperation;
import film.interfaces.searchentity.ISubjectcatsearch;
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
@WebServlet(name="Subjectcat", urlPatterns={"/film.Subjectcat"})
public class Subjectcat extends SecurityDataServlet {
   
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
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        blsubjectcat.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISubjectcatPK subjectcatPK;
                    ISubjectcat subjectcat;
                    switch(this.operation) {
                        case ISubjectcatOperation.SELECT_ALL:
                            dataobject = blsubjectcat.getSubjectcats();
                            break;
                        case ISubjectcatOperation.SELECT_SUBJECTCAT:
                            subjectcatPK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
                            dataobject = blsubjectcat.getSubjectcat(subjectcatPK);
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat1:
                            ISubjectPK subjectCat1PK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            dataobject = blsubjectcat.getSubjectcat1(subjectCat1PK);
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat2:
                            ISubjectPK subjectCat2PK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            dataobject = blsubjectcat.getSubjectcat2(subjectCat2PK);
                            break;
                        case ISubjectcatOperation.SELECT_SEARCH:
                            ISubjectcatsearch search = (ISubjectcatsearch)parser.getJavaObject("search");
                            dataobject = blsubjectcat.search(search);
                            break;
                        case ISubjectcatOperation.SELECT_SEARCHCOUNT:
                            ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)parser.getJavaObject("search");
                            dataobject = blsubjectcat.searchcount(subjectcatsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ISubjectcatOperation.SELECT_CAT1:
                            dataobject = blsubjectcat.getSubjectcats1();
                            break;
                        case ISubjectcatOperation.SELECT_CAT2:
                            dataobject = blsubjectcat.getSubjectcats2();
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISubjectcatOperation.INSERT_SUBJECTCAT:
                            subjectcat = (ISubjectcat)parser.getJavaObject("subjectcat");
                            blsubjectcat.insertSubjectcat(subjectcat);
                            break;
//Custom code, do not change this line
                        case ISubjectcatOperation.INSERT_CAT1:
                            ISubjectcat subjectcat1 = (ISubjectcat)parser.getJavaObject("subjectcat1");
                            blsubjectcat.insertSubjectcat(subjectcat1);
                            dataobject = blsubjectcat.getSubjectcats1();
                            break;
                        case ISubjectcatOperation.INSERT_CAT2:
                            ISubjectcat subjectcat2 = (ISubjectcat)parser.getJavaObject("subjectcat2");
                            blsubjectcat.insertSubjectcat(subjectcat2);
                            dataobject = blsubjectcat.getSubjectcats2();
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISubjectcatOperation.UPDATE_SUBJECTCAT:
                            subjectcat = (ISubjectcat)parser.getJavaObject("subjectcat");
                            blsubjectcat.updateSubjectcat(subjectcat);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISubjectcatOperation.DELETE_SUBJECTCAT:
                            subjectcat = (ISubjectcat)parser.getJavaObject("subjectcat");
                            blsubjectcat.deleteSubjectcat(subjectcat);
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
        return "subjectcat";
    }

}

