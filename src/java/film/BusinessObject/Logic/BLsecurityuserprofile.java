/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.ISecurityuserprofile;
import film.logicentity.Securityuserprofile;
import film.BusinessObject.table.Bsecurityuserprofile;
import general.exception.DBException;
import general.exception.DataException;

public class BLsecurityuserprofile extends Bsecurityuserprofile {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLsecurityuserprofile(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLsecurityuserprofile(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
