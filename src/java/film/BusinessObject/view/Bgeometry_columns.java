/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMgeometry_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Geometry_columns;
import java.sql.Time;

public abstract class Bgeometry_columns extends ViewBusinessrules {

    public Bgeometry_columns(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMgeometry_columns()));
    }
    
    public ArrayList<Geometry_columns> getGeometry_columnss() throws DBException {
        return (ArrayList<Geometry_columns>)viewio.getEntities(EMgeometry_columns.SQLSelectAll);
    }
}
