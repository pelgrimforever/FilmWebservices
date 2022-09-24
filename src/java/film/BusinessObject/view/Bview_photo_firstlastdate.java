/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_photo_firstlastdate;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photo_firstlastdate;
import java.sql.Time;

public abstract class Bview_photo_firstlastdate extends ViewBusinessrules {

    public Bview_photo_firstlastdate(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_photo_firstlastdate()));
    }
    
    public ArrayList<View_photo_firstlastdate> getView_photo_firstlastdates() throws DBException {
        return (ArrayList<View_photo_firstlastdate>)viewio.getEntities(EMview_photo_firstlastdate.SQLSelectAll);
    }
}
