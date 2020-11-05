/*
 * BLview_locality_photolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.3.2016 11:1
 *
 */

package film.BusinessObject.Logic;

import data.interfaces.db.View;
import film.logicview.View_locality_photolocations;
import film.BusinessObject.view.Bview_locality_photolocations;
import film.interfaces.BusinessObject.IBLview_locality_photolocations;
import general.exception.DBException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BLview_locality_photolocations extends Bview_locality_photolocations implements IBLview_locality_photolocations {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_locality_photolocations as default Entity
     */
    public BLview_locality_photolocations() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_locality_photolocations) throws SQLException {
        
    }
    
    public ArrayList get4Location(String countrycode, String locality) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
        return this.getMapper().loadViewVector(this, View_locality_photolocations.SQLSelect4location, parameter);
    }
}
