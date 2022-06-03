/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 1.5.2022 20:24
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import film.entity.pk.*;
import film.logicentity.Arealevel3;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMarealevel3_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMarealevel3_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Arealevel3s
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Arealevel3
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

