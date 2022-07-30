/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2016 12:24
 */

package film.BusinessObject.Logic;

import db.SQLreader;
import general.exception.DBException;
import film.BusinessObject.view.Bview_photodates;
import film.conversion.entity.EMview_photodates;
import film.conversion.entity.EMview_photodatespublic;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_photodates extends Bview_photodates {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_photodates(SQLreader sqlreader) {
        super(sqlreader);
    }

    @Override
    public ArrayList getView_photodatess() throws DBException {
        return viewio.getEntities(EMview_photodatespublic.SQLSelectAll);
    }
    
    public ArrayList getView_photodatess(boolean loggedin) throws DBException {
        if(loggedin)
            return viewio.getEntities(EMview_photodates.SQLSelectAll);
        else
            return getView_photodatess();
    }
    
}
