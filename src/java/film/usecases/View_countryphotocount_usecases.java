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
public class View_countryphotocount_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_countryphotocount blview_countryphotocount = new BLview_countryphotocount(sqlreader);
    
    public View_countryphotocount_usecases() {
        this(false);
    }
    
    public View_countryphotocount_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_countryphotocount.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_countryphotocount> get_all() throws DBException {
        return blview_countryphotocount.getView_countryphotocounts();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_countryphotocount> get_private_photocount_per_country(boolean privateaccess) throws DBException {
        if(privateaccess)
            return blview_countryphotocount.getAllView_countryphotocounts();
        else
            return blview_countryphotocount.getView_countryphotocounts();
    }
//Custom code, do not change this line   

}

