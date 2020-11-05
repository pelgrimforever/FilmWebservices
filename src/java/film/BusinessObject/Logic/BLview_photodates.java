/*
 * BLview_photodates.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2016 12:24
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.BusinessObject.view.Bview_photodates;
import film.interfaces.BusinessObject.IBLview_photodates;
import film.logicview.View_photodates;
import film.logicview.View_photodatespublic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_photodates
 *
 * Class for manipulating data- and database objects
 * for View View_photodates and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_photodates extends Bview_photodates implements IBLview_photodates {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_photodates as default Entity
     */
    public BLview_photodates() {
    }

    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    @Override
    public ArrayList getView_photodatess() throws DBException {
        return getMapper().loadViewVector(this, View_photodatespublic.SQLSelectAll);
    }
    
    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    public ArrayList getView_photodatess(boolean loggedin) throws DBException {
        if(loggedin) {
            return getMapper().loadViewVector(this, View_photodates.SQLSelectAll);
        } else {
            return this.getView_photodatess();
        }
    }
    
    @Override
    public void loadExtra(ResultSet dbresult, View view_photodates) throws SQLException {
        
    }
    
}
