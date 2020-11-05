/*
 * Bgeometry_columns.java
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
import film.logicview.Geometry_columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bgeometry_columns
 *
 * Superclass for manipulating data- and database objects
 * for View Geometry_columns and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bgeometry_columns extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets Geometry_columns as default Entity
     */
    public Bgeometry_columns() {
        super(new SQLMapper_pgsql(connectionpool, "Geometry_columns"), new Geometry_columns());
    }

    /**
     * Map ResultSet Field values to Geometry_columns
     * @param dbresult: Database ResultSet
     */
    public Geometry_columns mapResultSet2View(ResultSet dbresult) throws SQLException {
        Geometry_columns geometry_columns = new Geometry_columns();
        if(dbresult!=null) {
            try {
                geometry_columns.setF_table_catalog(dbresult.getString("f_table_catalog"));
                geometry_columns.setF_table_schema(dbresult.getString("f_table_schema"));
                geometry_columns.setF_table_name(dbresult.getString("f_table_name"));
                geometry_columns.setF_geometry_column(dbresult.getString("f_geometry_column"));
                geometry_columns.setCoord_dimension(dbresult.getInt("coord_dimension"));
                geometry_columns.setSrid(dbresult.getInt("srid"));
                geometry_columns.setType(dbresult.getString("type"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, geometry_columns);
        return geometry_columns;
    }

    /**
     * get all Geometry_columns objects from database
     * @return ArrayList of Geometry_columns objects
     * @throws DBException
     */
    public ArrayList getGeometry_columnss() throws DBException {
        return getMapper().loadViewVector(this, Geometry_columns.SQLSelectAll);
    }
}
