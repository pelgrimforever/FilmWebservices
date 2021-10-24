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
import film.logicentity.Photosubjects;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMphotosubjects_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMphotosubjects_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Photosubjectss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Photosubjects
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

