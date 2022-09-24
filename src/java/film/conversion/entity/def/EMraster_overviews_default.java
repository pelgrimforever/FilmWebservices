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
import film.logicview.Raster_overviews;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMraster_overviews_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select raster_overviews.* from raster_overviews";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "raster_overviews"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
        return raster_overviews;
    }

}

