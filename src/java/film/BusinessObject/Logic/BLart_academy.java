/*
 * BLart_academy.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IArt_academy;
import film.logicentity.Art_academy;
import film.BusinessObject.table.Bart_academy;
import film.interfaces.BusinessObject.IBLart_academy;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLart_academy
 *
 * Class for manipulating data- and database objects
 * for Entity Art_academy and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLart_academy extends Bart_academy implements IBLart_academy {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Art_academy as default Entity
     */
    public BLart_academy() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Art_academy as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLart_academy(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity art_academy) throws SQLException {
        
    }
    
    /**
     * try to insert Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        trans_insertArt_academy(art_academy);
        super.Commit2DB();
    }
    
    /**
     * try to insert Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        trans_insertArt_academy(art_academy);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        trans_updateArt_academy(art_academy);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        trans_updateArt_academy(art_academy);
        super.Commit2DB();
    }
    
    /**
     * try to delete Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteArt_academy(IArt_academy art_academy) throws DBException {
        trans_deleteArt_academy(art_academy);
        super.Commit2DB();
    }

    /**
     * try to delete Art_academy object in database
     * commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteArt_academy(IArt_academy art_academy) throws DBException {
        trans_deleteArt_academy(art_academy);
        super.Commit2DB();
    }

    /**
     * try to insert Art_academy object in database
     * do not commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        super.checkDATA(art_academy);
        super.insertArt_academy((Art_academy)art_academy);
    }
    
    /**
     * try to update Art_academy object in database
     * do not commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        super.checkDATA(art_academy);
        super.updateArt_academy((Art_academy)art_academy);
    }
    
    /**
     * try to delete Art_academy object in database
     * do not commit transaction
     * @param art_academy: Art_academy Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteArt_academy(IArt_academy art_academy) throws DBException {
        super.deleteArt_academy((Art_academy)art_academy);
    }
}