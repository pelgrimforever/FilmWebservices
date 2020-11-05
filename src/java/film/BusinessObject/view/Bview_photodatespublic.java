/*
 * Bview_photodatespublic.java
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
import film.logicview.View_photodatespublic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photodatespublic
 *
 * Superclass for manipulating data- and database objects
 * for View View_photodatespublic and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photodatespublic extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_photodatespublic as default Entity
     */
    public Bview_photodatespublic() {
        super(new SQLMapper_pgsql(connectionpool, "View_photodatespublic"), new View_photodatespublic());
    }

    /**
     * Map ResultSet Field values to View_photodatespublic
     * @param dbresult: Database ResultSet
     */
    public View_photodatespublic mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_photodatespublic view_photodatespublic = new View_photodatespublic();
        if(dbresult!=null) {
            try {
                view_photodatespublic.setPhotodate(dbresult.getDate("photodate"));
                view_photodatespublic.setPhotos(dbresult.getLong("photos"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_photodatespublic);
        return view_photodatespublic;
    }

    /**
     * get all View_photodatespublic objects from database
     * @return ArrayList of View_photodatespublic objects
     * @throws DBException
     */
    public ArrayList getView_photodatespublics() throws DBException {
        return getMapper().loadViewVector(this, View_photodatespublic.SQLSelectAll);
    }
}
