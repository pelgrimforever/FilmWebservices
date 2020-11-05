/*
 * BLgeometry_columns.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.2.2013 17:43
 *
 */

package film.BusinessObject.Logic;

import data.interfaces.db.View;
import film.BusinessObject.view.Bgeometry_columns;
import film.interfaces.BusinessObject.IBLgeometry_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLgeometry_columns
 *
 * Class for manipulating data- and database objects
 * for View Geometry_columns and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLgeometry_columns extends Bgeometry_columns implements IBLgeometry_columns {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets Geometry_columns as default Entity
     */
    public BLgeometry_columns() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View geometry_columns) throws SQLException {
        
    }
    
}
