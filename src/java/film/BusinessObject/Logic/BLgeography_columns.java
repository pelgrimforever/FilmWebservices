/*
 * BLgeography_columns.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.2.2013 17:43
 *
 */

package film.BusinessObject.Logic;

import data.interfaces.db.View;
import film.BusinessObject.view.Bgeography_columns;
import film.interfaces.BusinessObject.IBLgeography_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLgeography_columns
 *
 * Class for manipulating data- and database objects
 * for View Geography_columns and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLgeography_columns extends Bgeography_columns implements IBLgeography_columns {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets Geography_columns as default Entity
     */
    public BLgeography_columns() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View geography_columns) throws SQLException {
        
    }
    
}
