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
import film.logicentity.Art_subgroup;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMart_subgroup_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "subgroupid = :art_subgroup.subgroupid:";
    public static final String SQLSelect1 = "select art_subgroup.* from art_subgroup where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_subgroup where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_subgroup.* from art_subgroup";

    public static final String SQLSelect = "select art_subgroup.* from art_subgroup";
    public static final String SQLWhereart_group = "groupid = :art_group.groupid:";

//Custom code, do not change this line
    public static final String OrderBy = " order by subgroupid";
//Custom code, do not change this line

    public static final String SQLSelect4art_group = "select * from art_subgroup where " + SQLWhereart_group + OrderBy;
    public static final String SQLDelete4art_group = "delete from art_subgroup where " + SQLWhereart_group;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "art_subgroup"; }

    /**
     * 
     * @return SQL where clause for one Art_subgroup (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Art_subgroup (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_subgroupPK art_subgroupPK = null;
        Art_subgroup art_subgroup;
        if(dbresult==null) {
            art_subgroup = new Art_subgroup(art_subgroupPK);
        } else {
            try {
                art_subgroupPK = new Art_subgroupPK(dbresult.getInt("subgroupid"));
                art_subgroup = new Art_subgroup(art_subgroupPK);
                art_subgroup.initArt_groupPK(new Art_groupPK(dbresult.getInt("groupid")));
                if(dbresult.wasNull()) art_subgroup.setArt_groupPK(null);                
                art_subgroup.initSubgroupname(dbresult.getString("subgroupname"));
                art_subgroup.initLastseqno(dbresult.getInt("lastseqno"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return art_subgroup;
    }

}

