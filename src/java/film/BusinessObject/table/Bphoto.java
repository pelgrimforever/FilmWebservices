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
import film.conversion.entity.EMphoto;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhotosearch;
import film.logicentity.Photo;

public abstract class Bphoto extends TableBusinessrules {

    public Bphoto(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMphoto()));
    }

    public Bphoto(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMphoto()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IPhoto newPhoto() {
    	return new Photo();
    }
    
    public IPhoto newPhoto(java.lang.String film, int id) {
        return new Photo(film, id);
    }

    public IPhoto newPhoto(IPhotoPK photoPK) {
        return new Photo((PhotoPK)photoPK);
    }

    public IPhotoPK newPhotoPK() {
        return new PhotoPK();
    }

    public IPhotoPK newPhotoPK(java.lang.String film, int id) {
        return new PhotoPK(film, id);
    }

    public ArrayList<Photo> getPhotos() throws DBException {
        return (ArrayList<Photo>)tableio.getEntities(EMphoto.SQLSelectAll);
    }

    public Photo getPhoto(IPhotoPK photoPK) throws DBException {
        return (Photo)tableio.getEntity((PhotoPK)photoPK);
    }

    public ArrayList<Photo> searchphotos(IPhotosearch search) throws DBException {
        return (ArrayList<Photo>)tableio.search(search);
    }

    public ArrayList<Photo> searchphotos(IPhotosearch search, String orderby) throws DBException {
        return (ArrayList<Photo>)tableio.search(search, orderby);
    }

    public boolean getPhotoExists(IPhotoPK photoPK) throws DBException {
        return tableio.getEntityExists((PhotoPK)photoPK);
    }

    public Photo getEntity(String sql) throws DBException {
        return (Photo)tableio.getEntity(sql);
    }
    
    public Photo getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Photo)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Photo> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Photo> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Photo> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Photo> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertPhoto(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, photo);
    }

    public void insertupdatePhoto(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
    	checkDATA(photo);
        if(this.getPhotoExists(photo.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, photo);
        } else {
            tableio.insertEntity(transactionqueue, photo);
        }
    }

    public void updatePhoto(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
    	checkDATA(photo);
        tableio.updateEntity(transactionqueue, photo);
    }

    public void deletePhoto(SQLTqueue transactionqueue, IPhoto photo) throws DBException {
        cascadedeletePhoto(transactionqueue, photo.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, photo);
    }

    private void checkDATA(IPhoto photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photo.Film - Film.Id
        //Primary key
        if(photo.getRoutePK()!=null && photo.getRoutePK().getCountrycode()!=null && photo.getRoutePK().getCountrycode().length()>IPhoto.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_COUNTRYCODE + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getPostalcode()!=null && photo.getRoutePK().getPostalcode().length()>IPhoto.SIZE_POSTALCODE) {
            message.append("Postalcode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_POSTALCODE + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getLocality()!=null && photo.getRoutePK().getLocality().length()>IPhoto.SIZE_LOCALITY) {
            message.append("Locality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_LOCALITY + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getSublocality()!=null && photo.getRoutePK().getSublocality().length()>IPhoto.SIZE_SUBLOCALITY) {
            message.append("Sublocality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_SUBLOCALITY + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getRoutecode()!=null && photo.getRoutePK().getRoutecode().length()>IPhoto.SIZE_ROUTECODE) {
            message.append("Routecode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_ROUTECODE + "\n");
        }

        if(photo.getCreatorPK()!=null && photo.getCreatorPK().getCreatorid()!=null && photo.getCreatorPK().getCreatorid().length()>IPhoto.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_CREATOR + "\n");
        }

        if(photo.getFormat()!=null && photo.getFormat().length()>IPhoto.SIZE_FORMAT) {
            message.append("Format is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_FORMAT).append("\n");
        }
        if(photo.getFormat()==null) {
            message.append("Format mag niet leeg zijn.\n");
        }
        if(photo.getDescription()!=null && photo.getDescription().length()>IPhoto.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_DESCRIPTION).append("\n");
        }
        if(photo.getReversegeocode()!=null && photo.getReversegeocode().length()>IPhoto.SIZE_REVERSEGEOCODE) {
            message.append("Reversegeocode is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_REVERSEGEOCODE).append("\n");
        }
        if(photo.getStreetnumber()!=null && photo.getStreetnumber().length()>IPhoto.SIZE_STREETNUMBER) {
            message.append("Streetnumber is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_STREETNUMBER).append("\n");
        }
        if(photo.getFormattedaddress()!=null && photo.getFormattedaddress().length()>IPhoto.SIZE_FORMATTEDADDRESS) {
            message.append("Formattedaddress is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_FORMATTEDADDRESS).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeletePhoto(SQLTqueue transactionqueue, IPhotoPK photoPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.setAuthenticated(isAuthenticated());
        blphototree7subject.delete4photo(transactionqueue, photoPK);
        BLart_photo blart_photo = new BLart_photo(this);
        blart_photo.setAuthenticated(isAuthenticated());
        blart_photo.delete4photo(transactionqueue, photoPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.setAuthenticated(isAuthenticated());
        blphotosubjects.delete4photo(transactionqueue, photoPK);
        BLphototags blphototags = new BLphototags(this);
        blphototags.setAuthenticated(isAuthenticated());
        blphototags.delete4photo(transactionqueue, photoPK);
    }

    public void delete4route(SQLTqueue transactionqueue, IRoutePK routePK) {
        tableio.addStatement(transactionqueue, EMphoto.SQLDelete4route, routePK.getSQLprimarykey());
    }

    public ArrayList<Photo> getPhotos4route(IRoutePK routePK) throws CustomException {
        return tableio.getEntities(EMphoto.SQLSelect4route, routePK.getSQLprimarykey());
    }
    public void delete4creator(SQLTqueue transactionqueue, ICreatorPK creatorPK) {
        tableio.addStatement(transactionqueue, EMphoto.SQLDelete4creator, creatorPK.getSQLprimarykey());
    }

    public ArrayList<Photo> getPhotos4creator(ICreatorPK creatorPK) throws CustomException {
        return tableio.getEntities(EMphoto.SQLSelect4creator, creatorPK.getSQLprimarykey());
    }
    public void delete4film(SQLTqueue transactionqueue, IFilmPK filmPK) {
        tableio.addStatement(transactionqueue, EMphoto.SQLDelete4film, filmPK.getSQLprimarykey());
    }

    public ArrayList<Photo> getPhotos4film(IFilmPK filmPK) throws CustomException {
        return tableio.getEntities(EMphoto.SQLSelect4film, filmPK.getSQLprimarykey());
    }
    public Photo getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(phototree7subjectPK.getFilm(), phototree7subjectPK.getId());
        return this.getPhoto(photoPK);
    }

    public Photo getArt_photo(IArt_photoPK art_photoPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(art_photoPK.getFilm(), art_photoPK.getPhoto());
        return this.getPhoto(photoPK);
    }

    public Photo getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(photosubjectsPK.getFilm(), photosubjectsPK.getId());
        return this.getPhoto(photoPK);
    }

    public Photo getPhototags(IPhototagsPK phototagsPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(phototagsPK.getFilm(), phototagsPK.getId());
        return this.getPhoto(photoPK);
    }


    public ArrayList<Photo> getPhotos(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphoto.SQLSelect);
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
        return (ArrayList<Photo>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delPhoto(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Photo.table);
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
