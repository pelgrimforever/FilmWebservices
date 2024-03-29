/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_countryphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_countryphotocount;
import java.sql.Time;

public abstract class Bview_countryphotocount extends ViewBusinessrules {

    public Bview_countryphotocount(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_countryphotocount()));
    }
    
    public ArrayList<View_countryphotocount> getView_countryphotocounts() throws DBException {
        return (ArrayList<View_countryphotocount>)viewio.getEntities(EMview_countryphotocount.SQLSelectAll);
    }
}
