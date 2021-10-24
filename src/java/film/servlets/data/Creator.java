/*
 * Creator.java
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
import film.interfaces.logicentity.ICreator;
import film.interfaces.servlet.ICreatorOperation;
import film.interfaces.searchentity.ICreatorsearch;
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
@WebServlet(name="Creator", urlPatterns={"/film.Creator"})
public class Creator extends SecurityDataServlet {
   
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
        BLcreator blcreator = new BLcreator();
        blcreator.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ICreatorPK creatorPK;
                    ICreator creator;
                    switch(this.operation) {
                        case ICreatorOperation.SELECT_ALL:
                            dataobject = blcreator.getCreators();
                            break;
                        case ICreatorOperation.SELECT_CREATOR:
                            creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
                            dataobject = blcreator.getCreator(creatorPK);
                            break;
                        case ICreatorOperation.SELECT_SEARCH:
                            ICreatorsearch search = (ICreatorsearch)parser.getJavaObject("search");
                            dataobject = blcreator.search(search);
                            break;
                        case ICreatorOperation.SELECT_SEARCHCOUNT:
                            ICreatorsearch creatorsearch = (ICreatorsearch)parser.getJavaObject("search");
                            dataobject = blcreator.searchcount(creatorsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ICreatorOperation.INSERT_CREATOR:
                            creator = (ICreator)parser.getJavaObject("creator");
                            blcreator.insertCreator(creator);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ICreatorOperation.UPDATE_CREATOR:
                            creator = (ICreator)parser.getJavaObject("creator");
                            blcreator.updateCreator(creator);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ICreatorOperation.DELETE_CREATOR:
                            creator = (ICreator)parser.getJavaObject("creator");
                            blcreator.deleteCreator(creator);
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
        return "creator";
    }

}

