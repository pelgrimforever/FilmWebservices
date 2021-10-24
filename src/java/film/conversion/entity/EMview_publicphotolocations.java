/*
 * EMview_publicphotolocations.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_publicphotolocations_default;
import film.logicview.View_publicphotolocations;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_publicphotolocations
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_publicphotolocations extends EMview_publicphotolocations_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLWherelocality = "countrycode = :countrycode: and locality = :locality:";
    public static final String SQLSelect4locality = SQLSelectAll + " where " + SQLWherelocality;

    /**
     * Map ResultSet Field values to View_publicphotolocations
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publicphotolocations view_publicphotolocations = (View_publicphotolocations)super.mapResultSet2Entity(dbresult);
        return view_publicphotolocations;
    }    
    
}

