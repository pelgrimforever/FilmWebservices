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
import film.logicentity.Art_group;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Art_group_usecases {

    private boolean loggedin = false;
    private BLart_group blart_group = new BLart_group();
    
    public Art_group_usecases() {
        this(false);
    }
    
    public Art_group_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blart_group.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blart_group.count();
    }
    
    public ArrayList<Art_group> get_all() throws DBException {
        return blart_group.getArt_groups();
    }
    
    public boolean getArt_groupExists(IArt_groupPK art_groupPK) throws DBException {
        return blart_group.getEntityExists(art_groupPK);
    }
    
    public Art_group get_art_group_by_primarykey(IArt_groupPK art_groupPK) throws DBException {
        return blart_group.getArt_group(art_groupPK);
    }

    public ArrayList<Art_group> search_art_group(IArt_groupsearch art_groupsearch) throws CustomException {
        return blart_group.search(art_groupsearch);
    }
    
    public long search_art_group_count(IArt_groupsearch art_groupsearch) throws CustomException {
        return blart_group.searchcount(art_groupsearch);
    }

    public void secureinsertArt_group(IArt_group art_group) throws DBException, DataException {
        blart_group.secureinsertArt_group(art_group);
    }

    public void secureupdateArt_group(IArt_group art_group) throws DBException, DataException {
        blart_group.secureupdateArt_group(art_group);
    }

    public void securedeleteArt_group(IArt_group art_group) throws DBException, DataException {
        blart_group.securedeleteArt_group(art_group);
    }
}

