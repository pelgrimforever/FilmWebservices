/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMlocality;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ILocalitysearch;
import film.logicentity.Locality;

/**
 * @author Franky Laseure
 */
public abstract class Blocality extends TableBusinessrules {

    public Blocality(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMlocality()));
    }

    public Blocality(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMlocality()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ILocality newLocality() {
    	return new Locality();
    }
    
    public ILocality newLocality(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality) {
        return new Locality(countrycode, postalcode, locality);
    }

    public ILocality newLocality(ILocalityPK localityPK) {
        return new Locality((LocalityPK)localityPK);
    }

    public ILocalityPK newLocalityPK() {
        return new LocalityPK();
    }

    public ILocalityPK newLocalityPK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality) {
        return new LocalityPK(countrycode, postalcode, locality);
    }

    public ArrayList<Locality> getLocalitys() throws DBException {
        return (ArrayList<Locality>)tableio.getEntities(EMlocality.SQLSelectAll);
    }

    public Locality getLocality(ILocalityPK localityPK) throws DBException {
        return (Locality)tableio.getEntity((LocalityPK)localityPK);
    }

    public ArrayList<Locality> searchlocalitys(ILocalitysearch search) throws DBException {
        return (ArrayList<Locality>)tableio.search(search);
    }

    public ArrayList<Locality> searchlocalitys(ILocalitysearch search, String orderby) throws DBException {
        return (ArrayList<Locality>)tableio.search(search, orderby);
    }

    public boolean getLocalityExists(ILocalityPK localityPK) throws DBException {
        return tableio.getEntityExists((LocalityPK)localityPK);
    }

    public Locality getEntity(String sql) throws DBException {
        return (Locality)tableio.getEntity(sql);
    }
    
    public Locality getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Locality)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Locality> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Locality> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Locality> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Locality> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertLocality(SQLTqueue transactionqueue, ILocality locality) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, locality);
    }

    public void insertupdateLocality(SQLTqueue transactionqueue, ILocality locality) throws DBException, DataException {
    	checkDATA(locality);
        if(this.getLocalityExists(locality.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, locality);
        } else {
            tableio.insertEntity(transactionqueue, locality);
        }
    }

    public void updateLocality(SQLTqueue transactionqueue, ILocality locality) throws DBException, DataException {
    	checkDATA(locality);
        tableio.updateEntity(transactionqueue, locality);
    }

    public void deleteLocality(SQLTqueue transactionqueue, ILocality locality) throws DBException {
        cascadedeleteLocality(transactionqueue, locality.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, locality);
    }

    private void checkDATA(ILocality locality) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Locality.Countrycode - Postalcode.Countrycode
        //foreign key Locality.Postalcode - Postalcode.Postalcode
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteLocality(SQLTqueue transactionqueue, ILocalityPK localityPK) {
        BLsublocality blsublocality = new BLsublocality(this);
        blsublocality.setAuthenticated(isAuthenticated());
        blsublocality.delete4locality(transactionqueue, localityPK);
    }

    public void delete4postalcode(SQLTqueue transactionqueue, IPostalcodePK postalcodePK) {
        tableio.addStatement(transactionqueue, EMlocality.SQLDelete4postalcode, postalcodePK.getSQLprimarykey());
    }

    public ArrayList<Locality> getLocalitys4postalcode(IPostalcodePK postalcodePK) throws CustomException {
        return tableio.getEntities(EMlocality.SQLSelect4postalcode, postalcodePK.getSQLprimarykey());
    }
    public Locality getSublocality(ISublocalityPK sublocalityPK) throws CustomException {
        LocalityPK localityPK = new LocalityPK(sublocalityPK.getCountrycode(), sublocalityPK.getPostalcode(), sublocalityPK.getLocality());
        return this.getLocality(localityPK);
    }


    public ArrayList<Locality> getLocalitys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMlocality.SQLSelect);
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
        return (ArrayList<Locality>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delLocality(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Locality.table);
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
