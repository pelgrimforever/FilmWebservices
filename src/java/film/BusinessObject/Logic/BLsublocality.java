/*
 * BLsublocality.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ISublocality;
import film.logicentity.Sublocality;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Bsublocality;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLsublocality;
import film.interfaces.entity.pk.ILocalityPK;
import film.interfaces.logicentity.ILocality;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsublocality
 *
 * Class for manipulating data- and database objects
 * for Entity Sublocality and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsublocality extends Bsublocality implements IBLsublocality {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Sublocality as default Entity
     */
    public BLsublocality() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Sublocality as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsublocality(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity sublocality) throws SQLException {
        
    }
    
    /**
     * @param localityPK: foreign key for Locality
     * @return all Sublocality Entity objects for Locality
     * @throws film.general.exception.CustomException
     */
    @Override
    public ArrayList getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        return getMapper().loadEntityVector(this, Sublocality.SQLSelect4locality, localityPK.getKeyFields());
    }    
    
    /**
     * try to insert Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_insertSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to insert Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_insertSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * check if Sublocality exists
     * if not, try to insert Sublocality in database
     * @param sublocality: Sublocality object
     * @throws DBException
     */
    public void insertcheckSublocality(ISublocality sublocality) throws DBException, DataException {
        if(this.getSublocality(sublocality.getPrimaryKey())==null) {
            insertSublocality(sublocality);
        }
    }
    
    /**
     * try to update Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_updateSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to update Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateSublocality(ISublocality sublocality) throws DBException, DataException {
        trans_updateSublocality(sublocality);
        super.Commit2DB();
    }
    
    /**
     * try to delete Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteSublocality(ISublocality sublocality) throws DBException {
        trans_deleteSublocality(sublocality);
        super.Commit2DB();
    }

    /**
     * try to delete Sublocality object in database
     * commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteSublocality(ISublocality sublocality) throws DBException {
        trans_deleteSublocality(sublocality);
        super.Commit2DB();
    }

    /**
     * try to insert Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertSublocality(ISublocality sublocality) throws DBException, DataException {
        super.checkDATA(sublocality);
        super.insertSublocality((Sublocality)sublocality);
    }
    
    /**
     * try to update Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateSublocality(ISublocality sublocality) throws DBException, DataException {
        super.checkDATA(sublocality);
        super.updateSublocality((Sublocality)sublocality);
    }
    
    /**
     * try to delete Sublocality object in database
     * do not commit transaction
     * @param sublocality: Sublocality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteSublocality(ISublocality sublocality) throws DBException {
        super.deleteSublocality((Sublocality)sublocality);
    }
}
