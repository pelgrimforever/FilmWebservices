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
import film.logicentity.Art_subgroup;
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
public class Art_subgroup_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLart_subgroup blart_subgroup = new BLart_subgroup(sqlreader);
    
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
        return blart_subgroup.getArt_subgroupExists(art_subgroupPK);
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

    public void insertArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_subgroup.insertArt_subgroup(tq, art_subgroup);
        sqlwriter.Commit2DB(tq);
    }

    public void updateArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_subgroup.updateArt_subgroup(tq, art_subgroup);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteArt_subgroup(IArt_subgroup art_subgroup) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_subgroup.deleteArt_subgroup(tq, art_subgroup);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Art_group(IArt_groupPK art_groupPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blart_subgroup.delete4art_group(tq, art_groupPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

