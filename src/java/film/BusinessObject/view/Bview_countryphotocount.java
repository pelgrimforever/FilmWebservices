/*
 * Bview_countryphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import film.conversion.entity.EMview_countryphotocount;
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
public abstract class Bview_countryphotocount extends BLview {

    /**
     * Constructor, sets View_countryphotocount as default Entity
     */
    public Bview_countryphotocount() {
        super(new View_countryphotocount(), new EMview_countryphotocount());
    }

    /**
     * get all View_countryphotocount objects from database
     * @return ArrayList of View_countryphotocount objects
     * @throws DBException
     */
    public ArrayList<View_countryphotocount> getView_countryphotocounts() throws DBException {
        return getEntities(EMview_countryphotocount.SQLSelectAll);
    }
}
