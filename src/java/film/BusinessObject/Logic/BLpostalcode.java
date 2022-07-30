/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 12:3
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IPostalcode;
import film.logicentity.Postalcode;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Bpostalcode;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLpostalcode extends Bpostalcode {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLpostalcode(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLpostalcode(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void insertcheckPostalcode(SQLTqueue transactionqueue, IPostalcode postalcode) throws DBException, DataException {
        if(this.getPostalcode(postalcode.getPrimaryKey())==null)
            insertPostalcode(transactionqueue, postalcode);
    }    
}
