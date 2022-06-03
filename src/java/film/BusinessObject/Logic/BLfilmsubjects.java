/*
 * BLfilmsubjects.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import film.interfaces.logicentity.IFilmsubjects;
import film.logicentity.Filmsubjects;
import film.BusinessObject.table.Bfilmsubjects;
import film.entity.pk.FilmsubjectsPK;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.logicentity.ISubject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLfilmsubjects
 *
 * Class for manipulating data- and database objects
 * for Entity Filmsubjects and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLfilmsubjects extends Bfilmsubjects {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Filmsubjects as default Entity
     */
    public BLfilmsubjects() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Filmsubjects as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLfilmsubjects(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Filmsubjects object in database
     * commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        trans_insertFilmsubjects(filmsubjects);
        super.Commit2DB();
    }
    
    /**
     * try to insert Filmsubjects object in database commit transaction
     *
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        trans_insertFilmsubjects(filmsubjects);
        super.Commit2DB();
    }

    /**
     * try to update Filmsubjects object in database
     * commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        trans_updateFilmsubjects(filmsubjects);
        super.Commit2DB();
    }
    
    /**
     * try to update Filmsubjects object in database
     * commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        trans_updateFilmsubjects(filmsubjects);
        super.Commit2DB();
    }
    
    /**
     * Replace subjects for film with new subjects
     * @param filmPK: Film primary key
     * @param subjects: Subject objects
     * @throws general.exception.DataException
     * @throws DBException
     */
    public void linkFilm_with_Subjects(IFilmPK filmPK, ArrayList subjects) throws DataException, DBException {
        delete4film(filmPK);
        ISubject subject;
        Filmsubjects filmsubject;
        FilmsubjectsPK filmsubjectPK;
        for(int i=0; i<subjects.size(); i++) {
            subject = (ISubject)subjects.get(i);
            filmsubjectPK = new FilmsubjectsPK();
            filmsubjectPK.setFilmPK(filmPK);
            filmsubjectPK.setSubjectPK(subject.getPrimaryKey());
            filmsubject = new Filmsubjects(filmsubjectPK);
            this.insertFilmsubjects(filmsubject);
        }
    }

    /**
     * try to delete Filmsubjects object in database
     * commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException {
        trans_deleteFilmsubjects(filmsubjects);
        super.Commit2DB();
    }

    /**
     * try to delete Filmsubjects object in database
     * commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException {
        trans_deleteFilmsubjects(filmsubjects);
        super.Commit2DB();
    }

    /**
     * try to insert Filmsubjects object in database
     * do not commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        super.checkDATA(filmsubjects);
        super.insertFilmsubjects((Filmsubjects)filmsubjects);
    }
    
    /**
     * try to update Filmsubjects object in database
     * do not commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateFilmsubjects(IFilmsubjects filmsubjects) throws DBException, DataException {
        super.checkDATA(filmsubjects);
        super.updateFilmsubjects((Filmsubjects)filmsubjects);
    }
    
    /**
     * try to delete Filmsubjects object in database
     * do not commit transaction
     * @param filmsubjects: Filmsubjects Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteFilmsubjects(IFilmsubjects filmsubjects) throws DBException {
        super.deleteFilmsubjects((Filmsubjects)filmsubjects);
    }
}
