/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMfilm;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmsearch;
import film.logicentity.Film;

/**
 * @author Franky Laseure
 */
public abstract class Bfilm extends TableBusinessrules {

    public Bfilm(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfilm()));
    }

    public Bfilm(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfilm()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFilm newFilm() {
    	return new Film();
    }
    
    public IFilm newFilm(java.lang.String id) {
        return new Film(id);
    }

    public IFilm newFilm(IFilmPK filmPK) {
        return new Film((FilmPK)filmPK);
    }

    public IFilmPK newFilmPK() {
        return new FilmPK();
    }

    public IFilmPK newFilmPK(java.lang.String id) {
        return new FilmPK(id);
    }

    public ArrayList<Film> getFilms() throws DBException {
        return (ArrayList<Film>)tableio.getEntities(EMfilm.SQLSelectAll);
    }

    public Film getFilm(IFilmPK filmPK) throws DBException {
        return (Film)tableio.getEntity((FilmPK)filmPK);
    }

    public ArrayList<Film> searchfilms(IFilmsearch search) throws DBException {
        return (ArrayList<Film>)tableio.search(search);
    }

    public ArrayList<Film> searchfilms(IFilmsearch search, String orderby) throws DBException {
        return (ArrayList<Film>)tableio.search(search, orderby);
    }

    public boolean getFilmExists(IFilmPK filmPK) throws DBException {
        return tableio.getEntityExists((FilmPK)filmPK);
    }

    public Film getEntity(String sql) throws DBException {
        return (Film)tableio.getEntity(sql);
    }
    
    public Film getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Film)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Film> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Film> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Film> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Film> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFilm(SQLTqueue transactionqueue, IFilm film) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, film);
    }

    public void insertupdateFilm(SQLTqueue transactionqueue, IFilm film) throws DBException, DataException {
    	checkDATA(film);
        if(this.getFilmExists(film.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, film);
        } else {
            tableio.insertEntity(transactionqueue, film);
        }
    }

    public void updateFilm(SQLTqueue transactionqueue, IFilm film) throws DBException, DataException {
    	checkDATA(film);
        tableio.updateEntity(transactionqueue, film);
    }

    public void deleteFilm(SQLTqueue transactionqueue, IFilm film) throws DBException {
        cascadedeleteFilm(transactionqueue, film.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, film);
    }

    private void checkDATA(IFilm film) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(film.getFilmtypePK()!=null && film.getFilmtypePK().getType()!=null && film.getFilmtypePK().getType().length()>IFilm.SIZE_TYPE) {
            message.append("Type is langer dan toegestaan. Max aantal karakters: " + IFilm.SIZE_TYPE + "\n");
        }
        if(film.getFilmtypePK()==null || film.getFilmtypePK().getType()==null) {
            message.append("Type mag niet leeg zijn.\n");
        }

        if(film.getIso()!=null && film.getIso().length()>IFilm.SIZE_ISO) {
            message.append("Iso is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_ISO).append("\n");
        }
        if(film.getOwner()!=null && film.getOwner().length()>IFilm.SIZE_OWNER) {
            message.append("Owner is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_OWNER).append("\n");
        }
        if(film.getCd()!=null && film.getCd().length()>IFilm.SIZE_CD) {
            message.append("Cd is langer dan toegestaan. Max aantal karakters: ").append(IFilm.SIZE_CD).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteFilm(SQLTqueue transactionqueue, IFilmPK filmPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.setAuthenticated(isAuthenticated());
        blfilmsubjects.delete4film(transactionqueue, filmPK);
        BLphoto blphoto = new BLphoto(this);
        blphoto.setAuthenticated(isAuthenticated());
        blphoto.delete4film(transactionqueue, filmPK);
    }

    public void delete4filmtype(SQLTqueue transactionqueue, IFilmtypePK filmtypePK) {
        tableio.addStatement(transactionqueue, EMfilm.SQLDelete4filmtype, filmtypePK.getSQLprimarykey());
    }

    public ArrayList<Film> getFilms4filmtype(IFilmtypePK filmtypePK) throws CustomException {
        return tableio.getEntities(EMfilm.SQLSelect4filmtype, filmtypePK.getSQLprimarykey());
    }
    public Film getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        FilmPK filmPK = new FilmPK(filmsubjectsPK.getFilm());
        return this.getFilm(filmPK);
    }

    public Film getPhoto(IPhotoPK photoPK) throws CustomException {
        FilmPK filmPK = new FilmPK(photoPK.getFilm());
        return this.getFilm(filmPK);
    }


    public ArrayList<Film> getFilms(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilm.SQLSelect);
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
        return (ArrayList<Film>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFilm(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Film.table);
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
