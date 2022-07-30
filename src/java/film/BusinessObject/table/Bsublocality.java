/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMsublocality;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISublocalitysearch;
import film.logicentity.Sublocality;

/**
 * @author Franky Laseure
 */
public abstract class Bsublocality extends TableBusinessrules {

    public Bsublocality(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsublocality()));
    }

    public Bsublocality(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsublocality()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISublocality newSublocality() {
    	return new Sublocality();
    }
    
    public ISublocality newSublocality(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality) {
        return new Sublocality(countrycode, postalcode, locality, sublocality);
    }

    public ISublocality newSublocality(ISublocalityPK sublocalityPK) {
        return new Sublocality((SublocalityPK)sublocalityPK);
    }

    public ISublocalityPK newSublocalityPK() {
        return new SublocalityPK();
    }

    public ISublocalityPK newSublocalityPK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality) {
        return new SublocalityPK(countrycode, postalcode, locality, sublocality);
    }

    public ArrayList<Sublocality> getSublocalitys() throws DBException {
        return (ArrayList<Sublocality>)tableio.getEntities(EMsublocality.SQLSelectAll);
    }

    public Sublocality getSublocality(ISublocalityPK sublocalityPK) throws DBException {
        return (Sublocality)tableio.getEntity((SublocalityPK)sublocalityPK);
    }

    public ArrayList<Sublocality> searchsublocalitys(ISublocalitysearch search) throws DBException {
        return (ArrayList<Sublocality>)tableio.search(search);
    }

    public ArrayList<Sublocality> searchsublocalitys(ISublocalitysearch search, String orderby) throws DBException {
        return (ArrayList<Sublocality>)tableio.search(search, orderby);
    }

    public boolean getSublocalityExists(ISublocalityPK sublocalityPK) throws DBException {
        return tableio.getEntityExists((SublocalityPK)sublocalityPK);
    }

    public Sublocality getEntity(String sql) throws DBException {
        return (Sublocality)tableio.getEntity(sql);
    }
    
    public Sublocality getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Sublocality)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Sublocality> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Sublocality> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Sublocality> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Sublocality> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSublocality(SQLTqueue transactionqueue, ISublocality sublocality) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, sublocality);
    }

    public void insertupdateSublocality(SQLTqueue transactionqueue, ISublocality sublocality) throws DBException, DataException {
    	checkDATA(sublocality);
        if(this.getSublocalityExists(sublocality.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, sublocality);
        } else {
            tableio.insertEntity(transactionqueue, sublocality);
        }
    }

    public void updateSublocality(SQLTqueue transactionqueue, ISublocality sublocality) throws DBException, DataException {
    	checkDATA(sublocality);
        tableio.updateEntity(transactionqueue, sublocality);
    }

    public void deleteSublocality(SQLTqueue transactionqueue, ISublocality sublocality) throws DBException {
        cascadedeleteSublocality(transactionqueue, sublocality.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, sublocality);
    }

    private void checkDATA(ISublocality sublocality) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Sublocality.Countrycode - Locality.Countrycode
        //foreign key Sublocality.Postalcode - Locality.Postalcode
        //foreign key Sublocality.Locality - Locality.Locality
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSublocality(SQLTqueue transactionqueue, ISublocalityPK sublocalityPK) {
        BLroute blroute = new BLroute(this);
        blroute.setAuthenticated(isAuthenticated());
        blroute.delete4sublocality(transactionqueue, sublocalityPK);
    }

    public void delete4locality(SQLTqueue transactionqueue, ILocalityPK localityPK) {
        tableio.addStatement(transactionqueue, EMsublocality.SQLDelete4locality, localityPK.getSQLprimarykey());
    }

    public ArrayList<Sublocality> getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        return tableio.getEntities(EMsublocality.SQLSelect4locality, localityPK.getSQLprimarykey());
    }
    public Sublocality getRoute(IRoutePK routePK) throws CustomException {
        SublocalityPK sublocalityPK = new SublocalityPK(routePK.getCountrycode(), routePK.getPostalcode(), routePK.getLocality(), routePK.getSublocality());
        return this.getSublocality(sublocalityPK);
    }


    public ArrayList<Sublocality> getSublocalitys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsublocality.SQLSelect);
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
        return (ArrayList<Sublocality>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSublocality(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Sublocality.table);
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
