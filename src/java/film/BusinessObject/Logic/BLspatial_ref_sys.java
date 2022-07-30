/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 18:50
 */

package film.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
import film.BusinessObject.table.Bspatial_ref_sys;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class BLspatial_ref_sys extends Bspatial_ref_sys {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLspatial_ref_sys(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLspatial_ref_sys(TableBusinessrules businessrules) {
        super(businessrules);
        setLogginrequired(isprivatetable);
        setAuthenticated(businessrules.isAuthenticated());
    }

}
