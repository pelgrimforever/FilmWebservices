package film.BusinessObject.Logic;

import data.gis.shape.piPoint;
import data.interfaces.db.Filedata;
import db.SQLTqueue;
import db.SQLTwriter;
import db.SQLreader;
import film.BusinessObject.table.Bphoto;
import film.entity.pk.PhotoPK;
import film.entity.pk.RoutePK;
import film.logicentity.Arealevel1;
import film.logicentity.Arealevel2;
import film.logicentity.Arealevel3;
import film.logicentity.Country;
import film.logicentity.Locality;
import film.logicentity.Photo;
import film.logicentity.Postalcode;
import film.logicentity.Route;
import film.logicentity.Sublocality;
import film.usecases.Photo_usecases;
import general.exception.DBException;
import general.exception.DataException;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class PhotogeolocatorTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="sqlwriter")
    private SQLTwriter sqlwriter_mock = new SQLTwriter();
    @Mock(name="blphoto")
    private BLphoto blphoto_mock = new BLphoto(sqlreader_mock);
    @Mock(name="blcountry")
    BLcountry blcountry_mock = new BLcountry(sqlreader_mock);
    @Mock(name="blarealevel1")
    BLarealevel1 blarealevel1_mock = new BLarealevel1(sqlreader_mock);
    @Mock(name="blarealevel2")
    BLarealevel2 blarealevel2_mock = new BLarealevel2(sqlreader_mock);
    @Mock(name="blarealevel3")
    BLarealevel3 blarealevel3_mock = new BLarealevel3(sqlreader_mock);
    @Mock(name="blpostalcode")
    BLpostalcode blpostalcode_mock = new BLpostalcode(sqlreader_mock);
    @Mock(name="bllocality")
    BLlocality bllocality_mock = new BLlocality(sqlreader_mock);
    @Mock(name="blsublocality")
    BLsublocality blsublocality_mock = new BLsublocality(sqlreader_mock);
    @Mock(name="blroute")
    BLroute blroute_mock = new BLroute(sqlreader_mock);
    @InjectMocks
    private Photogeolocator photogeolocator = new Photogeolocator();
    
    public PhotogeolocatorTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
        try {
            doNothing().when(blcountry_mock).insertupdateCountry(any(SQLTqueue.class), any(Country.class));
            doNothing().when(blarealevel1_mock).insertupdateArealevel1(any(SQLTqueue.class), any(Arealevel1.class));
            doNothing().when(blarealevel2_mock).insertupdateArealevel2(any(SQLTqueue.class), any(Arealevel2.class));
            doNothing().when(blarealevel3_mock).insertupdateArealevel3(any(SQLTqueue.class), any(Arealevel3.class));
            doNothing().when(blpostalcode_mock).insertupdatePostalcode(any(SQLTqueue.class), any(Postalcode.class));
            doNothing().when(bllocality_mock).insertupdateLocality(any(SQLTqueue.class), any(Locality.class));
            doNothing().when(blsublocality_mock).insertupdateSublocality(any(SQLTqueue.class), any(Sublocality.class));
            doNothing().when(blroute_mock).insertupdateRoute(any(SQLTqueue.class), any(Route.class));
        }
        catch(DBException | DataException e) {
        }
    }

    @Test
    public void testupdateGeolocation_alldata() {
        try {
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
            photogeolocator.google_processreversegeocode(transactionqueue, photo);
            RoutePK routepk = photo.getRoutePK();
            Assert.assertEquals(routepk.getCountrycode(), "BE");
            Assert.assertEquals(routepk.getLocality(), "Brussels");
            Assert.assertEquals(routepk.getPostalcode(), "1000");
            Assert.assertEquals(routepk.getRoutecode(), "Rue des Grands Carmes");
            Assert.assertEquals(routepk.getSublocalityPK().getSublocality(), "Brussels");
            Assert.assertEquals(routepk.getSublocality(), "Brussels");
        }
        catch(DBException | DataException e) {
        }
    }
    
}
