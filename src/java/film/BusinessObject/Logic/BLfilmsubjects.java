/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
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

    public void linkFilm_with_Subjects(SQLTqueue transactionqueue, IFilmPK filmPK, ArrayList<ISubject> subjects) throws DataException, DBException {
        delete4film(transactionqueue, filmPK);
        for(ISubject subject: subjects)
            linkFilm_with_Subject(filmPK, subject, transactionqueue);
    }

    private void linkFilm_with_Subject(IFilmPK filmPK, ISubject subject, SQLTqueue transactionqueue) throws DBException, DataException {
        FilmsubjectsPK filmsubjectPK = new FilmsubjectsPK();
        filmsubjectPK.setFilmPK(filmPK);
        filmsubjectPK.setSubjectPK(subject.getPrimaryKey());
        Filmsubjects filmsubject = new Filmsubjects(filmsubjectPK);
        insertFilmsubjects(transactionqueue, filmsubject);
    }
}
