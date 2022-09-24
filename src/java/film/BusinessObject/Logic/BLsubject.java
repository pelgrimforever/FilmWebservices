/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLparameters;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.ISubject;
import film.logicentity.Subject;
import film.BusinessObject.table.Bsubject;
import film.conversion.entity.EMsubject;
import film.entity.pk.SubjectPK;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.entity.pk.ISubjectcatPK;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

public class BLsubject extends Bsubject {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLsubject(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLsubject(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getSubjects(ISubjectcatPK subjectcat1PK, ISubjectcatPK subjectcat2PK) throws DBException {
        Object[][] parameter = { { "cat1", subjectcat1PK.getCat() }, { "cat2", subjectcat2PK.getCat() } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMsubject.SQLSelect4cat1cat2, parameters);
    }

    public ArrayList getSubjects(ArrayList subjectpks) throws DBException {
        ArrayList subjects = new ArrayList();
        for(int i=0; i<subjectpks.size(); i++) {
            subjects.add(getSubject((SubjectPK)subjectpks.get(i)));
        }
        return subjects;
    }

    public ArrayList getSubjects(IPhotoPK photoPK) throws DBException {
        return this.getEntities(EMsubject.SQLSelect4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList getSubjects(IFilmPK filmPK) throws DBException {
        return this.getEntities(EMsubject.SQLSelect4film, filmPK.getSQLprimarykey());
    }

    public int getMaxSubjectid() throws DBException {
        return ((Subject)this.getEntity(EMsubject.getMaxsubjectid)).getPrimaryKey().getId();
    }

    @Override
    public void insertSubject(SQLTqueue transactionqueue, ISubject subject) throws DBException, DataException {
        subject.getPrimaryKey().setId(getMaxSubjectid() + 1);
        super.insertSubject(transactionqueue, subject);
    }
}
