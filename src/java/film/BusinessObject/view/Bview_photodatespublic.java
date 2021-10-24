/*
 * Bview_photodatespublic.java
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
import film.conversion.entity.EMview_photodatespublic;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photodatespublic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_photodatespublic
 *
 * Superclass for manipulating data- and database objects
 * for View View_photodatespublic and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_photodatespublic extends BLview {

    /**
     * Constructor, sets View_photodatespublic as default Entity
     */
    public Bview_photodatespublic() {
        super(new View_photodatespublic(), new EMview_photodatespublic());
    }

    /**
     * get all View_photodatespublic objects from database
     * @return ArrayList of View_photodatespublic objects
     * @throws DBException
     */
    public ArrayList<View_photodatespublic> getView_photodatespublics() throws DBException {
        return getEntities(EMview_photodatespublic.SQLSelectAll);
    }
}
