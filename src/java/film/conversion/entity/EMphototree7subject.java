/*
 * EMphototree7subject.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMphototree7subject_default;
import film.logicentity.Phototree7subject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMphototree7subject
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMphototree7subject extends EMphototree7subject_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Phototree7subject
     * @param dbresult: Database ResultSet
     * @return Phototree7subject
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Phototree7subject phototree7subject = (Phototree7subject)super.mapResultSet2Entity(dbresult);
        return phototree7subject;
    }    
    
}

