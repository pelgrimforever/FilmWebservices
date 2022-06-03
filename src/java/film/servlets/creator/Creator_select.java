/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.creator;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ICreator;
import film.interfaces.servlet.ICreatorOperation;
import film.interfaces.searchentity.ICreatorsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Creator_usecases;
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
@WebServlet(name="Creator_select", urlPatterns={"/film.Creator_select"})
public class Creator_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Creator_usecases creatorusecases = new Creator_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ICreatorOperation.SELECT_ALL:
                    dataobject = creatorusecases.get_all();
                    break;
                case ICreatorOperation.SELECT_CREATOR:
                    dataobject = get_creator_with_primarykey(creatorusecases);
                    break;
                case ICreatorOperation.SELECT_SEARCH:
                    dataobject = search_creator(creatorusecases);
                    break;
                case ICreatorOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_creator_count(creatorusecases);
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

    private Object get_creator_with_primarykey(Creator_usecases creatorusecases) throws DBException {
        ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
        return creatorusecases.get_creator_by_primarykey(creatorPK);
    }

    private Object search_creator(Creator_usecases creatorusecases) throws CustomException {
        ICreatorsearch search = (ICreatorsearch)parser.getJavaObject("search");
        return creatorusecases.search_creator(search);
    }
    
    private Object search_creator_count(Creator_usecases creatorusecases) throws CustomException {
        ICreatorsearch creatorsearch = (ICreatorsearch)parser.getJavaObject("search");
        return creatorusecases.search_creator_count(creatorsearch);
    }

    @Override
    public String getServletInfo() {
        return "creator_select";
    }

}

