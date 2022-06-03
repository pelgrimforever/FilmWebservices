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
import film.logicview.Geography_columns;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMgeography_columns_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMgeography_columns_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select geography_columns.* from geography_columns";
	  
    /**
     * 
     * @return SQL select statement for all Geography_columnss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Geography_columns
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

