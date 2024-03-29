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
import film.interfaces.logicentity.IUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.BusinessObject.table.Buploadsessionsettings;
import film.conversion.entity.EMuploadsession;
import film.conversion.entity.EMuploadsessionsettings;
import film.logicentity.Uploadsession;
import general.exception.DBException;
import general.exception.DataException;

public class BLuploadsessionsettings extends Buploadsessionsettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLuploadsessionsettings(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLuploadsessionsettings(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void insertUploadsessionsettings(
            SQLTqueue transactionqueue, 
            String senderobject, 
            IUploadsessionsettings uploadsessionsettings) 
            throws DBException, DataException {
        boolean uploadsessionsetttings_in_database = getUploadsessionsettings(uploadsessionsettings.getPrimaryKey())==null;
        if(uploadsessionsetttings_in_database)
            replaceUploadsession(transactionqueue, uploadsessionsettings);
        else
            updateUploadsessionsettings(transactionqueue, uploadsessionsettings);
    }

    private void replaceUploadsession(SQLTqueue transactionqueue, IUploadsessionsettings uploadsessionsettings) throws DataException, DBException {
        addStatement(transactionqueue, EMuploadsession.SQLdeleteall);
        addStatement(transactionqueue, EMuploadsessionsettings.SQLdeleteall);
        uploadsessionsettings.setUploadingposition(-1);
        insertUploadsessionsettings(transactionqueue, uploadsessionsettings);
    }
    
    public void deleteall(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMuploadsession.SQLdeleteall);
        addStatement(transactionqueue, EMuploadsessionsettings.SQLdeleteall);
    }
    
}
