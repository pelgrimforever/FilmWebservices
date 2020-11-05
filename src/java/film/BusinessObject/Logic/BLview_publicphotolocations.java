/*
 * BLview_publicphotolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.8.2014 16:3
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_publicphotolocations;
import film.logicview.View_publicphotolocations;
import film.BusinessObject.view.Bview_publicphotolocations;
import film.interfaces.BusinessObject.IBLview_publicphotolocations;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_publicphotolocations
 *
 * Class for manipulating data- and database objects
 * for View View_publicphotolocations and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_publicphotolocations extends Bview_publicphotolocations implements IBLview_publicphotolocations {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_publicphotolocations as default Entity
     */
    public BLview_publicphotolocations() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_publicphotolocations) throws SQLException {
        
    }
    
}
