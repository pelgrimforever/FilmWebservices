/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 16:45
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import film.filmDatabaseproperties;
import film.logicview.Geometry_columns;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMgeometry_columns_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select geometry_columns.* from geometry_columns";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "geometry_columns"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

