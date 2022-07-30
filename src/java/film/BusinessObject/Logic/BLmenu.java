/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IMenu;
import film.logicentity.Menu;
import film.BusinessObject.table.Bmenu;
import general.exception.DBException;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLmenu extends Bmenu {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLmenu(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLmenu(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
