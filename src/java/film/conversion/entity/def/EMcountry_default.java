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
import film.logicentity.Country;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMcountry_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "code = :country.code:";
    public static final String SQLSelect1 = "select country.* from country where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from country where " + SQLWhere1;
    public static final String SQLSelectAll = "select country.* from country";

    public static final String SQLSelect = "select country.* from country";

//Custom code, do not change this line
    public static final String OrderBy = " order by code";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "country"; }

    /**
     * 
     * @return SQL where clause for one Country (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Country (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CountryPK countryPK = null;
        Country country;
        if(dbresult==null) {
            country = new Country(countryPK);
        } else {
            try {
                countryPK = new CountryPK(dbresult.getString("code"));
                country = new Country(countryPK);
                country.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    country.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((org.postgis.PGgeometry)o_bounds);
                    country.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((org.postgis.PGgeometry)o_viewport);
                    country.initViewport(c_viewport.abstractclone());
                }
                country.initApproximate(dbresult.getBoolean("approximate"));
                country.initHasarealevel1(dbresult.getBoolean("hasarealevel1"));
                country.initHasarealevel2(dbresult.getBoolean("hasarealevel2"));
                country.initHasarealevel3(dbresult.getBoolean("hasarealevel3"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return country;
    }

}

