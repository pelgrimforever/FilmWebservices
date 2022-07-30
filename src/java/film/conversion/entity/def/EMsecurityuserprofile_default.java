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
import film.logicentity.Securityuserprofile;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMsecurityuserprofile_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "siteusername = :securityuserprofile.siteusername: and userprofile = :securityuserprofile.userprofile:";
    public static final String SQLSelect1 = "select securityuserprofile.* from securityuserprofile where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from securityuserprofile where " + SQLWhere1;
    public static final String SQLSelectAll = "select securityuserprofile.* from securityuserprofile";

    public static final String SQLSelect = "select securityuserprofile.* from securityuserprofile";
    public static final String SQLWheresecurityprofile = "userprofile = :securityprofile.userprofile:";

//Custom code, do not change this line
    public static final String OrderBy = " order by siteusername, userprofile";
//Custom code, do not change this line

    public static final String SQLSelect4securityprofile = "select * from securityuserprofile where " + SQLWheresecurityprofile + OrderBy;
    public static final String SQLDelete4securityprofile = "delete from securityuserprofile where " + SQLWheresecurityprofile;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "securityuserprofile"; }

    /**
     * 
     * @return SQL where clause for one Securityuserprofile (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Securityuserprofile (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityuserprofilePK securityuserprofilePK = null;
        Securityuserprofile securityuserprofile;
        if(dbresult==null) {
            securityuserprofile = new Securityuserprofile(securityuserprofilePK);
        } else {
            try {
                securityuserprofilePK = new SecurityuserprofilePK(dbresult.getString("siteusername"), dbresult.getString("userprofile"));
                securityuserprofile = new Securityuserprofile(securityuserprofilePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return securityuserprofile;
    }

}

