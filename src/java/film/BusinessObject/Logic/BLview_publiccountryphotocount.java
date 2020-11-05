/*
 * BLview_publiccountryphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.4.2016 15:31
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_publiccountryphotocount;
import film.logicview.View_publiccountryphotocount;
import film.BusinessObject.view.Bview_publiccountryphotocount;
import film.interfaces.BusinessObject.IBLview_publiccountryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_publiccountryphotocount
 *
 * Class for manipulating data- and database objects
 * for View View_publiccountryphotocount and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_publiccountryphotocount extends Bview_publiccountryphotocount implements IBLview_publiccountryphotocount {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_publiccountryphotocount as default Entity
     */
    public BLview_publiccountryphotocount() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_publiccountryphotocount) throws SQLException {
        
    }
    
}
