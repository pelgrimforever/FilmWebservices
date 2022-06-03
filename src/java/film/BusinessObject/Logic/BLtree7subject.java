/*
 * BLtree7subject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import film.interfaces.logicentity.ITree7subject;
import film.logicentity.Tree7subject;
import film.BusinessObject.table.Btree7subject;
import film.conversion.entity.EMtree7subject;
import film.entity.pk.Tree7subjectPK;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.entity.pk.ITree7subjectPK;
import film.logic.Userprofile;
import film.searchentity.Filmsearch;
import film.searchentity.Photosearch;
import film.searchentity.Tree7subjectsearch;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLtree7subject
 *
 * Class for manipulating data- and database objects
 * for Entity Tree7subject and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtree7subject extends Btree7subject {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Tree7subject as default Entity
     */
    public BLtree7subject() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Tree7subject as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtree7subject(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * get all items at top level (step = 1)
     * @return ArrayList of Subjects
     * @throws DBException
     */
    public ArrayList getAllStep1() throws DBException {
        return this.getEntities(EMtree7subject.SQLSelect4tree7subject_step1);
    }

    /**
     * get most used subjects
     * @return Arraylist of 20 most used subjects
     * @throws DBException 
     */
    public ArrayList getMostUsed() throws DBException {
        return addParents2Tree7subjects(this.getEntities(EMtree7subject.SQLSelectMostused));
    }
    
    /**
     * get all Tree7subjects linked to photo
     * @param photoPK: Photo primary key
     * @return ArrayList of Tree7subject objects
     * @throws DBException
     */
    public ArrayList getTree7subjects(IPhotoPK photoPK) throws DBException {
        Tree7subjectsearch search = new Tree7subjectsearch();
        Photosearch photosearch = new Photosearch();
        photosearch.addPrimarykey(photoPK);
        search.relphoto(photosearch);
        String orderby = Tree7subject.fieldnames[Tree7subject.TREE7ID-1];
        return addParents2Tree7subjects(super.search(search, orderby));
    }

    /**
     * get all Tree7subjects linked to film
     * @param filmPK: Film primary key
     * @return ArrayList of Tree7subject objects
     * @throws DBException
     */
    public ArrayList getTree7subjects(IFilmPK filmPK) throws DBException {
        Tree7subjectsearch search = new Tree7subjectsearch();
        Filmsearch filmsearch = new Filmsearch();
        filmsearch.addPrimarykey(filmPK);
        Photosearch photosearch = new Photosearch();
        photosearch.film(filmsearch);
        search.relphoto(photosearch);
        String orderby = Tree7subject.fieldnames[Tree7subject.TREE7ID-1];
        String sqlorderby = " order by " + orderby;
        search.build("");
        String searchsql = "select distinct tree7subject.* from tree7subject" + search.getJoin() + " where " + search.getSql() + sqlorderby;
        ArrayList result = this.getEntities(searchsql, search.getParameters());
        return addParents2Tree7subjects(result);
    }

    public ArrayList getTree7subjects(ArrayList tree7subjectpks) throws DBException {
        ArrayList tree7subjects = new ArrayList();
        for(int i=0; i<tree7subjectpks.size(); i++) {
            tree7subjects.add(getTree7subject((Tree7subjectPK)tree7subjectpks.get(i)));
        }
        return tree7subjects;
    }

    /**
     * Add the Parents to the list of Tree7subjects
     * @param tree7subjects: ArrayList of Tree7subjects
     * @return the given ArrayList of Tree7subjects with parents attached
     * @throws DBException
     */
    private ArrayList addParents2Tree7subjects(ArrayList tree7subjects) throws DBException {
        Tree7subject subject;
        for(int i=0; i<tree7subjects.size(); i++) {
            subject = (Tree7subject)tree7subjects.get(i);
            subject.setParents(getParentlist((ITree7subject)subject));
        }
        return tree7subjects;
    }

    /**
     * 
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Tree7subject Entity objects for Tree7subject
     * @throws general.exception.CustomException
     */
    @Override
    public ArrayList getTree7subjects4tree7subjectParentsubjectid(ITree7subjectPK tree7subjectPK) throws CustomException {
        return addParents2Tree7subjects(this.getEntities(EMtree7subject.SQLSelect4parent, tree7subjectPK.getSQLprimarykey()));
    }
    
    /**
     * get all children from tree where parent has tree7id (excluding the parent)
     * @param tree7id: tree7id
     * @return ArrayList of Tree7subject entities
     * @throws DBException 
     */
    public ArrayList getTree7subjects4Tree7id(String tree7id) throws DBException {
        Object[][] parameter = { { "liketree7id", tree7id + ":*:" }, { "tree7id", tree7id } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMtree7subject.SQLSelectchildren4tree7id, parameters);
    }

    /**
     * search all Tree7subjects that contains subjecttext
     * order by tree7id, include parent list in each Tree7subject
     * @param subjecttext: search text
     * @return ArrayList of Tree7subjects
     * @throws DBException
     */
    public ArrayList searchTree7subject_Subject(String subjecttext) throws DBException {
        Tree7subjectsearch search = new Tree7subjectsearch();
        String[] values = { ":*:" + subjecttext + ":*:" };
        search.subject(values);
        searchtree7subjects(search);
        String orderby = ITree7subject.fieldnames[ITree7subject.TREE7ID-1];
        log.fine("BLtree7subject.searchTree7subject_Subject order by " + orderby);
        return this.addParents2Tree7subjects(searchtree7subjects(search, orderby));
    }

    /**
     * get parent list of subject, sorted by tree7id (top parent first)
     * @param tree7subject: tree7subject
     * @return ArrayList of tree7subject entities
     * @throws DBException
     */
    public ArrayList getParentlist(ITree7subject tree7subject) throws DBException {
        Tree7subjectsearch search = new Tree7subjectsearch();
        String[] values = new String[tree7subject.getTreestep() - 1];
        for(int i=0; i<tree7subject.getTreestep() - 1; i++) {
            values[i] = tree7subject.getTree7id().substring(0, i+1);
        }
        search.tree7id(values, search.EQUAL, search.OR);
        String orderby = ITree7subject.fieldnames[ITree7subject.TREE7ID-1];
        return this.searchtree7subjects(search, orderby);
    }

    /**
     * no insert without authorisation
     * @param tree7subject
     * @throws DBException
     * @throws DataException
     */
    @Override
    public void insertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
    }

    /**
     * no insert without authorisation
     * @param tree7subject
     * @throws DBException
     * @throws DataException
     */
    public void secureinsertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
    }

    /**
     * try to insert Tree7subject object in database
     * commit transaction
     * @param userprofile
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void insertTree7subject(Userprofile userprofile, ITree7subject tree7subject) throws DBException, DataException, CustomException {
        if(userprofile.isEditor()) {
            tree7subject.getPrimaryKey().setSubjectid(super.ConstructUID());
            if(tree7subject.getTree7subjectparentsubjectidPK()==null) {
                //Put on top of the tree
                tree7subject.setTree7subjectparentsubjectidPK((Tree7subjectPK)tree7subject.getPrimaryKey());
                tree7subject.setTreestep(1);
                ArrayList steps1 = getAllStep1();
                //only 7 items are allowed on 1 treelevel
                if(steps1.size()<7) {
                    tree7subject.setTree7id(String.valueOf(getFreeTree7id(steps1)));
                } else {
                    throw new DataException("Tree 7 rule, not allowed");
                }
            } else {
                //put into tree
                updateTreeparameters(tree7subject);
            }
            trans_insertTree7subject(tree7subject);
            super.Commit2DB();
        }
    }
    
    private int getFreeTree7id(ArrayList children) {
        Tree7subject subject;
        int freestep = 1;
        boolean[] stepnumbers = { true, true, true, true, true, true, true };
        for(int i=0; i<children.size(); i++) {
            subject = (Tree7subject)children.get(i);
            String treeid = subject.getTree7id();
            String subid = treeid.substring(treeid.length()-1);
            stepnumbers[Integer.valueOf(subid)-1] = false;
        }
        for(int step=0; step<7; step++) {
            if(stepnumbers[step]) {
                freestep = step+1;
                break;
            }
        }
        return freestep;
    }

    /**
     * Update Tree7 functional dependent parameters with a given ParentID
     * @param tree7subject: Tree7subject to be written to database
     * @return tree7id updated flag (true = id is changed)
     * @throws DBException
     * @throws CustomException 
     */
    private boolean updateTreeparameters(ITree7subject tree7subject) throws DBException, DataException, CustomException {
        //get parent
        Tree7subject parent = this.getTree7subject(tree7subject.getTree7subjectparentsubjectidPK());
        //check if an unvalid parent is choosen, raise DateException if that is the case
        if(tree7subject.getTreestep()>0) { //tree7id has a value
            if(parent.getTreestep()>tree7subject.getTreestep()) {
                //parent is at a lower level then updated subject
                //check if parent is not a child of tree7subject and would cause a loop
                if(parent.getTree7id().startsWith(tree7subject.getTree7id())) {
                    throw new DataException("No tree loops allowed. Parent id: " + parent.getTree7id() + ", Child id: " + tree7subject.getTree7id());
                }
            }
        }
        //check if tree is filled and has right format
        String tree7id = tree7subject.getTree7id();
        Boolean tree7idcorrect = false;
        if(tree7id!=null) {
            tree7idcorrect = tree7id.startsWith(parent.getTree7id()) && tree7id.length()==parent.getTree7id().length()+1;
        }
        //put into tree
        if(!tree7idcorrect) {
            ArrayList children = this.getTree7subjects4tree7subjectParentsubjectid(tree7subject.getTree7subjectparentsubjectidPK());
            tree7subject.setTree7subjectparentsubjectidPK(parent.getPrimaryKey());
            tree7subject.setTreestep(parent.getTreestep()+1);
            if(children.size()==0) {
                tree7subject.setTree7id(parent.getTree7id() + "1");
            } else if(children.size()>6) {
                throw new DataException("Tree 7 rule, not allowed");
            } else {
                String stepnumber = String.valueOf(getFreeTree7id(children));
                if(parent.getPrimaryKey().getSubjectid()==tree7subject.getPrimaryKey().getSubjectid()) {
                    tree7subject.setTree7id(String.valueOf(stepnumber));
                } else {
                    tree7subject.setTree7id(parent.getTree7id() + stepnumber);
                }
            }
        }
        return !tree7idcorrect;
    }

    /**
     * no update without authorisation
     * @param tree7subject
     * @throws DBException
     * @throws DataException
     */
    @Override
    public void updateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
    }

    /**
     * no update without authorisation
     * @param tree7subject
     * @throws DBException
     * @throws DataException
     */
    public void secureupdateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
    }
    
    /**
     * try to update Tree7subject object in database
     * commit transaction
     * @param userprofile
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void updateTree7subject(Userprofile userprofile, ITree7subject tree7subject) throws DBException, DataException, CustomException {
        if(userprofile.isEditor()) {
            boolean tree7idchanged = updateTreeparameters(tree7subject);
            trans_updateTree7subject(tree7subject);
            //update children tree7 parameters if subject has moved in the tree
            if(tree7idchanged) {
                //get original subject
                Tree7subject original = this.getTree7subject(tree7subject.getPrimaryKey());
                String originalparenttreeid = original.getTree7id();
                int idlength = originalparenttreeid.length();
                //get subject subtree
                String parenttree7id = tree7subject.getTree7id();
                Tree7subject subject;
                ArrayList subtree = getTree7subjects4Tree7id(originalparenttreeid);
                String newtree7id;
                for(int s=0; s<subtree.size(); s++) {
                    subject = (Tree7subject)subtree.get(s);
                    newtree7id = parenttree7id + subject.getTree7id().substring(idlength);
                    subject.setTree7id(newtree7id);
                    trans_updateTree7subject(subject);
                }
            }
            super.Commit2DB();
        }
    }

    /**
     * no delete without authorisation
     * @param tree7subject
     * @throws DBException
     */
    @Override
    public void deleteTree7subject(ITree7subject tree7subject) throws DBException {
    }

    /**
     * no delete without authorisation
     * @param tree7subject
     * @throws DBException
     */
    public void securedeleteTree7subject(ITree7subject tree7subject) throws DBException {
    }

    /**
     * try to delete Tree7subject object in database
     * commit transaction
     * @param userprofile
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     */
    public void deleteTree7subject(Userprofile userprofile, ITree7subject tree7subject) throws DBException {
        if(userprofile.isEditor()) {
            trans_deleteTree7subject(tree7subject);
            super.Commit2DB();
        }
    }

    /**
     * try to insert Tree7subject object in database
     * do not commit transaction
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        super.checkDATA(tree7subject);
        super.insertTree7subject((Tree7subject)tree7subject);
    }
    
    /**
     * try to update Tree7subject object in database
     * do not commit transaction
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateTree7subject(ITree7subject tree7subject) throws DBException, DataException {
        super.checkDATA(tree7subject);
        super.updateTree7subject((Tree7subject)tree7subject);
    }
    
    /**
     * try to delete Tree7subject object in database
     * do not commit transaction
     * @param tree7subject: Tree7subject Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteTree7subject(ITree7subject tree7subject) throws DBException {
        super.deleteTree7subject((Tree7subject)tree7subject);
    }
}
