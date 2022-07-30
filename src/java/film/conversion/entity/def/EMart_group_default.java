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
import film.logicentity.Art_group;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMart_group_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "groupid = :art_group.groupid:";
    public static final String SQLSelect1 = "select art_group.* from art_group where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_group where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_group.* from art_group";

    public static final String SQLSelect = "select art_group.* from art_group";

//Custom code, do not change this line
    public static final String OrderBy = " order by groupid";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "art_group"; }

    /**
     * 
     * @return SQL where clause for one Art_group (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Art_group (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_groupPK art_groupPK = null;
        Art_group art_group;
        if(dbresult==null) {
            art_group = new Art_group(art_groupPK);
        } else {
            try {
                art_groupPK = new Art_groupPK(dbresult.getLong("groupid"));
                art_group = new Art_group(art_groupPK);
                art_group.initGroupname(dbresult.getString("groupname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return art_group;
    }

}

