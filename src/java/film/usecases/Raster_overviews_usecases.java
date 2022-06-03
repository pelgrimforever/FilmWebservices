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
import film.logicview.Raster_overviews;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Raster_overviews_usecases {

    private boolean loggedin = false;
    private BLraster_overviews blraster_overviews = new BLraster_overviews();
    
    public Raster_overviews_usecases() {
        this(false);
    }
    
    public Raster_overviews_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blraster_overviews.setAuthenticated(loggedin);
    }
    
    public ArrayList<Raster_overviews> get_all() throws DBException {
        return blraster_overviews.getRaster_overviewss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

