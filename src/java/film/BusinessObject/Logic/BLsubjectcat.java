/*
 * BLsubjectcat.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import film.interfaces.logicentity.ISubjectcat;
import film.logicentity.Subjectcat;
import film.BusinessObject.table.Bsubjectcat;
import film.conversion.entity.EMsubjectcat;
import general.exception.DBException;
import general.exception.DataException;
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
public class BLsubjectcat extends Bsubjectcat {
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
    public BLsubjectcat(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Get Subjects with catno = 1
     * @return ArrayList with Subjectcats
     * @throws DBException
     */
    public ArrayList getSubjectcats1() throws DBException {
        Object[][] parameter = { { "catno", 1 } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMsubjectcat.SQLSelectCatno, parameters);
    }

    /**
     * Get Subjects with catno = 1
     * @return ArrayList with Subjectcats
     * @throws DBException
     */
    public ArrayList getSubjectcats2() throws DBException {
        Object[][] parameter = { { "catno", 2 } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMsubjectcat.SQLSelectCatno, parameters);
    }

    /**
     * try to insert Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_insertSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to insert Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_insertSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to update Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_updateSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to update Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        trans_updateSubjectcat(subjectcat);
        super.Commit2DB();
    }
    
    /**
     * try to delete Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        trans_deleteSubjectcat(subjectcat);
        super.Commit2DB();
    }

    /**
     * try to delete Subjectcat object in database
     * commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        trans_deleteSubjectcat(subjectcat);
        super.Commit2DB();
    }

    /**
     * try to insert Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.checkDATA(subjectcat);
        super.insertSubjectcat((Subjectcat)subjectcat);
    }
    
    /**
     * try to update Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.checkDATA(subjectcat);
        super.updateSubjectcat((Subjectcat)subjectcat);
    }
    
    /**
     * try to delete Subjectcat object in database
     * do not commit transaction
     * @param subjectcat: Subjectcat Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        super.deleteSubjectcat((Subjectcat)subjectcat);
    }
}
