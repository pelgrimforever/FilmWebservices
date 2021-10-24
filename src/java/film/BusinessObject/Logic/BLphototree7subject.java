/*
 * BLphototree7subject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IPhototree7subject;
import film.logicentity.Phototree7subject;
import film.BusinessObject.table.Bphototree7subject;
import film.entity.pk.Phototree7subjectPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ITree7subject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLphototree7subject
 *
 * Class for manipulating data- and database objects
 * for Entity Phototree7subject and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLphototree7subject extends Bphototree7subject {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Phototree7subject as default Entity
     */
    public BLphototree7subject() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Phototree7subject as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLphototree7subject(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Replace linked tree7subjects for photoPK
     * @param senderobject
     * @param photoPK: Photo primary key
     * @param tree7subjects: ArrayList of Tree7subjects
     * @throws general.exception.DataException
     * @throws DBException
     */
    public void linkPhoto_with_Subjects(String senderobject, IPhotoPK photoPK, ArrayList tree7subjects) throws DataException, DBException {
        delete4photo(photoPK);
        ITree7subject tree7subject;
        Phototree7subject phototree7subject;
        Phototree7subjectPK phototree7subjectPK;
        for(int i=0; i<tree7subjects.size(); i++) {
            tree7subject = (ITree7subject)tree7subjects.get(i);
            phototree7subjectPK = new Phototree7subjectPK();
            phototree7subjectPK.setPhotoPK(photoPK);
            phototree7subjectPK.setTree7subjectPK(tree7subject.getPrimaryKey());
            phototree7subject = new Phototree7subject(phototree7subjectPK);
            this.insertPhototree7subject(phototree7subject);
        }
    }

    /**
     * try to insert Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        trans_insertPhototree7subject(phototree7subject);
        super.Commit2DB();
    }
    
    /**
     * try to insert Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        trans_insertPhototree7subject(phototree7subject);
        super.Commit2DB();
    }
    
    /**
     * try to update Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        trans_updatePhototree7subject(phototree7subject);
        super.Commit2DB();
    }
    
    /**
     * try to update Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        trans_updatePhototree7subject(phototree7subject);
        super.Commit2DB();
    }
    
    /**
     * try to delete Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deletePhototree7subject(IPhototree7subject phototree7subject) throws DBException {
        trans_deletePhototree7subject(phototree7subject);
        super.Commit2DB();
    }

    /**
     * try to delete Phototree7subject object in database
     * commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     */
    public void securedeletePhototree7subject(IPhototree7subject phototree7subject) throws DBException {
        trans_deletePhototree7subject(phototree7subject);
        super.Commit2DB();
    }

    /**
     * try to insert Phototree7subject object in database
     * do not commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        super.checkDATA(phototree7subject);
        super.insertPhototree7subject((Phototree7subject)phototree7subject);
    }
    
    /**
     * try to update Phototree7subject object in database
     * do not commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        super.checkDATA(phototree7subject);
        super.updatePhototree7subject((Phototree7subject)phototree7subject);
    }
    
    /**
     * try to delete Phototree7subject object in database
     * do not commit transaction
     * @param phototree7subject: Phototree7subject Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deletePhototree7subject(IPhototree7subject phototree7subject) throws DBException {
        super.deletePhototree7subject((Phototree7subject)phototree7subject);
    }
}
