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
import film.interfaces.logicentity.IPhotosubjects;
import film.logicentity.Photosubjects;
import film.BusinessObject.table.Bphotosubjects;
import film.entity.pk.PhotosubjectsPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ISubject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

public class BLphotosubjects extends Bphotosubjects {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLphotosubjects(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLphotosubjects(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void linkPhoto_with_Subjects(SQLTqueue transactionqueue, String senderobject, IPhotoPK photoPK, ArrayList<ISubject> subjects) throws DataException, DBException {
        delete4photo(transactionqueue, photoPK);
        Photosubjects photosubject;
        PhotosubjectsPK photosubjectPK;
        for(ISubject subject: subjects) {
            photosubjectPK = new PhotosubjectsPK();
            photosubjectPK.setPhotoPK(photoPK);
            photosubjectPK.setSubjectPK(subject.getPrimaryKey());
            photosubject = new Photosubjects(photosubjectPK);
            insertPhotosubjects(transactionqueue, photosubject);
        }
    }
}
