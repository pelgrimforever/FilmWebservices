/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMsubjectcat;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISubjectcatsearch;
import film.logicentity.Subjectcat;

/**
 * @author Franky Laseure
 */
public abstract class Bsubjectcat extends TableBusinessrules {

    public Bsubjectcat(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsubjectcat()));
    }

    public Bsubjectcat(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsubjectcat()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISubjectcat newSubjectcat() {
    	return new Subjectcat();
    }
    
    public ISubjectcat newSubjectcat(java.lang.String cat) {
        return new Subjectcat(cat);
    }

    public ISubjectcat newSubjectcat(ISubjectcatPK subjectcatPK) {
        return new Subjectcat((SubjectcatPK)subjectcatPK);
    }

    public ISubjectcatPK newSubjectcatPK() {
        return new SubjectcatPK();
    }

    public ISubjectcatPK newSubjectcatPK(java.lang.String cat) {
        return new SubjectcatPK(cat);
    }

    public ArrayList<Subjectcat> getSubjectcats() throws DBException {
        return (ArrayList<Subjectcat>)tableio.getEntities(EMsubjectcat.SQLSelectAll);
    }

    public Subjectcat getSubjectcat(ISubjectcatPK subjectcatPK) throws DBException {
        return (Subjectcat)tableio.getEntity((SubjectcatPK)subjectcatPK);
    }

    public ArrayList<Subjectcat> searchsubjectcats(ISubjectcatsearch search) throws DBException {
        return (ArrayList<Subjectcat>)tableio.search(search);
    }

    public ArrayList<Subjectcat> searchsubjectcats(ISubjectcatsearch search, String orderby) throws DBException {
        return (ArrayList<Subjectcat>)tableio.search(search, orderby);
    }

    public boolean getSubjectcatExists(ISubjectcatPK subjectcatPK) throws DBException {
        return tableio.getEntityExists((SubjectcatPK)subjectcatPK);
    }

    public Subjectcat getEntity(String sql) throws DBException {
        return (Subjectcat)tableio.getEntity(sql);
    }
    
    public Subjectcat getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Subjectcat)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Subjectcat> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Subjectcat> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Subjectcat> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Subjectcat> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSubjectcat(SQLTqueue transactionqueue, ISubjectcat subjectcat) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, subjectcat);
    }

    public void insertupdateSubjectcat(SQLTqueue transactionqueue, ISubjectcat subjectcat) throws DBException, DataException {
    	checkDATA(subjectcat);
        if(this.getSubjectcatExists(subjectcat.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, subjectcat);
        } else {
            tableio.insertEntity(transactionqueue, subjectcat);
        }
    }

    public void updateSubjectcat(SQLTqueue transactionqueue, ISubjectcat subjectcat) throws DBException, DataException {
    	checkDATA(subjectcat);
        tableio.updateEntity(transactionqueue, subjectcat);
    }

    public void deleteSubjectcat(SQLTqueue transactionqueue, ISubjectcat subjectcat) throws DBException {
        cascadedeleteSubjectcat(transactionqueue, subjectcat.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, subjectcat);
    }

    private void checkDATA(ISubjectcat subjectcat) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(subjectcat.getDescription()!=null && subjectcat.getDescription().length()>ISubjectcat.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(ISubjectcat.SIZE_DESCRIPTION).append("\n");
        }
        if(subjectcat.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSubjectcat(SQLTqueue transactionqueue, ISubjectcatPK subjectcatPK) {
        BLsubject blsubjectCat1 = new BLsubject(this);
        blsubjectCat1.setAuthenticated(isAuthenticated());
        blsubjectCat1.delete4subjectcatCat1(transactionqueue, subjectcatPK);
        BLsubject blsubjectCat2 = new BLsubject(this);
        blsubjectCat2.setAuthenticated(isAuthenticated());
        blsubjectCat2.delete4subjectcatCat2(transactionqueue, subjectcatPK);
    }

    public Subjectcat getSubjectcat1(ISubjectPK subjectPK) throws CustomException {
        SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat1());
        return this.getSubjectcat(subjectcatPK);
    }

    public Subjectcat getSubjectcat2(ISubjectPK subjectPK) throws CustomException {
        SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat2());
        return this.getSubjectcat(subjectcatPK);
    }


    public ArrayList<Subjectcat> getSubjectcats(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsubjectcat.SQLSelect);
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
        return (ArrayList<Subjectcat>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSubjectcat(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Subjectcat.table);
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
