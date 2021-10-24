/*
 * Bview_localityphotocount.java
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
import film.conversion.entity.EMview_localityphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_localityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_localityphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_localityphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_localityphotocount extends BLview {

    /**
     * Constructor, sets View_localityphotocount as default Entity
     */
    public Bview_localityphotocount() {
        super(new View_localityphotocount(), new EMview_localityphotocount());
    }

    /**
     * get all View_localityphotocount objects from database
     * @return ArrayList of View_localityphotocount objects
     * @throws DBException
     */
    public ArrayList<View_localityphotocount> getView_localityphotocounts() throws DBException {
        return getEntities(EMview_localityphotocount.SQLSelectAll);
    }
}
