/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

public class View_localityphotocount_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_localityphotocount blview_localityphotocount = new BLview_localityphotocount(sqlreader);
    
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

