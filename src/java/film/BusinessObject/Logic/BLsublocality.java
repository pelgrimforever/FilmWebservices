/*
 * BLsublocality.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ISublocality;
import film.logicentity.Sublocality;
import BusinessObject.BLtable;
import film.BusinessObject.table.Bsublocality;
import film.conversion.entity.EMsublocality;
import general.exception.DataException;
import film.interfaces.entity.pk.ILocalityPK;
import general.exception.CustomException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsublocality
 *
 * Class for manipulating data- and database objects
 * for Entity Sublocality and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsublocality extends Bsublocality {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Sublocality as default Entity
     */
    public BLsublocality() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Sublocality as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsublocality(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * @param localityPK: foreign key for Locality
     * @return all Sublocality Entity objects for Locality
     * @throws general.exception.CustomException
     */
    @Override
    public ArrayList getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        return this.getEntities(EMsublocality.SQLSelect4locality, localityPK.getSQLprimarykey());
    }    
    
    /**
     * try to insert Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_insertSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to insert Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_insertSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * check if Sublocality exists
     * if not, try to insert Sublocality in database
     * @param sublocality: Sublocality object
     * @throws DBException
     * @throws general.exception.DataException
     */
    public void insertcheckSublocality(ISublocality sublocality) throws DBException, DataException {
        if(this.getSublocality(sublocality.getPrimaryKey())==null) {
            insertSublocality(sublocality);
        }
    }
    
    /**
     * try to update Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_updateSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to update Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_updateSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to delete Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSublocality(ISublocality sublocality) throws DBException {
        trans_deleteSublocality(sublocality);
        super.Commit2DB();
    }

    /**
     * try to delete Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSublocality(ISublocality sublocality) throws DBException {
        trans_deleteSublocality(sublocality);
        super.Commit2DB();
    }

    /**
     * try to insert Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSublocality(ISublocality sublocality) throws DBException, DataException {
        super.checkDATA(sublocality);
        super.insertSublocality((Sublocality)sublocality);
    }
    
    /**
     * try to update Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSublocality(ISublocality sublocality) throws DBException, DataException {
        super.checkDATA(sublocality);
        super.updateSublocality((Sublocality)sublocality);
    }
    
    /**
     * try to delete Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSublocality(ISublocality sublocality) throws DBException {
        super.deleteSublocality((Sublocality)sublocality);
    }
}
