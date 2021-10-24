/*
 * BLview_photodates.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2016 12:24
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.BusinessObject.view.Bview_photodates;
import film.conversion.entity.EMview_photodates;
import film.conversion.entity.EMview_photodatespublic;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_photodates
 *
 * Class for manipulating data- and database objects
 * for View View_photodates and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_photodates extends Bview_photodates {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_photodates as default Entity
     */
    public BLview_photodates() {
    }

    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    @Override
    public ArrayList getView_photodatess() throws DBException {
        return this.getEntities(EMview_photodatespublic.SQLSelectAll);
    }
    
    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    public ArrayList getView_photodatess(boolean loggedin) throws DBException {
        if(loggedin) {
            return this.getEntities(EMview_photodates.SQLSelectAll);
        } else {
            return this.getView_photodatess();
        }
    }
    
}
