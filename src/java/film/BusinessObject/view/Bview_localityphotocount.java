/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_localityphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_localityphotocount;
import java.sql.Time;

public abstract class Bview_localityphotocount extends ViewBusinessrules {

    public Bview_localityphotocount(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_localityphotocount()));
    }
    
    public ArrayList<View_localityphotocount> getView_localityphotocounts() throws DBException {
        return (ArrayList<View_localityphotocount>)viewio.getEntities(EMview_localityphotocount.SQLSelectAll);
    }
}
