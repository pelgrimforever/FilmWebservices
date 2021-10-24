/*
 * Phototags.java
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
import film.interfaces.logicentity.IPhototags;
import film.interfaces.servlet.IPhototagsOperation;
import film.interfaces.searchentity.IPhototagssearch;
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
@WebServlet(name="Phototags", urlPatterns={"/film.Phototags"})
public class Phototags extends SecurityDataServlet {
   
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
        BLphototags blphototags = new BLphototags();
        blphototags.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IPhototagsPK phototagsPK;
                    IPhototags phototags;
                    switch(this.operation) {
                        case IPhototagsOperation.SELECT_ALL:
                            dataobject = blphototags.getPhototagss();
                            break;
                        case IPhototagsOperation.SELECT_PHOTOTAGS:
                            phototagsPK = (IPhototagsPK)parser.getJavaObject("phototagspk");
                            dataobject = blphototags.getPhototags(phototagsPK);
                            break;
                        case IPhototagsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blphototags.getPhototagss4photo(photoPK);
                            break;
                        case IPhototagsOperation.SELECT_SEARCH:
                            IPhototagssearch search = (IPhototagssearch)parser.getJavaObject("search");
                            dataobject = blphototags.search(search);
                            break;
                        case IPhototagsOperation.SELECT_SEARCHCOUNT:
                            IPhototagssearch phototagssearch = (IPhototagssearch)parser.getJavaObject("search");
                            dataobject = blphototags.searchcount(phototagssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IPhototagsOperation.INSERT_PHOTOTAGS:
                            phototags = (IPhototags)parser.getJavaObject("phototags");
                            blphototags.insertPhototags(phototags);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IPhototagsOperation.UPDATE_PHOTOTAGS:
                            phototags = (IPhototags)parser.getJavaObject("phototags");
                            blphototags.updatePhototags(phototags);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IPhototagsOperation.DELETE_PHOTOTAGS:
                            phototags = (IPhototags)parser.getJavaObject("phototags");
                            blphototags.deletePhototags(phototags);
                            break;
                        case IPhototagsOperation.DELETE_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            blphototags.delete4photo(photoPK);
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
        return "phototags";
    }

}

