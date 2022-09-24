/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Route;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Route_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLroute blroute = new BLroute(sqlreader);
    
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
        return blroute.getRouteExists(routePK);
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

    public void insertRoute(IRoute route) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroute.insertRoute(tq, route);
        sqlwriter.Commit2DB(tq);
    }

    public void updateRoute(IRoute route) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroute.updateRoute(tq, route);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteRoute(IRoute route) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroute.deleteRoute(tq, route);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blroute.delete4sublocality(tq, sublocalityPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

