/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
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
 * @author Franky Laseure
 */
public class BLfilmsubjects extends Bfilmsubjects {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLfilmsubjects(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLfilmsubjects(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void linkFilm_with_Subjects(SQLTqueue transactionqueue, IFilmPK filmPK, ArrayList subjects) throws DataException, DBException {
        delete4film(transactionqueue, filmPK);
        ISubject subject;
        Filmsubjects filmsubject;
        FilmsubjectsPK filmsubjectPK;
        for(int i=0; i<subjects.size(); i++) {
            subject = (ISubject)subjects.get(i);
            filmsubjectPK = new FilmsubjectsPK();
            filmsubjectPK.setFilmPK(filmPK);
            filmsubjectPK.setSubjectPK(subject.getPrimaryKey());
            filmsubject = new Filmsubjects(filmsubjectPK);
            insertFilmsubjects(transactionqueue, filmsubject);
        }
    }
}
