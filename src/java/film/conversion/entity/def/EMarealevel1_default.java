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
import film.logicentity.Arealevel1;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMarealevel1_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :arealevel1.countrycode: and al1code = :arealevel1.al1code:";
    public static final String SQLSelect1 = "select arealevel1.* from arealevel1 where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from arealevel1 where " + SQLWhere1;
    public static final String SQLSelectAll = "select arealevel1.* from arealevel1";

    public static final String SQLSelect = "select arealevel1.* from arealevel1";
    public static final String SQLWherecountry = "countrycode = :country.code:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, al1code";
//Custom code, do not change this line

    public static final String SQLSelect4country = "select * from arealevel1 where " + SQLWherecountry + OrderBy;
    public static final String SQLDelete4country = "delete from arealevel1 where " + SQLWherecountry;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "arealevel1"; }

    /**
     * 
     * @return SQL where clause for one Arealevel1 (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Arealevel1 (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel1PK arealevel1PK = null;
        Arealevel1 arealevel1;
        if(dbresult==null) {
            arealevel1 = new Arealevel1(arealevel1PK);
        } else {
            try {
                arealevel1PK = new Arealevel1PK(dbresult.getString("countrycode"), dbresult.getString("al1code"));
                arealevel1 = new Arealevel1(arealevel1PK);
                arealevel1.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    arealevel1.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    arealevel1.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    arealevel1.initViewport(c_viewport.abstractclone());
                }
                arealevel1.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return arealevel1;
    }

}

