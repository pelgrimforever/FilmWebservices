/*
 * BLpostalcode.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 12:3
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IPostalcode;
import film.logicentity.Postalcode;
import BusinessObject.BLtable;
import film.BusinessObject.table.Bpostalcode;
import general.exception.DataException;

/**
 * Business Logic Entity class BLpostalcode
 *
 * Class for manipulating data- and database objects
 * for Entity Postalcode and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLpostalcode extends Bpostalcode {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Postalcode as default Entity
     */
    public BLpostalcode() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Postalcode as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLpostalcode(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        trans_insertPostalcode(postalcode);
        super.Commit2DB();
    }
    
    /**
     * try to insert Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        trans_insertPostalcode(postalcode);
        super.Commit2DB();
    }
    
    /**
     * check if Postalcode exists
     * if not, try to insert Postalcode in database
     * @param postalcode: Postalcode object
     * @throws DBException
     * @throws general.exception.DataException
     */
    public void insertcheckPostalcode(IPostalcode postalcode) throws DBException, DataException {
        if(this.getPostalcode(postalcode.getPrimaryKey())==null) {
            insertPostalcode(postalcode);
        }
    }
    
    /**
     * try to update Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        trans_updatePostalcode(postalcode);
        super.Commit2DB();
    }
    
    /**
     * try to update Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        trans_updatePostalcode(postalcode);
        super.Commit2DB();
    }
    
    /**
     * try to delete Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deletePostalcode(IPostalcode postalcode) throws DBException {
        trans_deletePostalcode(postalcode);
        super.Commit2DB();
    }

    /**
     * try to delete Postalcode object in database
     * commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     */
    public void securedeletePostalcode(IPostalcode postalcode) throws DBException {
        trans_deletePostalcode(postalcode);
        super.Commit2DB();
    }

    /**
     * try to insert Postalcode object in database
     * do not commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        super.checkDATA(postalcode);
        super.insertPostalcode((Postalcode)postalcode);
    }
    
    /**
     * try to update Postalcode object in database
     * do not commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        super.checkDATA(postalcode);
        super.updatePostalcode((Postalcode)postalcode);
    }
    
    /**
     * try to delete Postalcode object in database
     * do not commit transaction
     * @param postalcode: Postalcode Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deletePostalcode(IPostalcode postalcode) throws DBException {
        super.deletePostalcode((Postalcode)postalcode);
    }
}
