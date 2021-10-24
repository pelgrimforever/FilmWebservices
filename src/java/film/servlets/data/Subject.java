/*
 * Subject.java
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
import film.interfaces.logicentity.ISubject;
import film.interfaces.servlet.ISubjectOperation;
import film.interfaces.searchentity.ISubjectsearch;
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
@WebServlet(name="Subject", urlPatterns={"/film.Subject"})
public class Subject extends SecurityDataServlet {
   
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
        BLsubject blsubject = new BLsubject();
        blsubject.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISubjectPK subjectPK;
                    ISubject subject;
                    switch(this.operation) {
                        case ISubjectOperation.SELECT_ALL:
                            dataobject = blsubject.getSubjects();
                            break;
                        case ISubjectOperation.SELECT_SUBJECT:
                            subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            dataobject = blsubject.getSubject(subjectPK);
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat1:
                            ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
                            dataobject = blsubject.getSubjects4subjectcatCat1(subjectcatCat1PK);
                            break;
                        case ISubjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            dataobject = blsubject.getSubjects4tree7subject(tree7subjectPK);
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat2:
                            ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
                            dataobject = blsubject.getSubjects4subjectcatCat2(subjectcatCat2PK);
                            break;
                        case ISubjectOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
                            dataobject = blsubject.getFilmsubjects(filmsubjectsPK);
                            break;
                        case ISubjectOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
                            dataobject = blsubject.getPhotosubjects(photosubjectsPK);
                            break;
                        case ISubjectOperation.SELECT_SEARCH:
                            ISubjectsearch search = (ISubjectsearch)parser.getJavaObject("search");
                            dataobject = blsubject.search(search);
                            break;
                        case ISubjectOperation.SELECT_SEARCHCOUNT:
                            ISubjectsearch subjectsearch = (ISubjectsearch)parser.getJavaObject("search");
                            dataobject = blsubject.searchcount(subjectsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISubjectOperation.INSERT_SUBJECT:
                            subject = (ISubject)parser.getJavaObject("subject");
                            blsubject.insertSubject(subject);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISubjectOperation.UPDATE_SUBJECT:
                            subject = (ISubject)parser.getJavaObject("subject");
                            blsubject.updateSubject(subject);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISubjectOperation.DELETE_SUBJECT:
                            subject = (ISubject)parser.getJavaObject("subject");
                            blsubject.deleteSubject(subject);
                            break;
                        case ISubjectOperation.DELETE_Subjectcatcat1:
                            ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
                            blsubject.delete4subjectcatCat1(subjectcatCat1PK);
                            break;
                        case ISubjectOperation.DELETE_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
                            blsubject.delete4tree7subject(tree7subjectPK);
                            break;
                        case ISubjectOperation.DELETE_Subjectcatcat2:
                            ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
                            blsubject.delete4subjectcatCat2(subjectcatCat2PK);
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
        return "subject";
    }

}

