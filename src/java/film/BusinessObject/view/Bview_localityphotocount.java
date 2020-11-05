/*
 * Bview_localityphotocount.java
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
import film.logicview.View_localityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_localityphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_localityphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_localityphotocount extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_localityphotocount as default Entity
     */
    public Bview_localityphotocount() {
        super(new SQLMapper_pgsql(connectionpool, "View_localityphotocount"), new View_localityphotocount());
    }

    /**
     * Map ResultSet Field values to View_localityphotocount
     * @param dbresult: Database ResultSet
     */
    public View_localityphotocount mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_localityphotocount view_localityphotocount = new View_localityphotocount();
        if(dbresult!=null) {
            try {
                view_localityphotocount.setCountrycode(dbresult.getString("countrycode"));
                view_localityphotocount.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    view_localityphotocount.setLocation(c_location.abstractclone());
                }
                view_localityphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_localityphotocount);
        return view_localityphotocount;
    }

    /**
     * get all View_localityphotocount objects from database
     * @return ArrayList of View_localityphotocount objects
     * @throws DBException
     */
    public ArrayList getView_localityphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_localityphotocount.SQLSelectAll);
    }
}
