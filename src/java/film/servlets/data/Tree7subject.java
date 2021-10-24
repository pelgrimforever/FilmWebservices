/*
 * Tree7subject.java
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
import film.interfaces.logicentity.ITree7subject;
import film.interfaces.servlet.ITree7subjectOperation;
import film.interfaces.searchentity.ITree7subjectsearch;
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
@WebServlet(name="Tree7subject", urlPatterns={"/film.Tree7subject"})
public class Tree7subject extends SecurityDataServlet {
   
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
        BLtree7subject bltree7subject = new BLtree7subject();
        bltree7subject.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ITree7subjectPK tree7subjectPK;
                    ITree7subject tree7subject;
                    switch(this.operation) {
                        case ITree7subjectOperation.SELECT_ALL:
                            dataobject = bltree7subject.getTree7subjects();
                            break;
                        case ITree7subjectOperation.SELECT_TREE7SUBJECT:
                            tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = bltree7subject.getTree7subject(tree7subjectPK);
                            break;
                        case ITree7subjectOperation.SELECT_Tree7subjectparentsubjectid:
                            ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK);
                            break;
                        case ITree7subjectOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
                            dataobject = bltree7subject.getPhototree7subject(phototree7subjectPK);
                            break;
                        case ITree7subjectOperation.SELECT_SEARCH:
                            ITree7subjectsearch search = (ITree7subjectsearch)parser.getJavaObject("search");
                            dataobject = bltree7subject.search(search);
                            break;
                        case ITree7subjectOperation.SELECT_SEARCHCOUNT:
                            ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)parser.getJavaObject("search");
                            dataobject = bltree7subject.searchcount(tree7subjectsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITree7subjectOperation.SELECT_STEP1:
                            dataobject = bltree7subject.getAllStep1();
                            break;
                        case ITree7subjectOperation.SELECT_MOSTUSED:
                            dataobject = bltree7subject.getMostUsed();
                            break;
                        case ITree7subjectOperation.SELECT_CHILDREN4PARENT:
                            tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectPK);
                            break;
                        case ITree7subjectOperation.SELECT_SEARCHTEXT:
                            String searchtext = (String)parser.getJavaObject("searchtext");
                            dataobject = bltree7subject.searchTree7subject_Subject(searchtext);
                            break;
                        case ITree7subjectOperation.SELECT_PHOTOPK:
                            IPhotoPK photopk = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = bltree7subject.getTree7subjects(photopk);
                            break;
                        case ITree7subjectOperation.SELECT_FILMPK:
                            IFilmPK filmpk = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = bltree7subject.getTree7subjects(filmpk);
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ITree7subjectOperation.INSERT_TREE7SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.insertTree7subject(tree7subject);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITree7subjectOperation.INSERT_SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.insertTree7subject(userprofile, tree7subject);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ITree7subjectOperation.UPDATE_TREE7SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.updateTree7subject(tree7subject);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITree7subjectOperation.UPDATE_SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.updateTree7subject(userprofile, tree7subject);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ITree7subjectOperation.DELETE_TREE7SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.deleteTree7subject(tree7subject);
                            break;
                        case ITree7subjectOperation.DELETE_Tree7subjectparentsubjectid:
                            ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            bltree7subject.delete4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITree7subjectOperation.DELETE_SUBJECT:
                            tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
                            bltree7subject.deleteTree7subject(userprofile, tree7subject);
                            break;
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
        return "tree7subject";
    }

}

