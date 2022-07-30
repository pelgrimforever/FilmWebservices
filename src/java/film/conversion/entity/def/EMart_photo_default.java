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
import film.logicentity.Art_photo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMart_photo_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "film = :art_photo.film: and photo = :art_photo.photo:";
    public static final String SQLSelect1 = "select art_photo.* from art_photo where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_photo where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_photo.* from art_photo";

    public static final String SQLSelect = "select art_photo.* from art_photo";
    public static final String SQLWherephoto = "film = :photo.film: and photo = :photo.id:";
    public static final String SQLWhereart_subgroup = "photosubgroup = :art_subgroup.subgroupid:";
    public static final String SQLWhereart_academy = "academy = :art_academy.academyid:";
    public static final String SQLWhereart_group = "photogroup = :art_group.groupid:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, photo";
//Custom code, do not change this line

    public static final String SQLSelect4photo = "select * from art_photo where " + SQLWherephoto + OrderBy;
    public static final String SQLDelete4photo = "delete from art_photo where " + SQLWherephoto;
    public static final String SQLSelect4art_subgroup = "select * from art_photo where " + SQLWhereart_subgroup + OrderBy;
    public static final String SQLDelete4art_subgroup = "delete from art_photo where " + SQLWhereart_subgroup;
    public static final String SQLSelect4art_academy = "select * from art_photo where " + SQLWhereart_academy + OrderBy;
    public static final String SQLDelete4art_academy = "delete from art_photo where " + SQLWhereart_academy;
    public static final String SQLSelect4art_group = "select * from art_photo where " + SQLWhereart_group + OrderBy;
    public static final String SQLDelete4art_group = "delete from art_photo where " + SQLWhereart_group;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "art_photo"; }

    /**
     * 
     * @return SQL where clause for one Art_photo (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Art_photo (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_photoPK art_photoPK = null;
        Art_photo art_photo;
        if(dbresult==null) {
            art_photo = new Art_photo(art_photoPK);
        } else {
            try {
                art_photoPK = new Art_photoPK(dbresult.getString("film"), dbresult.getInt("photo"));
                art_photo = new Art_photo(art_photoPK);
                art_photo.initArt_subgroupPK(new Art_subgroupPK(dbresult.getInt("photosubgroup")));
                if(dbresult.wasNull()) art_photo.setArt_subgroupPK(null);                
                art_photo.initArt_academyPK(new Art_academyPK(dbresult.getLong("academy")));
                if(dbresult.wasNull()) art_photo.setArt_academyPK(null);                
                art_photo.initArt_groupPK(new Art_groupPK(dbresult.getLong("photogroup")));
                if(dbresult.wasNull()) art_photo.setArt_groupPK(null);                
                art_photo.initSelection(dbresult.getBoolean("selection"));
                art_photo.initWidth(dbresult.getInt("width"));
                art_photo.initHeight(dbresult.getInt("height"));
                art_photo.initComment(dbresult.getString("comment"));
                art_photo.initSeqno(dbresult.getInt("seqno"));
                art_photo.initArchive(dbresult.getBoolean("archive"));
                art_photo.initSurround(dbresult.getBoolean("surround"));
                art_photo.initSurrounddir(dbresult.getString("surrounddir"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return art_photo;
    }

}

