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
import film.conversion.entity.EMcountry;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ICountrysearch;
import film.logicentity.Country;

public abstract class Bcountry extends TableBusinessrules {

    public Bcountry(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcountry()));
    }

    public Bcountry(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcountry()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ICountry newCountry() {
    	return new Country();
    }
    
    public ICountry newCountry(java.lang.String code) {
        return new Country(code);
    }

    public ICountry newCountry(ICountryPK countryPK) {
        return new Country((CountryPK)countryPK);
    }

    public ICountryPK newCountryPK() {
        return new CountryPK();
    }

    public ICountryPK newCountryPK(java.lang.String code) {
        return new CountryPK(code);
    }

    public ArrayList<Country> getCountrys() throws DBException {
        return (ArrayList<Country>)tableio.getEntities(EMcountry.SQLSelectAll);
    }

    public Country getCountry(ICountryPK countryPK) throws DBException {
        return (Country)tableio.getEntity((CountryPK)countryPK);
    }

    public ArrayList<Country> searchcountrys(ICountrysearch search) throws DBException {
        return (ArrayList<Country>)tableio.search(search);
    }

    public ArrayList<Country> searchcountrys(ICountrysearch search, String orderby) throws DBException {
        return (ArrayList<Country>)tableio.search(search, orderby);
    }

    public boolean getCountryExists(ICountryPK countryPK) throws DBException {
        return tableio.getEntityExists((CountryPK)countryPK);
    }

    public Country getEntity(String sql) throws DBException {
        return (Country)tableio.getEntity(sql);
    }
    
    public Country getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Country)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Country> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Country> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Country> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Country> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertCountry(SQLTqueue transactionqueue, ICountry country) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, country);
    }

    public void insertupdateCountry(SQLTqueue transactionqueue, ICountry country) throws DBException, DataException {
    	checkDATA(country);
        if(this.getCountryExists(country.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, country);
        } else {
            tableio.insertEntity(transactionqueue, country);
        }
    }

    public void updateCountry(SQLTqueue transactionqueue, ICountry country) throws DBException, DataException {
    	checkDATA(country);
        tableio.updateEntity(transactionqueue, country);
    }

    public void deleteCountry(SQLTqueue transactionqueue, ICountry country) throws DBException {
        cascadedeleteCountry(transactionqueue, country.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, country);
    }

    private void checkDATA(ICountry country) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(country.getName()!=null && country.getName().length()>ICountry.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICountry.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteCountry(SQLTqueue transactionqueue, ICountryPK countryPK) {
        BLarealevel1 blarealevel1 = new BLarealevel1(this);
        blarealevel1.setAuthenticated(isAuthenticated());
        blarealevel1.delete4country(transactionqueue, countryPK);
    }

    public Country getArealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        CountryPK countryPK = new CountryPK(arealevel1PK.getCountrycode());
        return this.getCountry(countryPK);
    }


    public ArrayList<Country> getCountrys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcountry.SQLSelect);
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
        return (ArrayList<Country>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delCountry(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Country.table);
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
