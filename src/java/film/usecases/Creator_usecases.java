/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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
import film.logicentity.Creator;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Creator_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLcreator blcreator = new BLcreator(sqlreader);
    
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
        return blcreator.getCreatorExists(creatorPK);
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

    public void insertCreator(ICreator creator) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcreator.insertCreator(tq, creator);
        sqlwriter.Commit2DB(tq);
    }

    public void updateCreator(ICreator creator) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcreator.updateCreator(tq, creator);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteCreator(ICreator creator) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcreator.deleteCreator(tq, creator);
        sqlwriter.Commit2DB(tq);
    }

}

