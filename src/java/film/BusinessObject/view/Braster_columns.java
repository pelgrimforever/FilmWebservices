/*
 * Braster_columns.java
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
public abstract class Braster_columns extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets Raster_columns as default Entity
     */
    public Braster_columns() {
        super(new SQLMapper_pgsql(connectionpool, "Raster_columns"), new Raster_columns());
    }

    /**
     * Map ResultSet Field values to Raster_columns
     * @param dbresult: Database ResultSet
     */
    public Raster_columns mapResultSet2View(ResultSet dbresult) throws SQLException {
        Raster_columns raster_columns = new Raster_columns();
        if(dbresult!=null) {
            try {
                raster_columns.setR_table_catalog(dbresult.getString("r_table_catalog"));
                raster_columns.setR_table_schema(dbresult.getString("r_table_schema"));
                raster_columns.setR_table_name(dbresult.getString("r_table_name"));
                raster_columns.setR_raster_column(dbresult.getString("r_raster_column"));
                raster_columns.setSrid(dbresult.getInt("srid"));
                raster_columns.setScale_x(dbresult.getDouble("scale_x"));
                raster_columns.setScale_y(dbresult.getDouble("scale_y"));
                raster_columns.setBlocksize_x(dbresult.getInt("blocksize_x"));
                raster_columns.setBlocksize_y(dbresult.getInt("blocksize_y"));
                raster_columns.setSame_alignment(dbresult.getBoolean("same_alignment"));
                raster_columns.setRegular_blocking(dbresult.getBoolean("regular_blocking"));
                raster_columns.setNum_bands(dbresult.getInt("num_bands"));
                raster_columns.setPixel_types(dbresult.getArray("pixel_types"));
                raster_columns.setNodata_values(dbresult.getArray("nodata_values"));
                raster_columns.setOut_db(dbresult.getArray("out_db"));
                Object o_extent = dbresult.getObject("extent");
                if(o_extent!=null) {
                    piShape c_extent = new psqlGeometry((PGgeometry)o_extent);
                    raster_columns.setExtent(c_extent.abstractclone());
                }
                raster_columns.setSpatial_index(dbresult.getBoolean("spatial_index"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, raster_columns);
        return raster_columns;
    }

    /**
     * get all Raster_columns objects from database
     * @return ArrayList of Raster_columns objects
     * @throws DBException
     */
    public ArrayList getRaster_columnss() throws DBException {
        return getMapper().loadViewVector(this, Raster_columns.SQLSelectAll);
    }
}
