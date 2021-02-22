/*
 * Bview_subjects_for_film.java
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
import film.logicview.View_subjects_for_film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_subjects_for_film
 *
 * Superclass for manipulating data- and database objects
 * for View View_subjects_for_film and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_subjects_for_film extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_subjects_for_film as default Entity
     */
    public Bview_subjects_for_film() {
        super(new SQLMapper_pgsql(connectionpool, "View_subjects_for_film"), new View_subjects_for_film());
    }

    /**
     * Map ResultSet Field values to View_subjects_for_film
     * @param dbresult: Database ResultSet
     */
    public View_subjects_for_film mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_subjects_for_film view_subjects_for_film = new View_subjects_for_film();
        if(dbresult!=null) {
            try {
                view_subjects_for_film.setFilm(dbresult.getString("film"));
                view_subjects_for_film.setCat1(dbresult.getString("cat1"));
                view_subjects_for_film.setCat2(dbresult.getString("cat2"));
                view_subjects_for_film.setId(dbresult.getInt("id"));
                view_subjects_for_film.setSubject(dbresult.getString("subject"));
                view_subjects_for_film.setDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_subjects_for_film);
        return view_subjects_for_film;
    }

    /**
     * get all View_subjects_for_film objects from database
     * @return ArrayList of View_subjects_for_film objects
     * @throws DBException
     */
    public ArrayList getView_subjects_for_films() throws DBException {
        return getMapper().loadViewVector(this, View_subjects_for_film.SQLSelectAll);
    }
}
