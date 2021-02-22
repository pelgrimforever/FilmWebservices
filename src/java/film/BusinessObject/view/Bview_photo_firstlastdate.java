/*
 * Bview_photo_firstlastdate.java
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
import film.logicview.View_photo_firstlastdate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photo_firstlastdate
 *
 * Superclass for manipulating data- and database objects
 * for View View_photo_firstlastdate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photo_firstlastdate extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_photo_firstlastdate as default Entity
     */
    public Bview_photo_firstlastdate() {
        super(new SQLMapper_pgsql(connectionpool, "View_photo_firstlastdate"), new View_photo_firstlastdate());
    }

    /**
     * Map ResultSet Field values to View_photo_firstlastdate
     * @param dbresult: Database ResultSet
     */
    public View_photo_firstlastdate mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_photo_firstlastdate view_photo_firstlastdate = new View_photo_firstlastdate();
        if(dbresult!=null) {
            try {
                view_photo_firstlastdate.setMinphotodate(dbresult.getDate("minphotodate"));
                view_photo_firstlastdate.setMaxphotodate(dbresult.getDate("maxphotodate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_photo_firstlastdate);
        return view_photo_firstlastdate;
    }

    /**
     * get all View_photo_firstlastdate objects from database
     * @return ArrayList of View_photo_firstlastdate objects
     * @throws DBException
     */
    public ArrayList getView_photo_firstlastdates() throws DBException {
        return getMapper().loadViewVector(this, View_photo_firstlastdate.SQLSelectAll);
    }
}
