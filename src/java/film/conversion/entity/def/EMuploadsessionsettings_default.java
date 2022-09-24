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
import film.logicentity.Uploadsessionsettings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMuploadsessionsettings_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "directory = :uploadsessionsettings.directory:";
    public static final String SQLSelect1 = "select uploadsessionsettings.* from uploadsessionsettings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from uploadsessionsettings where " + SQLWhere1;
    public static final String SQLSelectAll = "select uploadsessionsettings.* from uploadsessionsettings";

    public static final String SQLSelect = "select uploadsessionsettings.* from uploadsessionsettings";

//Custom code, do not change this line
    public static final String OrderBy = " order by directory";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "uploadsessionsettings"; }

    /**
     * 
     * @return SQL where clause for one Uploadsessionsettings (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Uploadsessionsettings (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UploadsessionsettingsPK uploadsessionsettingsPK = null;
        Uploadsessionsettings uploadsessionsettings;
        if(dbresult==null) {
            uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
        } else {
            try {
                uploadsessionsettingsPK = new UploadsessionsettingsPK(dbresult.getString("directory"));
                uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
                uploadsessionsettings.initUploadtype(dbresult.getString("uploadtype"));
                uploadsessionsettings.initFilmgroups(dbresult.getString("filmgroups"));
                uploadsessionsettings.initLastposition(dbresult.getInt("lastposition"));
                uploadsessionsettings.initCopymode(dbresult.getString("copymode"));
                uploadsessionsettings.initUploadingposition(dbresult.getInt("uploadingposition"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return uploadsessionsettings;
    }

}

