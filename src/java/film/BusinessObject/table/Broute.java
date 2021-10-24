/*
 * Broute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONRoute;
import film.conversion.entity.EMroute;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IRoutesearch;
import film.logicentity.Route;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Broute
 *
 * Superclass for manipulating data- and database objects
 * for Entity Route and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Broute extends BLtable {

    /**
     * Constructor, sets Route as default Entity
     */
    public Broute() {
        super(new Route(), new EMroute());
    }

    /**
     * Constructor, sets Route as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Broute(BLtable transactionobject) {
        super(transactionobject, new Route(), new EMroute());
    }

    /**
     * create new empty Route object
     * @return empty IRoute
     */
    public IRoute newRoute() {
    	return new Route();
    }
    
    /**
     * create new empty Route object
     * create new primary key with given parameters
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
     * @param sublocality primary key field
     * @param routecode primary key field
     * @return IRoute with primary key
     */
    public IRoute newRoute(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality, java.lang.String routecode) {
        return new Route(countrycode, postalcode, locality, sublocality, routecode);
    }

    /**
     * create new empty Route object with given primary key
     * @param routePK: primary key for Route
     * @return IRoute with primary key
     */
    public IRoute newRoute(IRoutePK routePK) {
        return new Route((RoutePK)routePK);
    }

    /**
     * create new empty primary key
     * @return empty RoutePK
     */
    public IRoutePK newRoutePK() {
        return new RoutePK();
    }

    /**
     * create new primary key with given parameters
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
     * @param sublocality primary key field
     * @param routecode primary key field
     * @return new IRoutePK
     */
    public IRoutePK newRoutePK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality, java.lang.String routecode) {
        return new RoutePK(countrycode, postalcode, locality, sublocality, routecode);
    }

    /**
     * get all Route objects from database
     * @return ArrayList of Route objects
     * @throws DBException
     */
    public ArrayList<Route> getRoutes() throws DBException {
        return (ArrayList<Route>)super.getEntities(EMroute.SQLSelectAll);
    }

    /**
     * search Route for primary key
     * @param routePK: Route primary key
     * @return Route object
     * @throws DBException
     */
    public Route getRoute(IRoutePK routePK) throws DBException {
        return (Route)super.getEntity((RoutePK)routePK);
    }

    /**
     * search route with IRoutesearch parameters
     * @param search IRoutesearch
     * @return ArrayList of Route
     * @throws DBException 
     */
    public ArrayList<Route> searchroutes(IRoutesearch search) throws DBException {
        return (ArrayList<Route>)this.search(search);
    }

    /**
     * search route with IRoutesearch parameters, order by orderby sql clause
     * @param search IRoutesearch
     * @param orderby sql order by string
     * @return ArrayList of Route
     * @throws DBException 
     */
    public ArrayList<Route> searchroutes(IRoutesearch search, String orderby) throws DBException {
        return (ArrayList<Route>)this.search(search, orderby);
    }

    /**
     * Search route in database for routePK:
     * @param routePK: Route Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRouteExists(IRoutePK routePK) throws DBException {
        return super.getEntityExists((RoutePK)routePK);
    }

    /**
     * try to insert Route in database
     * @param route Route object
     * @throws DBException
     * @throws DataException
     */
    public void insertRoute(IRoute route) throws DBException, DataException {
        super.insertEntity(route);
    }

    /**
     * check if RoutePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param route Route object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateRoute(IRoute route) throws DBException, DataException {
        if(this.getRouteExists(route.getPrimaryKey())) {
            super.updateEntity(route);
        } else {
            super.insertEntity(route);
        }
    }

    /**
     * try to update Route in database
     * @param route Route object
     * @throws DBException
     * @throws DataException
     */
    public void updateRoute(IRoute route) throws DBException, DataException {
        super.updateEntity(route);
    }

    /**
     * try to delete Route in database
     * @param route Route object
     * @throws DBException
     */
    public void deleteRoute(IRoute route) throws DBException {
        cascadedeleteRoute(route.getPrimaryKey());
        super.deleteEntity(route);
    }

    /**
     * check data rules in Route, throw DataException with customized message if rules do not apply
     * @param route Route object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRoute route) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Route.Countrycode - Sublocality.Countrycode
        //foreign key Route.Postalcode - Sublocality.Postalcode
        //foreign key Route.Locality - Sublocality.Locality
        //foreign key Route.Sublocality - Sublocality.Sublocality
        //Primary key
        if(route.getName()!=null && route.getName().length()>IRoute.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRoute.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where routePK is used in a primary key
     * @param routePK: Route primary key
     */
    public void cascadedeleteRoute(IRoutePK routePK) {
    }

    /**
     * @param sublocalityPK: foreign key for Sublocality
     * @delete all Route Entity objects for Sublocality in database
     */
    public void delete4sublocality(ISublocalityPK sublocalityPK) {
        super.addStatement(EMroute.SQLDelete4sublocality, sublocalityPK.getSQLprimarykey());
    }

    /**
     * @param sublocalityPK: foreign key for Sublocality
     * @return all Route Entity objects for Sublocality
     * @throws CustomException
     */
    public ArrayList<Route> getRoutes4sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        return super.getEntities(EMroute.SQLSelect4sublocality, sublocalityPK.getSQLprimarykey());
    }

    /**
     * get all Route objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Route objects
     * @throws DBException
     */
    public ArrayList<Route> getRoutes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMroute.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Route>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Route objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delRoute(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Route.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
