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
public class View_publicphotolocations_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_publicphotolocations blview_publicphotolocations = new BLview_publicphotolocations(sqlreader);
    
    public View_publicphotolocations_usecases() {
        this(false);
    }
    
    public View_publicphotolocations_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_publicphotolocations.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_publicphotolocations> get_all() throws DBException {
        return blview_publicphotolocations.getView_publicphotolocationss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

