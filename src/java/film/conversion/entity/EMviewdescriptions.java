/*
 * EMviewdescriptions.java
 *
 */
package film.conversion.entity;

import film.logicview.Viewdescriptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.ViewMapper;

/**
 * EMviewdescriptions
 * @author Franky Laseure
 */
public class EMviewdescriptions implements ViewMapper {
    
    /**
     * @return empty string
     */
    public String getSQLSelectAll() {
        return "";
    }
    
    /**
     * Map ResultSet Field values to View_subjects_for_photo
     * @param dbresult: Database ResultSet
     */
    @Override
    public Viewdescriptions mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Viewdescriptions viewdescriptions = new Viewdescriptions();
        if(dbresult!=null) {
            try {
                viewdescriptions.setDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return viewdescriptions;
    }    
    
}

