/*
 * BLspatial_ref_sys.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.9.2021 20:57
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
import BusinessObject.BLtable;
import film.BusinessObject.table.Bspatial_ref_sys;
import general.exception.DataException;

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
public class BLspatial_ref_sys extends Bspatial_ref_sys {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
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
    public BLspatial_ref_sys(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_insertSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to insert Spatial_ref_sys object in database
     * an alternative to insertSpatial_ref_sys, which can be made an empty function
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_insertSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_updateSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * an alternative to updateSpatial_ref_sys, which can be made an empty function
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        trans_updateSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }
    
    /**
     * try to delete Spatial_ref_sys object in database
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        trans_deleteSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }

    /**
     * try to delete Spatial_ref_sys object in database
     * an alternative to deleteSpatial_ref_sys, which can be made an empty function
     * commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        trans_deleteSpatial_ref_sys(spatial_ref_sys);
        super.Commit2DB();
    }

    /**
     * try to insert Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.checkDATA(spatial_ref_sys);
        super.insertSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
    
    /**
     * try to update Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.checkDATA(spatial_ref_sys);
        super.updateSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
    
    /**
     * try to delete Spatial_ref_sys object in database
     * do not commit transaction
     * @param spatial_ref_sys: Spatial_ref_sys Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        super.deleteSpatial_ref_sys((Spatial_ref_sys)spatial_ref_sys);
    }
}
