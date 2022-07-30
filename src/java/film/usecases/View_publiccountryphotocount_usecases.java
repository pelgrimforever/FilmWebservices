/*
 * Generated on 27.6.2022 16:45
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import film.interfaces.searchentity.*;
import film.logicview.*;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.logicentity.*;
import film.logicview.*;
import film.usecases.custom.*;
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
    private SQLreader sqlreader = new SQLreader();
    private BLview_publiccountryphotocount blview_publiccountryphotocount = new BLview_publiccountryphotocount(sqlreader);
    
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

