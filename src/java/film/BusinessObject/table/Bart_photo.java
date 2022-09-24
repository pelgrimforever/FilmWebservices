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
import film.conversion.entity.EMart_photo;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_photosearch;
import film.logicentity.Art_photo;

public abstract class Bart_photo extends TableBusinessrules {

    public Bart_photo(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMart_photo()));
    }

    public Bart_photo(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMart_photo()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IArt_photo newArt_photo() {
    	return new Art_photo();
    }
    
    public IArt_photo newArt_photo(java.lang.String film, int photo) {
        return new Art_photo(film, photo);
    }

    public IArt_photo newArt_photo(IArt_photoPK art_photoPK) {
        return new Art_photo((Art_photoPK)art_photoPK);
    }

    public IArt_photoPK newArt_photoPK() {
        return new Art_photoPK();
    }

    public IArt_photoPK newArt_photoPK(java.lang.String film, int photo) {
        return new Art_photoPK(film, photo);
    }

    public ArrayList<Art_photo> getArt_photos() throws DBException {
        return (ArrayList<Art_photo>)tableio.getEntities(EMart_photo.SQLSelectAll);
    }

    public Art_photo getArt_photo(IArt_photoPK art_photoPK) throws DBException {
        return (Art_photo)tableio.getEntity((Art_photoPK)art_photoPK);
    }

    public ArrayList<Art_photo> searchart_photos(IArt_photosearch search) throws DBException {
        return (ArrayList<Art_photo>)tableio.search(search);
    }

    public ArrayList<Art_photo> searchart_photos(IArt_photosearch search, String orderby) throws DBException {
        return (ArrayList<Art_photo>)tableio.search(search, orderby);
    }

    public boolean getArt_photoExists(IArt_photoPK art_photoPK) throws DBException {
        return tableio.getEntityExists((Art_photoPK)art_photoPK);
    }

    public Art_photo getEntity(String sql) throws DBException {
        return (Art_photo)tableio.getEntity(sql);
    }
    
    public Art_photo getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Art_photo)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Art_photo> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Art_photo> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Art_photo> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Art_photo> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertArt_photo(SQLTqueue transactionqueue, IArt_photo art_photo) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, art_photo);
    }

    public void insertupdateArt_photo(SQLTqueue transactionqueue, IArt_photo art_photo) throws DBException, DataException {
    	checkDATA(art_photo);
        if(this.getArt_photoExists(art_photo.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, art_photo);
        } else {
            tableio.insertEntity(transactionqueue, art_photo);
        }
    }

    public void updateArt_photo(SQLTqueue transactionqueue, IArt_photo art_photo) throws DBException, DataException {
    	checkDATA(art_photo);
        tableio.updateEntity(transactionqueue, art_photo);
    }

    public void deleteArt_photo(SQLTqueue transactionqueue, IArt_photo art_photo) throws DBException {
        cascadedeleteArt_photo(transactionqueue, art_photo.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, art_photo);
    }

    private void checkDATA(IArt_photo art_photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Art_photo.Film - Photo.Film
        //foreign key Art_photo.Photo - Photo.Id
        if(art_photo.getComment()!=null && art_photo.getComment().length()>IArt_photo.SIZE_COMMENT) {
            message.append("Comment is langer dan toegestaan. Max aantal karakters: ").append(IArt_photo.SIZE_COMMENT).append("\n");
        }
        if(art_photo.getSurrounddir()!=null && art_photo.getSurrounddir().length()>IArt_photo.SIZE_SURROUNDDIR) {
            message.append("Surrounddir is langer dan toegestaan. Max aantal karakters: ").append(IArt_photo.SIZE_SURROUNDDIR).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteArt_photo(SQLTqueue transactionqueue, IArt_photoPK art_photoPK) {
    }

    public void delete4photo(SQLTqueue transactionqueue, IPhotoPK photoPK) {
        tableio.addStatement(transactionqueue, EMart_photo.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Art_photo> getArt_photos4photo(IPhotoPK photoPK) throws CustomException {
        return tableio.getEntities(EMart_photo.SQLSelect4photo, photoPK.getSQLprimarykey());
    }
    public void delete4art_subgroup(SQLTqueue transactionqueue, IArt_subgroupPK art_subgroupPK) {
        tableio.addStatement(transactionqueue, EMart_photo.SQLDelete4art_subgroup, art_subgroupPK.getSQLprimarykey());
    }

    public ArrayList<Art_photo> getArt_photos4art_subgroup(IArt_subgroupPK art_subgroupPK) throws CustomException {
        return tableio.getEntities(EMart_photo.SQLSelect4art_subgroup, art_subgroupPK.getSQLprimarykey());
    }
    public void delete4art_academy(SQLTqueue transactionqueue, IArt_academyPK art_academyPK) {
        tableio.addStatement(transactionqueue, EMart_photo.SQLDelete4art_academy, art_academyPK.getSQLprimarykey());
    }

    public ArrayList<Art_photo> getArt_photos4art_academy(IArt_academyPK art_academyPK) throws CustomException {
        return tableio.getEntities(EMart_photo.SQLSelect4art_academy, art_academyPK.getSQLprimarykey());
    }
    public void delete4art_group(SQLTqueue transactionqueue, IArt_groupPK art_groupPK) {
        tableio.addStatement(transactionqueue, EMart_photo.SQLDelete4art_group, art_groupPK.getSQLprimarykey());
    }

    public ArrayList<Art_photo> getArt_photos4art_group(IArt_groupPK art_groupPK) throws CustomException {
        return tableio.getEntities(EMart_photo.SQLSelect4art_group, art_groupPK.getSQLprimarykey());
    }

    public ArrayList<Art_photo> getArt_photos(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_photo.SQLSelect);
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
        return (ArrayList<Art_photo>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delArt_photo(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_photo.table);
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
