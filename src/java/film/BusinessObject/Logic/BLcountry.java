/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2013 11:31
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ICountry;
import film.logicentity.Country;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Bcountry;
import general.exception.DataException;

public class BLcountry extends Bcountry {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLcountry(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLcountry(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
