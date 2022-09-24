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
import film.conversion.entity.EMarealevel1;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel1search;
import film.logicentity.Arealevel1;

public abstract class Barealevel1 extends TableBusinessrules {

    public Barealevel1(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMarealevel1()));
    }

    public Barealevel1(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMarealevel1()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArealevel1 newArealevel1() {
    	return new Arealevel1();
    }
    
    public IArealevel1 newArealevel1(java.lang.String countrycode, java.lang.String al1code) {
        return new Arealevel1(countrycode, al1code);
    }

    public IArealevel1 newArealevel1(IArealevel1PK arealevel1PK) {
        return new Arealevel1((Arealevel1PK)arealevel1PK);
    }

    public IArealevel1PK newArealevel1PK() {
        return new Arealevel1PK();
    }

    public IArealevel1PK newArealevel1PK(java.lang.String countrycode, java.lang.String al1code) {
        return new Arealevel1PK(countrycode, al1code);
    }

    public ArrayList<Arealevel1> getArealevel1s() throws DBException {
        return (ArrayList<Arealevel1>)tableio.getEntities(EMarealevel1.SQLSelectAll);
    }

    public Arealevel1 getArealevel1(IArealevel1PK arealevel1PK) throws DBException {
        return (Arealevel1)tableio.getEntity((Arealevel1PK)arealevel1PK);
    }

    public ArrayList<Arealevel1> searcharealevel1s(IArealevel1search search) throws DBException {
        return (ArrayList<Arealevel1>)tableio.search(search);
    }

    public ArrayList<Arealevel1> searcharealevel1s(IArealevel1search search, String orderby) throws DBException {
        return (ArrayList<Arealevel1>)tableio.search(search, orderby);
    }

    public boolean getArealevel1Exists(IArealevel1PK arealevel1PK) throws DBException {
        return tableio.getEntityExists((Arealevel1PK)arealevel1PK);
    }

    public Arealevel1 getEntity(String sql) throws DBException {
        return (Arealevel1)tableio.getEntity(sql);
    }
    
    public Arealevel1 getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Arealevel1)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Arealevel1> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Arealevel1> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Arealevel1> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Arealevel1> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArealevel1(SQLTqueue transactionqueue, IArealevel1 arealevel1) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, arealevel1);
    }

    public void insertupdateArealevel1(SQLTqueue transactionqueue, IArealevel1 arealevel1) throws DBException, DataException {
    	checkDATA(arealevel1);
        if(this.getArealevel1Exists(arealevel1.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, arealevel1);
        } else {
            tableio.insertEntity(transactionqueue, arealevel1);
        }
    }

    public void updateArealevel1(SQLTqueue transactionqueue, IArealevel1 arealevel1) throws DBException, DataException {
    	checkDATA(arealevel1);
        tableio.updateEntity(transactionqueue, arealevel1);
    }

    public void deleteArealevel1(SQLTqueue transactionqueue, IArealevel1 arealevel1) throws DBException {
        cascadedeleteArealevel1(transactionqueue, arealevel1.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, arealevel1);
    }

    private void checkDATA(IArealevel1 arealevel1) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel1.Countrycode - Country.Code
        //Primary key
        if(arealevel1.getName()!=null && arealevel1.getName().length()>IArealevel1.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel1.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArealevel1(SQLTqueue transactionqueue, IArealevel1PK arealevel1PK) {
        BLarealevel2 blarealevel2 = new BLarealevel2(this);
        blarealevel2.setAuthenticated(isAuthenticated());
        blarealevel2.delete4arealevel1(transactionqueue, arealevel1PK);
    }

    public void delete4country(SQLTqueue transactionqueue, ICountryPK countryPK) {
        tableio.addStatement(transactionqueue, EMarealevel1.SQLDelete4country, countryPK.getSQLprimarykey());
    }

    public ArrayList<Arealevel1> getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        return tableio.getEntities(EMarealevel1.SQLSelect4country, countryPK.getSQLprimarykey());
    }
    public Arealevel1 getArealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        Arealevel1PK arealevel1PK = new Arealevel1PK(arealevel2PK.getCountrycode(), arealevel2PK.getAl1code());
        return this.getArealevel1(arealevel1PK);
    }


    public ArrayList<Arealevel1> getArealevel1s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel1.SQLSelect);
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
        return (ArrayList<Arealevel1>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArealevel1(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel1.table);
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
