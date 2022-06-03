/*
 * Bview_locality_photolocations.java
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
import film.conversion.entity.EMview_locality_photolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_locality_photolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_locality_photolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_locality_photolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_locality_photolocations extends BLview {

    /**
     * Constructor, sets View_locality_photolocations as default Entity
     */
    public Bview_locality_photolocations() {
        super(new View_locality_photolocations(), new EMview_locality_photolocations());
    }

    /**
     * get all View_locality_photolocations objects from database
     * @return ArrayList of View_locality_photolocations objects
     * @throws DBException
     */
    public ArrayList<View_locality_photolocations> getView_locality_photolocationss() throws DBException {
        return getEntities(EMview_locality_photolocations.SQLSelectAll);
    }
}
