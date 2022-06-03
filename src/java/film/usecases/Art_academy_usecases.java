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
import film.logicentity.Art_academy;
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
    private BLart_academy blart_academy = new BLart_academy();
    
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
        return blart_academy.getEntityExists(art_academyPK);
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

    public void secureinsertArt_academy(IArt_academy art_academy) throws DBException, DataException {
        blart_academy.secureinsertArt_academy(art_academy);
    }

    public void secureupdateArt_academy(IArt_academy art_academy) throws DBException, DataException {
        blart_academy.secureupdateArt_academy(art_academy);
    }

    public void securedeleteArt_academy(IArt_academy art_academy) throws DBException, DataException {
        blart_academy.securedeleteArt_academy(art_academy);
    }
}

