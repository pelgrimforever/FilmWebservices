/*
 * EMview_photodatespublic.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_photodatespublic_default;
import film.logicview.View_photodatespublic;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_photodatespublic
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_photodatespublic extends EMview_photodatespublic_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_photodatespublic
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photodatespublic view_photodatespublic = (View_photodatespublic)super.mapResultSet2Entity(dbresult);
        return view_photodatespublic;
    }    
    
}

