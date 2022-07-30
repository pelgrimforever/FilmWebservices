/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.route;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IRoute;
import film.interfaces.servlet.IRouteOperation;
import film.interfaces.searchentity.IRoutesearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Route_usecases;
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
@WebServlet(name="Route_select", urlPatterns={"/film.Route_select"})
public class Route_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Route_usecases routeusecases = new Route_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IRouteOperation.SELECT_ALL:
                    dataobject = routeusecases.get_all();
                    break;
                case IRouteOperation.SELECT_ROUTE:
                    dataobject = get_route_with_primarykey(routeusecases);
                    break;
                case IRouteOperation.SELECT_Sublocality:
                    dataobject = get_route_with_foreignkey_sublocality(routeusecases);
                    break;
                case IRouteOperation.SELECT_SEARCH:
                    dataobject = search_route(routeusecases);
                    break;
                case IRouteOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_route_count(routeusecases);
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

    private Object get_route_with_primarykey(Route_usecases routeusecases) throws DBException {
        IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
        return routeusecases.get_route_by_primarykey(routePK);
    }

    private Object get_route_with_foreignkey_sublocality(Route_usecases routeusecases) throws CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)parser.getJavaObject("sublocalitypk");
        return routeusecases.get_route_with_foreignkey_sublocality(sublocalityPK);
    }
    
    private Object search_route(Route_usecases routeusecases) throws CustomException {
        IRoutesearch search = (IRoutesearch)parser.getJavaObject("search");
        return routeusecases.search_route(search);
    }
    
    private Object search_route_count(Route_usecases routeusecases) throws CustomException {
        IRoutesearch routesearch = (IRoutesearch)parser.getJavaObject("search");
        return routeusecases.search_route_count(routesearch);
    }

    @Override
    public String getServletInfo() {
        return "route_select";
    }

}

