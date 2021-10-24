/*
 * BLart_group.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IArt_group;
import film.logicentity.Art_group;
import film.BusinessObject.table.Bart_group;
import general.exception.DBException;
import general.exception.DataException;

/**
 * Business Logic Entity class BLart_group
 *
 * Class for manipulating data- and database objects
 * for Entity Art_group and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLart_group extends Bart_group {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Art_group as default Entity
     */
    public BLart_group() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Art_group as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLart_group(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertArt_group(IArt_group art_group) throws DBException, DataException {
        trans_insertArt_group(art_group);
        super.Commit2DB();
    }
    
    /**
     * try to insert Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertArt_group(IArt_group art_group) throws DBException, DataException {
        trans_insertArt_group(art_group);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateArt_group(IArt_group art_group) throws DBException, DataException {
        trans_updateArt_group(art_group);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateArt_group(IArt_group art_group) throws DBException, DataException {
        trans_updateArt_group(art_group);
        super.Commit2DB();
    }
    
    /**
     * try to delete Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteArt_group(IArt_group art_group) throws DBException {
        trans_deleteArt_group(art_group);
        super.Commit2DB();
    }

    /**
     * try to delete Art_group object in database
     * commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteArt_group(IArt_group art_group) throws DBException {
        trans_deleteArt_group(art_group);
        super.Commit2DB();
    }

    /**
     * try to insert Art_group object in database
     * do not commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertArt_group(IArt_group art_group) throws DBException, DataException {
        super.checkDATA(art_group);
        super.insertArt_group((Art_group)art_group);
    }
    
    /**
     * try to update Art_group object in database
     * do not commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateArt_group(IArt_group art_group) throws DBException, DataException {
        super.checkDATA(art_group);
        super.updateArt_group((Art_group)art_group);
    }
    
    /**
     * try to delete Art_group object in database
     * do not commit transaction
     * @param art_group: Art_group Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteArt_group(IArt_group art_group) throws DBException {
        super.deleteArt_group((Art_group)art_group);
    }
}
