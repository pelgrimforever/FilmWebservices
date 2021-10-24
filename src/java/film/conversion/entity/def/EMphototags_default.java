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
import film.logicentity.Phototags;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMphototags_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMphototags_default implements TableMapper {
    
    public static final String SQLWhere1 = "film = :phototags.film: and id = :phototags.id: and tag = :phototags.tag:";
    public static final String SQLSelect1 = "select phototags.* from phototags where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from phototags where " + SQLWhere1;
    public static final String SQLSelectAll = "select phototags.* from phototags";

    public static final String SQLSelect = "select phototags.* from phototags";
    public static final String SQLWherephoto = "film = :photo.film: and id = :photo.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, id, tag";
//Custom code, do not change this line

    public static final String SQLSelect4photo = "select * from phototags where " + SQLWherephoto + OrderBy;
    public static final String SQLDelete4photo = "delete from phototags where " + SQLWherephoto;

    /**
     * 
     * @return SQL where clause for one Phototags (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Phototags (=Primarykey)
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
     * @return SQL select statement for all Phototagss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Phototags
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhototagsPK phototagsPK = null;
        Phototags phototags;
        if(dbresult==null) {
            phototags = new Phototags(phototagsPK);
        } else {
            try {
                phototagsPK = new PhototagsPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getString("tag"));
                phototags = new Phototags(phototagsPK);
                phototags.initTagformat(dbresult.getString("tagformat"));
                phototags.initTagvalue(dbresult.getString("tagvalue"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return phototags;
    }

}

