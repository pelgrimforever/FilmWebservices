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
import film.interfaces.logicentity.IPhototree7subject;
import film.interfaces.servlet.IPhototree7subjectOperation;
import film.interfaces.searchentity.IPhototree7subjectsearch;
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
@WebServlet(name="Phototree7subject", urlPatterns={"/film.Phototree7subject"})
public class Phototree7subject extends SecurityDataServlet {
   
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
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        blphototree7subject.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
        BLtree7subject bltree7subject = new BLtree7subject();
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IPhototree7subjectPK phototree7subjectPK;
                    IPhototree7subject phototree7subject;
                    switch(this.operation) {
                        case IPhototree7subjectOperation.SELECT_ALL:
                            dataobject = blphototree7subject.getPhototree7subjects();
                            break;
                        case IPhototree7subjectOperation.SELECT_PHOTOTREE7SUBJECT:
                            phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
                            dataobject = blphototree7subject.getPhototree7subject(phototree7subjectPK);
                            break;
                        case IPhototree7subjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK);
                            break;
                        case IPhototree7subjectOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blphototree7subject.getPhototree7subjects4photo(photoPK);
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCH:
                            IPhototree7subjectsearch search = (IPhototree7subjectsearch)parser.getJavaObject("search");
                            dataobject = blphototree7subject.search(search);
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCHCOUNT:
                            IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)parser.getJavaObject("search");
                            dataobject = blphototree7subject.searchcount(phototree7subjectsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhototree7subjectOperation.SELECT_SUBJECT:
                            ITree7subjectPK tree7subjectpk = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectpk);
                            break;
                        case IPhototree7subjectOperation.SELECT_PHOTO:
                            IPhotoPK photopk = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = bltree7subject.getTree7subjects(photopk);
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IPhototree7subjectOperation.INSERT_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)parser.getJavaObject("phototree7subject");
                            blphototree7subject.insertPhototree7subject(phototree7subject);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhototree7subjectOperation.INSERT_PHOTOSUBJECT:
                            phototree7subject = (IPhototree7subject)parser.getJavaObject("phototree7subject");
                            blphototree7subject.insertPhototree7subject(phototree7subject);
                            IPhotoPK photopk = phototree7subject.getPrimaryKey().getPhotoPK();
                            dataobject = blphototree7subject.getPhototree7subjects4photo(photopk);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IPhototree7subjectOperation.UPDATE_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)parser.getJavaObject("phototree7subject");
                            blphototree7subject.updatePhototree7subject(phototree7subject);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IPhototree7subjectOperation.DELETE_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)parser.getJavaObject("phototree7subject");
                            blphototree7subject.deletePhototree7subject(phototree7subject);
                            break;
                        case IPhototree7subjectOperation.DELETE_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            blphototree7subject.delete4tree7subject(this.getServletName(), tree7subjectPK);
                            break;
                        case IPhototree7subjectOperation.DELETE_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            blphototree7subject.delete4photo(this.getServletName(), photoPK);
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
        return "phototree7subject";
    }

}

