/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.8.2014 14:49
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import db.SQLreader;
import film.logicview.View_photolocations;
import film.BusinessObject.view.Bview_photolocations;
import film.conversion.entity.EMview_photolocations;
import film.conversion.entity.EMview_publicphotolocations;
import film.logicview.View_publicphotolocations;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_photolocations extends Bview_photolocations {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_photolocations(SQLreader sqlreader) {
        super(sqlreader);
    }

    @Override
    public ArrayList getView_photolocationss() throws DBException {
        return viewio.getEntities(EMview_publicphotolocations.SQLSelectAll);
    }
    
    public ArrayList getView_photolocationss(boolean privateaccess) throws DBException {
        if(privateaccess)
            return viewio.getEntities(EMview_photolocations.SQLSelectAll);
        else
            return getView_photolocationss();
    }
    
    public ArrayList get4Locality(boolean privateaccess, String countrycode, String locality) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode }, { "locality", locality } };
        SQLparameters parameters = new SQLparameters(parameter);
        if(privateaccess)
            return viewio.getEntities(EMview_photolocations.SQLSelect4locality, parameters);
        else
            return viewio.getEntities(EMview_publicphotolocations.SQLSelect4locality, parameters);
    }
}
