/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_locality_photolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_locality_photolocations;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_locality_photolocations extends ViewBusinessrules {

    public Bview_locality_photolocations(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_locality_photolocations()));
    }
    
    public ArrayList<View_locality_photolocations> getView_locality_photolocationss() throws DBException {
        return (ArrayList<View_locality_photolocations>)viewio.getEntities(EMview_locality_photolocations.SQLSelectAll);
    }
}
