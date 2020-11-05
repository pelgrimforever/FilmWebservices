/*
 * Broute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONRoute;
import film.data.ProjectConstants;
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
public abstract class Broute extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Route as default Entity
     */
    public Broute() {
        super(new SQLMapper_pgsql(connectionpool, "Route"), new Route());
    }

    /**
     * Constructor, sets Route as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Broute(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Route());
    }

    /**
     * Map ResultSet Field values to Route
     * @param dbresult: Database ResultSet
     */
    public Route mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RoutePK routePK = null;
        Route route;
        if(dbresult==null) {
            route = new Route(routePK);
        } else {
            try {
                routePK = new RoutePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"), dbresult.getString("routecode"));
                route = new Route(routePK);
                route.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    route.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    route.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    route.initViewport(c_viewport.abstractclone());
                }
                route.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, route);
        return route;
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
    public ArrayList getRoutes() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Route.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Route for primary key
     * @param routePK: Route primary key
     * @return Route object
     * @throws DBException
     */
    public Route getRoute(IRoutePK routePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Route)super.getEntity((RoutePK)routePK);
        } else return null;
    }

    public ArrayList searchroutes(IRoutesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchroutes(IRoutesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search route in database for routePK:
     * @param routePK: Route Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRouteExists(IRoutePK routePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((RoutePK)routePK);
        } else return false;
    }

    /**
     * try to insert Route in database
     * @param film: Route object
     * @throws DBException
     */
    public void insertRoute(IRoute route) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(route);
        }
    }

    /**
     * check if RoutePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Route object
     * @throws DBException
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
     * @param film: Route object
     * @throws DBException
     */
    public void updateRoute(IRoute route) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(route);
        }
    }

    /**
     * try to delete Route in database
     * @param film: Route object
     * @throws DBException
     */
    public void deleteRoute(IRoute route) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteRoute(route.getOwnerobject(), route.getPrimaryKey());
            super.deleteEntity(route);
        }
    }

    /**
     * check data rules in Route, throw DataException with customized message if rules do not apply
     * @param film: Route object
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
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IRoute.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where routePK is used in a primary key
     * @param routePK: Route primary key
     */
    public void cascadedeleteRoute(String senderobject, IRoutePK routePK) {
    }

    /**
     * @param sublocalityPK: foreign key for Sublocality
     * @delete all Route Entity objects for Sublocality in database
     * @throws film.general.exception.CustomException
     */
    public void delete4sublocality(String senderobject, ISublocalityPK sublocalityPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Route.SQLDelete4sublocality, sublocalityPK.getKeyFields());
        }
    }

    /**
     * @param sublocalityPK: foreign key for Sublocality
     * @return all Route Entity objects for Sublocality
     * @throws film.general.exception.CustomException
     */
    public ArrayList getRoutes4sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Route.SQLSelect4sublocality, sublocalityPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Route objects for sqlparameters
     * @return ArrayList of Route objects
     * @throws DBException
     */
    public ArrayList getRoutes(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Route.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Route objects for sqlparameters
     * @throws DBException
     */
    public void delRoute(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Route.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
