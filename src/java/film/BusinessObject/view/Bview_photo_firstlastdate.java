/*
 * Bview_photo_firstlastdate.java
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
import film.conversion.entity.EMview_photo_firstlastdate;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photo_firstlastdate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photo_firstlastdate
 *
 * Superclass for manipulating data- and database objects
 * for View View_photo_firstlastdate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photo_firstlastdate extends BLview {

    /**
     * Constructor, sets View_photo_firstlastdate as default Entity
     */
    public Bview_photo_firstlastdate() {
        super(new View_photo_firstlastdate(), new EMview_photo_firstlastdate());
    }

    /**
     * get all View_photo_firstlastdate objects from database
     * @return ArrayList of View_photo_firstlastdate objects
     * @throws DBException
     */
    public ArrayList<View_photo_firstlastdate> getView_photo_firstlastdates() throws DBException {
        return getEntities(EMview_photo_firstlastdate.SQLSelectAll);
    }
}
