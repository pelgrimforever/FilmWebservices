/*
 * Bgeography_columns.java
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
import film.conversion.entity.EMgeography_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Geography_columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bgeography_columns
 *
 * Superclass for manipulating data- and database objects
 * for View Geography_columns and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bgeography_columns extends BLview {

    /**
     * Constructor, sets Geography_columns as default Entity
     */
    public Bgeography_columns() {
        super(new Geography_columns(), new EMgeography_columns());
    }

    /**
     * get all Geography_columns objects from database
     * @return ArrayList of Geography_columns objects
     * @throws DBException
     */
    public ArrayList<Geography_columns> getGeography_columnss() throws DBException {
        return getEntities(EMgeography_columns.SQLSelectAll);
    }
}
