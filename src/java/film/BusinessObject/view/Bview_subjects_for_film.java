/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_subjects_for_film;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_subjects_for_film;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_subjects_for_film extends ViewBusinessrules {

    public Bview_subjects_for_film(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_subjects_for_film()));
    }
    
    public ArrayList<View_subjects_for_film> getView_subjects_for_films() throws DBException {
        return (ArrayList<View_subjects_for_film>)viewio.getEntities(EMview_subjects_for_film.SQLSelectAll);
    }
}
