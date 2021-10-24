/*
 * BLview_locality_photolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.3.2016 11:1
 *
 */

package film.BusinessObject.Logic;

import db.SQLparameters;
import film.BusinessObject.view.Bview_locality_photolocations;
import film.conversion.entity.EMview_locality_photolocations;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_locality_photolocations
 *
 * Class for manipulating data- and database objects
 * for View View_locality_photolocations and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_locality_photolocations extends Bview_locality_photolocations {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_locality_photolocations as default Entity
     */
    public BLview_locality_photolocations() {
    }

    public ArrayList get4Location(String countrycode, String locality) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMview_locality_photolocations.SQLSelect4location, parameters);
    }
}
