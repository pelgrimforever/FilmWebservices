/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.arealevel3;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel3;
import film.interfaces.servlet.IArealevel3Operation;
import film.interfaces.searchentity.IArealevel3search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel3_usecases;
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
@WebServlet(name="Arealevel3_select", urlPatterns={"/film.Arealevel3_select"})
public class Arealevel3_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel3Operation.SELECT_ALL:
                    dataobject = arealevel3usecases.get_all();
                    break;
                case IArealevel3Operation.SELECT_AREALEVEL3:
                    dataobject = get_arealevel3_with_primarykey(arealevel3usecases);
                    break;
                case IArealevel3Operation.SELECT_Arealevel2:
                    dataobject = get_arealevel3_with_foreignkey_arealevel2(arealevel3usecases);
                    break;
                case IArealevel3Operation.SELECT_SEARCH:
                    dataobject = search_arealevel3(arealevel3usecases);
                    break;
                case IArealevel3Operation.SELECT_SEARCHCOUNT:
                    dataobject = search_arealevel3_count(arealevel3usecases);
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

    private Object get_arealevel3_with_primarykey(Arealevel3_usecases arealevel3usecases) throws DBException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
        return arealevel3usecases.get_arealevel3_by_primarykey(arealevel3PK);
    }

    private Object get_arealevel3_with_foreignkey_arealevel2(Arealevel3_usecases arealevel3usecases) throws CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
        return arealevel3usecases.get_arealevel3_with_foreignkey_arealevel2(arealevel2PK);
    }
    
    private Object search_arealevel3(Arealevel3_usecases arealevel3usecases) throws CustomException {
        IArealevel3search search = (IArealevel3search)parser.getJavaObject("search");
        return arealevel3usecases.search_arealevel3(search);
    }
    
    private Object search_arealevel3_count(Arealevel3_usecases arealevel3usecases) throws CustomException {
        IArealevel3search arealevel3search = (IArealevel3search)parser.getJavaObject("search");
        return arealevel3usecases.search_arealevel3_count(arealevel3search);
    }

    @Override
    public String getServletInfo() {
        return "arealevel3_select";
    }

}

