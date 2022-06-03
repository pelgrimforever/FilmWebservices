/*
 * BLphotosubjects.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IPhotosubjects;
import film.logicentity.Photosubjects;
import film.BusinessObject.table.Bphotosubjects;
import film.entity.pk.PhotosubjectsPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ISubject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLphotosubjects
 *
 * Class for manipulating data- and database objects
 * for Entity Photosubjects and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLphotosubjects extends Bphotosubjects {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Photosubjects as default Entity
     */
    public BLphotosubjects() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Photosubjects as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLphotosubjects(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Replace subjects for photo with new subjects
     * @param senderobject
     * @param photoPK: Photo primary key
     * @param subjects: Subject objects
     * @throws general.exception.DataException
     * @throws DBException
     */
    public void linkPhoto_with_Subjects(String senderobject, IPhotoPK photoPK, ArrayList subjects) throws DataException, DBException {
        delete4photo(photoPK);
        ISubject subject;
        Photosubjects photosubject;
        PhotosubjectsPK photosubjectPK;
        for(int i=0; i<subjects.size(); i++) {
            subject = (ISubject)subjects.get(i);
            photosubjectPK = new PhotosubjectsPK();
            photosubjectPK.setPhotoPK(photoPK);
            photosubjectPK.setSubjectPK(subject.getPrimaryKey());
            photosubject = new Photosubjects(photosubjectPK);
            this.insertPhotosubjects(photosubject);
        }
    }

    /**
     * try to insert Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        trans_insertPhotosubjects(photosubjects);
        super.Commit2DB();
    }
    
    /**
     * try to insert Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        trans_insertPhotosubjects(photosubjects);
        super.Commit2DB();
    }
    
    /**
     * try to update Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        trans_updatePhotosubjects(photosubjects);
        super.Commit2DB();
    }
    
    /**
     * try to update Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        trans_updatePhotosubjects(photosubjects);
        super.Commit2DB();
    }
    
    /**
     * try to delete Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deletePhotosubjects(IPhotosubjects photosubjects) throws DBException {
        trans_deletePhotosubjects(photosubjects);
        super.Commit2DB();
    }

    /**
     * try to delete Photosubjects object in database
     * commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     */
    public void securedeletePhotosubjects(IPhotosubjects photosubjects) throws DBException {
        trans_deletePhotosubjects(photosubjects);
        super.Commit2DB();
    }

    /**
     * try to insert Photosubjects object in database
     * do not commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertPhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        super.checkDATA(photosubjects);
        super.insertPhotosubjects((Photosubjects)photosubjects);
    }
    
    /**
     * try to update Photosubjects object in database
     * do not commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updatePhotosubjects(IPhotosubjects photosubjects) throws DBException, DataException {
        super.checkDATA(photosubjects);
        super.updatePhotosubjects((Photosubjects)photosubjects);
    }
    
    /**
     * try to delete Photosubjects object in database
     * do not commit transaction
     * @param photosubjects: Photosubjects Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deletePhotosubjects(IPhotosubjects photosubjects) throws DBException {
        super.deletePhotosubjects((Photosubjects)photosubjects);
    }
}
