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
import film.conversion.entity.EMart_group;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_groupsearch;
import film.logicentity.Art_group;

public abstract class Bart_group extends TableBusinessrules {

    public Bart_group(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMart_group()));
    }

    public Bart_group(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMart_group()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArt_group newArt_group() {
    	return new Art_group();
    }
    
    public IArt_group newArt_group(long groupid) {
        return new Art_group(groupid);
    }

    public IArt_group newArt_group(IArt_groupPK art_groupPK) {
        return new Art_group((Art_groupPK)art_groupPK);
    }

    public IArt_groupPK newArt_groupPK() {
        return new Art_groupPK();
    }

    public IArt_groupPK newArt_groupPK(long groupid) {
        return new Art_groupPK(groupid);
    }

    public ArrayList<Art_group> getArt_groups() throws DBException {
        return (ArrayList<Art_group>)tableio.getEntities(EMart_group.SQLSelectAll);
    }

    public Art_group getArt_group(IArt_groupPK art_groupPK) throws DBException {
        return (Art_group)tableio.getEntity((Art_groupPK)art_groupPK);
    }

    public ArrayList<Art_group> searchart_groups(IArt_groupsearch search) throws DBException {
        return (ArrayList<Art_group>)tableio.search(search);
    }

    public ArrayList<Art_group> searchart_groups(IArt_groupsearch search, String orderby) throws DBException {
        return (ArrayList<Art_group>)tableio.search(search, orderby);
    }

    public boolean getArt_groupExists(IArt_groupPK art_groupPK) throws DBException {
        return tableio.getEntityExists((Art_groupPK)art_groupPK);
    }

    public Art_group getEntity(String sql) throws DBException {
        return (Art_group)tableio.getEntity(sql);
    }
    
    public Art_group getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Art_group)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Art_group> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Art_group> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Art_group> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Art_group> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArt_group(SQLTqueue transactionqueue, IArt_group art_group) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, art_group);
    }

    public void insertupdateArt_group(SQLTqueue transactionqueue, IArt_group art_group) throws DBException, DataException {
    	checkDATA(art_group);
        if(this.getArt_groupExists(art_group.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, art_group);
        } else {
            tableio.insertEntity(transactionqueue, art_group);
        }
    }

    public void updateArt_group(SQLTqueue transactionqueue, IArt_group art_group) throws DBException, DataException {
    	checkDATA(art_group);
        tableio.updateEntity(transactionqueue, art_group);
    }

    public void deleteArt_group(SQLTqueue transactionqueue, IArt_group art_group) throws DBException {
        cascadedeleteArt_group(transactionqueue, art_group.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, art_group);
    }

    private void checkDATA(IArt_group art_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_group.getGroupname()!=null && art_group.getGroupname().length()>IArt_group.SIZE_GROUPNAME) {
            message.append("Groupname is langer dan toegestaan. Max aantal karakters: ").append(IArt_group.SIZE_GROUPNAME).append("\n");
        }
        if(art_group.getGroupname()==null) {
            message.append("Groupname mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArt_group(SQLTqueue transactionqueue, IArt_groupPK art_groupPK) {
    }


    public ArrayList<Art_group> getArt_groups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_group.SQLSelect);
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
        return (ArrayList<Art_group>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArt_group(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_group.table);
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
