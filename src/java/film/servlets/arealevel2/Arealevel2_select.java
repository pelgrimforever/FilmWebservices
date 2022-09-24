/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.arealevel2;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArealevel2;
import film.interfaces.servlet.IArealevel2Operation;
import film.interfaces.searchentity.IArealevel2search;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Arealevel2_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Arealevel2_select", urlPatterns={"/film.Arealevel2_select"})
public class Arealevel2_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArealevel2Operation.SELECT_ALL:
                    dataobject = arealevel2usecases.get_all();
                    break;
                case IArealevel2Operation.SELECT_AREALEVEL2:
                    dataobject = get_arealevel2_with_primarykey(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_Arealevel1:
                    dataobject = get_arealevel2_with_foreignkey_arealevel1(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_Arealevel3:
                    dataobject = get_arealevel2_with_externalforeignkey_arealevel3(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_SEARCH:
                    dataobject = search_arealevel2(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_SEARCHCOUNT:
                    dataobject = search_arealevel2_count(arealevel2usecases);
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

    private Object get_arealevel2_with_primarykey(Arealevel2_usecases arealevel2usecases) throws DBException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)parser.getJavaObject("arealevel2pk");
        return arealevel2usecases.get_arealevel2_by_primarykey(arealevel2PK);
    }

    private Object get_arealevel2_with_foreignkey_arealevel1(Arealevel2_usecases arealevel2usecases) throws CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)parser.getJavaObject("arealevel1pk");
        return arealevel2usecases.get_arealevel2_with_foreignkey_arealevel1(arealevel1PK);
    }
    
    private Object get_arealevel2_with_externalforeignkey_arealevel3(Arealevel2_usecases arealevel2usecases) throws CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)parser.getJavaObject("arealevel3pk");
        return arealevel2usecases.get_arealevel2_with_externalforeignkey_arealevel3(arealevel3PK);
    }
    
    private Object search_arealevel2(Arealevel2_usecases arealevel2usecases) throws CustomException {
        IArealevel2search search = (IArealevel2search)parser.getJavaObject("search");
        return arealevel2usecases.search_arealevel2(search);
    }
    
    private Object search_arealevel2_count(Arealevel2_usecases arealevel2usecases) throws CustomException {
        IArealevel2search arealevel2search = (IArealevel2search)parser.getJavaObject("search");
        return arealevel2usecases.search_arealevel2_count(arealevel2search);
    }

    @Override
    public String getServletInfo() {
        return "arealevel2_select";
    }

}

