/*
 * BLcreator.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.10.2015 16:22
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ICreator;
import film.logicentity.Creator;
import BusinessObject.BLtable;
import film.BusinessObject.table.Bcreator;
import general.exception.DataException;

/**
 * Business Logic Entity class BLcreator
 *
 * Class for manipulating data- and database objects
 * for Entity Creator and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcreator extends Bcreator {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Creator as default Entity
     */
    public BLcreator() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Creator as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcreator(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Creator object in database
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertCreator(ICreator creator) throws DBException, DataException {
        trans_insertCreator(creator);
        super.Commit2DB();
    }
    
    /**
     * try to insert Creator object in database
     * an alternative to insertCreator, which can be made an empty function
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertCreator(ICreator creator) throws DBException, DataException {
        trans_insertCreator(creator);
        super.Commit2DB();
    }
    
    /**
     * try to update Creator object in database
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateCreator(ICreator creator) throws DBException, DataException {
        trans_updateCreator(creator);
        super.Commit2DB();
    }
    
    /**
     * try to update Creator object in database
     * an alternative to updateCreator, which can be made an empty function
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateCreator(ICreator creator) throws DBException, DataException {
        this.deleteEntity(creator);
        super.Commit2DB();
    }
    
    /**
     * try to delete Creator object in database
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteCreator(ICreator creator) throws DBException {
        this.deleteEntity(creator);
        super.Commit2DB();
    }

    /**
     * try to delete Creator object in database
     * an alternative to deleteCreator, which can be made an empty function
     * commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteCreator(ICreator creator) throws DBException {
        trans_deleteCreator(creator);
        super.Commit2DB();
    }

    /**
     * try to insert Creator object in database
     * do not commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertCreator(ICreator creator) throws DBException, DataException {
        super.checkDATA(creator);
        super.insertCreator((Creator)creator);
    }
    
    /**
     * try to update Creator object in database
     * do not commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateCreator(ICreator creator) throws DBException, DataException {
        super.checkDATA(creator);
        super.updateCreator((Creator)creator);
    }
    
    /**
     * try to delete Creator object in database
     * do not commit transaction
     * @param creator: Creator Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteCreator(ICreator creator) throws DBException {
        super.deleteCreator((Creator)creator);
    }
}
