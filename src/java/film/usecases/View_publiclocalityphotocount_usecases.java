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
import film.logicview.View_publiclocalityphotocount;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_publiclocalityphotocount_usecases {

    private boolean loggedin = false;
    private BLview_publiclocalityphotocount blview_publiclocalityphotocount = new BLview_publiclocalityphotocount();
    
    public View_publiclocalityphotocount_usecases() {
        this(false);
    }
    
    public View_publiclocalityphotocount_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_publiclocalityphotocount.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_publiclocalityphotocount> get_all() throws DBException {
        return blview_publiclocalityphotocount.getView_publiclocalityphotocounts();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

