/*
 * Braster_overviews.java
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
import film.conversion.entity.EMraster_overviews;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Raster_overviews;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Braster_overviews
 *
 * Superclass for manipulating data- and database objects
 * for View Raster_overviews and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Braster_overviews extends BLview {

    /**
     * Constructor, sets Raster_overviews as default Entity
     */
    public Braster_overviews() {
        super(new Raster_overviews(), new EMraster_overviews());
    }

    /**
     * get all Raster_overviews objects from database
     * @return ArrayList of Raster_overviews objects
     * @throws DBException
     */
    public ArrayList<Raster_overviews> getRaster_overviewss() throws DBException {
        return getEntities(EMraster_overviews.SQLSelectAll);
    }
}
