/*
 * BLroute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IRoute;
import film.logicentity.Route;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Broute;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLroute;
import film.interfaces.entity.pk.ILocalityPK;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLroute
 *
 * Class for manipulating data- and database objects
 * for Entity Route and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLroute extends Broute implements IBLroute {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Route as default Entity
     */
    public BLroute() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Route as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLroute(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity route) throws SQLException {
        
    }

    /**
     * @param localityPK: foreign key for Locality
     * @return all Route Entity objects for Locality
     * @throws film.general.exception.CustomException
     */
    public ArrayList getRoutes4locality(ILocalityPK localityPK) throws CustomException {
        return getMapper().loadEntityVector(this, Route.SQLSelect4localityPK, localityPK.getKeyFields());
    }
    
    /**
     * try to insert Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertRoute(IRoute route) throws DBException, DataException {
        if(route.getName()==null) route.setName(route.getPrimaryKey().getRoutecode());
        trans_insertRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to insert Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertRoute(IRoute route) throws DBException, DataException {
        if(route.getName()==null) route.setName(route.getPrimaryKey().getRoutecode());
        trans_insertRoute(route);
        super.Commit2DB();
    }
    
    /**
     * check if Route exists
     * if not, try to insert Route in database
     * @param route: Route object
     * @throws DBException
     */
    public void insertcheckRoute(IRoute route) throws DBException, DataException {
        if(this.getRoute(route.getPrimaryKey())==null) {
            insertRoute(route);
        }
    }
    
    /**
     * try to update Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateRoute(IRoute route) throws DBException, DataException {
        trans_updateRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to update Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateRoute(IRoute route) throws DBException, DataException {
        trans_updateRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to delete Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteRoute(IRoute route) throws DBException {
        trans_deleteRoute(route);
        super.Commit2DB();
    }

    /**
     * try to delete Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteRoute(IRoute route) throws DBException {
        trans_deleteRoute(route);
        super.Commit2DB();
    }

    /**
     * try to insert Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertRoute(IRoute route) throws DBException, DataException {
        super.checkDATA(route);
        super.insertRoute((Route)route);
    }
    
    /**
     * try to update Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateRoute(IRoute route) throws DBException, DataException {
        super.checkDATA(route);
        super.updateRoute((Route)route);
    }
    
    /**
     * try to delete Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteRoute(IRoute route) throws DBException {
        super.deleteRoute((Route)route);
    }
}
