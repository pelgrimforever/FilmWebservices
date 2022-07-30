/*
 * Generated on 27.6.2022 16:45
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Uploadsessionsettings;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Uploadsessionsettings_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings(sqlreader);
    
    public Uploadsessionsettings_usecases() {
        this(false);
    }
    
    public Uploadsessionsettings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bluploadsessionsettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void deleteall() throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsessionsettings.deleteall(tq, "Uploadsessionsettings_usecases.deleteall");
        sqlwriter.Commit2DB(tq);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bluploadsessionsettings.count();
    }
    
    public ArrayList<Uploadsessionsettings> get_all() throws DBException {
        return bluploadsessionsettings.getUploadsessionsettingss();
    }
    
    public boolean getUploadsessionsettingsExists(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return bluploadsessionsettings.getUploadsessionsettingsExists(uploadsessionsettingsPK);
    }
    
    public Uploadsessionsettings get_uploadsessionsettings_by_primarykey(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
    }

    public ArrayList<Uploadsessionsettings> search_uploadsessionsettings(IUploadsessionsettingssearch uploadsessionsettingssearch) throws CustomException {
        return bluploadsessionsettings.search(uploadsessionsettingssearch);
    }
    
    public long search_uploadsessionsettings_count(IUploadsessionsettingssearch uploadsessionsettingssearch) throws CustomException {
        return bluploadsessionsettings.searchcount(uploadsessionsettingssearch);
    }

    public void insertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsessionsettings.insertUploadsessionsettings(tq, uploadsessionsettings);
        sqlwriter.Commit2DB(tq);
    }

    public void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsessionsettings.updateUploadsessionsettings(tq, uploadsessionsettings);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bluploadsessionsettings.deleteUploadsessionsettings(tq, uploadsessionsettings);
        sqlwriter.Commit2DB(tq);
    }

}

