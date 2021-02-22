/*
 * BLarealevel2.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IArealevel2;
import film.logicentity.Arealevel2;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Barealevel2;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLarealevel2;
import film.interfaces.entity.pk.IArealevel1PK;
import film.interfaces.logicentity.IArealevel1;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLarealevel2
 *
 * Class for manipulating data- and database objects
 * for Entity Arealevel2 and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLarealevel2 extends Barealevel2 implements IBLarealevel2 {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Arealevel2 as default Entity
     */
    public BLarealevel2() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Arealevel2 as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLarealevel2(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity arealevel2) throws SQLException {
        
    }
    
    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @return all Arealevel2 Entity objects for Arealevel1
     * @throws film.general.exception.CustomException
     */
    @Override
    public ArrayList getArealevel2s4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return getMapper().loadEntityVector(this, Arealevel2.SQLSelect4arealevel1, arealevel1PK.getKeyFields());
    }
    
    /**
     * try to insert Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(arealevel2.getName()==null) arealevel2.setName(arealevel2.getPrimaryKey().getAl2code());
        trans_insertArealevel2(arealevel2);
        super.Commit2DB();
    }
    
    /**
     * try to insert Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(arealevel2.getName()==null) arealevel2.setName(arealevel2.getPrimaryKey().getAl2code());
        trans_insertArealevel2(arealevel2);
        super.Commit2DB();
    }
    
    /**
     * check if Arealevel2 exists
     * if not, try to insert Arealevel2 in database
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void insertcheckArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(this.getArealevel2(arealevel2.getPrimaryKey())==null) {
            insertArealevel2(arealevel2);
        }
    }
    
    /**
     * check if Arealevel2 exists
     * if not, try to insert Arealevel2 in database
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void secureinsertcheckArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(this.getArealevel2(arealevel2.getPrimaryKey())==null) {
            insertArealevel2(arealevel2);
        }
    }
    
    /**
     * try to update Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        trans_updateArealevel2(arealevel2);
        super.Commit2DB();
    }
    
    /**
     * try to update Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        trans_updateArealevel2(arealevel2);
        super.Commit2DB();
    }
    
    /**
     * try to delete Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteArealevel2(IArealevel2 arealevel2) throws DBException {
        trans_deleteArealevel2(arealevel2);
        super.Commit2DB();
    }

    /**
     * try to delete Arealevel2 object in database
     * commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteArealevel2(IArealevel2 arealevel2) throws DBException {
        trans_deleteArealevel2(arealevel2);
        super.Commit2DB();
    }

    /**
     * try to insert Arealevel2 object in database
     * do not commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        super.checkDATA(arealevel2);
        super.insertArealevel2((Arealevel2)arealevel2);
    }
    
    /**
     * try to update Arealevel2 object in database
     * do not commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        super.checkDATA(arealevel2);
        super.updateArealevel2((Arealevel2)arealevel2);
    }
    
    /**
     * try to delete Arealevel2 object in database
     * do not commit transaction
     * @param arealevel2: Arealevel2 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteArealevel2(IArealevel2 arealevel2) throws DBException {
        super.deleteArealevel2((Arealevel2)arealevel2);
    }
}