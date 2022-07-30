/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IArt_subgroup;
import film.logicentity.Art_subgroup;
import film.BusinessObject.table.Bart_subgroup;
import general.exception.DBException;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLart_subgroup extends Bart_subgroup {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLart_subgroup(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLart_subgroup(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
