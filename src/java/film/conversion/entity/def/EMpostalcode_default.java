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
import film.logicentity.Postalcode;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMpostalcode_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "countrycode = :postalcode.countrycode: and postalcode = :postalcode.postalcode:";
    public static final String SQLSelect1 = "select postalcode.* from postalcode where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from postalcode where " + SQLWhere1;
    public static final String SQLSelectAll = "select postalcode.* from postalcode";

    public static final String SQLSelect = "select postalcode.* from postalcode";
    public static final String SQLWherearealevel3 = "countrycode = :arealevel3.countrycode: and al1code = :arealevel3.al1code: and al2code = :arealevel3.al2code: and al3code = :arealevel3.al3code:";

//Custom code, do not change this line
    public static final String OrderBy = " order by countrycode, postalcode";
//Custom code, do not change this line

    public static final String SQLSelect4arealevel3 = "select * from postalcode where " + SQLWherearealevel3 + OrderBy;
    public static final String SQLDelete4arealevel3 = "delete from postalcode where " + SQLWherearealevel3;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "postalcode"; }

    /**
     * 
     * @return SQL where clause for one Postalcode (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Postalcode (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PostalcodePK postalcodePK = null;
        Postalcode postalcode;
        if(dbresult==null) {
            postalcode = new Postalcode(postalcodePK);
        } else {
            try {
                postalcodePK = new PostalcodePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"));
                postalcode = new Postalcode(postalcodePK);
                postalcode.initArealevel3PK(new Arealevel3PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"), dbresult.getString("al3code")));
                if(dbresult.wasNull()) postalcode.setArealevel3PK(null);                
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    postalcode.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    postalcode.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    postalcode.initViewport(c_viewport.abstractclone());
                }
                postalcode.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return postalcode;
    }

}

