/*
 * BLmenu.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IMenu;
import film.logicentity.Menu;
import film.BusinessObject.table.Bmenu;
import film.interfaces.BusinessObject.IBLmenu;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLmenu
 *
 * Class for manipulating data- and database objects
 * for Entity Menu and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLmenu extends Bmenu implements IBLmenu {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Menu as default Entity
     */
    public BLmenu() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Menu as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLmenu(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity menu) throws SQLException {
        
    }
    
    /**
     * try to insert Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertMenu(IMenu menu) throws DBException, DataException {
        trans_insertMenu(menu);
        super.Commit2DB();
    }
    
    /**
     * try to insert Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertMenu(IMenu menu) throws DBException, DataException {
        trans_insertMenu(menu);
        super.Commit2DB();
    }
    
    /**
     * try to update Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateMenu(IMenu menu) throws DBException, DataException {
        trans_updateMenu(menu);
        super.Commit2DB();
    }
    
    /**
     * try to update Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateMenu(IMenu menu) throws DBException, DataException {
        trans_updateMenu(menu);
        super.Commit2DB();
    }
    
    /**
     * try to delete Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteMenu(IMenu menu) throws DBException {
        trans_deleteMenu(menu);
        super.Commit2DB();
    }

    /**
     * try to delete Menu object in database
     * commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteMenu(IMenu menu) throws DBException {
        trans_deleteMenu(menu);
        super.Commit2DB();
    }

    /**
     * try to insert Menu object in database
     * do not commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertMenu(IMenu menu) throws DBException, DataException {
        super.checkDATA(menu);
        super.insertMenu((Menu)menu);
    }
    
    /**
     * try to update Menu object in database
     * do not commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateMenu(IMenu menu) throws DBException, DataException {
        super.checkDATA(menu);
        super.updateMenu((Menu)menu);
    }
    
    /**
     * try to delete Menu object in database
     * do not commit transaction
     * @param menu: Menu Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteMenu(IMenu menu) throws DBException {
        super.deleteMenu((Menu)menu);
    }
}
