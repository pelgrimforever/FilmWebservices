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
import film.logicentity.Art_subgroup;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMart_subgroup_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMart_subgroup_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Art_subgroups
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Art_subgroup
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

