/*
 * EMfilm.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMfilm_default;
import film.logicentity.Film;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfilm
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfilm extends EMfilm_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
        private static final String SQLWherePublic = " public = :public: ";
	public static final String SQLSelectAll = EMfilm_default.SQLSelectAll + OrderBy;
	public static final String SQLSelectAll4Public = "select * from film where " + SQLWherefilmtype + OrderBy;
        public static final String SQLSelect4film_filmtype_orderby = "select * from film where " + SQLWherefilmtype + OrderBy;
        public static final String SQLSelectGroups = "select * from film where "
                + "id not like '0%' and "
                + "id not like '1%' and "
                + "id not like '2%' and "
                + "id not like '3%' and "
                + "id not like '4%' and "
                + "id not like '5%' and "
                + "id not like '6%' and "
                + "id not like '7%' and "
                + "id not like '8%' and "
                + "id not like '9%' " + OrderBy;

    /**
     * Map ResultSet Field values to Film
     * @param dbresult: Database ResultSet
     * @return Film
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Film film = (Film)super.mapResultSet2Entity(dbresult);
        return film;
    }    
    
}

