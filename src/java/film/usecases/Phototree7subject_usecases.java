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
import film.logicentity.Phototree7subject;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Phototree7subject_usecases {

    private boolean loggedin = false;
    private BLphototree7subject blphototree7subject = new BLphototree7subject();
    
    public Phototree7subject_usecases() {
        this(false);
    }
    
    public Phototree7subject_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphototree7subject.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<ITree7subject> get_phototree7subject_from_photo(IPhotoPK photopk) throws DBException {
        BLtree7subject bltree7subject = new BLtree7subject();
        bltree7subject.setAuthenticated(loggedin);
        return bltree7subject.getTree7subjects(photopk);
    }

    public ArrayList<Phototree7subject> insert_phototree7subject_get_phototree7subject_with_foreignkey_photo(IPhototree7subject phototree7subject) throws DBException, CustomException {
        blphototree7subject.insertPhototree7subject(phototree7subject);
        IPhotoPK photopk = phototree7subject.getPrimaryKey().getPhotoPK();
        return blphototree7subject.getPhototree7subjects4photo(photopk);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphototree7subject.count();
    }
    
    public ArrayList<Phototree7subject> get_all() throws DBException {
        return blphototree7subject.getPhototree7subjects();
    }
    
    public boolean getPhototree7subjectExists(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return blphototree7subject.getEntityExists(phototree7subjectPK);
    }
    
    public Phototree7subject get_phototree7subject_by_primarykey(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return blphototree7subject.getPhototree7subject(phototree7subjectPK);
    }

    public ArrayList<Phototree7subject> get_phototree7subject_with_foreignkey_tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK);
    }
    
    public ArrayList<Phototree7subject> get_phototree7subject_with_foreignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blphototree7subject.getPhototree7subjects4photo(photoPK);
    }
    
    public ArrayList<Phototree7subject> search_phototree7subject(IPhototree7subjectsearch phototree7subjectsearch) throws CustomException {
        return blphototree7subject.search(phototree7subjectsearch);
    }
    
    public long search_phototree7subject_count(IPhototree7subjectsearch phototree7subjectsearch) throws CustomException {
        return blphototree7subject.searchcount(phototree7subjectsearch);
    }

    public void secureinsertPhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        blphototree7subject.secureinsertPhototree7subject(phototree7subject);
    }

    public void secureupdatePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        blphototree7subject.secureupdatePhototree7subject(phototree7subject);
    }

    public void securedeletePhototree7subject(IPhototree7subject phototree7subject) throws DBException, DataException {
        blphototree7subject.securedeletePhototree7subject(phototree7subject);
    }
}

