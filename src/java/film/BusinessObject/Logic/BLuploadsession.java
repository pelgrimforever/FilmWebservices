/*
 * BLuploadsession.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IUploadsession;
import film.logicentity.Uploadsession;
import film.BusinessObject.table.Buploadsession;
import film.conversion.entity.EMuploadsession;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLuploadsession
 *
 * Class for manipulating data- and database objects
 * for Entity Uploadsession and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLuploadsession extends Buploadsession {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Uploadsession as default Entity
     */
    public BLuploadsession() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Uploadsession as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLuploadsession(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * get all Uploadsession objects from database
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    @Override
    public ArrayList getUploadsessions() throws DBException {
        return this.getEntities(EMuploadsession.SQLSelectAllsorded);
    }

    public void insertCompletesession(ArrayList uploadsessions) throws DBException, DataException {
        //if Uploadsession table is empty, insert records
        //else only update
        String sql = "select count(distinct tablecount.*) as count from uploadsession as tablecount";
        long count = this.count(sql, null);
        if(count==0) {
            Uploadsession uploadsession;
            for(int i=0; i<uploadsessions.size(); i++) {
                uploadsession = (Uploadsession)uploadsessions.get(i);
                //allways force update of filmgroupid
                uploadsession.setFilmgroupid(uploadsession.getFilmgroupid());
                trans_insertUploadsession(uploadsession);
            }
            super.Commit2DB();
        } else {
            //Delete all lines first
            Uploadsession uploadsession;
            for(int i=0; i<uploadsessions.size(); i++) {
                uploadsession = (Uploadsession)uploadsessions.get(i);
                //allways force update of filmgroupid
                uploadsession.setFilmgroupid(uploadsession.getFilmgroupid());
                trans_updateUploadsession(uploadsession);
            }
            super.Commit2DB();
        }
    }

    /**
     * try to insert Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_insertUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to insert Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_insertUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_updateUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_updateUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to delete Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteUploadsession(IUploadsession uploadsession) throws DBException {
        trans_deleteUploadsession(uploadsession);
        super.Commit2DB();
    }

    /**
     * try to delete Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteUploadsession(IUploadsession uploadsession) throws DBException {
        trans_deleteUploadsession(uploadsession);
        super.Commit2DB();
    }

    /**
     * try to insert Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.checkDATA(uploadsession);
        super.insertUploadsession((Uploadsession)uploadsession);
    }
    
    /**
     * try to update Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.checkDATA(uploadsession);
        super.updateUploadsession((Uploadsession)uploadsession);
    }
    
    /**
     * try to delete Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteUploadsession(IUploadsession uploadsession) throws DBException {
        super.deleteUploadsession((Uploadsession)uploadsession);
    }
}
