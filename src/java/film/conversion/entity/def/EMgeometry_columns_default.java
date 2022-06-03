/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 1.5.2022 20:24
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import film.logicview.Geometry_columns;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMgeometry_columns_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMgeometry_columns_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select geometry_columns.* from geometry_columns";
	  
    /**
     * 
     * @return SQL select statement for all Geometry_columnss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Geometry_columns
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geometry_columns geometry_columns = new Geometry_columns();
        if(dbresult!=null) {
            try {
                geometry_columns.setF_table_catalog(dbresult.getString("f_table_catalog"));
                geometry_columns.setF_table_schema(dbresult.getString("f_table_schema"));
                geometry_columns.setF_table_name(dbresult.getString("f_table_name"));
                geometry_columns.setF_geometry_column(dbresult.getString("f_geometry_column"));
                geometry_columns.setCoord_dimension(dbresult.getInt("coord_dimension"));
                geometry_columns.setSrid(dbresult.getInt("srid"));
                geometry_columns.setType(dbresult.getString("type"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return geometry_columns;
    }

}

