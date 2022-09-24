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
import film.logicentity.Arealevel3;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMarealevel3_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :arealevel3.countrycode: and al1code = :arealevel3.al1code: and al2code = :arealevel3.al2code: and al3code = :arealevel3.al3code:";
    public static final String SQLSelect1 = "select arealevel3.* from arealevel3 where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from arealevel3 where " + SQLWhere1;
    public static final String SQLSelectAll = "select arealevel3.* from arealevel3";

    public static final String SQLSelect = "select arealevel3.* from arealevel3";
    public static final String SQLWherearealevel2 = "countrycode = :arealevel2.countrycode: and al1code = :arealevel2.al1code: and al2code = :arealevel2.al2code:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, al1code, al2code, al3code";
//Custom code, do not change this line

    public static final String SQLSelect4arealevel2 = "select * from arealevel3 where " + SQLWherearealevel2 + OrderBy;
    public static final String SQLDelete4arealevel2 = "delete from arealevel3 where " + SQLWherearealevel2;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "arealevel3"; }

    /**
     * 
     * @return SQL where clause for one Arealevel3 (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Arealevel3 (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel3PK arealevel3PK = null;
        Arealevel3 arealevel3;
        if(dbresult==null) {
            arealevel3 = new Arealevel3(arealevel3PK);
        } else {
            try {
                arealevel3PK = new Arealevel3PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"), dbresult.getString("al3code"));
                arealevel3 = new Arealevel3(arealevel3PK);
                arealevel3.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    arealevel3.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    arealevel3.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    arealevel3.initViewport(c_viewport.abstractclone());
                }
                arealevel3.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return arealevel3;
    }

}

