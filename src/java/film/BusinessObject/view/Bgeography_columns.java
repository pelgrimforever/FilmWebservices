/*
 * Bgeography_columns.java
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
import film.logicview.Geography_columns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bgeography_columns
 *
 * Superclass for manipulating data- and database objects
 * for View Geography_columns and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bgeography_columns extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets Geography_columns as default Entity
     */
    public Bgeography_columns() {
        super(new SQLMapper_pgsql(connectionpool, "Geography_columns"), new Geography_columns());
    }

    /**
     * Map ResultSet Field values to Geography_columns
     * @param dbresult: Database ResultSet
     */
    public Geography_columns mapResultSet2View(ResultSet dbresult) throws SQLException {
        Geography_columns geography_columns = new Geography_columns();
        if(dbresult!=null) {
            try {
                geography_columns.setF_table_catalog(dbresult.getString("f_table_catalog"));
                geography_columns.setF_table_schema(dbresult.getString("f_table_schema"));
                geography_columns.setF_table_name(dbresult.getString("f_table_name"));
                geography_columns.setF_geography_column(dbresult.getString("f_geography_column"));
                geography_columns.setCoord_dimension(dbresult.getInt("coord_dimension"));
                geography_columns.setSrid(dbresult.getInt("srid"));
                geography_columns.setType(dbresult.getString("type"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, geography_columns);
        return geography_columns;
    }

    /**
     * get all Geography_columns objects from database
     * @return ArrayList of Geography_columns objects
     * @throws DBException
     */
    public ArrayList getGeography_columnss() throws DBException {
        return getMapper().loadViewVector(this, Geography_columns.SQLSelectAll);
    }
}
