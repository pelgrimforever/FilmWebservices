/*
 * Bview_locationtree.java
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
import film.logicview.View_locationtree;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_locationtree
 *
 * Superclass for manipulating data- and database objects
 * for View View_locationtree and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_locationtree extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_locationtree as default Entity
     */
    public Bview_locationtree() {
        super(new SQLMapper_pgsql(connectionpool, "View_locationtree"), new View_locationtree());
    }

    /**
     * Map ResultSet Field values to View_locationtree
     * @param dbresult: Database ResultSet
     */
    public View_locationtree mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_locationtree view_locationtree = new View_locationtree();
        if(dbresult!=null) {
            try {
                view_locationtree.setCountrycode(dbresult.getString("countrycode"));
                view_locationtree.setCountryname(dbresult.getString("countryname"));
                view_locationtree.setPostalcode(dbresult.getString("postalcode"));
                view_locationtree.setAl1code(dbresult.getString("al1code"));
                view_locationtree.setAl1name(dbresult.getString("al1name"));
                view_locationtree.setAl2code(dbresult.getString("al2code"));
                view_locationtree.setAl2name(dbresult.getString("al2name"));
                view_locationtree.setAl3code(dbresult.getString("al3code"));
                view_locationtree.setAl3name(dbresult.getString("al3name"));
                view_locationtree.setLocality(dbresult.getString("locality"));
                view_locationtree.setHassublocality(dbresult.getBoolean("hassublocality"));
                view_locationtree.setSublocality(dbresult.getString("sublocality"));
                view_locationtree.setRoutecode(dbresult.getString("routecode"));
                view_locationtree.setRoutename(dbresult.getString("routename"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_locationtree);
        return view_locationtree;
    }

    /**
     * get all View_locationtree objects from database
     * @return ArrayList of View_locationtree objects
     * @throws DBException
     */
    public ArrayList getView_locationtrees() throws DBException {
        return getMapper().loadViewVector(this, View_locationtree.SQLSelectAll);
    }
}
