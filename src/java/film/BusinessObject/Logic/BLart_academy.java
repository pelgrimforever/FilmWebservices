/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IArt_academy;
import film.logicentity.Art_academy;
import film.BusinessObject.table.Bart_academy;
import general.exception.DBException;
import general.exception.DataException;

public class BLart_academy extends Bart_academy {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLart_academy(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLart_academy(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
