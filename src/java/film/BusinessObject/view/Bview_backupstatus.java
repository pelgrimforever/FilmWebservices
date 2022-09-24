/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import film.conversion.entity.EMview_backupstatus;
import general.exception.*;
import java.util.ArrayList;
import film.logicview.View_backupstatus;
import java.sql.Time;

public abstract class Bview_backupstatus extends ViewBusinessrules {

    public Bview_backupstatus(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_backupstatus()));
    }
    
    public ArrayList<View_backupstatus> getView_backupstatuss() throws DBException {
        return (ArrayList<View_backupstatus>)viewio.getEntities(EMview_backupstatus.SQLSelectAll);
    }
}
