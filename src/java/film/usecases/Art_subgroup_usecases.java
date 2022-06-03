/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Art_subgroup;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Art_subgroup_usecases {

    private boolean loggedin = false;
    private BLart_subgroup blart_subgroup = new BLart_subgroup();
    
    public Art_subgroup_usecases() {
        this(false);
    }
    
    public Art_subgroup_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blart_subgroup.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blart_subgroup.count();
    }
    
    public ArrayList<Art_subgroup> get_all() throws DBException {
        return blart_subgroup.getArt_subgroups();
    }
    
    public boolean getArt_subgroupExists(IArt_subgroupPK art_subgroupPK) throws DBException {
        return blart_subgroup.getEntityExists(art_subgroupPK);
    }
    
    public Art_subgroup get_art_subgroup_by_primarykey(IArt_subgroupPK art_subgroupPK) throws DBException {
        return blart_subgroup.getArt_subgroup(art_subgroupPK);
    }

    public ArrayList<Art_subgroup> get_art_subgroup_with_foreignkey_art_group(IArt_groupPK art_groupPK) throws CustomException {
        return blart_subgroup.getArt_subgroups4art_group(art_groupPK);
    }
    
    public ArrayList<Art_subgroup> search_art_subgroup(IArt_subgroupsearch art_subgroupsearch) throws CustomException {
        return blart_subgroup.search(art_subgroupsearch);
    }
    
    public long search_art_subgroup_count(IArt_subgroupsearch art_subgroupsearch) throws CustomException {
        return blart_subgroup.searchcount(art_subgroupsearch);
    }

    public void secureinsertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        blart_subgroup.secureinsertArt_subgroup(art_subgroup);
    }

    public void secureupdateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        blart_subgroup.secureupdateArt_subgroup(art_subgroup);
    }

    public void securedeleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        blart_subgroup.securedeleteArt_subgroup(art_subgroup);
    }
}

