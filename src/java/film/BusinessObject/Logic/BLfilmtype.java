/*
 * BLfilmtype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.IFilmtype;
import film.logicentity.Filmtype;
import film.BusinessObject.table.Bfilmtype;
import film.interfaces.BusinessObject.IBLfilmtype;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLfilmtype
 *
 * Class for manipulating data- and database objects
 * for Entity Filmtype and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLfilmtype extends Bfilmtype implements IBLfilmtype {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Filmtype as default Entity
     */
    public BLfilmtype() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Filmtype as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLfilmtype(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity filmtype) throws SQLException {
        
    }
    
    /**
     * try to insert Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        trans_insertFilmtype(filmtype);
        super.Commit2DB();
    }
    
    /**
     * try to insert Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        trans_insertFilmtype(filmtype);
        super.Commit2DB();
    }
    
    /**
     * try to update Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        trans_updateFilmtype(filmtype);
        super.Commit2DB();
    }
    
    /**
     * try to update Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        trans_updateFilmtype(filmtype);
        super.Commit2DB();
    }
    
    /**
     * try to delete Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteFilmtype(IFilmtype filmtype) throws DBException {
        trans_deleteFilmtype(filmtype);
        super.Commit2DB();
    }

    /**
     * try to delete Filmtype object in database
     * commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteFilmtype(IFilmtype filmtype) throws DBException {
        trans_deleteFilmtype(filmtype);
        super.Commit2DB();
    }

    /**
     * try to insert Filmtype object in database
     * do not commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        super.checkDATA(filmtype);
        super.insertFilmtype((Filmtype)filmtype);
    }
    
    /**
     * try to update Filmtype object in database
     * do not commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        super.checkDATA(filmtype);
        super.updateFilmtype((Filmtype)filmtype);
    }
    
    /**
     * try to delete Filmtype object in database
     * do not commit transaction
     * @param filmtype: Filmtype Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteFilmtype(IFilmtype filmtype) throws DBException {
        super.deleteFilmtype((Filmtype)filmtype);
    }
}