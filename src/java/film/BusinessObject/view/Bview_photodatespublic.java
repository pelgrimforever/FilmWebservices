/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_photodatespublic;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_photodatespublic;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_photodatespublic extends ViewBusinessrules {

    public Bview_photodatespublic(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_photodatespublic()));
    }
    
    public ArrayList<View_photodatespublic> getView_photodatespublics() throws DBException {
        return (ArrayList<View_photodatespublic>)viewio.getEntities(EMview_photodatespublic.SQLSelectAll);
    }
}
