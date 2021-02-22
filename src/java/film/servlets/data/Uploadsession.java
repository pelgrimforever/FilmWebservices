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
import film.interfaces.logicentity.IUploadsession;
import film.interfaces.servlet.IUploadsessionOperation;
import film.interfaces.searchentity.IUploadsessionsearch;
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
@WebServlet(name="Uploadsession", urlPatterns={"/film.Uploadsession"})
public class Uploadsession extends SecurityDataServlet {
   
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
        BLuploadsession bluploadsession = new BLuploadsession();
        bluploadsession.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
        bluploadsession.setAuthenticated(authenticated);
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IUploadsessionPK uploadsessionPK;
                    IUploadsession uploadsession;
                    switch(this.operation) {
                        case IUploadsessionOperation.SELECT_ALL:
                            dataobject = bluploadsession.getUploadsessions();
                            break;
                        case IUploadsessionOperation.SELECT_UPLOADSESSION:
                            uploadsessionPK = (IUploadsessionPK)parser.getJavaObject("uploadsessionpk");
                            dataobject = bluploadsession.getUploadsession(uploadsessionPK);
                            break;
                        case IUploadsessionOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
                            dataobject = bluploadsession.getUploadsessions4creator(creatorPK);
                            break;
                        case IUploadsessionOperation.SELECT_SEARCH:
                            IUploadsessionsearch search = (IUploadsessionsearch)parser.getJavaObject("search");
                            dataobject = bluploadsession.search(search);
                            break;
                        case IUploadsessionOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)parser.getJavaObject("search");
                            dataobject = bluploadsession.searchcount(uploadsessionsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUploadsessionOperation.SELECT_ALLWITHPHOTOPK:
                            ArrayList uploadsessions = bluploadsession.getUploadsessions();
                            //preload selected subjects
                            ITree7subjectPK[] subjectpks;
                            ArrayList subjectpkarraylist;
                            ArrayList subjects;
                            BLtree7subject blsubject = new BLtree7subject();
                            for(int i=0; i<uploadsessions.size(); i++) {
                                uploadsession = (film.logicentity.Uploadsession)uploadsessions.get(i);
                                subjectpks = uploadsession.getPhotosubjectkeys();
                                subjectpkarraylist = new ArrayList();
                                for(int s=0; s<subjectpks.length; s++) {
                                    subjectpkarraylist.add(subjectpks[s]);
                                }
                                subjects = blsubject.getTree7subjects(subjectpkarraylist);
                                uploadsession.setSubjects(subjects);
                            }
                            dataobject = uploadsessions;
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IUploadsessionOperation.INSERT_UPLOADSESSION:
                            uploadsession = (IUploadsession)parser.getJavaObject("uploadsession");
                            bluploadsession.insertUploadsession(uploadsession);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUploadsessionOperation.INSERT_UPLOADSESSIONS:
                            ArrayList uploadsessions = (ArrayList)parser.getJavaObject("uploadsessions");
                            bluploadsession.insertCompletesession(uploadsessions);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IUploadsessionOperation.UPDATE_UPLOADSESSION:
                            uploadsession = (IUploadsession)parser.getJavaObject("uploadsession");
                            bluploadsession.updateUploadsession(uploadsession);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IUploadsessionOperation.DELETE_UPLOADSESSION:
                            uploadsession = (IUploadsession)parser.getJavaObject("uploadsession");
                            bluploadsession.deleteUploadsession(uploadsession);
                            break;
                        case IUploadsessionOperation.DELETE_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
                            bluploadsession.delete4creator(this.getServletName(), creatorPK);
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
        return "uploadsession";
    }

}

