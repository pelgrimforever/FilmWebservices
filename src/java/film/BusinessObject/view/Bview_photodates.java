/*
 * Bview_photodates.java
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
import film.logicview.View_photodates;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photodates
 *
 * Superclass for manipulating data- and database objects
 * for View View_photodates and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photodates extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_photodates as default Entity
     */
    public Bview_photodates() {
        super(new SQLMapper_pgsql(connectionpool, "View_photodates"), new View_photodates());
    }

    /**
     * Map ResultSet Field values to View_photodates
     * @param dbresult: Database ResultSet
     */
    public View_photodates mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_photodates view_photodates = new View_photodates();
        if(dbresult!=null) {
            try {
                view_photodates.setPhotodate(dbresult.getDate("photodate"));
                view_photodates.setPhotos(dbresult.getLong("photos"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_photodates);
        return view_photodates;
    }

    /**
     * get all View_photodates objects from database
     * @return ArrayList of View_photodates objects
     * @throws DBException
     */
    public ArrayList getView_photodatess() throws DBException {
        return getMapper().loadViewVector(this, View_photodates.SQLSelectAll);
    }
}
