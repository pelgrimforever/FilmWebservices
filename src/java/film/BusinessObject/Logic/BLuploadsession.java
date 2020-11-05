/*
 * BLuploadsession.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLRecordcount;
import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import data.interfaces.db.Recordcount;
import db.AbstractSQLMapper;
import db.ViewMapper;
import film.interfaces.logicentity.IUploadsession;
import film.logicentity.Uploadsession;
import film.BusinessObject.table.Buploadsession;
import film.interfaces.BusinessObject.IBLuploadsession;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BLuploadsession extends Buploadsession implements IBLuploadsession {
//ProjectGenerator: NO AUTHOMATIC UPDATE
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
    public BLuploadsession(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity uploadsession) throws SQLException {
        
    }
    
    /**
     * get all Uploadsession objects from database
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    public ArrayList getUploadsessions() throws DBException {
            return getMapper().loadEntityVector(this, Uploadsession.SQLSelectAllsorded);
    }

    public void insertCompletesession(ArrayList uploadsessions) throws DBException, DataException {
        //if Uploadsession table is empty, insert records
        //else only update
        AbstractSQLMapper sqlmapper = entitymapper.resetSQLMapper("");
        BLRecordcount blrecordcount = new BLRecordcount(sqlmapper);
        String sql = "select count(distinct tablecount.*) as count from uploadsession as tablecount";
        ViewMapper viewmapper = new ViewMapper(sqlmapper);
        Recordcount recordcount = (Recordcount)viewmapper.loadView(blrecordcount, sql, null);
        long count = recordcount.getCount();
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
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_insertUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to insert Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_insertUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_updateUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to update Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        trans_updateUploadsession(uploadsession);
        super.Commit2DB();
    }
    
    /**
     * try to delete Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteUploadsession(IUploadsession uploadsession) throws DBException {
        trans_deleteUploadsession(uploadsession);
        super.Commit2DB();
    }

    /**
     * try to delete Uploadsession object in database
     * commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteUploadsession(IUploadsession uploadsession) throws DBException {
        trans_deleteUploadsession(uploadsession);
        super.Commit2DB();
    }

    /**
     * try to insert Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.checkDATA(uploadsession);
        super.insertUploadsession((Uploadsession)uploadsession);
    }
    
    /**
     * try to update Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        super.checkDATA(uploadsession);
        super.updateUploadsession((Uploadsession)uploadsession);
    }
    
    /**
     * try to delete Uploadsession object in database
     * do not commit transaction
     * @param uploadsession: Uploadsession Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteUploadsession(IUploadsession uploadsession) throws DBException {
        super.deleteUploadsession((Uploadsession)uploadsession);
    }
}
