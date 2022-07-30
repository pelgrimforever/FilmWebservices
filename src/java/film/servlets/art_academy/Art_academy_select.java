/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.art_academy;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArt_academy;
import film.interfaces.servlet.IArt_academyOperation;
import film.interfaces.searchentity.IArt_academysearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Art_academy_usecases;
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
@WebServlet(name="Art_academy_select", urlPatterns={"/film.Art_academy_select"})
public class Art_academy_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Art_academy_usecases art_academyusecases = new Art_academy_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArt_academyOperation.SELECT_ALL:
                    dataobject = art_academyusecases.get_all();
                    break;
                case IArt_academyOperation.SELECT_ART_ACADEMY:
                    dataobject = get_art_academy_with_primarykey(art_academyusecases);
                    break;
                case IArt_academyOperation.SELECT_SEARCH:
                    dataobject = search_art_academy(art_academyusecases);
                    break;
                case IArt_academyOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_art_academy_count(art_academyusecases);
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

    private Object get_art_academy_with_primarykey(Art_academy_usecases art_academyusecases) throws DBException {
        IArt_academyPK art_academyPK = (IArt_academyPK)parser.getJavaObject("art_academypk");
        return art_academyusecases.get_art_academy_by_primarykey(art_academyPK);
    }

    private Object search_art_academy(Art_academy_usecases art_academyusecases) throws CustomException {
        IArt_academysearch search = (IArt_academysearch)parser.getJavaObject("search");
        return art_academyusecases.search_art_academy(search);
    }
    
    private Object search_art_academy_count(Art_academy_usecases art_academyusecases) throws CustomException {
        IArt_academysearch art_academysearch = (IArt_academysearch)parser.getJavaObject("search");
        return art_academyusecases.search_art_academy_count(art_academysearch);
    }

    @Override
    public String getServletInfo() {
        return "art_academy_select";
    }

}

