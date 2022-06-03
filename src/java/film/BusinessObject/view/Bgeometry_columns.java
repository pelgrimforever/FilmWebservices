/*
 * Bgeometry_columns.java
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
import film.conversion.entity.EMgeometry_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Geometry_columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bgeometry_columns
 *
 * Superclass for manipulating data- and database objects
 * for View Geometry_columns and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bgeometry_columns extends BLview {

    /**
     * Constructor, sets Geometry_columns as default Entity
     */
    public Bgeometry_columns() {
        super(new Geometry_columns(), new EMgeometry_columns());
    }

    /**
     * get all Geometry_columns objects from database
     * @return ArrayList of Geometry_columns objects
     * @throws DBException
     */
    public ArrayList<Geometry_columns> getGeometry_columnss() throws DBException {
        return getEntities(EMgeometry_columns.SQLSelectAll);
    }
}
