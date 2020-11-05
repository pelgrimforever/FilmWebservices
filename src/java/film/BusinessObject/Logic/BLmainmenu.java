/*
 * BLmainmenu.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import BusinessObject.GeneralObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IMainmenu;
import film.logicentity.Mainmenu;
import film.BusinessObject.table.Bmainmenu;
import film.interfaces.BusinessObject.IBLmainmenu;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLmainmenu
 *
 * Class for manipulating data- and database objects
 * for Entity Mainmenu and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLmainmenu extends Bmainmenu implements IBLmainmenu {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Mainmenu as default Entity
     */
    public BLmainmenu() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Mainmenu as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLmainmenu(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity mainmenu) throws SQLException {
        
    }
    
    /**
     * try to insert Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        trans_insertMainmenu(mainmenu);
        super.Commit2DB();
    }
    
    /**
     * try to insert Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        trans_insertMainmenu(mainmenu);
        super.Commit2DB();
    }
    
    /**
     * try to update Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        trans_updateMainmenu(mainmenu);
        super.Commit2DB();
    }
    
    /**
     * try to update Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        trans_updateMainmenu(mainmenu);
        super.Commit2DB();
    }
    
    /**
     * try to delete Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteMainmenu(IMainmenu mainmenu) throws DBException {
        trans_deleteMainmenu(mainmenu);
        super.Commit2DB();
    }

    /**
     * try to delete Mainmenu object in database
     * commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteMainmenu(IMainmenu mainmenu) throws DBException {
        trans_deleteMainmenu(mainmenu);
        super.Commit2DB();
    }

    /**
     * try to insert Mainmenu object in database
     * do not commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        super.checkDATA(mainmenu);
        super.insertMainmenu((Mainmenu)mainmenu);
    }
    
    /**
     * try to update Mainmenu object in database
     * do not commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        super.checkDATA(mainmenu);
        super.updateMainmenu((Mainmenu)mainmenu);
    }
    
    /**
     * try to delete Mainmenu object in database
     * do not commit transaction
     * @param mainmenu: Mainmenu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteMainmenu(IMainmenu mainmenu) throws DBException {
        super.deleteMainmenu((Mainmenu)mainmenu);
    }
}
