/*
 * Photosubjects.java
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
import film.interfaces.logicentity.IPhotosubjects;
import film.interfaces.servlet.IPhotosubjectsOperation;
import film.interfaces.searchentity.IPhotosubjectssearch;
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
@WebServlet(name="Photosubjects", urlPatterns={"/film.Photosubjects"})
public class Photosubjects extends SecurityDataServlet {
   
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
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        blphotosubjects.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IPhotosubjectsPK photosubjectsPK;
                    IPhotosubjects photosubjects;
                    switch(this.operation) {
                        case IPhotosubjectsOperation.SELECT_ALL:
                            dataobject = blphotosubjects.getPhotosubjectss();
                            break;
                        case IPhotosubjectsOperation.SELECT_PHOTOSUBJECTS:
                            photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
                            dataobject = blphotosubjects.getPhotosubjects(photosubjectsPK);
                            break;
                        case IPhotosubjectsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blphotosubjects.getPhotosubjectss4photo(photoPK);
                            break;
                        case IPhotosubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            dataobject = blphotosubjects.getPhotosubjectss4subject(subjectPK);
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCH:
                            IPhotosubjectssearch search = (IPhotosubjectssearch)parser.getJavaObject("search");
                            dataobject = blphotosubjects.search(search);
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCHCOUNT:
                            IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)parser.getJavaObject("search");
                            dataobject = blphotosubjects.searchcount(photosubjectssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IPhotosubjectsOperation.INSERT_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)parser.getJavaObject("photosubjects");
                            blphotosubjects.insertPhotosubjects(photosubjects);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotosubjectsOperation.INSERT_PHOTOSUBJECT_RELOAD:
                            photosubjects = (IPhotosubjects)parser.getJavaObject("photosubject");
                            blphotosubjects.insertPhotosubjects(photosubjects);
                            IPhotoPK photopk = photosubjects.getPrimaryKey().getPhotoPK();
                            dataobject = blphotosubjects.getPhotosubjectss4photo(photopk);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IPhotosubjectsOperation.UPDATE_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)parser.getJavaObject("photosubjects");
                            blphotosubjects.updatePhotosubjects(photosubjects);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IPhotosubjectsOperation.DELETE_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)parser.getJavaObject("photosubjects");
                            blphotosubjects.deletePhotosubjects(photosubjects);
                            break;
                        case IPhotosubjectsOperation.DELETE_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            blphotosubjects.delete4photo(photoPK);
                            break;
                        case IPhotosubjectsOperation.DELETE_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
                            blphotosubjects.delete4subject(subjectPK);
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
        return "photosubjects";
    }

}

