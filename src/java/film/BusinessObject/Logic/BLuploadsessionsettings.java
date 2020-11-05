/*
 * BLuploadsessionsettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.BusinessObject.table.Buploadsessionsettings;
import film.interfaces.BusinessObject.IBLuploadsessionsettings;
import film.logicentity.Uploadsession;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class BLuploadsessionsettings extends Buploadsessionsettings implements IBLuploadsessionsettings {
//ProjectGenerator: NO AUTHOMATIC UPDATE
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
    public BLuploadsessionsettings(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity uploadsessionsettings) throws SQLException {
        
    }
    
    /**
     * try to insert Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertUploadsessionsettings(String senderobject, IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(getUploadsessionsettings(uploadsessionsettings.getPrimaryKey())==null) {
            //delete previouw settings and insert new
            super.addStatement(senderobject, Uploadsession.SQLdeleteall, null);
            super.addStatement(senderobject, Uploadsessionsettings.SQLdeleteall, null);
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
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        trans_updateUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        trans_updateUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }
    
    /**
     * try to delete Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        trans_deleteUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }

    /**
     * try to delete Uploadsessionsettings object in database
     * commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        trans_deleteUploadsessionsettings(uploadsessionsettings);
        super.Commit2DB();
    }

    public void deleteall(String senderobject) throws DBException {
        super.addStatement(senderobject, Uploadsession.SQLdeleteall, null);
        super.addStatement(senderobject, Uploadsessionsettings.SQLdeleteall, null);
        super.Commit2DB();
    }
    
    /**
     * try to insert Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.checkDATA(uploadsessionsettings);
        super.insertUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
    
    /**
     * try to update Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.checkDATA(uploadsessionsettings);
        super.updateUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
    
    /**
     * try to delete Uploadsessionsettings object in database
     * do not commit transaction
     * @param uploadsessionsettings: Uploadsessionsettings Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        super.deleteUploadsessionsettings((Uploadsessionsettings)uploadsessionsettings);
    }
}
