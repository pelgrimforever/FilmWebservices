/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMgeography_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Geography_columns;
import java.sql.Time;

public abstract class Bgeography_columns extends ViewBusinessrules {

    public Bgeography_columns(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMgeography_columns()));
    }
    
    public ArrayList<Geography_columns> getGeography_columnss() throws DBException {
        return (ArrayList<Geography_columns>)viewio.getEntities(EMgeography_columns.SQLSelectAll);
    }
}
