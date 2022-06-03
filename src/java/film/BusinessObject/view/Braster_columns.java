/*
 * Braster_columns.java
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
import film.conversion.entity.EMraster_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Raster_columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Braster_columns
 *
 * Superclass for manipulating data- and database objects
 * for View Raster_columns and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Braster_columns extends BLview {

    /**
     * Constructor, sets Raster_columns as default Entity
     */
    public Braster_columns() {
        super(new Raster_columns(), new EMraster_columns());
    }

    /**
     * get all Raster_columns objects from database
     * @return ArrayList of Raster_columns objects
     * @throws DBException
     */
    public ArrayList<Raster_columns> getRaster_columnss() throws DBException {
        return getEntities(EMraster_columns.SQLSelectAll);
    }
}
