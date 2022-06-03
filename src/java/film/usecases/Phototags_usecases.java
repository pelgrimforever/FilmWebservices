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
import film.logicentity.Phototags;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Phototags_usecases {

    private boolean loggedin = false;
    private BLphototags blphototags = new BLphototags();
    
    public Phototags_usecases() {
        this(false);
    }
    
    public Phototags_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphototags.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphototags.count();
    }
    
    public ArrayList<Phototags> get_all() throws DBException {
        return blphototags.getPhototagss();
    }
    
    public boolean getPhototagsExists(IPhototagsPK phototagsPK) throws DBException {
        return blphototags.getEntityExists(phototagsPK);
    }
    
    public Phototags get_phototags_by_primarykey(IPhototagsPK phototagsPK) throws DBException {
        return blphototags.getPhototags(phototagsPK);
    }

    public ArrayList<Phototags> get_phototags_with_foreignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blphototags.getPhototagss4photo(photoPK);
    }
    
    public ArrayList<Phototags> search_phototags(IPhototagssearch phototagssearch) throws CustomException {
        return blphototags.search(phototagssearch);
    }
    
    public long search_phototags_count(IPhototagssearch phototagssearch) throws CustomException {
        return blphototags.searchcount(phototagssearch);
    }

    public void secureinsertPhototags(IPhototags phototags) throws DBException, DataException {
        blphototags.secureinsertPhototags(phototags);
    }

    public void secureupdatePhototags(IPhototags phototags) throws DBException, DataException {
        blphototags.secureupdatePhototags(phototags);
    }

    public void securedeletePhototags(IPhototags phototags) throws DBException, DataException {
        blphototags.securedeletePhototags(phototags);
    }
}

