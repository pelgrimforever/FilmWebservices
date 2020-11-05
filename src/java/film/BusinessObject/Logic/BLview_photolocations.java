/*
 * BLview_photolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.8.2014 14:49
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import film.logicview.View_photolocations;
import film.BusinessObject.view.Bview_photolocations;
import film.interfaces.BusinessObject.IBLview_photolocations;
import film.logicview.View_publicphotolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_photolocations
 *
 * Class for manipulating data- and database objects
 * for View View_photolocations and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_photolocations extends Bview_photolocations implements IBLview_photolocations {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_photolocations as default Entity
     */
    public BLview_photolocations() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_photolocations) throws SQLException {
        
    }
    
    /**
     * get all View_photolocations objects from database
     * @return ArrayList of View_photolocations objects
     * @throws DBException
     */
    @Override
    public ArrayList getView_photolocationss() throws DBException {
        return getMapper().loadViewVector(this, View_publicphotolocations.SQLSelectAll);
    }
    
    /**
     * get all View_photolocations objects from database
     * @return ArrayList of View_photolocations objects
     * @throws DBException
     */
    public ArrayList getView_photolocationss(boolean privateaccess) throws DBException {
        if(privateaccess) {
            return getMapper().loadViewVector(this, View_photolocations.SQLSelectAll);
        } else {
            return getView_photolocationss();
        }
    }
    
    /**
     * 
     * @param privateaccess: when true, include photos with public = false
     * @param countrycode: country code
     * @param locality: locality code
     * @return ArrayList of View_photolocations objects with country code and locality
     * @throws DBException 
     */
    public ArrayList get4Locality(boolean privateaccess, String countrycode, String locality) throws DBException {
        if(privateaccess) {
            Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
            return getMapper().loadViewVector(this, View_photolocations.SQLSelect4locality, parameter);
        } else {
            Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
            return getMapper().loadViewVector(this, View_publicphotolocations.SQLSelect4locality, parameter);
        }
    }
}
