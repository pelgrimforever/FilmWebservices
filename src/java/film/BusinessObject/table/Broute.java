/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMroute;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IRoutesearch;
import film.logicentity.Route;

/**
 * @author Franky Laseure
 */
public abstract class Broute extends TableBusinessrules {

    public Broute(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMroute()));
    }

    public Broute(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMroute()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IRoute newRoute() {
    	return new Route();
    }
    
    public IRoute newRoute(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality, java.lang.String routecode) {
        return new Route(countrycode, postalcode, locality, sublocality, routecode);
    }

    public IRoute newRoute(IRoutePK routePK) {
        return new Route((RoutePK)routePK);
    }

    public IRoutePK newRoutePK() {
        return new RoutePK();
    }

    public IRoutePK newRoutePK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality, java.lang.String routecode) {
        return new RoutePK(countrycode, postalcode, locality, sublocality, routecode);
    }

    public ArrayList<Route> getRoutes() throws DBException {
        return (ArrayList<Route>)tableio.getEntities(EMroute.SQLSelectAll);
    }

    public Route getRoute(IRoutePK routePK) throws DBException {
        return (Route)tableio.getEntity((RoutePK)routePK);
    }

    public ArrayList<Route> searchroutes(IRoutesearch search) throws DBException {
        return (ArrayList<Route>)tableio.search(search);
    }

    public ArrayList<Route> searchroutes(IRoutesearch search, String orderby) throws DBException {
        return (ArrayList<Route>)tableio.search(search, orderby);
    }

    public boolean getRouteExists(IRoutePK routePK) throws DBException {
        return tableio.getEntityExists((RoutePK)routePK);
    }

    public Route getEntity(String sql) throws DBException {
        return (Route)tableio.getEntity(sql);
    }
    
    public Route getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Route)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Route> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Route> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Route> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Route> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertRoute(SQLTqueue transactionqueue, IRoute route) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, route);
    }

    public void insertupdateRoute(SQLTqueue transactionqueue, IRoute route) throws DBException, DataException {
    	checkDATA(route);
        if(this.getRouteExists(route.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, route);
        } else {
            tableio.insertEntity(transactionqueue, route);
        }
    }

    public void updateRoute(SQLTqueue transactionqueue, IRoute route) throws DBException, DataException {
    	checkDATA(route);
        tableio.updateEntity(transactionqueue, route);
    }

    public void deleteRoute(SQLTqueue transactionqueue, IRoute route) throws DBException {
        cascadedeleteRoute(transactionqueue, route.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, route);
    }

    private void checkDATA(IRoute route) throws DataException, DBException {
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
        
    public void cascadedeleteRoute(SQLTqueue transactionqueue, IRoutePK routePK) {
    }

    public void delete4sublocality(SQLTqueue transactionqueue, ISublocalityPK sublocalityPK) {
        tableio.addStatement(transactionqueue, EMroute.SQLDelete4sublocality, sublocalityPK.getSQLprimarykey());
    }

    public ArrayList<Route> getRoutes4sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        return tableio.getEntities(EMroute.SQLSelect4sublocality, sublocalityPK.getSQLprimarykey());
    }

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
        return (ArrayList<Route>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delRoute(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
