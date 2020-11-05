/*
 * BLview_locationtree.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.5.2016 15:57
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_locationtree;
import film.logicview.View_locationtree;
import film.BusinessObject.view.Bview_locationtree;
import film.interfaces.BusinessObject.IBLview_locationtree;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_locationtree
 *
 * Class for manipulating data- and database objects
 * for View View_locationtree and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_locationtree extends Bview_locationtree implements IBLview_locationtree {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_locationtree as default Entity
     */
    public BLview_locationtree() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_locationtree) throws SQLException {
        
    }
    
}
