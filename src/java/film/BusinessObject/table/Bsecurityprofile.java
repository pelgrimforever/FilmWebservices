/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMsecurityprofile;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.logicentity.Securityprofile;

/**
 * @author Franky Laseure
 */
public abstract class Bsecurityprofile extends TableBusinessrules {

    public Bsecurityprofile(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsecurityprofile()));
    }

    public Bsecurityprofile(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsecurityprofile()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISecurityprofile newSecurityprofile() {
    	return new Securityprofile();
    }
    
    public ISecurityprofile newSecurityprofile(java.lang.String userprofile) {
        return new Securityprofile(userprofile);
    }

    public ISecurityprofile newSecurityprofile(ISecurityprofilePK securityprofilePK) {
        return new Securityprofile((SecurityprofilePK)securityprofilePK);
    }

    public ISecurityprofilePK newSecurityprofilePK() {
        return new SecurityprofilePK();
    }

    public ISecurityprofilePK newSecurityprofilePK(java.lang.String userprofile) {
        return new SecurityprofilePK(userprofile);
    }

    public ArrayList<Securityprofile> getSecurityprofiles() throws DBException {
        return (ArrayList<Securityprofile>)tableio.getEntities(EMsecurityprofile.SQLSelectAll);
    }

    public Securityprofile getSecurityprofile(ISecurityprofilePK securityprofilePK) throws DBException {
        return (Securityprofile)tableio.getEntity((SecurityprofilePK)securityprofilePK);
    }

    public ArrayList<Securityprofile> searchsecurityprofiles(ISecurityprofilesearch search) throws DBException {
        return (ArrayList<Securityprofile>)tableio.search(search);
    }

    public ArrayList<Securityprofile> searchsecurityprofiles(ISecurityprofilesearch search, String orderby) throws DBException {
        return (ArrayList<Securityprofile>)tableio.search(search, orderby);
    }

    public boolean getSecurityprofileExists(ISecurityprofilePK securityprofilePK) throws DBException {
        return tableio.getEntityExists((SecurityprofilePK)securityprofilePK);
    }

    public Securityprofile getEntity(String sql) throws DBException {
        return (Securityprofile)tableio.getEntity(sql);
    }
    
    public Securityprofile getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Securityprofile)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Securityprofile> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Securityprofile> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Securityprofile> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Securityprofile> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSecurityprofile(SQLTqueue transactionqueue, ISecurityprofile securityprofile) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, securityprofile);
    }

    public void insertupdateSecurityprofile(SQLTqueue transactionqueue, ISecurityprofile securityprofile) throws DBException, DataException {
    	checkDATA(securityprofile);
        if(this.getSecurityprofileExists(securityprofile.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, securityprofile);
        } else {
            tableio.insertEntity(transactionqueue, securityprofile);
        }
    }

    public void updateSecurityprofile(SQLTqueue transactionqueue, ISecurityprofile securityprofile) throws DBException, DataException {
    	checkDATA(securityprofile);
        tableio.updateEntity(transactionqueue, securityprofile);
    }

    public void deleteSecurityprofile(SQLTqueue transactionqueue, ISecurityprofile securityprofile) throws DBException {
        cascadedeleteSecurityprofile(transactionqueue, securityprofile.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, securityprofile);
    }

    private void checkDATA(ISecurityprofile securityprofile) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSecurityprofile(SQLTqueue transactionqueue, ISecurityprofilePK securityprofilePK) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile(this);
        blsecurityuserprofile.setAuthenticated(isAuthenticated());
        blsecurityuserprofile.delete4securityprofile(transactionqueue, securityprofilePK);
    }

    public Securityprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws CustomException {
        SecurityprofilePK securityprofilePK = new SecurityprofilePK(securityuserprofilePK.getUserprofile());
        return this.getSecurityprofile(securityprofilePK);
    }


    public ArrayList<Securityprofile> getSecurityprofiles(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurityprofile.SQLSelect);
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
        return (ArrayList<Securityprofile>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSecurityprofile(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Securityprofile.table);
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
