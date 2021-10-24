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
import film.logicentity.Sublocality;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsublocality_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMsublocality_default implements TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :sublocality.countrycode: and postalcode = :sublocality.postalcode: and locality = :sublocality.locality: and sublocality = :sublocality.sublocality:";
    public static final String SQLSelect1 = "select sublocality.* from sublocality where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from sublocality where " + SQLWhere1;
    public static final String SQLSelectAll = "select sublocality.* from sublocality";

    public static final String SQLSelect = "select sublocality.* from sublocality";
    public static final String SQLWherelocality = "countrycode = :locality.countrycode: and postalcode = :locality.postalcode: and locality = :locality.locality:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, postalcode, locality, sublocality";
//Custom code, do not change this line

    public static final String SQLSelect4locality = "select * from sublocality where " + SQLWherelocality + OrderBy;
    public static final String SQLDelete4locality = "delete from sublocality where " + SQLWherelocality;

    /**
     * 
     * @return SQL where clause for one Sublocality (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Sublocality (=Primarykey)
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
     * @return SQL select statement for all Sublocalitys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Sublocality
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SublocalityPK sublocalityPK = null;
        Sublocality sublocality;
        if(dbresult==null) {
            sublocality = new Sublocality(sublocalityPK);
        } else {
            try {
                sublocalityPK = new SublocalityPK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"));
                sublocality = new Sublocality(sublocalityPK);
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    sublocality.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    sublocality.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    sublocality.initViewport(c_viewport.abstractclone());
                }
                sublocality.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return sublocality;
    }

}

