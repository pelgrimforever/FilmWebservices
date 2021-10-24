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
import film.logicentity.Photo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMphoto_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMphoto_default implements TableMapper {
    
    public static final String SQLWhere1 = "film = :photo.film: and id = :photo.id:";
    public static final String SQLSelect1 = "select photo.* from photo where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from photo where " + SQLWhere1;
    public static final String SQLSelectAll = "select photo.* from photo";

    public static final String SQLSelect = "select photo.* from photo";
    public static final String SQLWhereroute = "countrycode = :route.countrycode: and postalcode = :route.postalcode: and locality = :route.locality: and sublocality = :route.sublocality: and routecode = :route.routecode:";
    public static final String SQLWherecreator = "creator = :creator.creatorid:";
    public static final String SQLWherefilm = "film = :film.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, id";
//Custom code, do not change this line

    public static final String SQLSelect4route = "select * from photo where " + SQLWhereroute + OrderBy;
    public static final String SQLDelete4route = "delete from photo where " + SQLWhereroute;
    public static final String SQLSelect4creator = "select * from photo where " + SQLWherecreator + OrderBy;
    public static final String SQLDelete4creator = "delete from photo where " + SQLWherecreator;
    public static final String SQLSelect4film = "select * from photo where " + SQLWherefilm + OrderBy;
    public static final String SQLDelete4film = "delete from photo where " + SQLWherefilm;

    /**
     * 
     * @return SQL where clause for one Photo (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Photo (=Primarykey)
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
     * @return SQL select statement for all Photos
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Photo
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhotoPK photoPK = null;
        Photo photo;
        if(dbresult==null) {
            photo = new Photo(photoPK);
        } else {
            try {
                photoPK = new PhotoPK(dbresult.getString("film"), dbresult.getInt("id"));
                photo = new Photo(photoPK);
                photo.initRoutePK(new RoutePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"), dbresult.getString("routecode")));
                if(dbresult.wasNull()) photo.setRoutePK(null);                
                photo.initCreatorPK(new CreatorPK(dbresult.getString("creator")));
                if(dbresult.wasNull()) photo.setCreatorPK(null);                
                photo.initFormat(dbresult.getString("format"));
                photo.initDescription(dbresult.getString("description"));
                photo.initPhotodate(dbresult.getDate("photodate"));
                photo.initPhototime(dbresult.getString("phototime") == null ? null : Time.valueOf(dbresult.getString("phototime")));
                photo.initPublic(dbresult.getBoolean("public"));
                photo.initComposition(dbresult.getBoolean("composition"));
                photo.initRotation(dbresult.getFloat("rotation"));
                photo.initBackup(dbresult.getBoolean("backup"));
                photo.initImagebackup(dbresult.getBoolean("imagebackup"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    photo.initLocation(c_location.abstractclone());
                }
                photo.initExactlocation(dbresult.getBoolean("exactlocation"));
                photo.initLocationradius(dbresult.getDouble("locationradius"));
                photo.initReversegeocode(dbresult.getString("reversegeocode"));
                photo.initStreetnumber(dbresult.getString("streetnumber"));
                photo.initFormattedaddress(dbresult.getString("formattedaddress"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return photo;
    }

}

