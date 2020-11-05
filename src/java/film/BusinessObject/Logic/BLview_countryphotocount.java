/*
 * BLview_countryphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.3.2016 11:11
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.BusinessObject.view.Bview_countryphotocount;
import film.interfaces.BusinessObject.IBLview_countryphotocount;
import film.logicview.View_countryphotocount;
import film.logicview.View_publiccountryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_countryphotocount
 *
 * Class for manipulating data- and database objects
 * for View View_countryphotocount and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_countryphotocount extends Bview_countryphotocount implements IBLview_countryphotocount {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_countryphotocount as default Entity
     */
    public BLview_countryphotocount() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_countryphotocount) throws SQLException {
        
    }
    
    /**
     * get all View_publiccountryphotocount objects from database
     * Override normal getView_countryphotocounts to show only public records, no authentication is checked
     * @return ArrayList of View_countryphotocount objects
     * @throws DBException
     */
    @Override
    public ArrayList getView_countryphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_publiccountryphotocount.SQLSelectAll);
    }

    /**
     * get all View_countryphotocount objects from database
     * @return ArrayList of View_countryphotocount objects
     * @throws DBException
     */
    public ArrayList getAllView_countryphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_countryphotocount.SQLSelectAll);
    }
}
