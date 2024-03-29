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
import film.interfaces.logicentity.IPhototree7subject;
import film.logicentity.Phototree7subject;
import film.BusinessObject.table.Bphototree7subject;
import film.entity.pk.Phototree7subjectPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ITree7subject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

public class BLphototree7subject extends Bphototree7subject {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLphototree7subject(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLphototree7subject(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void linkPhoto_with_Subjects(SQLTqueue transactionqueue, IPhotoPK photoPK, ArrayList<ITree7subject> tree7subjects) throws DataException, DBException {
        delete4photo(transactionqueue, photoPK);
        Phototree7subject phototree7subject;
        Phototree7subjectPK phototree7subjectPK;
        for(ITree7subject tree7subject: tree7subjects) {
            phototree7subjectPK = new Phototree7subjectPK();
            phototree7subjectPK.setPhotoPK(photoPK);
            phototree7subjectPK.setTree7subjectPK(tree7subject.getPrimaryKey());
            phototree7subject = new Phototree7subject(phototree7subjectPK);
            insertPhototree7subject(transactionqueue, phototree7subject);
        }
    }
}
