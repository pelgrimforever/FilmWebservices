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
import film.logicentity.Art_photo;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Art_photo_usecases {

    private boolean loggedin = false;
    private BLart_photo blart_photo = new BLart_photo();
    
    public Art_photo_usecases() {
        this(false);
    }
    
    public Art_photo_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blart_photo.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blart_photo.count();
    }
    
    public ArrayList<Art_photo> get_all() throws DBException {
        return blart_photo.getArt_photos();
    }
    
    public boolean getArt_photoExists(IArt_photoPK art_photoPK) throws DBException {
        return blart_photo.getEntityExists(art_photoPK);
    }
    
    public Art_photo get_art_photo_by_primarykey(IArt_photoPK art_photoPK) throws DBException {
        return blart_photo.getArt_photo(art_photoPK);
    }

    public ArrayList<Art_photo> get_art_photo_with_foreignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blart_photo.getArt_photos4photo(photoPK);
    }
    
    public ArrayList<Art_photo> get_art_photo_with_foreignkey_art_subgroup(IArt_subgroupPK art_subgroupPK) throws CustomException {
        return blart_photo.getArt_photos4art_subgroup(art_subgroupPK);
    }
    
    public ArrayList<Art_photo> get_art_photo_with_foreignkey_art_academy(IArt_academyPK art_academyPK) throws CustomException {
        return blart_photo.getArt_photos4art_academy(art_academyPK);
    }
    
    public ArrayList<Art_photo> get_art_photo_with_foreignkey_art_group(IArt_groupPK art_groupPK) throws CustomException {
        return blart_photo.getArt_photos4art_group(art_groupPK);
    }
    
    public ArrayList<Art_photo> search_art_photo(IArt_photosearch art_photosearch) throws CustomException {
        return blart_photo.search(art_photosearch);
    }
    
    public long search_art_photo_count(IArt_photosearch art_photosearch) throws CustomException {
        return blart_photo.searchcount(art_photosearch);
    }

    public void secureinsertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        blart_photo.secureinsertArt_photo(art_photo);
    }

    public void secureupdateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        blart_photo.secureupdateArt_photo(art_photo);
    }

    public void securedeleteArt_photo(IArt_photo art_photo) throws DBException, DataException {
        blart_photo.securedeleteArt_photo(art_photo);
    }
}

