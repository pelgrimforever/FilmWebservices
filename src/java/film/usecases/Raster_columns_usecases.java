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

public class Raster_columns_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLraster_columns blraster_columns = new BLraster_columns(sqlreader);
    
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

