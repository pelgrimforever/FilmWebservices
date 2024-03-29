/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_publiclocalityphotocount;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_publiclocalityphotocount;
import java.sql.Time;

public abstract class Bview_publiclocalityphotocount extends ViewBusinessrules {

    public Bview_publiclocalityphotocount(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_publiclocalityphotocount()));
    }
    
    public ArrayList<View_publiclocalityphotocount> getView_publiclocalityphotocounts() throws DBException {
        return (ArrayList<View_publiclocalityphotocount>)viewio.getEntities(EMview_publiclocalityphotocount.SQLSelectAll);
    }
}
