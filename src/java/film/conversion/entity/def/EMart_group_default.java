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
import film.logicentity.Art_group;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMart_group_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMart_group_default implements TableMapper {
    
    public static final String SQLWhere1 = "groupid = :art_group.groupid:";
    public static final String SQLSelect1 = "select art_group.* from art_group where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_group where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_group.* from art_group";

    public static final String SQLSelect = "select art_group.* from art_group";

//Custom code, do not change this line
    public static final String OrderBy = " order by groupid";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Art_groups
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Art_group
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

