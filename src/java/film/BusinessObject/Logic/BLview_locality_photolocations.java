/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.3.2016 11:1
 * @author Franky Laseure
*/

package film.BusinessObject.Logic;

import db.SQLparameters;
import db.SQLreader;
import film.BusinessObject.view.Bview_locality_photolocations;
import film.conversion.entity.EMview_locality_photolocations;
import film.logicview.View_locality_photolocations;
import general.exception.DBException;
import java.util.ArrayList;

public class BLview_locality_photolocations extends Bview_locality_photolocations {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_locality_photolocations(SQLreader sqlreader) {
        super(sqlreader);
    }

    public ArrayList<View_locality_photolocations> get4Location(String countrycode, String locality) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
        SQLparameters parameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_locality_photolocations.SQLSelect4location, parameters);
    }
}
