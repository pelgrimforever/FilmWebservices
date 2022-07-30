/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMpostalcode;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPostalcodesearch;
import film.logicentity.Postalcode;

/**
 * @author Franky Laseure
 */
public abstract class Bpostalcode extends TableBusinessrules {

    public Bpostalcode(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMpostalcode()));
    }

    public Bpostalcode(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMpostalcode()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IPostalcode newPostalcode() {
    	return new Postalcode();
    }
    
    public IPostalcode newPostalcode(java.lang.String countrycode, java.lang.String postalcode) {
        return new Postalcode(countrycode, postalcode);
    }

    public IPostalcode newPostalcode(IPostalcodePK postalcodePK) {
        return new Postalcode((PostalcodePK)postalcodePK);
    }

    public IPostalcodePK newPostalcodePK() {
        return new PostalcodePK();
    }

    public IPostalcodePK newPostalcodePK(java.lang.String countrycode, java.lang.String postalcode) {
        return new PostalcodePK(countrycode, postalcode);
    }

    public ArrayList<Postalcode> getPostalcodes() throws DBException {
        return (ArrayList<Postalcode>)tableio.getEntities(EMpostalcode.SQLSelectAll);
    }

    public Postalcode getPostalcode(IPostalcodePK postalcodePK) throws DBException {
        return (Postalcode)tableio.getEntity((PostalcodePK)postalcodePK);
    }

    public ArrayList<Postalcode> searchpostalcodes(IPostalcodesearch search) throws DBException {
        return (ArrayList<Postalcode>)tableio.search(search);
    }

    public ArrayList<Postalcode> searchpostalcodes(IPostalcodesearch search, String orderby) throws DBException {
        return (ArrayList<Postalcode>)tableio.search(search, orderby);
    }

    public boolean getPostalcodeExists(IPostalcodePK postalcodePK) throws DBException {
        return tableio.getEntityExists((PostalcodePK)postalcodePK);
    }

    public Postalcode getEntity(String sql) throws DBException {
        return (Postalcode)tableio.getEntity(sql);
    }
    
    public Postalcode getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Postalcode)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Postalcode> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Postalcode> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Postalcode> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Postalcode> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertPostalcode(SQLTqueue transactionqueue, IPostalcode postalcode) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, postalcode);
    }

    public void insertupdatePostalcode(SQLTqueue transactionqueue, IPostalcode postalcode) throws DBException, DataException {
    	checkDATA(postalcode);
        if(this.getPostalcodeExists(postalcode.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, postalcode);
        } else {
            tableio.insertEntity(transactionqueue, postalcode);
        }
    }

    public void updatePostalcode(SQLTqueue transactionqueue, IPostalcode postalcode) throws DBException, DataException {
    	checkDATA(postalcode);
        tableio.updateEntity(transactionqueue, postalcode);
    }

    public void deletePostalcode(SQLTqueue transactionqueue, IPostalcode postalcode) throws DBException {
        cascadedeletePostalcode(transactionqueue, postalcode.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, postalcode);
    }

    private void checkDATA(IPostalcode postalcode) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        //Primary key
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getCountrycode()!=null && postalcode.getArealevel3PK().getCountrycode().length()>IPostalcode.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_COUNTRYCODE + "\n");
        }
        if(postalcode.getArealevel3PK()==null || postalcode.getArealevel3PK().getCountrycode()==null) {
            message.append("Countrycode mag niet leeg zijn.\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl1code()!=null && postalcode.getArealevel3PK().getAl1code().length()>IPostalcode.SIZE_AL1CODE) {
            message.append("Al1code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL1CODE + "\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl2code()!=null && postalcode.getArealevel3PK().getAl2code().length()>IPostalcode.SIZE_AL2CODE) {
            message.append("Al2code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL2CODE + "\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl3code()!=null && postalcode.getArealevel3PK().getAl3code().length()>IPostalcode.SIZE_AL3CODE) {
            message.append("Al3code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL3CODE + "\n");
        }

        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeletePostalcode(SQLTqueue transactionqueue, IPostalcodePK postalcodePK) {
        BLlocality bllocality = new BLlocality(this);
        bllocality.setAuthenticated(isAuthenticated());
        bllocality.delete4postalcode(transactionqueue, postalcodePK);
    }

    public void delete4arealevel3(SQLTqueue transactionqueue, IArealevel3PK arealevel3PK) {
        tableio.addStatement(transactionqueue, EMpostalcode.SQLDelete4arealevel3, arealevel3PK.getSQLprimarykey());
    }

    public ArrayList<Postalcode> getPostalcodes4arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return tableio.getEntities(EMpostalcode.SQLSelect4arealevel3, arealevel3PK.getSQLprimarykey());
    }
    public Postalcode getLocality(ILocalityPK localityPK) throws CustomException {
        PostalcodePK postalcodePK = new PostalcodePK(localityPK.getCountrycode(), localityPK.getPostalcode());
        return this.getPostalcode(postalcodePK);
    }


    public ArrayList<Postalcode> getPostalcodes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMpostalcode.SQLSelect);
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
        return (ArrayList<Postalcode>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delPostalcode(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Postalcode.table);
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
