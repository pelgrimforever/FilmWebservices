/*
 * BLart_photo.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import BusinessObject.GeneralObject;
import data.interfaces.db.LogicEntity;
import film.BusinessObject.table.Bart_photo;
import film.interfaces.logicentity.IArt_photo;
import film.logicentity.Art_photo;
import film.interfaces.BusinessObject.IBLart_photo;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLart_photo
 *
 * Class for manipulating data- and database objects
 * for Entity Art_photo and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLart_photo extends Bart_photo implements IBLart_photo {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Art_photo as default Entity
     */
    public BLart_photo() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Art_photo as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLart_photo(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity art_photo) throws SQLException {
        
    }
    
    /**
     * try to insert Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        trans_insertArt_photo(art_photo);
        super.Commit2DB();
    }
    
    /**
     * try to insert Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        trans_insertArt_photo(art_photo);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        trans_updateArt_photo(art_photo);
        super.Commit2DB();
    }
    
    /**
     * try to update Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        trans_updateArt_photo(art_photo);
        super.Commit2DB();
    }
    
    /**
     * try to delete Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteArt_photo(IArt_photo art_photo) throws DBException {
        trans_deleteArt_photo(art_photo);
        super.Commit2DB();
    }

    /**
     * try to delete Art_photo object in database
     * commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteArt_photo(IArt_photo art_photo) throws DBException {
        trans_deleteArt_photo(art_photo);
        super.Commit2DB();
    }

    /**
     * try to insert Art_photo object in database
     * do not commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        super.checkDATA(art_photo);
        super.insertArt_photo((Art_photo)art_photo);
    }
    
    /**
     * try to update Art_photo object in database
     * do not commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        super.checkDATA(art_photo);
        super.updateArt_photo((Art_photo)art_photo);
    }
    
    /**
     * try to delete Art_photo object in database
     * do not commit transaction
     * @param art_photo: Art_photo Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteArt_photo(IArt_photo art_photo) throws DBException {
        super.deleteArt_photo((Art_photo)art_photo);
    }
}