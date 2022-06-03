/*
 * Bview_subjects_for_film.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.conversion.entity.EMview_subjects_for_film;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_subjects_for_film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_subjects_for_film
 *
 * Superclass for manipulating data- and database objects
 * for View View_subjects_for_film and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_subjects_for_film extends BLview {

    /**
     * Constructor, sets View_subjects_for_film as default Entity
     */
    public Bview_subjects_for_film() {
        super(new View_subjects_for_film(), new EMview_subjects_for_film());
    }

    /**
     * get all View_subjects_for_film objects from database
     * @return ArrayList of View_subjects_for_film objects
     * @throws DBException
     */
    public ArrayList<View_subjects_for_film> getView_subjects_for_films() throws DBException {
        return getEntities(EMview_subjects_for_film.SQLSelectAll);
    }
}
