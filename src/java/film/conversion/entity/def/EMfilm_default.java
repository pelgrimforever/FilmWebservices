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
import film.logicentity.Film;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfilm_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMfilm_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :film.id:";
    public static final String SQLSelect1 = "select film.* from film where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from film where " + SQLWhere1;
    public static final String SQLSelectAll = "select film.* from film";

    public static final String SQLSelect = "select film.* from film";
    public static final String SQLWherefilmtype = "type = :filmtype.type:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4filmtype = "select * from film where " + SQLWherefilmtype + OrderBy;
    public static final String SQLDelete4filmtype = "delete from film where " + SQLWherefilmtype;

    /**
     * 
     * @return SQL where clause for one Film (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Film (=Primarykey)
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
     * @return SQL select statement for all Films
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Film
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmPK filmPK = null;
        Film film;
        if(dbresult==null) {
            film = new Film(filmPK);
        } else {
            try {
                filmPK = new FilmPK(dbresult.getString("id"));
                film = new Film(filmPK);
                film.initFilmtypePK(new FilmtypePK(dbresult.getString("type")));
                if(dbresult.wasNull()) film.setFilmtypePK(null);                
                film.initIso(dbresult.getString("iso"));
                film.initStartdate(dbresult.getDate("startdate"));
                film.initEnddate(dbresult.getDate("enddate"));
                film.initOwner(dbresult.getString("owner"));
                film.initCd(dbresult.getString("cd"));
                film.initPublic(dbresult.getBoolean("public"));
                film.initBackup(dbresult.getBoolean("backup"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return film;
    }

}

