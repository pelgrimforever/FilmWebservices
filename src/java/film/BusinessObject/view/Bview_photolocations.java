/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_photolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photolocations;
import java.sql.Time;

public abstract class Bview_photolocations extends ViewBusinessrules {

    public Bview_photolocations(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_photolocations()));
    }
    
    public ArrayList<View_photolocations> getView_photolocationss() throws DBException {
        return (ArrayList<View_photolocations>)viewio.getEntities(EMview_photolocations.SQLSelectAll);
    }
}
