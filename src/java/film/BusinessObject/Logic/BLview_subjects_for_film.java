/*
 * BLview_subjects_for_film.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.11.2012 13:49
 *
 */

package film.BusinessObject.Logic;

import data.interfaces.db.View;
import film.BusinessObject.view.Bview_subjects_for_film;
import film.interfaces.BusinessObject.IBLview_subjects_for_film;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_subjects_for_film
 *
 * Class for manipulating data- and database objects
 * for View View_subjects_for_film and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_subjects_for_film extends Bview_subjects_for_film implements IBLview_subjects_for_film {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_subjects_for_film as default Entity
     */
    public BLview_subjects_for_film() {
    }
    
    @Override
    public void loadExtra(ResultSet dbresult, View view_subjects_for_film) throws SQLException {
        
    }
    
}
