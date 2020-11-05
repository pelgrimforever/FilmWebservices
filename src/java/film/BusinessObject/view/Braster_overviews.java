/*
 * Braster_overviews.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.BusinessObject.view;

import BusinessObject.GeneralViewObject;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.data.ProjectConstants;
import db.ArchiveViewMapper;
import db.ViewMapper;
import db.ViewMapperInterface;
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
public abstract class Braster_overviews extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets Raster_overviews as default Entity
     */
    public Braster_overviews() {
        super(new SQLMapper_pgsql(connectionpool, "Raster_overviews"), new Raster_overviews());
    }

    /**
     * Map ResultSet Field values to Raster_overviews
     * @param dbresult: Database ResultSet
     */
    public Raster_overviews mapResultSet2View(ResultSet dbresult) throws SQLException {
        Raster_overviews raster_overviews = new Raster_overviews();
        if(dbresult!=null) {
            try {
                raster_overviews.setO_table_catalog(dbresult.getString("o_table_catalog"));
                raster_overviews.setO_table_schema(dbresult.getString("o_table_schema"));
                raster_overviews.setO_table_name(dbresult.getString("o_table_name"));
                raster_overviews.setO_raster_column(dbresult.getString("o_raster_column"));
                raster_overviews.setR_table_catalog(dbresult.getString("r_table_catalog"));
                raster_overviews.setR_table_schema(dbresult.getString("r_table_schema"));
                raster_overviews.setR_table_name(dbresult.getString("r_table_name"));
                raster_overviews.setR_raster_column(dbresult.getString("r_raster_column"));
                raster_overviews.setOverview_factor(dbresult.getInt("overview_factor"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, raster_overviews);
        return raster_overviews;
    }

    /**
     * get all Raster_overviews objects from database
     * @return ArrayList of Raster_overviews objects
     * @throws DBException
     */
    public ArrayList getRaster_overviewss() throws DBException {
        return getMapper().loadViewVector(this, Raster_overviews.SQLSelectAll);
    }
}
