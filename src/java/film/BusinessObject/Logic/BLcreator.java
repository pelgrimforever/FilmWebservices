/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.10.2015 16:22
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ICreator;
import film.logicentity.Creator;
import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Bcreator;
import general.exception.DataException;

public class BLcreator extends Bcreator {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLcreator(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLcreator(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
