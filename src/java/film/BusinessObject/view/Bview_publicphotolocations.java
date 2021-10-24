/*
 * Bview_publicphotolocations.java
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
import film.conversion.entity.EMview_publicphotolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_publicphotolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_publicphotolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_publicphotolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_publicphotolocations extends BLview {

    /**
     * Constructor, sets View_publicphotolocations as default Entity
     */
    public Bview_publicphotolocations() {
        super(new View_publicphotolocations(), new EMview_publicphotolocations());
    }

    /**
     * get all View_publicphotolocations objects from database
     * @return ArrayList of View_publicphotolocations objects
     * @throws DBException
     */
    public ArrayList<View_publicphotolocations> getView_publicphotolocationss() throws DBException {
        return getEntities(EMview_publicphotolocations.SQLSelectAll);
    }
}
