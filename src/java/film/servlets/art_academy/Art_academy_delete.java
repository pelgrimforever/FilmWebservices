/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.art_academy;

import general.exception.CustomException;
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
@WebServlet(name="Art_academy_delete", urlPatterns={"/film.Art_academy_delete"})
public class Art_academy_delete extends SecurityDataServlet {
   
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
                case IArt_academyOperation.DELETE_ART_ACADEMY:
                    delete_art_academy(art_academyusecases);
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

    private void delete_art_academy(Art_academy_usecases art_academyusecases) throws CustomException {
        IArt_academy art_academy = (IArt_academy)parser.getJavaObject("art_academy");
        art_academyusecases.deleteArt_academy(art_academy);
    }
    
    @Override
    public String getServletInfo() {
        return "art_academy_insert";
    }

}

