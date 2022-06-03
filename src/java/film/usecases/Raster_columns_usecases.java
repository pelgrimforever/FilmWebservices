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
import film.logicview.Raster_columns;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Raster_columns_usecases {

    private boolean loggedin = false;
    private BLraster_columns blraster_columns = new BLraster_columns();
    
    public Raster_columns_usecases() {
        this(false);
    }
    
    public Raster_columns_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blraster_columns.setAuthenticated(loggedin);
    }
    
    public ArrayList<Raster_columns> get_all() throws DBException {
        return blraster_columns.getRaster_columnss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

