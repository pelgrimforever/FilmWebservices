/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.art_subgroup;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArt_subgroup;
import film.interfaces.servlet.IArt_subgroupOperation;
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Art_subgroup_usecases;
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
@WebServlet(name="Art_subgroup_update", urlPatterns={"/film.Art_subgroup_update"})
public class Art_subgroup_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArt_subgroupOperation.UPDATE_ART_SUBGROUP:
                    update_art_subgroup(art_subgroupusecases);
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

    private void update_art_subgroup(Art_subgroup_usecases art_subgroupusecases) throws CustomException {
        IArt_subgroup art_subgroup = (IArt_subgroup)parser.getJavaObject("art_subgroup");
        art_subgroupusecases.secureupdateArt_subgroup(art_subgroup);
    }
    
    @Override
    public String getServletInfo() {
        return "art_subgroup_insert";
    }

}

