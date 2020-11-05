/*
 * BLspatial_ref_sys.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.2.2013 17:43
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.BusinessObject.table.Bspatial_ref_sys;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLspatial_ref_sys;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Business Logic Entity class BLspatial_ref_sys
 *
 * Class for manipulating data- and database objects
 * for Entity Spatial_ref_sys and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLspatial_ref_sys extends Bspatial_ref_sys implements IBLspatial_ref_sys {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     */
    public BLspatial_ref_sys() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLspatial_ref_sys(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity spatial_ref_sys) throws SQLException {
        
    }
    
    /**
     * try to insert Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_insertSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to insert Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_insertSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_updateSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_updateSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to delete Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        trans_deleteSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }

    /**
     * try to delete Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        trans_deleteSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }

    /**
     * try to insert Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.checkDATA(spatial_ref_sys);
        super.insertSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.checkDATA(spatial_ref_sys);
        super.updateSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
    
    /**
     * try to delete Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        super.deleteSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
}
