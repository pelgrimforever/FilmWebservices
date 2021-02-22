/*
 * Bview_photolocations.java
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
import film.logicview.View_photolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_photolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photolocations extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_photolocations as default Entity
     */
    public Bview_photolocations() {
        super(new SQLMapper_pgsql(connectionpool, "View_photolocations"), new View_photolocations());
    }

    /**
     * Map ResultSet Field values to View_photolocations
     * @param dbresult: Database ResultSet
     */
    public View_photolocations mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_photolocations view_photolocations = new View_photolocations();
        if(dbresult!=null) {
            try {
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    view_photolocations.setLocation(c_location.abstractclone());
                }
                view_photolocations.setExactlocation(dbresult.getBoolean("exactlocation"));
                view_photolocations.setLocationradius(dbresult.getDouble("locationradius"));
                view_photolocations.setCountrycode(dbresult.getString("countrycode"));
                view_photolocations.setPostalcode(dbresult.getString("postalcode"));
                view_photolocations.setLocality(dbresult.getString("locality"));
                view_photolocations.setSublocality(dbresult.getString("sublocality"));
                view_photolocations.setRoutecode(dbresult.getString("routecode"));
                view_photolocations.setStreetnumber(dbresult.getString("streetnumber"));
                view_photolocations.setLocationcount(dbresult.getLong("locationcount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_photolocations);
        return view_photolocations;
    }

    /**
     * get all View_photolocations objects from database
     * @return ArrayList of View_photolocations objects
     * @throws DBException
     */
    public ArrayList getView_photolocationss() throws DBException {
        return getMapper().loadViewVector(this, View_photolocations.SQLSelectAll);
    }
}
