/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.art_subgroup;

import general.exception.*;
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
@WebServlet(name="Art_subgroup_select", urlPatterns={"/film.Art_subgroup_select"})
public class Art_subgroup_select extends SecurityDataServlet {
   
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
                case IArt_subgroupOperation.SELECT_ALL:
                    dataobject = art_subgroupusecases.get_all();
                    break;
                case IArt_subgroupOperation.SELECT_ART_SUBGROUP:
                    dataobject = get_art_subgroup_with_primarykey(art_subgroupusecases);
                    break;
                case IArt_subgroupOperation.SELECT_Art_group:
                    dataobject = get_art_subgroup_with_foreignkey_art_group(art_subgroupusecases);
                    break;
                case IArt_subgroupOperation.SELECT_SEARCH:
                    dataobject = search_art_subgroup(art_subgroupusecases);
                    break;
                case IArt_subgroupOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_art_subgroup_count(art_subgroupusecases);
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

    private Object get_art_subgroup_with_primarykey(Art_subgroup_usecases art_subgroupusecases) throws DBException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)parser.getJavaObject("art_subgrouppk");
        return art_subgroupusecases.get_art_subgroup_by_primarykey(art_subgroupPK);
    }

    private Object get_art_subgroup_with_foreignkey_art_group(Art_subgroup_usecases art_subgroupusecases) throws CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
        return art_subgroupusecases.get_art_subgroup_with_foreignkey_art_group(art_groupPK);
    }
    
    private Object search_art_subgroup(Art_subgroup_usecases art_subgroupusecases) throws CustomException {
        IArt_subgroupsearch search = (IArt_subgroupsearch)parser.getJavaObject("search");
        return art_subgroupusecases.search_art_subgroup(search);
    }
    
    private Object search_art_subgroup_count(Art_subgroup_usecases art_subgroupusecases) throws CustomException {
        IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)parser.getJavaObject("search");
        return art_subgroupusecases.search_art_subgroup_count(art_subgroupsearch);
    }

    @Override
    public String getServletInfo() {
        return "art_subgroup_select";
    }

}

