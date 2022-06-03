/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import film.interfaces.searchentity.*;
import film.logicview.*;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.logicview.View_publiccountryphotocount;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_publiccountryphotocount_usecases {

    private boolean loggedin = false;
    private BLview_publiccountryphotocount blview_publiccountryphotocount = new BLview_publiccountryphotocount();
    
    public View_publiccountryphotocount_usecases() {
        this(false);
    }
    
    public View_publiccountryphotocount_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_publiccountryphotocount.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_publiccountryphotocount> get_all() throws DBException {
        return blview_publiccountryphotocount.getView_publiccountryphotocounts();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

