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
import film.logicview.View_localityphotocount;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_localityphotocount_usecases {

    private boolean loggedin = false;
    private BLview_localityphotocount blview_localityphotocount = new BLview_localityphotocount();
    
    public View_localityphotocount_usecases() {
        this(false);
    }
    
    public View_localityphotocount_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_localityphotocount.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_localityphotocount> get_all() throws DBException {
        return blview_localityphotocount.getView_localityphotocounts();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_localityphotocount> count_4_country(String countrycode, boolean privateaccess) throws DBException {
        return blview_localityphotocount.get4Countrycode(countrycode, privateaccess);
    }
//Custom code, do not change this line   

}

