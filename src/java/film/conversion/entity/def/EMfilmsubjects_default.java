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
import film.logicentity.Filmsubjects;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfilmsubjects_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMfilmsubjects_default implements TableMapper {
    
    public static final String SQLWhere1 = "film = :filmsubjects.film: and cat1 = :filmsubjects.cat1: and cat2 = :filmsubjects.cat2: and subject = :filmsubjects.subject:";
    public static final String SQLSelect1 = "select filmsubjects.* from filmsubjects where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from filmsubjects where " + SQLWhere1;
    public static final String SQLSelectAll = "select filmsubjects.* from filmsubjects";

    public static final String SQLSelect = "select filmsubjects.* from filmsubjects";
    public static final String SQLWheresubject = "cat1 = :subject.cat1: and cat2 = :subject.cat2: and subject = :subject.id:";
    public static final String SQLWherefilm = "film = :film.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, cat1, cat2, subject";
//Custom code, do not change this line

    public static final String SQLSelect4subject = "select * from filmsubjects where " + SQLWheresubject + OrderBy;
    public static final String SQLDelete4subject = "delete from filmsubjects where " + SQLWheresubject;
    public static final String SQLSelect4film = "select * from filmsubjects where " + SQLWherefilm + OrderBy;
    public static final String SQLDelete4film = "delete from filmsubjects where " + SQLWherefilm;

    /**
     * 
     * @return SQL where clause for one Filmsubjects (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Filmsubjects (=Primarykey)
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
     * @return SQL select statement for all Filmsubjectss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Filmsubjects
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmsubjectsPK filmsubjectsPK = null;
        Filmsubjects filmsubjects;
        if(dbresult==null) {
            filmsubjects = new Filmsubjects(filmsubjectsPK);
        } else {
            try {
                filmsubjectsPK = new FilmsubjectsPK(dbresult.getString("film"), dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("subject"));
                filmsubjects = new Filmsubjects(filmsubjectsPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return filmsubjects;
    }

}

