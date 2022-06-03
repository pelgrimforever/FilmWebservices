/*
 * Bview_photodates.java
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
import film.conversion.entity.EMview_photodates;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photodates;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photodates
 *
 * Superclass for manipulating data- and database objects
 * for View View_photodates and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photodates extends BLview {

    /**
     * Constructor, sets View_photodates as default Entity
     */
    public Bview_photodates() {
        super(new View_photodates(), new EMview_photodates());
    }

    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    public ArrayList<View_photodates> getView_photodatess() throws DBException {
        return getEntities(EMview_photodates.SQLSelectAll);
    }
}
