/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMart_academy;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_academysearch;
import film.logicentity.Art_academy;

/**
 * @author Franky Laseure
 */
public abstract class Bart_academy extends TableBusinessrules {

    public Bart_academy(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMart_academy()));
    }

    public Bart_academy(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMart_academy()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArt_academy newArt_academy() {
    	return new Art_academy();
    }
    
    public IArt_academy newArt_academy(long academyid) {
        return new Art_academy(academyid);
    }

    public IArt_academy newArt_academy(IArt_academyPK art_academyPK) {
        return new Art_academy((Art_academyPK)art_academyPK);
    }

    public IArt_academyPK newArt_academyPK() {
        return new Art_academyPK();
    }

    public IArt_academyPK newArt_academyPK(long academyid) {
        return new Art_academyPK(academyid);
    }

    public ArrayList<Art_academy> getArt_academys() throws DBException {
        return (ArrayList<Art_academy>)tableio.getEntities(EMart_academy.SQLSelectAll);
    }

    public Art_academy getArt_academy(IArt_academyPK art_academyPK) throws DBException {
        return (Art_academy)tableio.getEntity((Art_academyPK)art_academyPK);
    }

    public ArrayList<Art_academy> searchart_academys(IArt_academysearch search) throws DBException {
        return (ArrayList<Art_academy>)tableio.search(search);
    }

    public ArrayList<Art_academy> searchart_academys(IArt_academysearch search, String orderby) throws DBException {
        return (ArrayList<Art_academy>)tableio.search(search, orderby);
    }

    public boolean getArt_academyExists(IArt_academyPK art_academyPK) throws DBException {
        return tableio.getEntityExists((Art_academyPK)art_academyPK);
    }

    public Art_academy getEntity(String sql) throws DBException {
        return (Art_academy)tableio.getEntity(sql);
    }
    
    public Art_academy getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Art_academy)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Art_academy> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Art_academy> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Art_academy> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Art_academy> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArt_academy(SQLTqueue transactionqueue, IArt_academy art_academy) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, art_academy);
    }

    public void insertupdateArt_academy(SQLTqueue transactionqueue, IArt_academy art_academy) throws DBException, DataException {
    	checkDATA(art_academy);
        if(this.getArt_academyExists(art_academy.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, art_academy);
        } else {
            tableio.insertEntity(transactionqueue, art_academy);
        }
    }

    public void updateArt_academy(SQLTqueue transactionqueue, IArt_academy art_academy) throws DBException, DataException {
    	checkDATA(art_academy);
        tableio.updateEntity(transactionqueue, art_academy);
    }

    public void deleteArt_academy(SQLTqueue transactionqueue, IArt_academy art_academy) throws DBException {
        cascadedeleteArt_academy(transactionqueue, art_academy.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, art_academy);
    }

    private void checkDATA(IArt_academy art_academy) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_academy.getAcademy()!=null && art_academy.getAcademy().length()>IArt_academy.SIZE_ACADEMY) {
            message.append("Academy is langer dan toegestaan. Max aantal karakters: ").append(IArt_academy.SIZE_ACADEMY).append("\n");
        }
        if(art_academy.getAcademy()==null) {
            message.append("Academy mag niet leeg zijn.\n");
        }
        if(art_academy.getAcademylocation()!=null && art_academy.getAcademylocation().length()>IArt_academy.SIZE_ACADEMYLOCATION) {
            message.append("Academylocation is langer dan toegestaan. Max aantal karakters: ").append(IArt_academy.SIZE_ACADEMYLOCATION).append("\n");
        }
        if(art_academy.getAcademylocation()==null) {
            message.append("Academylocation mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArt_academy(SQLTqueue transactionqueue, IArt_academyPK art_academyPK) {
    }


    public ArrayList<Art_academy> getArt_academys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_academy.SQLSelect);
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
        return (ArrayList<Art_academy>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArt_academy(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_academy.table);
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
