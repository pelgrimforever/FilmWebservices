/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMraster_overviews;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.Raster_overviews;
import java.sql.Time;

public abstract class Braster_overviews extends ViewBusinessrules {

    public Braster_overviews(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMraster_overviews()));
    }
    
    public ArrayList<Raster_overviews> getRaster_overviewss() throws DBException {
        return (ArrayList<Raster_overviews>)viewio.getEntities(EMraster_overviews.SQLSelectAll);
    }
}
