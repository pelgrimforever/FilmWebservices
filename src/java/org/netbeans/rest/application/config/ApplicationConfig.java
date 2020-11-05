/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Franky Laseure
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Do not modify this method. It is automatically generated by NetBeans REST support.
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(film.restservices.RSArealevel1.class);
        resources.add(film.restservices.RSArealevel2.class);
        resources.add(film.restservices.RSArealevel3.class);
        resources.add(film.restservices.RSArt_academy.class);
        resources.add(film.restservices.RSArt_group.class);
        resources.add(film.restservices.RSArt_photo.class);
        resources.add(film.restservices.RSArt_subgroup.class);
        resources.add(film.restservices.RSCountry.class);
        resources.add(film.restservices.RSCreator.class);
        resources.add(film.restservices.RSFilm.class);
        resources.add(film.restservices.RSFilmsubjects.class);
        resources.add(film.restservices.RSFilmtype.class);
        resources.add(film.restservices.RSLocality.class);
        resources.add(film.restservices.RSMainmenu.class);
        resources.add(film.restservices.RSMenu.class);
        resources.add(film.restservices.RSMenuitem.class);
        resources.add(film.restservices.RSPhoto.class);
        resources.add(film.restservices.RSPhotosubjects.class);
        resources.add(film.restservices.RSPhototags.class);
        resources.add(film.restservices.RSPhototree7subject.class);
        resources.add(film.restservices.RSPostalcode.class);
        resources.add(film.restservices.RSRoute.class);
        resources.add(film.restservices.RSSecurityprofile.class);
        resources.add(film.restservices.RSSecurityuserprofile.class);
        resources.add(film.restservices.RSSpatial_ref_sys.class);
        resources.add(film.restservices.RSSubject.class);
        resources.add(film.restservices.RSSubjectcat.class);
        resources.add(film.restservices.RSSublocality.class);
        resources.add(film.restservices.RSTree7subject.class);
        resources.add(film.restservices.RSUploadsession.class);
        resources.add(film.restservices.RSUploadsessionsettings.class);
        resources.add(film.restservices.RSGeography_columns.class);
        resources.add(film.restservices.RSGeometry_columns.class);
        resources.add(film.restservices.RSRaster_columns.class);
        resources.add(film.restservices.RSRaster_overviews.class);
        resources.add(film.restservices.RSView_backupstatus.class);
        resources.add(film.restservices.RSView_countryphotocount.class);
        resources.add(film.restservices.RSView_locality_photolocations.class);
        resources.add(film.restservices.RSView_localityphotocount.class);
        resources.add(film.restservices.RSView_locationtree.class);
        resources.add(film.restservices.RSView_photo_firstlastdate.class);
        resources.add(film.restservices.RSView_photodates.class);
        resources.add(film.restservices.RSView_photodatespublic.class);
        resources.add(film.restservices.RSView_photolocations.class);
        resources.add(film.restservices.RSView_publiccountryphotocount.class);
        resources.add(film.restservices.RSView_publiclocalityphotocount.class);
        resources.add(film.restservices.RSView_publicphotolocations.class);
        resources.add(film.restservices.RSView_subjects_for_film.class);
        resources.add(film.restservices.RSView_subjects_for_photo.class);
        return resources;
    }
}
//needs customization by programmer ?
