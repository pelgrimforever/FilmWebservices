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
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.interfaces.servlet.ISpatial_ref_sysOperation;
import film.interfaces.searchentity.ISpatial_ref_syssearch;
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
@WebServlet(name="Spatial_ref_sys", urlPatterns={"/film.Spatial_ref_sys"})
public class Spatial_ref_sys extends SecurityDataServlet {
   
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
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        blspatial_ref_sys.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISpatial_ref_sysPK spatial_ref_sysPK;
                    ISpatial_ref_sys spatial_ref_sys;
                    switch(this.operation) {
                        case ISpatial_ref_sysOperation.SELECT_ALL:
                            dataobject = blspatial_ref_sys.getSpatial_ref_syss();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SPATIAL_REF_SYS:
                            spatial_ref_sysPK = (ISpatial_ref_sysPK)parser.getJavaObject("spatial_ref_syspk");
                            dataobject = blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK);
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCH:
                            ISpatial_ref_syssearch search = (ISpatial_ref_syssearch)parser.getJavaObject("search");
                            dataobject = blspatial_ref_sys.search(search);
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCHCOUNT:
                            ISpatial_ref_syssearch spatial_ref_syssearch = (ISpatial_ref_syssearch)parser.getJavaObject("search");
                            dataobject = blspatial_ref_sys.searchcount(spatial_ref_syssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISpatial_ref_sysOperation.INSERT_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)parser.getJavaObject("spatial_ref_sys");
                            blspatial_ref_sys.insertSpatial_ref_sys(spatial_ref_sys);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISpatial_ref_sysOperation.UPDATE_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)parser.getJavaObject("spatial_ref_sys");
                            blspatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISpatial_ref_sysOperation.DELETE_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)parser.getJavaObject("spatial_ref_sys");
                            blspatial_ref_sys.deleteSpatial_ref_sys(spatial_ref_sys);
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
        return "spatial_ref_sys";
    }

}

