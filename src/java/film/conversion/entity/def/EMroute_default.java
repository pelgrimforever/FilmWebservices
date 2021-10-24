/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.9.2021 14:50
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import film.entity.pk.*;
import film.logicentity.Route;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMroute_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMroute_default implements TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :route.countrycode: and postalcode = :route.postalcode: and locality = :route.locality: and sublocality = :route.sublocality: and routecode = :route.routecode:";
    public static final String SQLSelect1 = "select route.* from route where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from route where " + SQLWhere1;
    public static final String SQLSelectAll = "select route.* from route";

    public static final String SQLSelect = "select route.* from route";
    public static final String SQLWheresublocality = "countrycode = :sublocality.countrycode: and postalcode = :sublocality.postalcode: and locality = :sublocality.locality: and sublocality = :sublocality.sublocality:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, postalcode, locality, sublocality, routecode";
//Custom code, do not change this line

    public static final String SQLSelect4sublocality = "select * from route where " + SQLWheresublocality + OrderBy;
    public static final String SQLDelete4sublocality = "delete from route where " + SQLWheresublocality;

    /**
     * 
     * @return SQL where clause for one Route (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Route (=Primarykey)
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
     * @return SQL select statement for all Routes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Route
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RoutePK routePK = null;
        Route route;
        if(dbresult==null) {
            route = new Route(routePK);
        } else {
            try {
                routePK = new RoutePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"), dbresult.getString("routecode"));
                route = new Route(routePK);
                route.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    route.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    route.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    route.initViewport(c_viewport.abstractclone());
                }
                route.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return route;
    }

}

