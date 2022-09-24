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
import film.conversion.entity.EMarealevel3;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel3search;
import film.logicentity.Arealevel3;

public abstract class Barealevel3 extends TableBusinessrules {

    public Barealevel3(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMarealevel3()));
    }

    public Barealevel3(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMarealevel3()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArealevel3 newArealevel3() {
    	return new Arealevel3();
    }
    
    public IArealevel3 newArealevel3(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code, java.lang.String al3code) {
        return new Arealevel3(countrycode, al1code, al2code, al3code);
    }

    public IArealevel3 newArealevel3(IArealevel3PK arealevel3PK) {
        return new Arealevel3((Arealevel3PK)arealevel3PK);
    }

    public IArealevel3PK newArealevel3PK() {
        return new Arealevel3PK();
    }

    public IArealevel3PK newArealevel3PK(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code, java.lang.String al3code) {
        return new Arealevel3PK(countrycode, al1code, al2code, al3code);
    }

    public ArrayList<Arealevel3> getArealevel3s() throws DBException {
        return (ArrayList<Arealevel3>)tableio.getEntities(EMarealevel3.SQLSelectAll);
    }

    public Arealevel3 getArealevel3(IArealevel3PK arealevel3PK) throws DBException {
        return (Arealevel3)tableio.getEntity((Arealevel3PK)arealevel3PK);
    }

    public ArrayList<Arealevel3> searcharealevel3s(IArealevel3search search) throws DBException {
        return (ArrayList<Arealevel3>)tableio.search(search);
    }

    public ArrayList<Arealevel3> searcharealevel3s(IArealevel3search search, String orderby) throws DBException {
        return (ArrayList<Arealevel3>)tableio.search(search, orderby);
    }

    public boolean getArealevel3Exists(IArealevel3PK arealevel3PK) throws DBException {
        return tableio.getEntityExists((Arealevel3PK)arealevel3PK);
    }

    public Arealevel3 getEntity(String sql) throws DBException {
        return (Arealevel3)tableio.getEntity(sql);
    }
    
    public Arealevel3 getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Arealevel3)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Arealevel3> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Arealevel3> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Arealevel3> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Arealevel3> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArealevel3(SQLTqueue transactionqueue, IArealevel3 arealevel3) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, arealevel3);
    }

    public void insertupdateArealevel3(SQLTqueue transactionqueue, IArealevel3 arealevel3) throws DBException, DataException {
    	checkDATA(arealevel3);
        if(this.getArealevel3Exists(arealevel3.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, arealevel3);
        } else {
            tableio.insertEntity(transactionqueue, arealevel3);
        }
    }

    public void updateArealevel3(SQLTqueue transactionqueue, IArealevel3 arealevel3) throws DBException, DataException {
    	checkDATA(arealevel3);
        tableio.updateEntity(transactionqueue, arealevel3);
    }

    public void deleteArealevel3(SQLTqueue transactionqueue, IArealevel3 arealevel3) throws DBException {
        cascadedeleteArealevel3(transactionqueue, arealevel3.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, arealevel3);
    }

    private void checkDATA(IArealevel3 arealevel3) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel3.Countrycode - Arealevel2.Countrycode
        //foreign key Arealevel3.Al1code - Arealevel2.Al1code
        //foreign key Arealevel3.Al2code - Arealevel2.Al2code
        //Primary key
        if(arealevel3.getName()!=null && arealevel3.getName().length()>IArealevel3.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel3.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArealevel3(SQLTqueue transactionqueue, IArealevel3PK arealevel3PK) {
    }

    public void delete4arealevel2(SQLTqueue transactionqueue, IArealevel2PK arealevel2PK) {
        tableio.addStatement(transactionqueue, EMarealevel3.SQLDelete4arealevel2, arealevel2PK.getSQLprimarykey());
    }

    public ArrayList<Arealevel3> getArealevel3s4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return tableio.getEntities(EMarealevel3.SQLSelect4arealevel2, arealevel2PK.getSQLprimarykey());
    }

    public ArrayList<Arealevel3> getArealevel3s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel3.SQLSelect);
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
        return (ArrayList<Arealevel3>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArealevel3(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel3.table);
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
