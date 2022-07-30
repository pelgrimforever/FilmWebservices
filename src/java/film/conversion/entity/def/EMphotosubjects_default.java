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
import film.logicentity.Photosubjects;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMphotosubjects_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "film = :photosubjects.film: and id = :photosubjects.id: and cat1 = :photosubjects.cat1: and cat2 = :photosubjects.cat2: and subject = :photosubjects.subject:";
    public static final String SQLSelect1 = "select photosubjects.* from photosubjects where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from photosubjects where " + SQLWhere1;
    public static final String SQLSelectAll = "select photosubjects.* from photosubjects";

    public static final String SQLSelect = "select photosubjects.* from photosubjects";
    public static final String SQLWherephoto = "film = :photo.film: and id = :photo.id:";
    public static final String SQLWheresubject = "cat1 = :subject.cat1: and cat2 = :subject.cat2: and subject = :subject.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, id, cat1, cat2, subject";
//Custom code, do not change this line

    public static final String SQLSelect4photo = "select * from photosubjects where " + SQLWherephoto + OrderBy;
    public static final String SQLDelete4photo = "delete from photosubjects where " + SQLWherephoto;
    public static final String SQLSelect4subject = "select * from photosubjects where " + SQLWheresubject + OrderBy;
    public static final String SQLDelete4subject = "delete from photosubjects where " + SQLWheresubject;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "photosubjects"; }

    /**
     * 
     * @return SQL where clause for one Photosubjects (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Photosubjects (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhotosubjectsPK photosubjectsPK = null;
        Photosubjects photosubjects;
        if(dbresult==null) {
            photosubjects = new Photosubjects(photosubjectsPK);
        } else {
            try {
                photosubjectsPK = new PhotosubjectsPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("subject"));
                photosubjects = new Photosubjects(photosubjectsPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return photosubjects;
    }

}

