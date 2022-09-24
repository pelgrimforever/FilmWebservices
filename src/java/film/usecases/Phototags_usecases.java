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
import film.logicentity.Phototags;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Phototags_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLphototags blphototags = new BLphototags(sqlreader);
    
    public Phototags_usecases() {
        this(false);
    }
    
    public Phototags_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphototags.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList getPhototagss4photo(IPhotoPK photoPK) throws CustomException {
        return blphototags.getPhototagss4photo(photoPK);
    }
    
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphototags.count();
    }
    
    public ArrayList<Phototags> get_all() throws DBException {
        return blphototags.getPhototagss();
    }
    
    public boolean getPhototagsExists(IPhototagsPK phototagsPK) throws DBException {
        return blphototags.getPhototagsExists(phototagsPK);
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

    public void insertPhototags(IPhototags phototags) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototags.insertPhototags(tq, phototags);
        sqlwriter.Commit2DB(tq);
    }

    public void updatePhototags(IPhototags phototags) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototags.updatePhototags(tq, phototags);
        sqlwriter.Commit2DB(tq);
    }

    public void deletePhototags(IPhototags phototags) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphototags.deletePhototags(tq, phototags);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Photo(IPhotoPK photoPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphototags.delete4photo(tq, photoPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

