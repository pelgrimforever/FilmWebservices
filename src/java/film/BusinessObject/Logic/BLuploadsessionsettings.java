/*
 * BLuploadsessionsettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.BusinessObject.table.Buploadsessionsettings;
import film.conversion.entity.EMuploadsession;
import film.conversion.entity.EMuploadsessionsettings;
import film.logicentity.Uploadsession;
import general.exception.DBException;
import general.exception.DataException;

/**
 * Business Logic Entity class BLuploadsessionsettings
 *
 * Class for manipulating data- and database objects
 * for Entity Uploadsessionsettings and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLuploadsessionsettings extends Buploadsessionsettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     */
    public BLuploadsessionsettings() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLuploadsessionsettings(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Uploadsessionsettings object in database
     * commit transaction
     * @param senderobject
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void insertUploadsessionsettings(String senderobject, IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(getUploadsessionsettings(uploadsessionsettings.getPrimaryKey())==null) {
            //delete previouw settings and insert new
            super.addStatement(EMuploadsession.SQLdeleteall);
            super.addStatement(EMuploadsessionsettings.SQLdeleteall);
            super.Commit2DB();
            uploadsessionsettings.setUploadingposition(-1);
            trans_insertUploadsessionsettings(uploadsessionsettings);
        } else {
            //update settings
            trans_updateUploadsessionsettings(uploadsessionsettings);
        }
        super.Commit2DB();
    }
    
    /**
     * try to insert Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        trans_updateUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        trans_updateUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }
    
    /**
     * try to delete Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        trans_deleteUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }

    /**
     * try to delete Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        trans_deleteUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }

    public void deleteall(String senderobject) throws DBException {
        super.addStatement(EMuploadsession.SQLdeleteall);
        super.addStatement(EMuploadsessionsettings.SQLdeleteall);
        super.Commit2DB();
    }
    
    /**
     * try to insert Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.checkDATA(uploadsessionsettings);
        super.insertUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.checkDATA(uploadsessionsettings);
        super.updateUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
    
    /**
     * try to delete Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        super.deleteUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
}
