/*
 * BLcountry.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2013 11:31
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ICountry;
import film.logicentity.Country;
import BusinessObject.BLtable;
import film.BusinessObject.table.Bcountry;
import general.exception.DataException;

/**
 * Business Logic Entity class BLcountry
 *
 * Class for manipulating data- and database objects
 * for Entity Country and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcountry extends Bcountry {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Country as default Entity
     */
    public BLcountry() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Country as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcountry(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertCountry(ICountry country) throws DBException, DataException {
        trans_insertCountry(country);
        super.Commit2DB();
    }
    
    /**
     * try to insert Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertCountry(ICountry country) throws DBException, DataException {
        trans_insertCountry(country);
        super.Commit2DB();
    }
    
    /**
     * check if Country exists in database
     * if not, try to insert Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void insertcheckCountry(ICountry country) throws DBException, DataException {
        if(this.getCountry(country.getPrimaryKey())==null) {
            insertCountry(country);
        }
    }
    
    /**
     * try to update Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateCountry(ICountry country) throws DBException, DataException {
        trans_updateCountry(country);
        super.Commit2DB();
    }
    
    /**
     * try to update Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateCountry(ICountry country) throws DBException, DataException {
        trans_updateCountry(country);
        super.Commit2DB();
    }
    
    /**
     * try to delete Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteCountry(ICountry country) throws DBException {
        trans_deleteCountry(country);
        super.Commit2DB();
    }

    /**
     * try to delete Country object in database
     * commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteCountry(ICountry country) throws DBException {
        trans_deleteCountry(country);
        super.Commit2DB();
    }

    /**
     * try to insert Country object in database
     * do not commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertCountry(ICountry country) throws DBException, DataException {
        super.checkDATA(country);
        super.insertCountry((Country)country);
    }
    
    /**
     * try to update Country object in database
     * do not commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateCountry(ICountry country) throws DBException, DataException {
        super.checkDATA(country);
        super.updateCountry((Country)country);
    }
    
    /**
     * try to delete Country object in database
     * do not commit transaction
     * @param country: Country Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteCountry(ICountry country) throws DBException {
        super.deleteCountry((Country)country);
    }
}
