/*
 * Bview_publiclocalityphotocount.java
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
import film.logicview.View_publiclocalityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_publiclocalityphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_publiclocalityphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_publiclocalityphotocount extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_publiclocalityphotocount as default Entity
     */
    public Bview_publiclocalityphotocount() {
        super(new SQLMapper_pgsql(connectionpool, "View_publiclocalityphotocount"), new View_publiclocalityphotocount());
    }

    /**
     * Map ResultSet Field values to View_publiclocalityphotocount
     * @param dbresult: Database ResultSet
     */
    public View_publiclocalityphotocount mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_publiclocalityphotocount view_publiclocalityphotocount = new View_publiclocalityphotocount();
        if(dbresult!=null) {
            try {
                view_publiclocalityphotocount.setCountrycode(dbresult.getString("countrycode"));
                view_publiclocalityphotocount.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    view_publiclocalityphotocount.setLocation(c_location.abstractclone());
                }
                view_publiclocalityphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_publiclocalityphotocount);
        return view_publiclocalityphotocount;
    }

    /**
     * get all View_publiclocalityphotocount objects from database
     * @return ArrayList of View_publiclocalityphotocount objects
     * @throws DBException
     */
    public ArrayList getView_publiclocalityphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_publiclocalityphotocount.SQLSelectAll);
    }
}
