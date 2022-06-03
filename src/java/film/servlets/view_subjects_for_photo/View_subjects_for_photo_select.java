/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_subjects_for_photo;

import film.BusinessObject.Logic.BLview_subjects_for_photo;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_subjects_for_photo;
import film.interfaces.servlet.IView_subjects_for_photoOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_subjects_for_photo_usecases;
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
@WebServlet(name="View_subjects_for_photo_select", urlPatterns={"/film.View_subjects_for_photo_select"})
public class View_subjects_for_photo_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_subjects_for_photo blview_subjects_for_photo = new BLview_subjects_for_photo();
        View_subjects_for_photo_usecases view_subjects_for_photousecases = new View_subjects_for_photo_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_subjects_for_photoOperation.SELECT_ALL:
                    dataobject = view_subjects_for_photousecases.get_all();
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
        return "view_subjects_for_photo_select";
    }

}

