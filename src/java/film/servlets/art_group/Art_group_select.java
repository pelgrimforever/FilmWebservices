/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.art_group;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArt_group;
import film.interfaces.servlet.IArt_groupOperation;
import film.interfaces.searchentity.IArt_groupsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Art_group_usecases;
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
@WebServlet(name="Art_group_select", urlPatterns={"/film.Art_group_select"})
public class Art_group_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Art_group_usecases art_groupusecases = new Art_group_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArt_groupOperation.SELECT_ALL:
                    dataobject = art_groupusecases.get_all();
                    break;
                case IArt_groupOperation.SELECT_ART_GROUP:
                    dataobject = get_art_group_with_primarykey(art_groupusecases);
                    break;
                case IArt_groupOperation.SELECT_SEARCH:
                    dataobject = search_art_group(art_groupusecases);
                    break;
                case IArt_groupOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_art_group_count(art_groupusecases);
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

    private Object get_art_group_with_primarykey(Art_group_usecases art_groupusecases) throws DBException {
        IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
        return art_groupusecases.get_art_group_by_primarykey(art_groupPK);
    }

    private Object search_art_group(Art_group_usecases art_groupusecases) throws CustomException {
        IArt_groupsearch search = (IArt_groupsearch)parser.getJavaObject("search");
        return art_groupusecases.search_art_group(search);
    }
    
    private Object search_art_group_count(Art_group_usecases art_groupusecases) throws CustomException {
        IArt_groupsearch art_groupsearch = (IArt_groupsearch)parser.getJavaObject("search");
        return art_groupusecases.search_art_group_count(art_groupsearch);
    }

    @Override
    public String getServletInfo() {
        return "art_group_select";
    }

}

