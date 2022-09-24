package film.usecases;

import data.gis.shape.piPoint;
import data.interfaces.db.Filedata;
import db.SQLTqueue;
import db.SQLTwriter;
import db.SQLreader;
import film.BusinessObject.Logic.BLarealevel1;
import film.BusinessObject.Logic.BLarealevel2;
import film.BusinessObject.Logic.BLarealevel3;
import film.BusinessObject.Logic.BLcountry;
import film.BusinessObject.Logic.BLlocality;
import film.BusinessObject.Logic.BLphoto;
import film.BusinessObject.Logic.BLpostalcode;
import film.BusinessObject.Logic.BLroute;
import film.BusinessObject.Logic.BLsublocality;
import film.BusinessObject.Logic.PhotoImagefile;
import film.BusinessObject.Logic.Photogeolocator;
import film.BusinessObject.table.Bphoto;
import film.entity.pk.PhotoPK;
import film.entity.pk.RoutePK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ISecurityprofile;
import static film.logic.Userprofile.PRIVATEUSER;
import film.logicentity.Arealevel1;
import film.logicentity.Arealevel2;
import film.logicentity.Arealevel3;
import film.logicentity.Country;
import film.logicentity.Locality;
import film.logicentity.Photo;
import film.logicentity.Postalcode;
import film.logicentity.Route;
import film.logicentity.Securityprofile;
import film.logicentity.Sublocality;
import general.exception.DBException;
import general.exception.DataException;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import sitesecurity.interfaces.logicentity.ISitegroup;

/**
 * @author Franky Laseure
 */
public class Photo_usecasesTest {
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="sqlwriter")
    private SQLTwriter sqlwriter_mock = new SQLTwriter();
    @Mock(name="blphoto")
    private BLphoto blphoto_mock = new BLphoto(sqlreader_mock);
    @Mock(name="photogeolocator")
    Photogeolocator photogeolocator_mock = new Photogeolocator();
    @Mock(name="photoimagefile")
    private PhotoImagefile photoimagefile_mock = new PhotoImagefile();
    @InjectMocks
    private Photo_usecases photo_usecases_notauthorised = new Photo_usecases(false);
    @InjectMocks
    private Photo_usecases photo_usecases_authorised = new Photo_usecases(true);
    
    public Photo_usecasesTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
        try {
            Filedata filedata = new Filedata();
            doReturn(filedata).when(photoimagefile_mock).getSmallfiledata(any(PhotoPK.class));
        }
        catch(IOException e) {
        }
    }
    
    @Test
    public void get_smallimage_from_photo_notauthorised_notpublicphoto() {
        try {
            blphoto_mock.setAuthenticated(false);
            Filedata filedata = new Filedata();
            doReturn(filedata).when(photoimagefile_mock).getSmallfiledata(any(PhotoPK.class));
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when((Bphoto)blphoto_mock).getPhoto(any(PhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            film.logic.Userprofile userprofile = new film.logic.Userprofile(sitegroups, profiles);
            IPhotoPK photoPK = new PhotoPK();
            doReturn(false).when(blphoto_mock).hasAccess(any(film.logic.Userprofile.class), any(IPhotoPK.class));
            Filedata result = photo_usecases_notauthorised.get_smallimage_from_photo(userprofile, photoPK);
            Assert.assertEquals(result, null);
        }
        catch(DBException | IOException e) {
        }
    }

    @Test
    public void get_smallimage_from_photo_notauthorised_publicphoto() {
        try {
            blphoto_mock.setAuthenticated(false);
            Filedata filedata = new Filedata();
            doReturn(filedata).when(photoimagefile_mock).getSmallfiledata(any(PhotoPK.class));
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when((Bphoto)blphoto_mock).getPhoto(any(PhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            film.logic.Userprofile userprofile = new film.logic.Userprofile(sitegroups, profiles);
            IPhotoPK photoPK = new PhotoPK();
            doReturn(true).when(blphoto_mock).hasAccess(any(film.logic.Userprofile.class), any(IPhotoPK.class));
            Filedata result = photo_usecases_notauthorised.get_smallimage_from_photo(userprofile, photoPK);
            Assert.assertEquals(result, filedata);
        }
        catch(DBException | IOException e) {
        }
    }

    @Test
    public void get_smallimage_from_photo_authorised() {
        try {
            blphoto_mock.setAuthenticated(true);
            Filedata filedata = new Filedata();
            doReturn(filedata).when(photoimagefile_mock).getSmallfiledata(any(PhotoPK.class));
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when((Bphoto)blphoto_mock).getPhoto(any(PhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            ISecurityprofile securityprofile = new Securityprofile(PRIVATEUSER);
            securityprofile.setPrivateaccess(true);
            profiles.add(securityprofile);
            film.logic.Userprofile userprofile = new film.logic.Userprofile(sitegroups, profiles);
            IPhotoPK photoPK = new PhotoPK();
            doReturn(true).when(blphoto_mock).hasAccess(any(film.logic.Userprofile.class), any(IPhotoPK.class));
            Filedata result = photo_usecases_authorised.get_smallimage_from_photo(userprofile, photoPK);
            Assert.assertEquals(result, filedata);
        }
        catch(DBException | IOException e) {
        }
    }

    @Test
    public void testupdateGeolocation_nochange() {
        try {
            Photo photo = new Photo("TST001", 1);
            photo_usecases_authorised.updateGeolocation(photo);
            verify(blphoto_mock, times(0)).updatePhoto(any(SQLTqueue.class), any(Photo.class));
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void testupdateGeolocation_alldata() {
        try {
            doNothing().when(blphoto_mock).updatePhoto(any(SQLTqueue.class), any(Photo.class));
            Photo dbphoto = new Photo("TST001", 1);
            doReturn(dbphoto).when((Bphoto)blphoto_mock).getPhoto(any(PhotoPK.class));
            Photo photo = new Photo("TST001", 1);
            String reverselocation = "{" +
"   \"results\" : [" +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"10\"," +
"               \"short_name\" : \"10\"," +
"               \"types\" : [ \"street_number\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Rue des Grands Carmes\"," +
"               \"short_name\" : \"Rue des Grands Carmes\"," +
"               \"types\" : [ \"route\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"1000\"," +
"               \"short_name\" : \"1000\"," +
"               \"types\" : [ \"postal_code\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Rue des Grands Carmes 10, 1000 Bruxelles, Belgium\"," +
"         \"geometry\" : {" +
"            \"location\" : {" +
"               \"lat\" : 50.84552799999999," +
"               \"lng\" : 4.348694399999999" +
"            }," +
"            \"location_type\" : \"ROOFTOP\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.84687698029149," +
"                  \"lng\" : 4.350043380291502" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.84417901970849," +
"                  \"lng\" : 4.347345419708497" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJ_5gjVXjEw0cREslvxhsBopM\"," +
"         \"types\" : [ \"street_address\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"La Fontaine Saint-Jacques (Eau Potable)\"," +
"               \"short_name\" : \"La Fontaine Saint-Jacques (Eau Potable)\"," +
"               \"types\" : [ \"establishment\", \"point_of_interest\", \"premise\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"1000\"," +
"               \"short_name\" : \"1000\"," +
"               \"types\" : [ \"postal_code\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"La Fontaine Saint-Jacques (Eau Potable), 1000 Bruxelles, Belgium\"," +
"         \"geometry\" : {" +
"            \"location\" : {" +
"               \"lat\" : 50.84555539999999," +
"               \"lng\" : 4.3476492" +
"            }," +
"            \"location_type\" : \"ROOFTOP\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.8469043802915," +
"                  \"lng\" : 4.348998180291503" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.8442064197085," +
"                  \"lng\" : 4.346300219708498" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJKw9bS3jEw0cRH8b_ORMa198\"," +
"         \"types\" : [ \"establishment\", \"point_of_interest\", \"premise\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"Stalingrad\"," +
"               \"short_name\" : \"Stalingrad\"," +
"               \"types\" : [ \"neighborhood\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Grand-Place\"," +
"               \"short_name\" : \"Grand-Place\"," +
"               \"types\" : [ \"political\", \"sublocality\", \"sublocality_level_2\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Bruxelles\"," +
"               \"short_name\" : \"Bruxelles\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"1000\"," +
"               \"short_name\" : \"1000\"," +
"               \"types\" : [ \"postal_code\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Stalingrad, 1000 Bruxelles, Belgium\"," +
"         \"geometry\" : {" +
"            \"bounds\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.84678719999999," +
"                  \"lng\" : 4.3543196" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.8389284," +
"                  \"lng\" : 4.340972799999999" +
"               }" +
"            }," +
"            \"location\" : {" +
"               \"lat\" : 50.8435425," +
"               \"lng\" : 4.3477656" +
"            }," +
"            \"location_type\" : \"APPROXIMATE\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.84678719999999," +
"                  \"lng\" : 4.3543196" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.8389284," +
"                  \"lng\" : 4.340972799999999" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJN_2MiHnEw0cRIyIefrym8Yw\"," +
"         \"types\" : [ \"neighborhood\", \"political\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"Brussels\"," +
"               \"short_name\" : \"Brussels\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Brussels\"," +
"               \"short_name\" : \"Brussels\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Brussels, Belgium\"," +
"         \"geometry\" : {" +
"            \"bounds\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.91370999999999," +
"                  \"lng\" : 4.4369799" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.7962401," +
"                  \"lng\" : 4.3138" +
"               }" +
"            }," +
"            \"location\" : {" +
"               \"lat\" : 50.8503396," +
"               \"lng\" : 4.3517103" +
"            }," +
"            \"location_type\" : \"APPROXIMATE\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.91370999999999," +
"                  \"lng\" : 4.4369799" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.7962401," +
"                  \"lng\" : 4.3138" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJZ2jHc-2kw0cRpwJzeGY6i8E\"," +
"         \"types\" : [ \"locality\", \"political\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"1000\"," +
"               \"short_name\" : \"1000\"," +
"               \"types\" : [ \"postal_code\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Brussels\"," +
"               \"short_name\" : \"Brussels\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Brussels\"," +
"               \"short_name\" : \"Brussels\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"1000 Brussels, Belgium\"," +
"         \"geometry\" : {" +
"            \"bounds\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.8838089," +
"                  \"lng\" : 4.4013462" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.7960624," +
"                  \"lng\" : 4.3355197" +
"               }" +
"            }," +
"            \"location\" : {" +
"               \"lat\" : 50.8427501," +
"               \"lng\" : 4.3515499" +
"            }," +
"            \"location_type\" : \"APPROXIMATE\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.8838089," +
"                  \"lng\" : 4.4013462" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.7960624," +
"                  \"lng\" : 4.3355197" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJX6UHPofEw0cRXd0IVgg8wQA\"," +
"         \"types\" : [ \"postal_code\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"Brussels\"," +
"               \"short_name\" : \"Brussels\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Brussels, Belgium\"," +
"         \"geometry\" : {" +
"            \"bounds\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.91370999999999," +
"                  \"lng\" : 4.4822099" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.76369," +
"                  \"lng\" : 4.2446001" +
"               }" +
"            }," +
"            \"location\" : {" +
"               \"lat\" : 50.8503463," +
"               \"lng\" : 4.3517211" +
"            }," +
"            \"location_type\" : \"APPROXIMATE\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.91370999999999," +
"                  \"lng\" : 4.4822099" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.76369," +
"                  \"lng\" : 4.2446001" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJ_58PdIbEw0cRMIBML6uZAAE\"," +
"         \"types\" : [ \"administrative_area_level_1\", \"locality\", \"political\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Belgium\"," +
"         \"geometry\" : {" +
"            \"bounds\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 51.5051449," +
"                  \"lng\" : 6.408124099999999" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 49.497013," +
"                  \"lng\" : 2.5240999" +
"               }" +
"            }," +
"            \"location\" : {" +
"               \"lat\" : 50.503887," +
"               \"lng\" : 4.469936" +
"            }," +
"            \"location_type\" : \"APPROXIMATE\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 51.5051449," +
"                  \"lng\" : 6.408124099999999" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 49.497013," +
"                  \"lng\" : 2.5240999" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJl5fz7WR9wUcR8g_mObTy60c\"," +
"         \"types\" : [ \"country\", \"political\" ]" +
"      }," +
"      {" +
"         \"address_components\" : [" +
"            {" +
"               \"long_name\" : \"Beurs\"," +
"               \"short_name\" : \"Beurs\"," +
"               \"types\" : [" +
"                  \"bus_station\"," +
"                  \"establishment\"," +
"                  \"point_of_interest\"," +
"                  \"transit_station\"" +
"               ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Brussel\"," +
"               \"short_name\" : \"Brussel\"," +
"               \"types\" : [ \"locality\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Brussels Hoofdstedelijk Gewest\"," +
"               \"short_name\" : \"Brussels Hoofdstedelijk Gewest\"," +
"               \"types\" : [ \"administrative_area_level_1\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"Belgium\"," +
"               \"short_name\" : \"BE\"," +
"               \"types\" : [ \"country\", \"political\" ]" +
"            }," +
"            {" +
"               \"long_name\" : \"1000\"," +
"               \"short_name\" : \"1000\"," +
"               \"types\" : [ \"postal_code\" ]" +
"            }" +
"         ]," +
"         \"formatted_address\" : \"Beurs, 1000 Brussel, Belgium\"," +
"         \"geometry\" : {" +
"            \"location\" : {" +
"               \"lat\" : 50.8464864," +
"               \"lng\" : 4.3483792" +
"            }," +
"            \"location_type\" : \"GEOMETRIC_CENTER\"," +
"            \"viewport\" : {" +
"               \"northeast\" : {" +
"                  \"lat\" : 50.84783538029149," +
"                  \"lng\" : 4.349728180291502" +
"               }," +
"               \"southwest\" : {" +
"                  \"lat\" : 50.84513741970849," +
"                  \"lng\" : 4.347030219708498" +
"               }" +
"            }" +
"         }," +
"         \"place_id\" : \"ChIJZ8oNXHjEw0cROnYGvRh8hi8\"," +
"         \"types\" : [" +
"            \"bus_station\"," +
"            \"establishment\"," +
"            \"point_of_interest\"," +
"            \"transit_station\"" +
"         ]" +
"      }" +
"   ]," +
"   \"status\" : \"OK\"" +
"}";
            photo.setReversegeocode(reverselocation);
            piPoint location = new piPoint();
            location.setX(4.348694399999999);
            location.setY(50.84552799999999);
            photo.setLocation(location);
            photo.setExactlocation(true);
            photo_usecases_authorised.updateGeolocation(photo);
            verify(blphoto_mock, times(1)).updatePhoto(any(SQLTqueue.class), any(Photo.class));
        }
        catch(DBException | DataException e) {
        }
    }
}
