/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMsecurityuserprofile;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.logicentity.Securityuserprofile;

/**
 * @author Franky Laseure
 */
public abstract class Bsecurityuserprofile extends TableBusinessrules {

    public Bsecurityuserprofile(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsecurityuserprofile()));
    }

    public Bsecurityuserprofile(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsecurityuserprofile()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISecurityuserprofile newSecurityuserprofile() {
    	return new Securityuserprofile();
    }
    
    public ISecurityuserprofile newSecurityuserprofile(java.lang.String siteusername, java.lang.String userprofile) {
        return new Securityuserprofile(siteusername, userprofile);
    }

    public ISecurityuserprofile newSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) {
        return new Securityuserprofile((SecurityuserprofilePK)securityuserprofilePK);
    }

    public ISecurityuserprofilePK newSecurityuserprofilePK() {
        return new SecurityuserprofilePK();
    }

    public ISecurityuserprofilePK newSecurityuserprofilePK(java.lang.String siteusername, java.lang.String userprofile) {
        return new SecurityuserprofilePK(siteusername, userprofile);
    }

    public ArrayList<Securityuserprofile> getSecurityuserprofiles() throws DBException {
        return (ArrayList<Securityuserprofile>)tableio.getEntities(EMsecurityuserprofile.SQLSelectAll);
    }

    public Securityuserprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return (Securityuserprofile)tableio.getEntity((SecurityuserprofilePK)securityuserprofilePK);
    }

    public ArrayList<Securityuserprofile> searchsecurityuserprofiles(ISecurityuserprofilesearch search) throws DBException {
        return (ArrayList<Securityuserprofile>)tableio.search(search);
    }

    public ArrayList<Securityuserprofile> searchsecurityuserprofiles(ISecurityuserprofilesearch search, String orderby) throws DBException {
        return (ArrayList<Securityuserprofile>)tableio.search(search, orderby);
    }

    public boolean getSecurityuserprofileExists(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return tableio.getEntityExists((SecurityuserprofilePK)securityuserprofilePK);
    }

    public Securityuserprofile getEntity(String sql) throws DBException {
        return (Securityuserprofile)tableio.getEntity(sql);
    }
    
    public Securityuserprofile getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Securityuserprofile)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Securityuserprofile> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Securityuserprofile> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Securityuserprofile> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Securityuserprofile> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSecurityuserprofile(SQLTqueue transactionqueue, ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, securityuserprofile);
    }

    public void insertupdateSecurityuserprofile(SQLTqueue transactionqueue, ISecurityuserprofile securityuserprofile) throws DBException, DataException {
    	checkDATA(securityuserprofile);
        if(this.getSecurityuserprofileExists(securityuserprofile.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, securityuserprofile);
        } else {
            tableio.insertEntity(transactionqueue, securityuserprofile);
        }
    }

    public void updateSecurityuserprofile(SQLTqueue transactionqueue, ISecurityuserprofile securityuserprofile) throws DBException, DataException {
    	checkDATA(securityuserprofile);
        tableio.updateEntity(transactionqueue, securityuserprofile);
    }

    public void deleteSecurityuserprofile(SQLTqueue transactionqueue, ISecurityuserprofile securityuserprofile) throws DBException {
        cascadedeleteSecurityuserprofile(transactionqueue, securityuserprofile.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, securityuserprofile);
    }

    private void checkDATA(ISecurityuserprofile securityuserprofile) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Securityuserprofile.Userprofile - Securityprofile.Userprofile
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSecurityuserprofile(SQLTqueue transactionqueue, ISecurityuserprofilePK securityuserprofilePK) {
    }

    public void delete4securityprofile(SQLTqueue transactionqueue, ISecurityprofilePK securityprofilePK) {
        tableio.addStatement(transactionqueue, EMsecurityuserprofile.SQLDelete4securityprofile, securityprofilePK.getSQLprimarykey());
    }

    public ArrayList<Securityuserprofile> getSecurityuserprofiles4securityprofile(ISecurityprofilePK securityprofilePK) throws CustomException {
        return tableio.getEntities(EMsecurityuserprofile.SQLSelect4securityprofile, securityprofilePK.getSQLprimarykey());
    }

    public ArrayList<Securityuserprofile> getSecurityuserprofiles(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurityuserprofile.SQLSelect);
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
        return (ArrayList<Securityuserprofile>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSecurityuserprofile(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Securityuserprofile.table);
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
