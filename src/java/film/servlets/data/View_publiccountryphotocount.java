/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 31.4.2016 15:31
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_publiccountryphotocount;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_publiccountryphotocount;
import film.interfaces.servlet.IView_publiccountryphotocountOperation;
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
@WebServlet(name="View_publiccountryphotocount", urlPatterns={"/film.View_publiccountryphotocount"})
public class View_publiccountryphotocount extends SecurityDataServlet {
//ProjectGenerator: NO AUTHOMATIC UPDATE
   
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
        BLview_publiccountryphotocount blview_publiccountryphotocount = new BLview_publiccountryphotocount();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_publiccountryphotocountOperation.SELECT_ALL:
                            dataobject = blview_publiccountryphotocount.getView_publiccountryphotocounts();
                            break;
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
        return "view_publiccountryphotocount";
    }

}

