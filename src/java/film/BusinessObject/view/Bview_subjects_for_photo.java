/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_subjects_for_photo;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_subjects_for_photo;
import java.sql.Time;

public abstract class Bview_subjects_for_photo extends ViewBusinessrules {

    public Bview_subjects_for_photo(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_subjects_for_photo()));
    }
    
    public ArrayList<View_subjects_for_photo> getView_subjects_for_photos() throws DBException {
        return (ArrayList<View_subjects_for_photo>)viewio.getEntities(EMview_subjects_for_photo.SQLSelectAll);
    }
}
