/*
 * BLsubject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.GeneralEntityObject;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ISubject;
import film.logicentity.Subject;
import film.BusinessObject.table.Bsubject;
import film.entity.pk.SubjectPK;
import film.interfaces.BusinessObject.IBLsubject;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.entity.pk.ISubjectcatPK;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsubject
 *
 * Class for manipulating data- and database objects
 * for Entity Subject and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsubject extends Bsubject implements IBLsubject {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Subject as default Entity
     */
    public BLsubject() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Subject as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsubject(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity subject) throws SQLException {
        
    }
    
    /**
     * Get Subjects for subjectcat1PK, subjectcat2PK
     * @param subjectcat1PK: Subjectcat Primary Key
     * @param subjectcat2PK: Subjectcat Primary Key
     * @return ArrayList with Subjects
     * @throws DBException
     */
    public ArrayList getSubjects(ISubjectcatPK subjectcat1PK, ISubjectcatPK subjectcat2PK) throws DBException {
        Object[][] parameter = { { "cat1", subjectcat1PK.getCat() }, { "cat2", subjectcat2PK.getCat() } };
        return getMapper().loadEntityVector(this, Subject.SQLSelect4cat1cat2, parameter);
    }

    public ArrayList getSubjects(ArrayList subjectpks) throws DBException {
        ArrayList subjects = new ArrayList();
        for(int i=0; i<subjectpks.size(); i++) {
            subjects.add(getSubject((SubjectPK)subjectpks.get(i)));
        }
        return subjects;
    }

    /**
     * Get Subjects for photoPK
     * @param photoPK: Photo Primary Key
     * @return ArrayList with Subjects linked by photo in photosubjects
     * @throws DBException
     */
    public ArrayList getSubjects(IPhotoPK photoPK) throws DBException {
        return getMapper().loadEntityVector(this, Subject.SQLSelect4photo, photoPK.getKeyFields());
    }

    /**
     * Get Subjects for photoPK
     * @param photoPK: Photo Primary Key
     * @return ArrayList with Subjects linked by photo in filmsubjects
     * @throws DBException
     */
    public ArrayList getSubjects(IFilmPK filmPK) throws DBException {
        return getMapper().loadEntityVector(this, Subject.SQLSelect4film, filmPK.getKeyFields());
    }

    public int getMaxSubjectid() throws DBException {
        return ((Subject)getMapper().loadEntity(this, Subject.getMaxsubjectid)).getPrimaryKey().getId();
    }

    /**
     * try to insert Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertSubject(ISubject subject) throws DBException, DataException {
        subject.getPrimaryKey().setId(getMaxSubjectid() + 1);
        trans_insertSubject(subject);
        super.Commit2DB();
    }
    
    /**
     * try to insert Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertSubject(ISubject subject) throws DBException, DataException {
        subject.getPrimaryKey().setId(getMaxSubjectid() + 1);
        trans_insertSubject(subject);
        super.Commit2DB();
    }
    
    /**
     * try to update Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateSubject(ISubject subject) throws DBException, DataException {
        trans_updateSubject(subject);
        super.Commit2DB();
    }
    
    /**
     * try to update Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateSubject(ISubject subject) throws DBException, DataException {
        trans_updateSubject(subject);
        super.Commit2DB();
    }
    
    /**
     * try to delete Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteSubject(ISubject subject) throws DBException {
        trans_deleteSubject(subject);
        super.Commit2DB();
    }

    /**
     * try to delete Subject object in database
     * commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteSubject(ISubject subject) throws DBException {
        trans_deleteSubject(subject);
        super.Commit2DB();
    }

    /**
     * try to insert Subject object in database
     * do not commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertSubject(ISubject subject) throws DBException, DataException {
        super.checkDATA(subject);
        super.insertSubject((Subject)subject);
    }
    
    /**
     * try to update Subject object in database
     * do not commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateSubject(ISubject subject) throws DBException, DataException {
        super.checkDATA(subject);
        super.updateSubject((Subject)subject);
    }
    
    /**
     * try to delete Subject object in database
     * do not commit transaction
     * @param subject: Subject Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteSubject(ISubject subject) throws DBException {
        super.deleteSubject((Subject)subject);
    }
}
