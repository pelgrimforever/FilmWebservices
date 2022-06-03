/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.tree7subject;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ITree7subject;
import film.interfaces.servlet.ITree7subjectOperation;
import film.interfaces.searchentity.ITree7subjectsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Tree7subject_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Tree7subject_select", urlPatterns={"/film.Tree7subject_select"})
public class Tree7subject_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITree7subjectOperation.SELECT_ALL:
                    dataobject = tree7subjectusecases.get_all();
                    break;
                case ITree7subjectOperation.SELECT_TREE7SUBJECT:
                    dataobject = get_tree7subject_with_primarykey(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_Tree7subjectparentsubjectid:
                    dataobject = get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_Phototree7subject:
                    dataobject = get_tree7subject_with_externalforeignkey_phototree7subject(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_SEARCH:
                    dataobject = search_tree7subject(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_tree7subject_count(tree7subjectusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ITree7subjectOperation.SELECT_STEP1:
                    dataobject = tree7subjectusecases.get_all_4_step1();
                    break;
                case ITree7subjectOperation.SELECT_MOSTUSED:
                    dataobject = tree7subjectusecases.get_most_used();
                    break;
                case ITree7subjectOperation.SELECT_CHILDREN4PARENT:
                    dataobject = get_children_4_parent(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_SEARCHTEXT:
                    dataobject = searchtext(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_PHOTOPK:
                    dataobject = subjects4photo(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_FILMPK:
                    dataobject = subjects4film(tree7subjectusecases);
                    break;
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
    private Object get_children_4_parent(Tree7subject_usecases tree7subjectusecases) throws DBException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
        return tree7subjectusecases.get_children_4_parent(tree7subjectPK);
    }

    private Object searchtext(Tree7subject_usecases tree7subjectusecases) throws DBException, CustomException {
        String searchtext = (String)parser.getJavaObject("searchtext");
        return tree7subjectusecases.searchtext(searchtext);
    }

    private Object subjects4photo(Tree7subject_usecases tree7subjectusecases) throws DBException, CustomException {
        IPhotoPK photopk = (IPhotoPK)parser.getJavaObject("photopk");
        return tree7subjectusecases.subjects4photo(photopk);
    }

    private Object subjects4film(Tree7subject_usecases tree7subjectusecases) throws DBException, CustomException {
        IFilmPK filmpk = (IFilmPK)parser.getJavaObject("filmpk");
        return tree7subjectusecases.subjects4film(filmpk);
    }
//Custom code, do not change this line   

    private Object get_tree7subject_with_primarykey(Tree7subject_usecases tree7subjectusecases) throws DBException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
        return tree7subjectusecases.get_tree7subject_by_primarykey(tree7subjectPK);
    }

    private Object get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
        return tree7subjectusecases.get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectParentsubjectidPK);
    }
    
    private Object get_tree7subject_with_externalforeignkey_phototree7subject(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
        return tree7subjectusecases.get_tree7subject_with_externalforeignkey_phototree7subject(phototree7subjectPK);
    }
    
    private Object search_tree7subject(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subjectsearch search = (ITree7subjectsearch)parser.getJavaObject("search");
        return tree7subjectusecases.search_tree7subject(search);
    }
    
    private Object search_tree7subject_count(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)parser.getJavaObject("search");
        return tree7subjectusecases.search_tree7subject_count(tree7subjectsearch);
    }

    @Override
    public String getServletInfo() {
        return "tree7subject_select";
    }

}

