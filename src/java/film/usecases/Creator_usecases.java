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
import film.logicentity.Creator;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Creator_usecases {

    private boolean loggedin = false;
    private BLcreator blcreator = new BLcreator();
    
    public Creator_usecases() {
        this(false);
    }
    
    public Creator_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcreator.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcreator.count();
    }
    
    public ArrayList<Creator> get_all() throws DBException {
        return blcreator.getCreators();
    }
    
    public boolean getCreatorExists(ICreatorPK creatorPK) throws DBException {
        return blcreator.getEntityExists(creatorPK);
    }
    
    public Creator get_creator_by_primarykey(ICreatorPK creatorPK) throws DBException {
        return blcreator.getCreator(creatorPK);
    }

    public ArrayList<Creator> search_creator(ICreatorsearch creatorsearch) throws CustomException {
        return blcreator.search(creatorsearch);
    }
    
    public long search_creator_count(ICreatorsearch creatorsearch) throws CustomException {
        return blcreator.searchcount(creatorsearch);
    }

    public void secureinsertCreator(ICreator creator) throws DBException, DataException {
        blcreator.secureinsertCreator(creator);
    }

    public void secureupdateCreator(ICreator creator) throws DBException, DataException {
        blcreator.secureupdateCreator(creator);
    }

    public void securedeleteCreator(ICreator creator) throws DBException, DataException {
        blcreator.securedeleteCreator(creator);
    }
}

