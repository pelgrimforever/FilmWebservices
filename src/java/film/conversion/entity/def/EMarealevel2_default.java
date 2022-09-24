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
import film.logicentity.Arealevel2;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMarealevel2_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :arealevel2.countrycode: and al1code = :arealevel2.al1code: and al2code = :arealevel2.al2code:";
    public static final String SQLSelect1 = "select arealevel2.* from arealevel2 where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from arealevel2 where " + SQLWhere1;
    public static final String SQLSelectAll = "select arealevel2.* from arealevel2";

    public static final String SQLSelect = "select arealevel2.* from arealevel2";
    public static final String SQLWherearealevel1 = "countrycode = :arealevel1.countrycode: and al1code = :arealevel1.al1code:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, al1code, al2code";
//Custom code, do not change this line

    public static final String SQLSelect4arealevel1 = "select * from arealevel2 where " + SQLWherearealevel1 + OrderBy;
    public static final String SQLDelete4arealevel1 = "delete from arealevel2 where " + SQLWherearealevel1;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "arealevel2"; }

    /**
     * 
     * @return SQL where clause for one Arealevel2 (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Arealevel2 (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel2PK arealevel2PK = null;
        Arealevel2 arealevel2;
        if(dbresult==null) {
            arealevel2 = new Arealevel2(arealevel2PK);
        } else {
            try {
                arealevel2PK = new Arealevel2PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"));
                arealevel2 = new Arealevel2(arealevel2PK);
                arealevel2.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    arealevel2.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    arealevel2.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    arealevel2.initViewport(c_viewport.abstractclone());
                }
                arealevel2.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return arealevel2;
    }

}

