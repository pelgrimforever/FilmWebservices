/*
 * BLview_photo_firstlastdate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.9.2014 12:52
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_photo_firstlastdate;
import film.logicview.View_photo_firstlastdate;
import film.BusinessObject.view.Bview_photo_firstlastdate;
import film.interfaces.BusinessObject.IBLview_photo_firstlastdate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_photo_firstlastdate
 *
 * Class for manipulating data- and database objects
 * for View View_photo_firstlastdate and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_photo_firstlastdate extends Bview_photo_firstlastdate implements IBLview_photo_firstlastdate {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_photo_firstlastdate as default Entity
     */
    public BLview_photo_firstlastdate() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_photo_firstlastdate) throws SQLException {
        
    }
    
}
