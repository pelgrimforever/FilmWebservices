/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Film;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Film_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfilm blfilm = new BLfilm(sqlreader);
    
    public Film_usecases() {
        this(false);
    }
    
    public Film_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfilm.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    private static final String backupdir = "/media/serverbackup/autobackup/";
    
    private BLphoto blphoto = new BLphoto(sqlreader);
    private BLphototags blphototags = new BLphototags(sqlreader);
    private BLsubject blsubject = new BLsubject(sqlreader);
    private BLtree7subject bltree7subject = new BLtree7subject(sqlreader);
    private PhotoImagefile photoimagefile = new PhotoImagefile();    
    private FilmXML filmxml = new FilmXML(sqlreader);
    
    public ArrayList<Film> getFilms4Edit(film.logic.Userprofile userprofile) throws DBException {
        return blfilm.getFilms4Edit(userprofile);
    }

    public ArrayList<String> getFilmGroups() throws DBException {
        return blfilm.getGroups();
    }
    
    public void update_properties(film.logic.Userprofile userprofile, IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm(tq, userprofile, film);
        sqlwriter.Commit2DB(tq);
    }
    
    public void updateFilm_LoadJPGproperties(film.logic.Userprofile userprofile, IFilm film) throws IOException, DBException, DataException {
        if(blfilm.isAuthorised_for_edit(userprofile, film))
            updateFilm_LoadJPGproperties_authorised(userprofile, film);
    }

    private void updateFilm_LoadJPGproperties_authorised(film.logic.Userprofile userprofile, IFilm film) throws IOException, DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        boolean loadthumbnails = false;
        ArrayList<Photo> photos = blphoto.getPhotos4photo_film(userprofile.isEditor(), film.getPrimaryKey(), loadthumbnails);
        Filedata filedata;
        for(Photo photo: photos)
            updateFilm_LoadJPGproperties_authorised_savephototags(photo, tq);
        sqlwriter.Commit2DB(tq);
    }

    private void updateFilm_LoadJPGproperties_authorised_savephototags(Photo photo, SQLTqueue tq) throws IOException, DBException, DataException {
        Filedata filedata;
        boolean hasnophototags = blphototags.getPhototagss4photo(photo.getPrimaryKey()).size()==0;
        if(hasnophototags)
            updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG(photo, tq);
    }

    private void updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG(Photo photo, SQLTqueue tq) throws IOException, DBException, DataException {
        Filedata filedata;
        filedata = photoimagefile.getRootfiledata(photo.getPrimaryKey());
        if(filedata==null)
            filedata = photoimagefile.getSmallfiledata(photo.getPrimaryKey());
        if(filedata!=null)
            updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG_toDB(filedata, photo, tq);
    }

    public void updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG_toDB(
            Filedata filedata, 
            Photo photo, 
            SQLTqueue tq) 
            throws DataException, IOException, DBException {
        graphic.jpeg.Graphicfile gf = filedata.getGraphicfile();
        graphic.jpeg.Tag datetimetag = blphototags.findTag(gf.getMetadataTaglist(), graphic.jpeg.Tag.DATETIMEORIGINAL);
        if(datetimetag!=null)
            updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG_toDB_photoTimestamp(photo, datetimetag, tq);
        blphototags.insertGraphicfileMetatags(tq, gf, photo);
    }

    private void updateFilm_LoadJPGproperties_authorised_savephototags_extractfromJPG_toDB_photoTimestamp(
            Photo photo, 
            graphic.jpeg.Tag datetimetag, 
            SQLTqueue tq) 
            throws DataException, DBException {
        photo.setPhotodate(datetimetag.getDateValue());
        photo.setPhototime(datetimetag.getTimeValue());
        blphoto.updatePhoto(tq, photo);
    }

    public void updateFilm_LoadGPSproperties(
            film.logic.Userprofile userprofile, 
            IFilm film, 
            ArrayList<film.logicentity.GPSTrackpoint> gpstrackpoints) 
            throws DBException, DataException {
        if(blfilm.isAuthorised_for_edit(userprofile, film))
            updateFilm_LoadGPSproperties_authorised(userprofile, film, gpstrackpoints);
    }

    private long photodatetime;
    private int gpsarraypos;
    private int gpsarraylength;
    private GPSTrackpoint gpstrackpoint1;
    private GPSTrackpoint gpstrackpoint2;
    private GPSTrackpoint gpstrackpoint4photo;
    
    public void updateFilm_LoadGPSproperties_authorised(
            film.logic.Userprofile userprofile, 
            IFilm film, 
            ArrayList<GPSTrackpoint> gpstrackpoints) 
            throws DataException, DBException {
        SQLTqueue tq = new SQLTqueue();
        gpsarraypos = 1;
        gpsarraylength = gpstrackpoints.size();
        gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
        gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
        ArrayList<Photo> photos = blphoto.getPhotos4photo_film(userprofile.isEditor(), film.getPrimaryKey(), false);
        for(Photo photo: photos)
            updateFilm_LoadGPSproperties_authorised_for_photo(photo, gpstrackpoints, tq);
        sqlwriter.Commit2DB(tq);
    }

    private void updateFilm_LoadGPSproperties_authorised_for_photo(
            Photo photo, 
            ArrayList<GPSTrackpoint> gpstrackpoints, 
            SQLTqueue tq) 
            throws DataException, DBException {
        boolean photo_has_no_geographical_info = photo.getLocation()==null;
        if(photo_has_no_geographical_info)
            updateFilm_LoadGPSproperties_authorised_for_photo_findGPSpoint(gpstrackpoints, photo, tq);
    }

    private void updateFilm_LoadGPSproperties_authorised_for_photo_findGPSpoint(
            ArrayList<GPSTrackpoint> gpstrackpoints, 
            Photo photo, 
            SQLTqueue tq) throws DataException, DBException {
        photodatetime = photo.getPhotodate().getTime() + photo.getPhototime().getTime();
        while(gpstrackpoint1_is_later_then_photo() && gpsarraypos>1) {
            gpsarraypos--;
            gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
            gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
        }
        while(gpstrackpoint2_is_earlier_then_photo() && gpsarraypos<gpsarraylength) {
            gpsarraypos++;
            gpstrackpoint1 = gpstrackpoints.get(gpsarraypos-1);
            gpstrackpoint2 = gpstrackpoints.get(gpsarraypos);
        }
        if(phototimestamp_between_gpstrackpoints())
            updateFilm_LoadGPSproperties_authorised_for_photo_findGPSpoint_updateGeolocation(photo, tq);
    }

    private boolean gpstrackpoint1_is_later_then_photo() {
        return gpstrackpoint1.getDate().getTime()>photodatetime;
    }

    private boolean gpstrackpoint2_is_earlier_then_photo() {
        return gpstrackpoint2.getDate().getTime()<photodatetime;
    }

    private boolean phototimestamp_between_gpstrackpoints() {
        return gpstrackpoint1.getDate().getTime()<=photodatetime && gpstrackpoint2.getDate().getTime()>=photodatetime;
    }

    private void updateFilm_LoadGPSproperties_authorised_for_photo_findGPSpoint_updateGeolocation(
            Photo photo, 
            SQLTqueue tq) 
            throws DataException, DBException {
        boolean gpstrackpoint1_closer_in_time = photodatetime-gpstrackpoint1.getDate().getTime() > gpstrackpoint2.getDate().getTime()-photodatetime;
        gpstrackpoint4photo = gpstrackpoint1_closer_in_time ? gpstrackpoint1 : gpstrackpoint2;
        photo.setLocation(gpstrackpoint4photo.getPoint());
        Geocode geocode = new Geocode();
        photo.setReversegeocode(geocode.reversegeocode(gpstrackpoint4photo.getPoint().getY(), gpstrackpoint4photo.getPoint().getX()));
        Photo_usecases photo_usecases = new Photo_usecases();
        photo_usecases.updateGeolocation(photo);
    }

    public void backupPhotos(IFilmPK filmPK) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        Film film = blfilm.getFilm(filmPK);
        ArrayList<Photo> photobackups = blphoto.getPhotos4photo_film_imagebackup(filmPK);
        if(photobackups.size()>0)
            blphoto.backupImages(tq, film, photobackups.get(0), backupdir);
        else
            export_backup_to_xml(film, tq);
        sqlwriter.Commit2DB(tq);
    }

    private void export_backup_to_xml(Film film, SQLTqueue tq) throws DBException, FileNotFoundException, IOException {
        ArrayList<Photo> photobackups;
        photobackups = blphoto.getPhotos4photo_film_backup(film.getPrimaryKey());
        if(photobackups.isEmpty())
            export_backup_to_xml_hasdata(film, tq);
    }

    private void export_backup_to_xml_hasdata(Film film, SQLTqueue tq) throws DBException, FileNotFoundException, IOException {
        FilmPK filmPK = film.getPrimaryKey();
        StringBuffer rootimagepath = blfilm.getRootImagePath(film.getPrimaryKey());
        filmxml.export_backup_to_xml(film, backupdir, rootimagepath);
        blphoto.setBackedup(tq, filmPK);
    }

    public ArrayList<String> Checkbackup() throws DBException, CustomException {
        ArrayList<String> list = new ArrayList();
        ArrayList<film.logicentity.Film> films = blfilm.getFilms();
        for(film.logicentity.Film film: films)
            Checkbackup_for_film(film, list);
        return list;
    }

    private void Checkbackup_for_film(Film film, ArrayList<String> list) throws CustomException {
        ArrayList<film.logicentity.Photo> photos = blphoto.getPhotos4film(film.getPrimaryKey());
        for(film.logicentity.Photo photo: photos)
            Checkbackup_for_photo(film, photo, list);
    }

    private String backuppath;
    private String backupfullname;
    private File backupfile;
    
    private void Checkbackup_for_photo(Film film, Photo photo, ArrayList<String> list) {
        backuppath = backupdir + blfilm.getRootImagePath(film.getPrimaryKey()).toString() + "/";
        backupfullname = backuppath + photoimagefile.getFilename(photo.getPrimaryKey());
        backupfile = new File(backupfullname);
        if(!backupfile.exists())
            list.add(backupfullname);
    }

//Custom code, do not change this line   

    public long count() throws DBException {
        return blfilm.count();
    }
    
    public ArrayList<Film> get_all() throws DBException {
        return blfilm.getFilms();
    }
    
    public boolean getFilmExists(IFilmPK filmPK) throws DBException {
        return blfilm.getFilmExists(filmPK);
    }
    
    public Film get_film_by_primarykey(IFilmPK filmPK) throws DBException {
        return blfilm.getFilm(filmPK);
    }

    public ArrayList<Film> get_film_with_foreignkey_filmtype(IFilmtypePK filmtypePK) throws CustomException {
        return blfilm.getFilms4filmtype(filmtypePK);
    }
    
    public Film get_film_with_externalforeignkey_filmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        return blfilm.getFilmsubjects(filmsubjectsPK);
    }
    
    public Film get_film_with_externalforeignkey_photo(IPhotoPK photoPK) throws CustomException {
        return blfilm.getPhoto(photoPK);
    }
    
    public ArrayList<Film> search_film(IFilmsearch filmsearch) throws CustomException {
        return blfilm.search(filmsearch);
    }
    
    public long search_film_count(IFilmsearch filmsearch) throws CustomException {
        return blfilm.searchcount(filmsearch);
    }

    public void insertFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.insertFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.updateFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFilm(IFilm film) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.deleteFilm(tq, film);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Filmtype(IFilmtypePK filmtypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfilm.delete4filmtype(tq, filmtypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

