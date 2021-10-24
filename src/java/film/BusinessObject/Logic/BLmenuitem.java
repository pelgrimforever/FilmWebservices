/*
 * BLmenuitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IMenuitem;
import film.logicentity.Menuitem;
import film.BusinessObject.table.Bmenuitem;
import general.exception.DBException;
import general.exception.DataException;

/**
 * Business Logic Entity class BLmenuitem
 *
 * Class for manipulating data- and database objects
 * for Entity Menuitem and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLmenuitem extends Bmenuitem {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Menuitem as default Entity
     */
    public BLmenuitem() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Menuitem as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLmenuitem(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        trans_insertMenuitem(menuitem);
        super.Commit2DB();
    }
    
    /**
     * try to insert Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        trans_insertMenuitem(menuitem);
        super.Commit2DB();
    }
    
    /**
     * try to update Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        trans_updateMenuitem(menuitem);
        super.Commit2DB();
    }
    
    /**
     * try to update Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        trans_updateMenuitem(menuitem);
        super.Commit2DB();
    }
    
    /**
     * try to delete Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteMenuitem(IMenuitem menuitem) throws DBException {
        trans_deleteMenuitem(menuitem);
        super.Commit2DB();
    }

    /**
     * try to delete Menuitem object in database
     * commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteMenuitem(IMenuitem menuitem) throws DBException {
        trans_deleteMenuitem(menuitem);
        super.Commit2DB();
    }

    /**
     * try to insert Menuitem object in database
     * do not commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        super.checkDATA(menuitem);
        super.insertMenuitem((Menuitem)menuitem);
    }
    
    /**
     * try to update Menuitem object in database
     * do not commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        super.checkDATA(menuitem);
        super.updateMenuitem((Menuitem)menuitem);
    }
    
    /**
     * try to delete Menuitem object in database
     * do not commit transaction
     * @param menuitem: Menuitem Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteMenuitem(IMenuitem menuitem) throws DBException {
        super.deleteMenuitem((Menuitem)menuitem);
    }
}
