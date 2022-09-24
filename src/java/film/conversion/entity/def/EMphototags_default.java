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
import film.logicentity.Phototags;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMphototags_default implements filmDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "phototags"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

