/*
 * Bview_locality_photolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
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
import film.logicview.View_locality_photolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_locality_photolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_locality_photolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_locality_photolocations extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_locality_photolocations as default Entity
     */
    public Bview_locality_photolocations() {
        super(new SQLMapper_pgsql(connectionpool, "View_locality_photolocations"), new View_locality_photolocations());
    }

    /**
     * Map ResultSet Field values to View_locality_photolocations
     * @param dbresult: Database ResultSet
     */
    public View_locality_photolocations mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_locality_photolocations view_locality_photolocations = new View_locality_photolocations();
        if(dbresult!=null) {
            try {
                view_locality_photolocations.setCountrycode(dbresult.getString("countrycode"));
                view_locality_photolocations.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    view_locality_photolocations.setLocation(c_location.abstractclone());
                }
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_locality_photolocations);
        return view_locality_photolocations;
    }

    /**
     * get all View_locality_photolocations objects from database
     * @return ArrayList of View_locality_photolocations objects
     * @throws DBException
     */
    public ArrayList getView_locality_photolocationss() throws DBException {
        return getMapper().loadViewVector(this, View_locality_photolocations.SQLSelectAll);
    }
}
