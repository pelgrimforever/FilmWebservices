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
import film.conversion.entity.EMart_subgroup;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.logicentity.Art_subgroup;

public abstract class Bart_subgroup extends TableBusinessrules {

    public Bart_subgroup(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMart_subgroup()));
    }

    public Bart_subgroup(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMart_subgroup()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArt_subgroup newArt_subgroup() {
    	return new Art_subgroup();
    }
    
    public IArt_subgroup newArt_subgroup(int subgroupid) {
        return new Art_subgroup(subgroupid);
    }

    public IArt_subgroup newArt_subgroup(IArt_subgroupPK art_subgroupPK) {
        return new Art_subgroup((Art_subgroupPK)art_subgroupPK);
    }

    public IArt_subgroupPK newArt_subgroupPK() {
        return new Art_subgroupPK();
    }

    public IArt_subgroupPK newArt_subgroupPK(int subgroupid) {
        return new Art_subgroupPK(subgroupid);
    }

    public ArrayList<Art_subgroup> getArt_subgroups() throws DBException {
        return (ArrayList<Art_subgroup>)tableio.getEntities(EMart_subgroup.SQLSelectAll);
    }

    public Art_subgroup getArt_subgroup(IArt_subgroupPK art_subgroupPK) throws DBException {
        return (Art_subgroup)tableio.getEntity((Art_subgroupPK)art_subgroupPK);
    }

    public ArrayList<Art_subgroup> searchart_subgroups(IArt_subgroupsearch search) throws DBException {
        return (ArrayList<Art_subgroup>)tableio.search(search);
    }

    public ArrayList<Art_subgroup> searchart_subgroups(IArt_subgroupsearch search, String orderby) throws DBException {
        return (ArrayList<Art_subgroup>)tableio.search(search, orderby);
    }

    public boolean getArt_subgroupExists(IArt_subgroupPK art_subgroupPK) throws DBException {
        return tableio.getEntityExists((Art_subgroupPK)art_subgroupPK);
    }

    public Art_subgroup getEntity(String sql) throws DBException {
        return (Art_subgroup)tableio.getEntity(sql);
    }
    
    public Art_subgroup getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Art_subgroup)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Art_subgroup> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Art_subgroup> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Art_subgroup> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Art_subgroup> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArt_subgroup(SQLTqueue transactionqueue, IArt_subgroup art_subgroup) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, art_subgroup);
    }

    public void insertupdateArt_subgroup(SQLTqueue transactionqueue, IArt_subgroup art_subgroup) throws DBException, DataException {
    	checkDATA(art_subgroup);
        if(this.getArt_subgroupExists(art_subgroup.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, art_subgroup);
        } else {
            tableio.insertEntity(transactionqueue, art_subgroup);
        }
    }

    public void updateArt_subgroup(SQLTqueue transactionqueue, IArt_subgroup art_subgroup) throws DBException, DataException {
    	checkDATA(art_subgroup);
        tableio.updateEntity(transactionqueue, art_subgroup);
    }

    public void deleteArt_subgroup(SQLTqueue transactionqueue, IArt_subgroup art_subgroup) throws DBException {
        cascadedeleteArt_subgroup(transactionqueue, art_subgroup.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, art_subgroup);
    }

    private void checkDATA(IArt_subgroup art_subgroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(art_subgroup.getSubgroupname()!=null && art_subgroup.getSubgroupname().length()>IArt_subgroup.SIZE_SUBGROUPNAME) {
            message.append("Subgroupname is langer dan toegestaan. Max aantal karakters: ").append(IArt_subgroup.SIZE_SUBGROUPNAME).append("\n");
        }
        if(art_subgroup.getSubgroupname()==null) {
            message.append("Subgroupname mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArt_subgroup(SQLTqueue transactionqueue, IArt_subgroupPK art_subgroupPK) {
    }

    public void delete4art_group(SQLTqueue transactionqueue, IArt_groupPK art_groupPK) {
        tableio.addStatement(transactionqueue, EMart_subgroup.SQLDelete4art_group, art_groupPK.getSQLprimarykey());
    }

    public ArrayList<Art_subgroup> getArt_subgroups4art_group(IArt_groupPK art_groupPK) throws CustomException {
        return tableio.getEntities(EMart_subgroup.SQLSelect4art_group, art_groupPK.getSQLprimarykey());
    }

    public ArrayList<Art_subgroup> getArt_subgroups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_subgroup.SQLSelect);
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
        return (ArrayList<Art_subgroup>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArt_subgroup(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_subgroup.table);
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
