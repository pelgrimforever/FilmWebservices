/*
 * Bview_backupstatus.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.BusinessObject.view;

import BusinessObject.GeneralViewObject;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.data.ProjectConstants;
import db.ArchiveViewMapper;
import db.ViewMapper;
import db.ViewMapperInterface;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_backupstatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_backupstatus
 *
 * Superclass for manipulating data- and database objects
 * for View View_backupstatus and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_backupstatus extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_backupstatus as default Entity
     */
    public Bview_backupstatus() {
        super(new SQLMapper_pgsql(connectionpool, "View_backupstatus"), new View_backupstatus());
    }

    /**
     * Map ResultSet Field values to View_backupstatus
     * @param dbresult: Database ResultSet
     */
    public View_backupstatus mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_backupstatus view_backupstatus = new View_backupstatus();
        if(dbresult!=null) {
            try {
                view_backupstatus.setId(dbresult.getString("id"));
                view_backupstatus.setPhotocount(dbresult.getLong("photocount"));
                view_backupstatus.setBackupcount(dbresult.getLong("backupcount"));
                view_backupstatus.setImagebackupcount(dbresult.getLong("imagebackupcount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_backupstatus);
        return view_backupstatus;
    }

    /**
     * get all View_backupstatus objects from database
     * @return ArrayList of View_backupstatus objects
     * @throws DBException
     */
    public ArrayList getView_backupstatuss() throws DBException {
        return getMapper().loadViewVector(this, View_backupstatus.SQLSelectAll);
    }
}
