/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.uploadsession;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IUploadsession;
import film.interfaces.servlet.IUploadsessionOperation;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Uploadsession_usecases;
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
@WebServlet(name="Uploadsession_select", urlPatterns={"/film.Uploadsession_select"})
public class Uploadsession_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUploadsessionOperation.SELECT_ALL:
                    dataobject = uploadsessionusecases.get_all();
                    break;
                case IUploadsessionOperation.SELECT_UPLOADSESSION:
                    dataobject = get_uploadsession_with_primarykey(uploadsessionusecases);
                    break;
                case IUploadsessionOperation.SELECT_Creator:
                    dataobject = get_uploadsession_with_foreignkey_creator(uploadsessionusecases);
                    break;
                case IUploadsessionOperation.SELECT_SEARCH:
                    dataobject = search_uploadsession(uploadsessionusecases);
                    break;
                case IUploadsessionOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_uploadsession_count(uploadsessionusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IUploadsessionOperation.SELECT_ALLWITHPHOTOPK:
                    dataobject = get_uploadsession_with_tree7subjects(uploadsessionusecases);
                    break;
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
    private Object get_uploadsession_with_tree7subjects(Uploadsession_usecases uploadsessionusecases) throws DBException {
        return uploadsessionusecases.get_uploadsession_with_tree7subjects();
    }
//Custom code, do not change this line   

    private Object get_uploadsession_with_primarykey(Uploadsession_usecases uploadsessionusecases) throws DBException {
        IUploadsessionPK uploadsessionPK = (IUploadsessionPK)parser.getJavaObject("uploadsessionpk");
        return uploadsessionusecases.get_uploadsession_by_primarykey(uploadsessionPK);
    }

    private Object get_uploadsession_with_foreignkey_creator(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
        return uploadsessionusecases.get_uploadsession_with_foreignkey_creator(creatorPK);
    }
    
    private Object search_uploadsession(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        IUploadsessionsearch search = (IUploadsessionsearch)parser.getJavaObject("search");
        return uploadsessionusecases.search_uploadsession(search);
    }
    
    private Object search_uploadsession_count(Uploadsession_usecases uploadsessionusecases) throws CustomException {
        IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)parser.getJavaObject("search");
        return uploadsessionusecases.search_uploadsession_count(uploadsessionsearch);
    }

    @Override
    public String getServletInfo() {
        return "uploadsession_select";
    }

}

