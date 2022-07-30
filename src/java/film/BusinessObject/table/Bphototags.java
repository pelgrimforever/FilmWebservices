/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMphototags;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhototagssearch;
import film.logicentity.Phototags;

/**
 * @author Franky Laseure
 */
public abstract class Bphototags extends TableBusinessrules {

    public Bphototags(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMphototags()));
    }

    public Bphototags(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMphototags()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IPhototags newPhototags() {
    	return new Phototags();
    }
    
    public IPhototags newPhototags(java.lang.String film, int id, java.lang.String tag) {
        return new Phototags(film, id, tag);
    }

    public IPhototags newPhototags(IPhototagsPK phototagsPK) {
        return new Phototags((PhototagsPK)phototagsPK);
    }

    public IPhototagsPK newPhototagsPK() {
        return new PhototagsPK();
    }

    public IPhototagsPK newPhototagsPK(java.lang.String film, int id, java.lang.String tag) {
        return new PhototagsPK(film, id, tag);
    }

    public ArrayList<Phototags> getPhototagss() throws DBException {
        return (ArrayList<Phototags>)tableio.getEntities(EMphototags.SQLSelectAll);
    }

    public Phototags getPhototags(IPhototagsPK phototagsPK) throws DBException {
        return (Phototags)tableio.getEntity((PhototagsPK)phototagsPK);
    }

    public ArrayList<Phototags> searchphototagss(IPhototagssearch search) throws DBException {
        return (ArrayList<Phototags>)tableio.search(search);
    }

    public ArrayList<Phototags> searchphototagss(IPhototagssearch search, String orderby) throws DBException {
        return (ArrayList<Phototags>)tableio.search(search, orderby);
    }

    public boolean getPhototagsExists(IPhototagsPK phototagsPK) throws DBException {
        return tableio.getEntityExists((PhototagsPK)phototagsPK);
    }

    public Phototags getEntity(String sql) throws DBException {
        return (Phototags)tableio.getEntity(sql);
    }
    
    public Phototags getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Phototags)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Phototags> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Phototags> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Phototags> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Phototags> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertPhototags(SQLTqueue transactionqueue, IPhototags phototags) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, phototags);
    }

    public void insertupdatePhototags(SQLTqueue transactionqueue, IPhototags phototags) throws DBException, DataException {
    	checkDATA(phototags);
        if(this.getPhototagsExists(phototags.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, phototags);
        } else {
            tableio.insertEntity(transactionqueue, phototags);
        }
    }

    public void updatePhototags(SQLTqueue transactionqueue, IPhototags phototags) throws DBException, DataException {
    	checkDATA(phototags);
        tableio.updateEntity(transactionqueue, phototags);
    }

    public void deletePhototags(SQLTqueue transactionqueue, IPhototags phototags) throws DBException {
        cascadedeletePhototags(transactionqueue, phototags.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, phototags);
    }

    private void checkDATA(IPhototags phototags) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototags.Film - Photo.Film
        //foreign key Phototags.Id - Photo.Id
        //Primary key
        if(phototags.getTagformat()!=null && phototags.getTagformat().length()>IPhototags.SIZE_TAGFORMAT) {
            message.append("Tagformat is langer dan toegestaan. Max aantal karakters: ").append(IPhototags.SIZE_TAGFORMAT).append("\n");
        }
        if(phototags.getTagformat()==null) {
            message.append("Tagformat mag niet leeg zijn.\n");
        }
        if(phototags.getTagvalue()!=null && phototags.getTagvalue().length()>IPhototags.SIZE_TAGVALUE) {
            message.append("Tagvalue is langer dan toegestaan. Max aantal karakters: ").append(IPhototags.SIZE_TAGVALUE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeletePhototags(SQLTqueue transactionqueue, IPhototagsPK phototagsPK) {
    }

    public void delete4photo(SQLTqueue transactionqueue, IPhotoPK photoPK) {
        tableio.addStatement(transactionqueue, EMphototags.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Phototags> getPhototagss4photo(IPhotoPK photoPK) throws CustomException {
        return tableio.getEntities(EMphototags.SQLSelect4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Phototags> getPhototagss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphototags.SQLSelect);
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
        return (ArrayList<Phototags>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delPhototags(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Phototags.table);
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
