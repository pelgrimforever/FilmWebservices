/*
 * BLview_publiclocalityphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.4.2016 16:29
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_publiclocalityphotocount;
import film.logicview.View_publiclocalityphotocount;
import film.BusinessObject.view.Bview_publiclocalityphotocount;
import film.interfaces.BusinessObject.IBLview_publiclocalityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_publiclocalityphotocount
 *
 * Class for manipulating data- and database objects
 * for View View_publiclocalityphotocount and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_publiclocalityphotocount extends Bview_publiclocalityphotocount implements IBLview_publiclocalityphotocount {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_publiclocalityphotocount as default Entity
     */
    public BLview_publiclocalityphotocount() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_publiclocalityphotocount) throws SQLException {
        
    }
    
}
