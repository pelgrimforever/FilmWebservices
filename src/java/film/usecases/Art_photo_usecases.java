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
import film.logicentity.Art_photo;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Art_photo_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLart_photo blart_photo = new BLart_photo(sqlreader);
    
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
        return blart_photo.getArt_photoExists(art_photoPK);
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

    public void insertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.insertArt_photo(tq, art_photo);
        sqlwriter.Commit2DB(tq);
    }

    public void updateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.updateArt_photo(tq, art_photo);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteArt_photo(IArt_photo art_photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.deleteArt_photo(tq, art_photo);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Photo(IPhotoPK photoPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.delete4photo(tq, photoPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Art_subgroup(IArt_subgroupPK art_subgroupPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.delete4art_subgroup(tq, art_subgroupPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Art_academy(IArt_academyPK art_academyPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.delete4art_academy(tq, art_academyPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Art_group(IArt_groupPK art_groupPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blart_photo.delete4art_group(tq, art_groupPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

