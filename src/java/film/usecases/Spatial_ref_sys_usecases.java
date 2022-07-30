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
import film.logicentity.Spatial_ref_sys;
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
public class Spatial_ref_sys_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys(sqlreader);
    
    public Spatial_ref_sys_usecases() {
        this(false);
    }
    
    public Spatial_ref_sys_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blspatial_ref_sys.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blspatial_ref_sys.count();
    }
    
    public ArrayList<Spatial_ref_sys> get_all() throws DBException {
        return blspatial_ref_sys.getSpatial_ref_syss();
    }
    
    public boolean getSpatial_ref_sysExists(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return blspatial_ref_sys.getSpatial_ref_sysExists(spatial_ref_sysPK);
    }
    
    public Spatial_ref_sys get_spatial_ref_sys_by_primarykey(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK);
    }

    public ArrayList<Spatial_ref_sys> search_spatial_ref_sys(ISpatial_ref_syssearch spatial_ref_syssearch) throws CustomException {
        return blspatial_ref_sys.search(spatial_ref_syssearch);
    }
    
    public long search_spatial_ref_sys_count(ISpatial_ref_syssearch spatial_ref_syssearch) throws CustomException {
        return blspatial_ref_sys.searchcount(spatial_ref_syssearch);
    }

    public void insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blspatial_ref_sys.insertSpatial_ref_sys(tq, spatial_ref_sys);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blspatial_ref_sys.updateSpatial_ref_sys(tq, spatial_ref_sys);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blspatial_ref_sys.deleteSpatial_ref_sys(tq, spatial_ref_sys);
        sqlwriter.Commit2DB(tq);
    }

}

