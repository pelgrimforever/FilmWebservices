/*
 * Bview_publiclocalityphotocount.java
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
import film.conversion.entity.EMview_publiclocalityphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_publiclocalityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_publiclocalityphotocount
 *
 * Superclass for manipulating data- and database objects
 * for View View_publiclocalityphotocount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_publiclocalityphotocount extends BLview {

    /**
     * Constructor, sets View_publiclocalityphotocount as default Entity
     */
    public Bview_publiclocalityphotocount() {
        super(new View_publiclocalityphotocount(), new EMview_publiclocalityphotocount());
    }

    /**
     * get all View_publiclocalityphotocount objects from database
     * @return ArrayList of View_publiclocalityphotocount objects
     * @throws DBException
     */
    public ArrayList<View_publiclocalityphotocount> getView_publiclocalityphotocounts() throws DBException {
        return getEntities(EMview_publiclocalityphotocount.SQLSelectAll);
    }
}
