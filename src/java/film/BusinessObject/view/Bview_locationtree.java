/*
 * Bview_locationtree.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.conversion.entity.EMview_locationtree;
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
public abstract class Bview_locationtree extends BLview {

    /**
     * Constructor, sets View_locationtree as default Entity
     */
    public Bview_locationtree() {
        super(new View_locationtree(), new EMview_locationtree());
    }

    /**
     * get all View_locationtree objects from database
     * @return ArrayList of View_locationtree objects
     * @throws DBException
     */
    public ArrayList<View_locationtree> getView_locationtrees() throws DBException {
        return getEntities(EMview_locationtree.SQLSelectAll);
    }
}
