/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_subjects_for_film;

import film.BusinessObject.Logic.BLview_subjects_for_film;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_subjects_for_film;
import film.interfaces.servlet.IView_subjects_for_filmOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_subjects_for_film_usecases;
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
@WebServlet(name="View_subjects_for_film_select", urlPatterns={"/film.View_subjects_for_film_select"})
public class View_subjects_for_film_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_subjects_for_film blview_subjects_for_film = new BLview_subjects_for_film();
        View_subjects_for_film_usecases view_subjects_for_filmusecases = new View_subjects_for_film_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_subjects_for_filmOperation.SELECT_ALL:
                    dataobject = view_subjects_for_filmusecases.get_all();
                    break;
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        this.sendData(response, dataobject);
    } 

    @Override
    public String getServletInfo() {
        return "view_subjects_for_film_select";
    }

}

