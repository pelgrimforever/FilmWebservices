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
import film.logicentity.Art_academy;
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
public class Art_academy_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLart_academy blart_academy = new BLart_academy(sqlreader);
    
    public Art_academy_usecases() {
        this(false);
    }
    
    public Art_academy_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blart_academy.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blart_academy.count();
    }
    
    public ArrayList<Art_academy> get_all() throws DBException {
        return blart_academy.getArt_academys();
    }
    
    public boolean getArt_academyExists(IArt_academyPK art_academyPK) throws DBException {
        return blart_academy.getArt_academyExists(art_academyPK);
    }
    
    public Art_academy get_art_academy_by_primarykey(IArt_academyPK art_academyPK) throws DBException {
        return blart_academy.getArt_academy(art_academyPK);
    }

    public ArrayList<Art_academy> search_art_academy(IArt_academysearch art_academysearch) throws CustomException {
        return blart_academy.search(art_academysearch);
    }
    
    public long search_art_academy_count(IArt_academysearch art_academysearch) throws CustomException {
        return blart_academy.searchcount(art_academysearch);
    }

    public void insertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_academy.insertArt_academy(tq, art_academy);
        sqlwriter.Commit2DB(tq);
    }

    public void updateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_academy.updateArt_academy(tq, art_academy);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteArt_academy(IArt_academy art_academy) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_academy.deleteArt_academy(tq, art_academy);
        sqlwriter.Commit2DB(tq);
    }

}

