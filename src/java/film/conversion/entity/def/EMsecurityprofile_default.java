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
import film.logicentity.Securityprofile;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMsecurityprofile_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "userprofile = :securityprofile.userprofile:";
    public static final String SQLSelect1 = "select securityprofile.* from securityprofile where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from securityprofile where " + SQLWhere1;
    public static final String SQLSelectAll = "select securityprofile.* from securityprofile";

    public static final String SQLSelect = "select securityprofile.* from securityprofile";

//Custom code, do not change this line
    public static final String OrderBy = " order by userprofile";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "securityprofile"; }

    /**
     * 
     * @return SQL where clause for one Securityprofile (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Securityprofile (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityprofilePK securityprofilePK = null;
        Securityprofile securityprofile;
        if(dbresult==null) {
            securityprofile = new Securityprofile(securityprofilePK);
        } else {
            try {
                securityprofilePK = new SecurityprofilePK(dbresult.getString("userprofile"));
                securityprofile = new Securityprofile(securityprofilePK);
                securityprofile.initPrivateaccess(dbresult.getBoolean("privateaccess"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return securityprofile;
    }

}

