/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMraster_columns;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Raster_columns;
import java.sql.Time;

public abstract class Braster_columns extends ViewBusinessrules {

    public Braster_columns(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMraster_columns()));
    }
    
    public ArrayList<Raster_columns> getRaster_columnss() throws DBException {
        return (ArrayList<Raster_columns>)viewio.getEntities(EMraster_columns.SQLSelectAll);
    }
}
