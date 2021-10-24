/*
 * EMsubjectcat.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMsubjectcat_default;
import film.logicentity.Subjectcat;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsubjectcat
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsubjectcat extends EMsubjectcat_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by cat";
    public static final String SQLWhereCatno = "catno = :catno:";
    public static final String SQLSelectCatno = "select * from subjectcat where " + SQLWhereCatno + OrderBy;

    /**
     * Map ResultSet Field values to Subjectcat
     * @param dbresult: Database ResultSet
     * @return Subjectcat
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Subjectcat subjectcat = (Subjectcat)super.mapResultSet2Entity(dbresult);
        return subjectcat;
    }    
    
}

