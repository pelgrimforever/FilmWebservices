/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

@WebServlet(name="Tree7subject_update", urlPatterns={"/film.Tree7subject_update"})
public class Tree7subject_update extends SecurityDataServlet {
   
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
                case ITree7subjectOperation.UPDATE_TREE7SUBJECT:
                    update_tree7subject(tree7subjectusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ITree7subjectOperation.UPDATE_SUBJECT:
                    update_tree7subject_in_tree(tree7subjectusecases);
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
    private void update_tree7subject_in_tree(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subject tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
        tree7subjectusecases.update_tree7subject_in_tree(userprofile, tree7subject);
    }
//Custom code, do not change this line   

    private void update_tree7subject(Tree7subject_usecases tree7subjectusecases) throws CustomException {
        ITree7subject tree7subject = (ITree7subject)parser.getJavaObject("tree7subject");
        tree7subjectusecases.updateTree7subject(tree7subject);
    }
    
    @Override
    public String getServletInfo() {
        return "tree7subject_insert";
    }

}

