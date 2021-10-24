/*
 * Bview_photolocations.java
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
import film.conversion.entity.EMview_photolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_photolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photolocations extends BLview {

    /**
     * Constructor, sets View_photolocations as default Entity
     */
    public Bview_photolocations() {
        super(new View_photolocations(), new EMview_photolocations());
    }

    /**
     * get all View_photolocations objects from database
     * @return ArrayList of View_photolocations objects
     * @throws DBException
     */
    public ArrayList<View_photolocations> getView_photolocationss() throws DBException {
        return getEntities(EMview_photolocations.SQLSelectAll);
    }
}
