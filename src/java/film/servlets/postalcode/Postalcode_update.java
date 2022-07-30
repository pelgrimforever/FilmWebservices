/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.postalcode;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPostalcode;
import film.interfaces.servlet.IPostalcodeOperation;
import film.interfaces.searchentity.IPostalcodesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Postalcode_usecases;
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
@WebServlet(name="Postalcode_update", urlPatterns={"/film.Postalcode_update"})
public class Postalcode_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Postalcode_usecases postalcodeusecases = new Postalcode_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPostalcodeOperation.UPDATE_POSTALCODE:
                    update_postalcode(postalcodeusecases);
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

    private void update_postalcode(Postalcode_usecases postalcodeusecases) throws CustomException {
        IPostalcode postalcode = (IPostalcode)parser.getJavaObject("postalcode");
        postalcodeusecases.updatePostalcode(postalcode);
    }
    
    @Override
    public String getServletInfo() {
        return "postalcode_insert";
    }

}

