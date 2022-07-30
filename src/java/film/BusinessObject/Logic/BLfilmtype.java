/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IFilmtype;
import film.logicentity.Filmtype;
import film.BusinessObject.table.Bfilmtype;
import general.exception.DBException;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLfilmtype extends Bfilmtype {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLfilmtype(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLfilmtype(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
