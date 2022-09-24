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
import film.logicview.Geography_columns;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMgeography_columns_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select geography_columns.* from geography_columns";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "geography_columns"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geography_columns geography_columns = new Geography_columns();
        if(dbresult!=null) {
            try {
                geography_columns.setF_table_catalog(dbresult.getString("f_table_catalog"));
                geography_columns.setF_table_schema(dbresult.getString("f_table_schema"));
                geography_columns.setF_table_name(dbresult.getString("f_table_name"));
                geography_columns.setF_geography_column(dbresult.getString("f_geography_column"));
                geography_columns.setCoord_dimension(dbresult.getInt("coord_dimension"));
                geography_columns.setSrid(dbresult.getInt("srid"));
                geography_columns.setType(dbresult.getString("type"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return geography_columns;
    }

}

