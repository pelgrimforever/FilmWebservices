/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 16:45
 */
package film.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import film.filmDatabaseproperties;
import film.entity.pk.*;
import film.logicentity.Locality;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMlocality_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :locality.countrycode: and postalcode = :locality.postalcode: and locality = :locality.locality:";
    public static final String SQLSelect1 = "select locality.* from locality where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from locality where " + SQLWhere1;
    public static final String SQLSelectAll = "select locality.* from locality";

    public static final String SQLSelect = "select locality.* from locality";
    public static final String SQLWherepostalcode = "countrycode = :postalcode.countrycode: and postalcode = :postalcode.postalcode:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, postalcode, locality";
//Custom code, do not change this line

    public static final String SQLSelect4postalcode = "select * from locality where " + SQLWherepostalcode + OrderBy;
    public static final String SQLDelete4postalcode = "delete from locality where " + SQLWherepostalcode;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "locality"; }

    /**
     * 
     * @return SQL where clause for one Locality (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Locality (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        LocalityPK localityPK = null;
        Locality locality;
        if(dbresult==null) {
            locality = new Locality(localityPK);
        } else {
            try {
                localityPK = new LocalityPK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"));
                locality = new Locality(localityPK);
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    locality.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    locality.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    locality.initViewport(c_viewport.abstractclone());
                }
                locality.initApproximate(dbresult.getBoolean("approximate"));
                locality.initHassublocality(dbresult.getBoolean("hassublocality"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return locality;
    }

}

