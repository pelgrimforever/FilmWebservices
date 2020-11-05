/*
 * BLview_photodatespublic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2016 12:24
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.interfaces.logicview.IView_photodatespublic;
import film.logicview.View_photodatespublic;
import film.BusinessObject.view.Bview_photodatespublic;
import film.interfaces.BusinessObject.IBLview_photodatespublic;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_photodatespublic
 *
 * Class for manipulating data- and database objects
 * for View View_photodatespublic and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_photodatespublic extends Bview_photodatespublic implements IBLview_photodatespublic {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_photodatespublic as default Entity
     */
    public BLview_photodatespublic() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_photodatespublic) throws SQLException {
        
    }
    
}
