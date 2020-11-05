/*
 * BLarealevel3.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IArealevel3;
import film.logicentity.Arealevel3;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Barealevel3;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLarealevel3;
import film.interfaces.entity.pk.IArealevel2PK;
import film.interfaces.logicentity.IArealevel2;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLarealevel3
 *
 * Class for manipulating data- and database objects
 * for Entity Arealevel3 and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLarealevel3 extends Barealevel3 implements IBLarealevel3 {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Arealevel3 as default Entity
     */
    public BLarealevel3() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Arealevel3 as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLarealevel3(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity arealevel3) throws SQLException {
        
    }
    
    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @return all Arealevel3 Entity objects for Arealevel2
     * @throws film.general.exception.CustomException
     */
    @Override
    public ArrayList getArealevel3s4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return getMapper().loadEntityVector(this, Arealevel3.SQLSelect4arealevel2, arealevel2PK.getKeyFields());
    }
    
    /**
     * try to insert Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(arealevel3.getName()==null) arealevel3.setName(arealevel3.getPrimaryKey().getAl3code());
        trans_insertArealevel3(arealevel3);
        super.Commit2DB();
    }
    
    /**
     * try to insert Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(arealevel3.getName()==null) arealevel3.setName(arealevel3.getPrimaryKey().getAl3code());
        trans_insertArealevel3(arealevel3);
        super.Commit2DB();
    }
    
    /**
     * check if Arealevel3 exists
     * if not, try to insert Arealevel3 in database
     * @param film: Arealevel3 object
     * @throws DBException
     */
    public void insertcheckArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(this.getArealevel3(arealevel3.getPrimaryKey())==null) {
            insertArealevel3(arealevel3);
        }
    }
    
    /**
     * try to update Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        trans_updateArealevel3(arealevel3);
        super.Commit2DB();
    }
    
    /**
     * try to update Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        trans_updateArealevel3(arealevel3);
        super.Commit2DB();
    }
    
    /**
     * try to delete Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteArealevel3(IArealevel3 arealevel3) throws DBException {
        trans_deleteArealevel3(arealevel3);
        super.Commit2DB();
    }

    /**
     * try to delete Arealevel3 object in database
     * commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteArealevel3(IArealevel3 arealevel3) throws DBException {
        trans_deleteArealevel3(arealevel3);
        super.Commit2DB();
    }

    /**
     * try to insert Arealevel3 object in database
     * do not commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        super.checkDATA(arealevel3);
        super.insertArealevel3((Arealevel3)arealevel3);
    }
    
    /**
     * try to update Arealevel3 object in database
     * do not commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        super.checkDATA(arealevel3);
        super.updateArealevel3((Arealevel3)arealevel3);
    }
    
    /**
     * try to delete Arealevel3 object in database
     * do not commit transaction
     * @param arealevel3: Arealevel3 Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteArealevel3(IArealevel3 arealevel3) throws DBException {
        super.deleteArealevel3((Arealevel3)arealevel3);
    }
}
