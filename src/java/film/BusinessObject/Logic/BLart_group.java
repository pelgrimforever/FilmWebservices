/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IArt_group;
import film.logicentity.Art_group;
import film.BusinessObject.table.Bart_group;
import general.exception.DBException;
import general.exception.DataException;

public class BLart_group extends Bart_group {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLart_group(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLart_group(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
