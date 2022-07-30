/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.tree7subject;

import general.exception.CustomException;
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
@WebServlet(name="Tree7subject_delete", urlPatterns={"/film.Tree7subject_delete"})
public class Tree7subject_delete extends SecurityDataServlet {
   
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
                case ITree7subjectOperation.DELETE_TREE7SUBJECT:
                    delete_tree7subject(tree7subjectusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ITree7subjectOperation.DELETE_SUBJECT:
                    delete_tree7subject_in_tree(tree7subjectusecases);
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
    private void delete_tree7subject_in_tree(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subject tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
        tree7subjectusecases.delete_tree7subject_in_tree(userprofile, tree7subject);
    }
//Custom code, do not change this line   

    private void delete_tree7subject(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subject tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
        tree7subjectusecases.deleteTree7subject(tree7subject);
    }
    
    @Override
    public String getServletInfo() {
        return "tree7subject_insert";
    }

}

