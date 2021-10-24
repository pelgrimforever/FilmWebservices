/*
 * EMsubject.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMsubject_default;
import film.logicentity.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsubject
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsubject extends EMsubject_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
        public static final String OrderBy = " order by subject";
	public static final String SQLWherecat1cat2 = "cat1 = :cat1: and cat2 = :cat2:";
	public static final String SQLSelect4cat1cat2 = "select * from subject where " + SQLWherecat1cat2 + OrderBy;
	public static final String SQLWherephoto = "photosubjects.film = :photo.film: and photosubjects.id = :photo.id:";
	public static final String SQLWherefilm = "filmsubjects.film = :film.id:";
	public static final String SQLSelect4photo = "select subject.* from subject "
                + "inner join photosubjects on subject.cat1 = photosubjects.cat1 and subject.cat2 = photosubjects.cat2 "
                + "and subject.id = photosubjects.subject "
                + " where " + SQLWherephoto + OrderBy;
	public static final String SQLSelect4film = "select subject.* from subject "
                + "inner join filmsubjects on subject.cat1 = filmsubjects.cat1 and subject.cat2 = filmsubjects.cat2 "
                + "and subject.id = filmsubjects.subject "
                + " where " + SQLWherefilm + OrderBy;
        public static final String getMaxsubjectid = "select * from subject where id = (select max(id) from subject)";

    /**
     * Map ResultSet Field values to Subject
     * @param dbresult: Database ResultSet
     * @return Subject
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Subject subject = (Subject)super.mapResultSet2Entity(dbresult);
        return subject;
    }    
    
}

