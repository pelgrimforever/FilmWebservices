/*
 * BLsecurityuserprofile.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.ISecurityuserprofile;
import film.logicentity.Securityuserprofile;
import film.BusinessObject.table.Bsecurityuserprofile;
import general.exception.DBException;
import general.exception.DataException;

/**
 * Business Logic Entity class BLsecurityuserprofile
 *
 * Class for manipulating data- and database objects
 * for Entity Securityuserprofile and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsecurityuserprofile extends Bsecurityuserprofile {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Securityuserprofile as default Entity
     */
    public BLsecurityuserprofile() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Securityuserprofile as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsecurityuserprofile(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        trans_insertSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }
    
    /**
     * try to insert Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        trans_insertSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }
    
    /**
     * try to update Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        trans_updateSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }
    
    /**
     * try to update Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        trans_updateSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }
    
    /**
     * try to delete Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException {
        trans_deleteSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }

    /**
     * try to delete Securityuserprofile object in database
     * commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException {
        trans_deleteSecurityuserprofile(securityuserprofile);
        super.Commit2DB();
    }

    /**
     * try to insert Securityuserprofile object in database
     * do not commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        super.checkDATA(securityuserprofile);
        super.insertSecurityuserprofile((Securityuserprofile)securityuserprofile);
    }
    
    /**
     * try to update Securityuserprofile object in database
     * do not commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        super.checkDATA(securityuserprofile);
        super.updateSecurityuserprofile((Securityuserprofile)securityuserprofile);
    }
    
    /**
     * try to delete Securityuserprofile object in database
     * do not commit transaction
     * @param securityuserprofile: Securityuserprofile Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException {
        super.deleteSecurityuserprofile((Securityuserprofile)securityuserprofile);
    }
}
