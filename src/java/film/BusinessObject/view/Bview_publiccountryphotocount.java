/*
 * Bview_publiccountryphotocount.java
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
import film.conversion.entity.EMview_publiccountryphotocount;
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
public abstract class Bview_publiccountryphotocount extends BLview {

    /**
     * Constructor, sets View_publiccountryphotocount as default Entity
     */
    public Bview_publiccountryphotocount() {
        super(new View_publiccountryphotocount(), new EMview_publiccountryphotocount());
    }

    /**
     * get all View_publiccountryphotocount objects from database
     * @return ArrayList of View_publiccountryphotocount objects
     * @throws DBException
     */
    public ArrayList<View_publiccountryphotocount> getView_publiccountryphotocounts() throws DBException {
        return getEntities(EMview_publiccountryphotocount.SQLSelectAll);
    }
}
