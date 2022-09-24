/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMtree7subject;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ITree7subjectsearch;
import film.logicentity.Tree7subject;

public abstract class Btree7subject extends TableBusinessrules {

    public Btree7subject(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMtree7subject()));
    }

    public Btree7subject(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMtree7subject()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ITree7subject newTree7subject() {
    	return new Tree7subject();
    }
    
    public ITree7subject newTree7subject(long subjectid) {
        return new Tree7subject(subjectid);
    }

    public ITree7subject newTree7subject(ITree7subjectPK tree7subjectPK) {
        return new Tree7subject((Tree7subjectPK)tree7subjectPK);
    }

    public ITree7subjectPK newTree7subjectPK() {
        return new Tree7subjectPK();
    }

    public ITree7subjectPK newTree7subjectPK(long subjectid) {
        return new Tree7subjectPK(subjectid);
    }

    public ArrayList<Tree7subject> getTree7subjects() throws DBException {
        return (ArrayList<Tree7subject>)tableio.getEntities(EMtree7subject.SQLSelectAll);
    }

    public Tree7subject getTree7subject(ITree7subjectPK tree7subjectPK) throws DBException {
        return (Tree7subject)tableio.getEntity((Tree7subjectPK)tree7subjectPK);
    }

    public ArrayList<Tree7subject> searchtree7subjects(ITree7subjectsearch search) throws DBException {
        return (ArrayList<Tree7subject>)tableio.search(search);
    }

    public ArrayList<Tree7subject> searchtree7subjects(ITree7subjectsearch search, String orderby) throws DBException {
        return (ArrayList<Tree7subject>)tableio.search(search, orderby);
    }

    public boolean getTree7subjectExists(ITree7subjectPK tree7subjectPK) throws DBException {
        return tableio.getEntityExists((Tree7subjectPK)tree7subjectPK);
    }

    public Tree7subject getEntity(String sql) throws DBException {
        return (Tree7subject)tableio.getEntity(sql);
    }
    
    public Tree7subject getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Tree7subject)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Tree7subject> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Tree7subject> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Tree7subject> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Tree7subject> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertTree7subject(SQLTqueue transactionqueue, ITree7subject tree7subject) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, tree7subject);
    }

    public void insertupdateTree7subject(SQLTqueue transactionqueue, ITree7subject tree7subject) throws DBException, DataException {
    	checkDATA(tree7subject);
        if(this.getTree7subjectExists(tree7subject.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, tree7subject);
        } else {
            tableio.insertEntity(transactionqueue, tree7subject);
        }
    }

    public void updateTree7subject(SQLTqueue transactionqueue, ITree7subject tree7subject) throws DBException, DataException {
    	checkDATA(tree7subject);
        tableio.updateEntity(transactionqueue, tree7subject);
    }

    public void deleteTree7subject(SQLTqueue transactionqueue, ITree7subject tree7subject) throws DBException {
        cascadedeleteTree7subject(transactionqueue, tree7subject.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, tree7subject);
    }

    private void checkDATA(ITree7subject tree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(tree7subject.getTree7id()!=null && tree7subject.getTree7id().length()>ITree7subject.SIZE_TREE7ID) {
            message.append("Tree7id is langer dan toegestaan. Max aantal karakters: ").append(ITree7subject.SIZE_TREE7ID).append("\n");
        }
        if(tree7subject.getTree7id()==null) {
            message.append("Tree7id mag niet leeg zijn.\n");
        }
        if(tree7subject.getSubject()!=null && tree7subject.getSubject().length()>ITree7subject.SIZE_SUBJECT) {
            message.append("Subject is langer dan toegestaan. Max aantal karakters: ").append(ITree7subject.SIZE_SUBJECT).append("\n");
        }
        if(tree7subject.getSubject()==null) {
            message.append("Subject mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteTree7subject(SQLTqueue transactionqueue, ITree7subjectPK tree7subjectPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.setAuthenticated(isAuthenticated());
        blphototree7subject.delete4tree7subject(transactionqueue, tree7subjectPK);
    }

    public void delete4tree7subjectParentsubjectid(SQLTqueue transactionqueue, ITree7subjectPK tree7subjectPK) {
        tableio.addStatement(transactionqueue, EMtree7subject.SQLDelete4tree7subjectParentsubjectid, tree7subjectPK.getSQLprimarykey());
    }

    public ArrayList<Tree7subject> getTree7subjects4tree7subjectParentsubjectid(ITree7subjectPK tree7subjectPK) throws CustomException {
        return tableio.getEntities(EMtree7subject.SQLSelect4tree7subjectParentsubjectid, tree7subjectPK.getSQLprimarykey());
    }
    public Tree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        Tree7subjectPK tree7subjectPK = new Tree7subjectPK(phototree7subjectPK.getSubjectid());
        return this.getTree7subject(tree7subjectPK);
    }


    public ArrayList<Tree7subject> getTree7subjects(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtree7subject.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Tree7subject>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delTree7subject(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tree7subject.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
