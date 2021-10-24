/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.9.2021 14:50
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import film.logicview.Raster_overviews;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMraster_overviews_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMraster_overviews_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select raster_overviews.* from raster_overviews";
	  
    /**
     * 
     * @return SQL select statement for all Raster_overviewss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Raster_overviews
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

