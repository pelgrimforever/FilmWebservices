/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.spatial_ref_sys;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.interfaces.servlet.ISpatial_ref_sysOperation;
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Spatial_ref_sys_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Spatial_ref_sys_select", urlPatterns={"/film.Spatial_ref_sys_select"})
public class Spatial_ref_sys_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISpatial_ref_sysOperation.SELECT_ALL:
                    dataobject = spatial_ref_sysusecases.get_all();
                    break;
                case ISpatial_ref_sysOperation.SELECT_SPATIAL_REF_SYS:
                    dataobject = get_spatial_ref_sys_with_primarykey(spatial_ref_sysusecases);
                    break;
                case ISpatial_ref_sysOperation.SELECT_SEARCH:
                    dataobject = search_spatial_ref_sys(spatial_ref_sysusecases);
                    break;
                case ISpatial_ref_sysOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_spatial_ref_sys_count(spatial_ref_sysusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_spatial_ref_sys_with_primarykey(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws DBException {
        ISpatial_ref_sysPK spatial_ref_sysPK = (ISpatial_ref_sysPK)parser.getJavaObject("spatial_ref_syspk");
        return spatial_ref_sysusecases.get_spatial_ref_sys_by_primarykey(spatial_ref_sysPK);
    }

    private Object search_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws CustomException {
        ISpatial_ref_syssearch search = (ISpatial_ref_syssearch)parser.getJavaObject("search");
        return spatial_ref_sysusecases.search_spatial_ref_sys(search);
    }
    
    private Object search_spatial_ref_sys_count(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws CustomException {
        ISpatial_ref_syssearch spatial_ref_syssearch = (ISpatial_ref_syssearch)parser.getJavaObject("search");
        return spatial_ref_sysusecases.search_spatial_ref_sys_count(spatial_ref_syssearch);
    }

    @Override
    public String getServletInfo() {
        return "spatial_ref_sys_select";
    }

}

