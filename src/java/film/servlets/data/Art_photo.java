/*
 * Art_photo.java
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
import film.interfaces.logicentity.IArt_photo;
import film.interfaces.servlet.IArt_photoOperation;
import film.interfaces.searchentity.IArt_photosearch;
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
@WebServlet(name="Art_photo", urlPatterns={"/film.Art_photo"})
public class Art_photo extends SecurityDataServlet {
   
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
        BLart_photo blart_photo = new BLart_photo();
        blart_photo.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IArt_photoPK art_photoPK;
                    IArt_photo art_photo;
                    switch(this.operation) {
                        case IArt_photoOperation.SELECT_ALL:
                            dataobject = blart_photo.getArt_photos();
                            break;
                        case IArt_photoOperation.SELECT_ART_PHOTO:
                            art_photoPK = (IArt_photoPK)parser.getJavaObject("art_photopk");
                            dataobject = blart_photo.getArt_photo(art_photoPK);
                            break;
                        case IArt_photoOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blart_photo.getArt_photos4photo(photoPK);
                            break;
                        case IArt_photoOperation.SELECT_Art_subgroup:
                            IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)parser.getJavaObject("art_subgrouppk");
                            dataobject = blart_photo.getArt_photos4art_subgroup(art_subgroupPK);
                            break;
                        case IArt_photoOperation.SELECT_Art_academy:
                            IArt_academyPK art_academyPK = (IArt_academyPK)parser.getJavaObject("art_academypk");
                            dataobject = blart_photo.getArt_photos4art_academy(art_academyPK);
                            break;
                        case IArt_photoOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
                            dataobject = blart_photo.getArt_photos4art_group(art_groupPK);
                            break;
                        case IArt_photoOperation.SELECT_SEARCH:
                            IArt_photosearch search = (IArt_photosearch)parser.getJavaObject("search");
                            dataobject = blart_photo.search(search);
                            break;
                        case IArt_photoOperation.SELECT_SEARCHCOUNT:
                            IArt_photosearch art_photosearch = (IArt_photosearch)parser.getJavaObject("search");
                            dataobject = blart_photo.searchcount(art_photosearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IArt_photoOperation.INSERT_ART_PHOTO:
                            art_photo = (IArt_photo)parser.getJavaObject("art_photo");
                            blart_photo.insertArt_photo(art_photo);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IArt_photoOperation.UPDATE_ART_PHOTO:
                            art_photo = (IArt_photo)parser.getJavaObject("art_photo");
                            blart_photo.updateArt_photo(art_photo);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IArt_photoOperation.DELETE_ART_PHOTO:
                            art_photo = (IArt_photo)parser.getJavaObject("art_photo");
                            blart_photo.deleteArt_photo(art_photo);
                            break;
                        case IArt_photoOperation.DELETE_Photo:
                            IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            blart_photo.delete4photo(photoPK);
                            break;
                        case IArt_photoOperation.DELETE_Art_subgroup:
                            IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)parser.getJavaObject("art_subgrouppk");
                            blart_photo.delete4art_subgroup(art_subgroupPK);
                            break;
                        case IArt_photoOperation.DELETE_Art_academy:
                            IArt_academyPK art_academyPK = (IArt_academyPK)parser.getJavaObject("art_academypk");
                            blart_photo.delete4art_academy(art_academyPK);
                            break;
                        case IArt_photoOperation.DELETE_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
                            blart_photo.delete4art_group(art_groupPK);
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
        return "art_photo";
    }

}

