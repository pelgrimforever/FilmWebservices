/*
 * Bview_countryphotocount.java
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
import film.logicview.View_countryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_countryphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_countryphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_countryphotocount extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_countryphotocount as default Entity
     */
    public Bview_countryphotocount() {
        super(new SQLMapper_pgsql(connectionpool, "View_countryphotocount"), new View_countryphotocount());
    }

    /**
     * Map ResultSet Field values to View_countryphotocount
     * @param dbresult: Database ResultSet
     */
    public View_countryphotocount mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_countryphotocount view_countryphotocount = new View_countryphotocount();
        if(dbresult!=null) {
            try {
                view_countryphotocount.setCode(dbresult.getString("code"));
                view_countryphotocount.setName(dbresult.getString("name"));
                view_countryphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_countryphotocount);
        return view_countryphotocount;
    }

    /**
     * get all View_countryphotocount objects from database
     * @return ArrayList of View_countryphotocount objects
     * @throws DBException
     */
    public ArrayList getView_countryphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_countryphotocount.SQLSelectAll);
    }
}
