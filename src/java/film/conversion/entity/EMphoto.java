/*
 * EMphoto.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMphoto_default;
import film.logicentity.Photo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMphoto
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMphoto extends EMphoto_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by id";
    public static final String OrderByDateTime = " order by photodate, phototime, film, id";
    public static final String OrderByDescription = " order by description";
    public static final String SQLWherePublic = " public = :public: ";
    public static final String SQLSelectAll4Public = "select * from photo where " + SQLWherePublic + OrderBy;

    public static final String SQLSelect4photo_sorted = "select * from photo" + OrderBy;
    public static final String SQLSelect4photo_film_sorted = "select * from photo where film = :film.id:" + OrderBy;
    public static final String SQLSelect4photo_filmpublic_sorted = "select * from photo where " + SQLWherefilm + " and " + SQLWherePublic + OrderBy;

    public static final String SQLjoinfilmtype = " inner join film on photo.film = film.id and film.type = :type: ";
    public static final String SQLWhereLastPhotoinGroup = "film like :groupid:";
    public static final String SQLSelectLastPhotoinGroup = "select * from photo where " + SQLWhereLastPhotoinGroup + " order by film desc, id desc";
    public static final String SQLSelectLastPhotoinGroupAndFilmtype =
        "select * from photo " + SQLjoinfilmtype + " where " + SQLWhereLastPhotoinGroup + " order by photo.film desc, photo.id desc";

    public static final String SQLWherebackup = "backup";
    public static final String SQLSelect4photo_film_backup = "select * from photo where " + SQLWherefilm + " and " + SQLWherebackup;
    public static final String SQLWhereimagebackup = "imagebackup";
    public static final String SQLSelect4photo_film_imagebackup = "select * from photo where " + SQLWherefilm + " and " + SQLWhereimagebackup;

    public static final String SQLSelect4publiclocation = "select * from photo where location = :location: and " + SQLWherePublic + OrderByDateTime;
    public static final String SQLSelect4location = "select * from photo where location = :location:" + OrderByDateTime;
    
    public static final String SQLSelect4publicdate = "select * from photo where photodate = :photodate: and " + SQLWherePublic + OrderByDateTime;
    public static final String SQLSelect4date = "select * from photo where photodate = :photodate:" + OrderByDateTime;
    
    public static final String SQLSelectDescriptions = "select distinct description from photo where description like :description:";
    
    public static final String SQLSelectDataError = "select * from photo where public and (location is null or photodate is null) order by film, id";
    
    public static final String SQLUpdateBackup4Film = "update photo set backup = :backup: where " + SQLWherefilm;

    /**
     * Map ResultSet Field values to Photo
     * @param dbresult: Database ResultSet
     * @return Photo
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Photo photo = (Photo)super.mapResultSet2Entity(dbresult);
        return photo;
    }    
    
}

