/*
 * BLarealevel1.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IArealevel1;
import film.logicentity.Arealevel1;
import BusinessObject.BLtable;
import film.BusinessObject.table.Barealevel1;
import film.conversion.entity.EMarealevel1;
import general.exception.DataException;
import film.interfaces.entity.pk.ICountryPK;
import general.exception.CustomException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLarealevel1
 *
 * Class for manipulating data- and database objects
 * for Entity Arealevel1 and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLarealevel1 extends Barealevel1 {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Arealevel1 as default Entity
     */
    public BLarealevel1() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Arealevel1 as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLarealevel1(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * @param countryPK: foreign key for Country
     * @return all Arealevel1 Entity objects for Country
     * @throws general.exception.CustomException
     */
    @Override
    public ArrayList getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        return this.getEntities(EMarealevel1.SQLSelect4country, countryPK.getSQLprimarykey());
    }
    
    /**
     * try to insert Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(arealevel1.getName()==null) arealevel1.setName(arealevel1.getPrimaryKey().getAl1code());
        trans_insertArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to insert Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(arealevel1.getName()==null) arealevel1.setName(arealevel1.getPrimaryKey().getAl1code());
        trans_insertArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * check if Arealevel1 exists
     * if not, try to insert Arealevel1 in database
     * @param arealevel1
     * @throws DBException
     * @throws general.exception.DataException
     */
    public void insertcheckArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(this.getArealevel1(arealevel1.getPrimaryKey())==null) {
            insertArealevel1(arealevel1);
        }
    }
    
    /**
     * try to update Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        trans_updateArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to update Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        trans_updateArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to delete Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        trans_deleteArealevel1(arealevel1);
        super.Commit2DB();
    }

    /**
     * try to delete Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteArealevel1(IArealevel1 arealevel1) throws DBException {
        trans_deleteArealevel1(arealevel1);
        super.Commit2DB();
    }

    /**
     * try to insert Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.checkDATA(arealevel1);
        super.insertArealevel1((Arealevel1)arealevel1);
    }
    
    /**
     * try to update Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.checkDATA(arealevel1);
        super.updateArealevel1((Arealevel1)arealevel1);
    }
    
    /**
     * try to delete Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        super.deleteArealevel1((Arealevel1)arealevel1);
    }
}
