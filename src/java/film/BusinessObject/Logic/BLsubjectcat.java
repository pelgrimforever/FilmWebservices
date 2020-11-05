/*
 * BLsubjectcat.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ISubjectcat;
import film.logicentity.Subjectcat;
import film.BusinessObject.table.Bsubjectcat;
import film.interfaces.BusinessObject.IBLsubjectcat;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsubjectcat
 *
 * Class for manipulating data- and database objects
 * for Entity Subjectcat and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsubjectcat extends Bsubjectcat implements IBLsubjectcat {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Subjectcat as default Entity
     */
    public BLsubjectcat() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Subjectcat as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsubjectcat(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity subjectcat) throws SQLException {
        
    }
    
    /**
     * Get Subjects with catno = 1
     * @return ArrayList with Subjectcats
     * @throws DBException
     */
    public ArrayList getSubjectcats1() throws DBException {
        Object[][] parameter = { { "catno", 1 } };
        return getMapper().loadEntityVector(this, Subjectcat.SQLSelectCatno, parameter);
    }

    /**
     * Get Subjects with catno = 1
     * @return ArrayList with Subjectcats
     * @throws DBException
     */
    public ArrayList getSubjectcats2() throws DBException {
        Object[][] parameter = { { "catno", 2 } };
        return getMapper().loadEntityVector(this, Subjectcat.SQLSelectCatno, parameter);
    }

    /**
     * try to insert Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_insertSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to insert Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_insertSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to update Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_updateSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to update Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_updateSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to delete Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        trans_deleteSubjectcat(subjectcat);
        super.Commit2DB();
    }

    /**
     * try to delete Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        trans_deleteSubjectcat(subjectcat);
        super.Commit2DB();
    }

    /**
     * try to insert Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.checkDATA(subjectcat);
        super.insertSubjectcat((Subjectcat)subjectcat);
    }
    
    /**
     * try to update Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.checkDATA(subjectcat);
        super.updateSubjectcat((Subjectcat)subjectcat);
    }
    
    /**
     * try to delete Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        super.deleteSubjectcat((Subjectcat)subjectcat);
    }
}
