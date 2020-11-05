/*
 * Bview_subjects_for_photo.java
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
import film.logicview.View_subjects_for_photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_subjects_for_photo
 *
 * Superclass for manipulating data- and database objects
 * for View View_subjects_for_photo and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_subjects_for_photo extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_subjects_for_photo as default Entity
     */
    public Bview_subjects_for_photo() {
        super(new SQLMapper_pgsql(connectionpool, "View_subjects_for_photo"), new View_subjects_for_photo());
    }

    /**
     * Map ResultSet Field values to View_subjects_for_photo
     * @param dbresult: Database ResultSet
     */
    public View_subjects_for_photo mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_subjects_for_photo view_subjects_for_photo = new View_subjects_for_photo();
        if(dbresult!=null) {
            try {
                view_subjects_for_photo.setFilm(dbresult.getString("film"));
                view_subjects_for_photo.setPhotoid(dbresult.getInt("photoid"));
                view_subjects_for_photo.setCat1(dbresult.getString("cat1"));
                view_subjects_for_photo.setCat2(dbresult.getString("cat2"));
                view_subjects_for_photo.setId(dbresult.getInt("id"));
                view_subjects_for_photo.setSubject(dbresult.getString("subject"));
                view_subjects_for_photo.setDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_subjects_for_photo);
        return view_subjects_for_photo;
    }

    /**
     * get all View_subjects_for_photo objects from database
     * @return ArrayList of View_subjects_for_photo objects
     * @throws DBException
     */
    public ArrayList getView_subjects_for_photos() throws DBException {
        return getMapper().loadViewVector(this, View_subjects_for_photo.SQLSelectAll);
    }
}
