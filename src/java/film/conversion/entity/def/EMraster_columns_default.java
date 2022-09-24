/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import film.filmDatabaseproperties;
import film.logicview.Raster_columns;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMraster_columns_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select raster_columns.* from raster_columns";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "raster_columns"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
                    piShape c_extent = new psqlGeometry((org.postgis.PGgeometry)o_extent);
                    raster_columns.setExtent(c_extent.abstractclone());
                }
                raster_columns.setSpatial_index(dbresult.getBoolean("spatial_index"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return raster_columns;
    }

}

