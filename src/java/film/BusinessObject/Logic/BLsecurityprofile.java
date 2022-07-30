/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.ISecurityprofile;
import film.logicentity.Securityprofile;
import film.BusinessObject.table.Bsecurityprofile;
import film.conversion.entity.EMsecurityprofile;
import film.entity.pk.SecurityprofilePK;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLsecurityprofile extends Bsecurityprofile {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLsecurityprofile(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLsecurityprofile(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getSecurityprofiles(String securityprofile) throws DBException {
        return this.getEntities(EMsecurityprofile.SQLSelect1, new SecurityprofilePK(securityprofile).getSQLprimarykey());
    }

    public ArrayList getSecurityprofiles_for_user(String username) throws DBException {
        Object[][] parameters = { { "siteusername", username } };
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return this.getEntities(EMsecurityprofile.SQLSelectUsername, sqlparameters);
    }    
}
