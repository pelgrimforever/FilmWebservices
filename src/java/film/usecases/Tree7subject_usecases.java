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
import film.logicentity.Tree7subject;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Tree7subject_usecases {

    private boolean loggedin = false;
    private BLtree7subject bltree7subject = new BLtree7subject();
    
    public Tree7subject_usecases() {
        this(false);
    }
    
    public Tree7subject_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltree7subject.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Tree7subject> get_all_4_step1() throws DBException {
        return bltree7subject.getAllStep1();
    }

    public ArrayList<Tree7subject> get_most_used() throws DBException {
        return bltree7subject.getMostUsed();
    }

    public ArrayList<Tree7subject> get_children_4_parent(ITree7subjectPK tree7subjectPK) throws DBException, CustomException {
        return bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectPK);
    }

    public ArrayList<Tree7subject> searchtext(String searchtext) throws DBException, CustomException {
        return bltree7subject.searchTree7subject_Subject(searchtext);
    }

    public ArrayList<Tree7subject> subjects4photo(IPhotoPK photoPK) throws DBException, CustomException {
        return bltree7subject.getTree7subjects(photoPK);
    }

    public ArrayList<Tree7subject> subjects4film(IFilmPK filmpk) throws DBException, CustomException {
        return bltree7subject.getTree7subjects(filmpk);
    }

    public void insertTree7subject_in_tree(film.logic.Userprofile userprofile, ITree7subject tree7subject) throws DBException, CustomException {
        bltree7subject.insertTree7subject(userprofile, tree7subject);
    }

    public void update_tree7subject_in_tree(film.logic.Userprofile userprofile, ITree7subject tree7subject) throws DBException, CustomException {
        bltree7subject.updateTree7subject(userprofile, tree7subject);
    }
    public void delete_tree7subject_in_tree(film.logic.Userprofile userprofile, ITree7subject tree7subject) throws DBException, CustomException {
        bltree7subject.deleteTree7subject(userprofile, tree7subject);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltree7subject.count();
    }
    
    public ArrayList<Tree7subject> get_all() throws DBException {
        return bltree7subject.getTree7subjects();
    }
    
    public boolean getTree7subjectExists(ITree7subjectPK tree7subjectPK) throws DBException {
        return bltree7subject.getEntityExists(tree7subjectPK);
    }
    
    public Tree7subject get_tree7subject_by_primarykey(ITree7subjectPK tree7subjectPK) throws DBException {
        return bltree7subject.getTree7subject(tree7subjectPK);
    }

    public ArrayList<Tree7subject> get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(ITree7subjectPK tree7subjectParentsubjectidPK) throws CustomException {
        return bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK);
    }
    
    public Tree7subject get_tree7subject_with_externalforeignkey_phototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        return bltree7subject.getPhototree7subject(phototree7subjectPK);
    }
    
    public ArrayList<Tree7subject> search_tree7subject(ITree7subjectsearch tree7subjectsearch) throws CustomException {
        return bltree7subject.search(tree7subjectsearch);
    }
    
    public long search_tree7subject_count(ITree7subjectsearch tree7subjectsearch) throws CustomException {
        return bltree7subject.searchcount(tree7subjectsearch);
    }

    public void secureinsertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        bltree7subject.secureinsertTree7subject(tree7subject);
    }

    public void secureupdateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        bltree7subject.secureupdateTree7subject(tree7subject);
    }

    public void securedeleteTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        bltree7subject.securedeleteTree7subject(tree7subject);
    }
}

