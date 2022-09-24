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
import film.conversion.entity.EMarealevel2;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel2search;
import film.logicentity.Arealevel2;

public abstract class Barealevel2 extends TableBusinessrules {

    public Barealevel2(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMarealevel2()));
    }

    public Barealevel2(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMarealevel2()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArealevel2 newArealevel2() {
    	return new Arealevel2();
    }
    
    public IArealevel2 newArealevel2(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code) {
        return new Arealevel2(countrycode, al1code, al2code);
    }

    public IArealevel2 newArealevel2(IArealevel2PK arealevel2PK) {
        return new Arealevel2((Arealevel2PK)arealevel2PK);
    }

    public IArealevel2PK newArealevel2PK() {
        return new Arealevel2PK();
    }

    public IArealevel2PK newArealevel2PK(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code) {
        return new Arealevel2PK(countrycode, al1code, al2code);
    }

    public ArrayList<Arealevel2> getArealevel2s() throws DBException {
        return (ArrayList<Arealevel2>)tableio.getEntities(EMarealevel2.SQLSelectAll);
    }

    public Arealevel2 getArealevel2(IArealevel2PK arealevel2PK) throws DBException {
        return (Arealevel2)tableio.getEntity((Arealevel2PK)arealevel2PK);
    }

    public ArrayList<Arealevel2> searcharealevel2s(IArealevel2search search) throws DBException {
        return (ArrayList<Arealevel2>)tableio.search(search);
    }

    public ArrayList<Arealevel2> searcharealevel2s(IArealevel2search search, String orderby) throws DBException {
        return (ArrayList<Arealevel2>)tableio.search(search, orderby);
    }

    public boolean getArealevel2Exists(IArealevel2PK arealevel2PK) throws DBException {
        return tableio.getEntityExists((Arealevel2PK)arealevel2PK);
    }

    public Arealevel2 getEntity(String sql) throws DBException {
        return (Arealevel2)tableio.getEntity(sql);
    }
    
    public Arealevel2 getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Arealevel2)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Arealevel2> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Arealevel2> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Arealevel2> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Arealevel2> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArealevel2(SQLTqueue transactionqueue, IArealevel2 arealevel2) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, arealevel2);
    }

    public void insertupdateArealevel2(SQLTqueue transactionqueue, IArealevel2 arealevel2) throws DBException, DataException {
    	checkDATA(arealevel2);
        if(this.getArealevel2Exists(arealevel2.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, arealevel2);
        } else {
            tableio.insertEntity(transactionqueue, arealevel2);
        }
    }

    public void updateArealevel2(SQLTqueue transactionqueue, IArealevel2 arealevel2) throws DBException, DataException {
    	checkDATA(arealevel2);
        tableio.updateEntity(transactionqueue, arealevel2);
    }

    public void deleteArealevel2(SQLTqueue transactionqueue, IArealevel2 arealevel2) throws DBException {
        cascadedeleteArealevel2(transactionqueue, arealevel2.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, arealevel2);
    }

    private void checkDATA(IArealevel2 arealevel2) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel2.Countrycode - Arealevel1.Countrycode
        //foreign key Arealevel2.Al1code - Arealevel1.Al1code
        //Primary key
        if(arealevel2.getName()!=null && arealevel2.getName().length()>IArealevel2.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel2.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArealevel2(SQLTqueue transactionqueue, IArealevel2PK arealevel2PK) {
        BLarealevel3 blarealevel3 = new BLarealevel3(this);
        blarealevel3.setAuthenticated(isAuthenticated());
        blarealevel3.delete4arealevel2(transactionqueue, arealevel2PK);
    }

    public void delete4arealevel1(SQLTqueue transactionqueue, IArealevel1PK arealevel1PK) {
        tableio.addStatement(transactionqueue, EMarealevel2.SQLDelete4arealevel1, arealevel1PK.getSQLprimarykey());
    }

    public ArrayList<Arealevel2> getArealevel2s4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return tableio.getEntities(EMarealevel2.SQLSelect4arealevel1, arealevel1PK.getSQLprimarykey());
    }
    public Arealevel2 getArealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        Arealevel2PK arealevel2PK = new Arealevel2PK(arealevel3PK.getCountrycode(), arealevel3PK.getAl1code(), arealevel3PK.getAl2code());
        return this.getArealevel2(arealevel2PK);
    }


    public ArrayList<Arealevel2> getArealevel2s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel2.SQLSelect);
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
        return (ArrayList<Arealevel2>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArealevel2(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel2.table);
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
