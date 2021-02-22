/*
 * Bview_publicphotolocations.java
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
import film.logicview.View_publicphotolocations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_publicphotolocations
 *
 * Superclass for manipulating data- and database objects
 * for View View_publicphotolocations and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_publicphotolocations extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_publicphotolocations as default Entity
     */
    public Bview_publicphotolocations() {
        super(new SQLMapper_pgsql(connectionpool, "View_publicphotolocations"), new View_publicphotolocations());
    }

    /**
     * Map ResultSet Field values to View_publicphotolocations
     * @param dbresult: Database ResultSet
     */
    public View_publicphotolocations mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_publicphotolocations view_publicphotolocations = new View_publicphotolocations();
        if(dbresult!=null) {
            try {
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    view_publicphotolocations.setLocation(c_location.abstractclone());
                }
                view_publicphotolocations.setExactlocation(dbresult.getBoolean("exactlocation"));
                view_publicphotolocations.setLocationradius(dbresult.getDouble("locationradius"));
                view_publicphotolocations.setCountrycode(dbresult.getString("countrycode"));
                view_publicphotolocations.setPostalcode(dbresult.getString("postalcode"));
                view_publicphotolocations.setLocality(dbresult.getString("locality"));
                view_publicphotolocations.setSublocality(dbresult.getString("sublocality"));
                view_publicphotolocations.setRoutecode(dbresult.getString("routecode"));
                view_publicphotolocations.setStreetnumber(dbresult.getString("streetnumber"));
                view_publicphotolocations.setLocationcount(dbresult.getLong("locationcount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_publicphotolocations);
        return view_publicphotolocations;
    }

    /**
     * get all View_publicphotolocations objects from database
     * @return ArrayList of View_publicphotolocations objects
     * @throws DBException
     */
    public ArrayList getView_publicphotolocationss() throws DBException {
        return getMapper().loadViewVector(this, View_publicphotolocations.SQLSelectAll);
    }
}
