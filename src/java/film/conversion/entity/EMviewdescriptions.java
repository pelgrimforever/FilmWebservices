/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.View;
import db.ViewMapper;
import static film.conversion.entity.def.EMview_subjects_for_film_default.SQLSelectAll;
import film.filmDatabaseproperties;
import static film.filmDatabaseproperties.connectionpool;
import static film.filmDatabaseproperties.databasetool;
import film.logicview.Viewdescriptions;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMviewdescriptions implements filmDatabaseproperties, ViewMapper {
    
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_subjects_for_film"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };
   
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

