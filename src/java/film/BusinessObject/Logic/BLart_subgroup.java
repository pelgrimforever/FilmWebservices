/*
 * BLart_subgroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IArt_subgroup;
import film.logicentity.Art_subgroup;
import film.BusinessObject.table.Bart_subgroup;
import general.exception.DBException;
import general.exception.DataException;

/**
 * Business Logic Entity class BLart_subgroup
 *
 * Class for manipulating data- and database objects
 * for Entity Art_subgroup and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLart_subgroup extends Bart_subgroup {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Art_subgroup as default Entity
     */
    public BLart_subgroup() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Art_subgroup as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLart_subgroup(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        trans_insertArt_subgroup(art_subgroup);
        super.Commit2DB();
    }
    
    /**
     * try to insert Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        trans_insertArt_subgroup(art_subgroup);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        trans_updateArt_subgroup(art_subgroup);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        trans_updateArt_subgroup(art_subgroup);
        super.Commit2DB();
    }
    
    /**
     * try to delete Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException {
        trans_deleteArt_subgroup(art_subgroup);
        super.Commit2DB();
    }

    /**
     * try to delete Art_subgroup object in database
     * commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException {
        trans_deleteArt_subgroup(art_subgroup);
        super.Commit2DB();
    }

    /**
     * try to insert Art_subgroup object in database
     * do not commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        super.checkDATA(art_subgroup);
        super.insertArt_subgroup((Art_subgroup)art_subgroup);
    }
    
    /**
     * try to update Art_subgroup object in database
     * do not commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        super.checkDATA(art_subgroup);
        super.updateArt_subgroup((Art_subgroup)art_subgroup);
    }
    
    /**
     * try to delete Art_subgroup object in database
     * do not commit transaction
     * @param art_subgroup: Art_subgroup Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException {
        super.deleteArt_subgroup((Art_subgroup)art_subgroup);
    }
}
