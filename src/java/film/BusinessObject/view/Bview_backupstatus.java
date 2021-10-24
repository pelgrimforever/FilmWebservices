/*
 * Bview_backupstatus.java
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
import film.conversion.entity.EMview_backupstatus;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_backupstatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_backupstatus
 *
 * Superclass for manipulating data- and database objects
 * for View View_backupstatus and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_backupstatus extends BLview {

    /**
     * Constructor, sets View_backupstatus as default Entity
     */
    public Bview_backupstatus() {
        super(new View_backupstatus(), new EMview_backupstatus());
    }

    /**
     * get all View_backupstatus objects from database
     * @return ArrayList of View_backupstatus objects
     * @throws DBException
     */
    public ArrayList<View_backupstatus> getView_backupstatuss() throws DBException {
        return getEntities(EMview_backupstatus.SQLSelectAll);
    }
}
