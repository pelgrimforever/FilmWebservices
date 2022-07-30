/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IRoute;
import film.logicentity.Route;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Broute;
import film.conversion.entity.EMroute;
import general.exception.DataException;
import film.interfaces.entity.pk.ILocalityPK;
import general.exception.CustomException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLroute extends Broute {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLroute(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLroute(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getRoutes4locality(ILocalityPK localityPK) throws CustomException {
        return this.getEntities(EMroute.SQLSelect4localityPK, localityPK.getSQLprimarykey());
    }
    
    @Override
    public void insertRoute(SQLTqueue transactionqueue, IRoute route) throws DBException, DataException {
        if(route.getName()==null) route.setName(route.getPrimaryKey().getRoutecode());
        super.insertRoute(transactionqueue, route);
    }
    
    public void insertcheckRoute(SQLTqueue transactionqueue, IRoute route) throws DBException, DataException {
        if(this.getRoute(route.getPrimaryKey())==null)
            insertRoute(transactionqueue, route);
    }    
}
