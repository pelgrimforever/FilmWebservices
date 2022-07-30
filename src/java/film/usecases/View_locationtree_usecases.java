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
public class View_locationtree_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_locationtree blview_locationtree = new BLview_locationtree(sqlreader);
    
    public View_locationtree_usecases() {
        this(false);
    }
    
    public View_locationtree_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_locationtree.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_locationtree> get_all() throws DBException {
        return blview_locationtree.getView_locationtrees();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

