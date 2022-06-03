/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Route;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Route_usecases {

    private boolean loggedin = false;
    private BLroute blroute = new BLroute();
    
    public Route_usecases() {
        this(false);
    }
    
    public Route_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blroute.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Route> getRoutes4locality(ILocalityPK localityPK) throws DBException, CustomException {
        return blroute.getRoutes4locality(localityPK);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blroute.count();
    }
    
    public ArrayList<Route> get_all() throws DBException {
        return blroute.getRoutes();
    }
    
    public boolean getRouteExists(IRoutePK routePK) throws DBException {
        return blroute.getEntityExists(routePK);
    }
    
    public Route get_route_by_primarykey(IRoutePK routePK) throws DBException {
        return blroute.getRoute(routePK);
    }

    public ArrayList<Route> get_route_with_foreignkey_sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        return blroute.getRoutes4sublocality(sublocalityPK);
    }
    
    public ArrayList<Route> search_route(IRoutesearch routesearch) throws CustomException {
        return blroute.search(routesearch);
    }
    
    public long search_route_count(IRoutesearch routesearch) throws CustomException {
        return blroute.searchcount(routesearch);
    }

    public void secureinsertRoute(IRoute route) throws DBException, DataException {
        blroute.secureinsertRoute(route);
    }

    public void secureupdateRoute(IRoute route) throws DBException, DataException {
        blroute.secureupdateRoute(route);
    }

    public void securedeleteRoute(IRoute route) throws DBException, DataException {
        blroute.securedeleteRoute(route);
    }
}

