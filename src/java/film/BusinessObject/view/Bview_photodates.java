/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_photodates;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photodates;
import java.sql.Time;

public abstract class Bview_photodates extends ViewBusinessrules {

    public Bview_photodates(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_photodates()));
    }
    
    public ArrayList<View_photodates> getView_photodatess() throws DBException {
        return (ArrayList<View_photodates>)viewio.getEntities(EMview_photodates.SQLSelectAll);
    }
}
