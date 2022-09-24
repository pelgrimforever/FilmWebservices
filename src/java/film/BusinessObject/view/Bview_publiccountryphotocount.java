/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_publiccountryphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_publiccountryphotocount;
import java.sql.Time;

public abstract class Bview_publiccountryphotocount extends ViewBusinessrules {

    public Bview_publiccountryphotocount(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_publiccountryphotocount()));
    }
    
    public ArrayList<View_publiccountryphotocount> getView_publiccountryphotocounts() throws DBException {
        return (ArrayList<View_publiccountryphotocount>)viewio.getEntities(EMview_publiccountryphotocount.SQLSelectAll);
    }
}
