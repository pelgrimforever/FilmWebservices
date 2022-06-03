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
import film.logicentity.Locality;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMlocality_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMlocality_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Localitys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Locality
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

