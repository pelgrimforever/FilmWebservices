/*
 * BLarealevel1.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IArealevel1;
import film.logicentity.Arealevel1;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Barealevel1;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLarealevel1;
import film.interfaces.entity.pk.ICountryPK;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BLarealevel1 extends Barealevel1 implements IBLarealevel1 {
//ProjectGenerator: NO AUTHOMATIC UPDATE
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
    public BLarealevel1(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity arealevel1) throws SQLException {
        
    }
    
    /**
     * @param countryPK: foreign key for Country
     * @return all Arealevel1 Entity objects for Country
     * @throws film.general.exception.CustomException
     */
    @Override
    public ArrayList getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        return getMapper().loadEntityVector(this, Arealevel1.SQLSelect4country, countryPK.getKeyFields());
    }
    
    /**
     * try to insert Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(arealevel1.getName()==null) arealevel1.setName(arealevel1.getPrimaryKey().getAl1code());
        trans_insertArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to insert Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(arealevel1.getName()==null) arealevel1.setName(arealevel1.getPrimaryKey().getAl1code());
        trans_insertArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * check if Arealevel1 exists
     * if not, try to insert Arealevel1 in database
     * @param film: Arealevel1 object
     * @throws DBException
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
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        trans_updateArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to update Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        trans_updateArealevel1(arealevel1);
        super.Commit2DB();
    }
    
    /**
     * try to delete Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        trans_deleteArealevel1(arealevel1);
        super.Commit2DB();
    }

    /**
     * try to delete Arealevel1 object in database
     * commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteArealevel1(IArealevel1 arealevel1) throws DBException {
        trans_deleteArealevel1(arealevel1);
        super.Commit2DB();
    }

    /**
     * try to insert Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.checkDATA(arealevel1);
        super.insertArealevel1((Arealevel1)arealevel1);
    }
    
    /**
     * try to update Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.checkDATA(arealevel1);
        super.updateArealevel1((Arealevel1)arealevel1);
    }
    
    /**
     * try to delete Arealevel1 object in database
     * do not commit transaction
     * @param arealevel1: Arealevel1 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        super.deleteArealevel1((Arealevel1)arealevel1);
    }
}
