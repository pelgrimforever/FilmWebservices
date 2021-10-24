/*
 * Bview_subjects_for_photo.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.conversion.entity.EMview_subjects_for_photo;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_subjects_for_photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_subjects_for_photo
 *
 * Superclass for manipulating data- and database objects
 * for View View_subjects_for_photo and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_subjects_for_photo extends BLview {

    /**
     * Constructor, sets View_subjects_for_photo as default Entity
     */
    public Bview_subjects_for_photo() {
        super(new View_subjects_for_photo(), new EMview_subjects_for_photo());
    }

    /**
     * get all View_subjects_for_photo objects from database
     * @return ArrayList of View_subjects_for_photo objects
     * @throws DBException
     */
    public ArrayList<View_subjects_for_photo> getView_subjects_for_photos() throws DBException {
        return getEntities(EMview_subjects_for_photo.SQLSelectAll);
    }
}
