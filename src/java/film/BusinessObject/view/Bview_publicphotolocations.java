/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_publicphotolocations;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_publicphotolocations;
import java.sql.Time;

public abstract class Bview_publicphotolocations extends ViewBusinessrules {

    public Bview_publicphotolocations(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_publicphotolocations()));
    }
    
    public ArrayList<View_publicphotolocations> getView_publicphotolocationss() throws DBException {
        return (ArrayList<View_publicphotolocations>)viewio.getEntities(EMview_publicphotolocations.SQLSelectAll);
    }
}
