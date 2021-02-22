/*
 * Bview_publiccountryphotocount.java
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
import film.logicview.View_publiccountryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_publiccountryphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_publiccountryphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_publiccountryphotocount extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_publiccountryphotocount as default Entity
     */
    public Bview_publiccountryphotocount() {
        super(new SQLMapper_pgsql(connectionpool, "View_publiccountryphotocount"), new View_publiccountryphotocount());
    }

    /**
     * Map ResultSet Field values to View_publiccountryphotocount
     * @param dbresult: Database ResultSet
     */
    public View_publiccountryphotocount mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_publiccountryphotocount view_publiccountryphotocount = new View_publiccountryphotocount();
        if(dbresult!=null) {
            try {
                view_publiccountryphotocount.setCode(dbresult.getString("code"));
                view_publiccountryphotocount.setName(dbresult.getString("name"));
                view_publiccountryphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_publiccountryphotocount);
        return view_publiccountryphotocount;
    }

    /**
     * get all View_publiccountryphotocount objects from database
     * @return ArrayList of View_publiccountryphotocount objects
     * @throws DBException
     */
    public ArrayList getView_publiccountryphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_publiccountryphotocount.SQLSelectAll);
    }
}
