/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_locationtree;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_locationtree;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_locationtree extends ViewBusinessrules {

    public Bview_locationtree(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_locationtree()));
    }
    
    public ArrayList<View_locationtree> getView_locationtrees() throws DBException {
        return (ArrayList<View_locationtree>)viewio.getEntities(EMview_locationtree.SQLSelectAll);
    }
}
