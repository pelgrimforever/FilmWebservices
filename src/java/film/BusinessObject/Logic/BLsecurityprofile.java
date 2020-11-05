/*
 * BLsecurityprofile.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ISecurityprofile;
import film.logicentity.Securityprofile;
import film.BusinessObject.table.Bsecurityprofile;
import film.interfaces.BusinessObject.IBLsecurityprofile;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsecurityprofile
 *
 * Class for manipulating data- and database objects
 * for Entity Securityprofile and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsecurityprofile extends Bsecurityprofile implements IBLsecurityprofile {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Securityprofile as default Entity
     */
    public BLsecurityprofile() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Securityprofile as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsecurityprofile(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity securityprofile) throws SQLException {
        
    }
    
    public ArrayList getSecurityprofiles(String username) throws DBException {
        Object[][] parameter = { { "siteusername", username } };
        return getMapper().loadEntityVector(this, Securityprofile.SQLSelectAll, parameter);
    }

    /**
     * try to insert Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        trans_insertSecurityprofile(securityprofile);
        super.Commit2DB();
    }
    
    /**
     * try to insert Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        trans_insertSecurityprofile(securityprofile);
        super.Commit2DB();
    }
    
    /**
     * try to update Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        trans_updateSecurityprofile(securityprofile);
        super.Commit2DB();
    }
    
    /**
     * try to update Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        trans_updateSecurityprofile(securityprofile);
        super.Commit2DB();
    }
    
    /**
     * try to delete Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteSecurityprofile(ISecurityprofile securityprofile) throws DBException {
        trans_deleteSecurityprofile(securityprofile);
        super.Commit2DB();
    }

    /**
     * try to delete Securityprofile object in database
     * commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteSecurityprofile(ISecurityprofile securityprofile) throws DBException {
        trans_deleteSecurityprofile(securityprofile);
        super.Commit2DB();
    }

    /**
     * try to insert Securityprofile object in database
     * do not commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        super.checkDATA(securityprofile);
        super.insertSecurityprofile((Securityprofile)securityprofile);
    }
    
    /**
     * try to update Securityprofile object in database
     * do not commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        super.checkDATA(securityprofile);
        super.updateSecurityprofile((Securityprofile)securityprofile);
    }
    
    /**
     * try to delete Securityprofile object in database
     * do not commit transaction
     * @param securityprofile: Securityprofile Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteSecurityprofile(ISecurityprofile securityprofile) throws DBException {
        super.deleteSecurityprofile((Securityprofile)securityprofile);
    }
}
