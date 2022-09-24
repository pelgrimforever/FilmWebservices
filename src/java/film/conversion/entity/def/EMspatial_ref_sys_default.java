/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
package film.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import film.filmDatabaseproperties;
import film.entity.pk.*;
import film.logicentity.Spatial_ref_sys;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMspatial_ref_sys_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "srid = :spatial_ref_sys.srid:";
    public static final String SQLSelect1 = "select spatial_ref_sys.* from spatial_ref_sys where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from spatial_ref_sys where " + SQLWhere1;
    public static final String SQLSelectAll = "select spatial_ref_sys.* from spatial_ref_sys";

    public static final String SQLSelect = "select spatial_ref_sys.* from spatial_ref_sys";

//Custom code, do not change this line
    public static final String OrderBy = " order by srid";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "spatial_ref_sys"; }

    /**
     * 
     * @return SQL where clause for one Spatial_ref_sys (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Spatial_ref_sys (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Spatial_ref_sysPK spatial_ref_sysPK = null;
        Spatial_ref_sys spatial_ref_sys;
        if(dbresult==null) {
            spatial_ref_sys = new Spatial_ref_sys(spatial_ref_sysPK);
        } else {
            try {
                spatial_ref_sysPK = new Spatial_ref_sysPK(dbresult.getInt("srid"));
                spatial_ref_sys = new Spatial_ref_sys(spatial_ref_sysPK);
                spatial_ref_sys.initAuth_name(dbresult.getString("auth_name"));
                spatial_ref_sys.initAuth_srid(dbresult.getInt("auth_srid"));
                spatial_ref_sys.initSrtext(dbresult.getString("srtext"));
                spatial_ref_sys.initProj4text(dbresult.getString("proj4text"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return spatial_ref_sys;
    }

}

