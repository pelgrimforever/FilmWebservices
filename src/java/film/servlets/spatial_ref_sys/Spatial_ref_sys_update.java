/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

@WebServlet(name="Spatial_ref_sys_update", urlPatterns={"/film.Spatial_ref_sys_update"})
public class Spatial_ref_sys_update extends SecurityDataServlet {
   
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
                case ISpatial_ref_sysOperation.UPDATE_SPATIAL_REF_SYS:
                    update_spatial_ref_sys(spatial_ref_sysusecases);
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

    private void update_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws CustomException {
        ISpatial_ref_sys spatial_ref_sys = (ISpatial_ref_sys)parser.getJavaObject("spatial_ref_sys");
        spatial_ref_sysusecases.updateSpatial_ref_sys(spatial_ref_sys);
    }
    
    @Override
    public String getServletInfo() {
        return "spatial_ref_sys_insert";
    }

}

