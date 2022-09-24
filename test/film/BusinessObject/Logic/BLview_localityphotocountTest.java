package film.BusinessObject.Logic;

import data.gis.shape.piPoint;
import db.SQLreader;
import film.logicview.View_locality_photolocations;
import film.logicview.View_localityphotocount;
import general.exception.DBException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLview_localityphotocountTest {
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="blview_locality_photolocations")
    private BLview_locality_photolocations blview_locality_photolocations_mock = new BLview_locality_photolocations(sqlreader_mock);
    @Spy
    @InjectMocks
    private BLview_localityphotocount blview_localityphotocount = new BLview_localityphotocount(sqlreader_mock);

    public BLview_localityphotocountTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testget4Countrycode_nolocalities() {
        try {
            ArrayList<View_localityphotocount> localities = new ArrayList<>();
            doReturn(localities).when(blview_localityphotocount).getLocalities4countrycode(anyString(), anyBoolean());
            ArrayList<View_localityphotocount> result = blview_localityphotocount.get4Countrycode("BE", true);
            Assert.assertEquals(result.size(), 0);
        }
        catch(DBException e) {
        }
    }
    
    public piPoint createlocation(double x, double y) {
        piPoint location = new piPoint();
        location.setX(x);
        location.setY(y);
        return location;
    }
    
    @Test
    public void testget4Countrycode_1_localities() {
        try {
            ArrayList<View_localityphotocount> localities = new ArrayList<>();
            View_localityphotocount locality1 = new View_localityphotocount();
            locality1.setLocality("L1");
            locality1.setLocation(createlocation(1.1, 2.1));
            localities.add(locality1);
            doReturn(localities).when(blview_localityphotocount).getLocalities4countrycode(anyString(), anyBoolean());
            ArrayList<View_localityphotocount> result = blview_localityphotocount.get4Countrycode("BE", true);
            Assert.assertEquals(result.size(), 1);
            View_localityphotocount result1 = result.get(0);
            Assert.assertEquals(1.1, ((piPoint)result1.getLocation()).getX(), 0.001);
            Assert.assertEquals(2.1, ((piPoint)result1.getLocation()).getY(), 0.001);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testget4Countrycode_2_same_localities() {
        try {
            ArrayList<View_localityphotocount> localities = new ArrayList<>();
            View_localityphotocount locality1 = new View_localityphotocount();
            locality1.setLocality("L1");
            locality1.setLocation(createlocation(1.1, 2.1));
            locality1.setPhotocount(1);
            localities.add(locality1);
            View_localityphotocount locality2 = new View_localityphotocount();
            locality2.setLocality("L1");
            locality2.setLocation(createlocation(1.1, 2.1));
            locality2.setPhotocount(2);
            localities.add(locality2);
            doReturn(localities).when(blview_localityphotocount).getLocalities4countrycode(anyString(), anyBoolean());
            ArrayList<View_localityphotocount> result = blview_localityphotocount.get4Countrycode("BE", true);
            Assert.assertEquals(1, result.size());
            View_localityphotocount result1 = result.get(0);
            Assert.assertEquals(((piPoint)result1.getLocation()).getX(), 1.1, 0.001);
            Assert.assertEquals(((piPoint)result1.getLocation()).getY(), 2.1, 0.001);
            Assert.assertEquals(3, result1.getPhotocount());
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testget4Countrycode_2_localities_with_1_empty_locality_1_photolocation() {
        try {
            ArrayList<View_localityphotocount> localities = new ArrayList<>();
            View_localityphotocount locality1 = new View_localityphotocount();
            locality1.setLocality("L1");
            locality1.setLocation(createlocation(1.1, 2.1));
            locality1.setPhotocount(1);
            localities.add(locality1);
            View_localityphotocount locality2 = new View_localityphotocount();
            locality2.setLocality("L2");
            locality2.setPhotocount(2);
            locality2.setCountrycode("BE");
            localities.add(locality2);
            doReturn(localities).when(blview_localityphotocount).getLocalities4countrycode(anyString(), anyBoolean());
            ArrayList<View_locality_photolocations> photolocations = new ArrayList<>();
            View_locality_photolocations photolocation1 = new View_locality_photolocations();
            photolocation1.setLocation(createlocation(1.0, 2.0));
            photolocations.add(photolocation1);
            doReturn(photolocations).when(blview_locality_photolocations_mock).get4Location(anyString(), anyString());                    
            ArrayList<View_localityphotocount> result = blview_localityphotocount.get4Countrycode("BE", true);
            Assert.assertEquals(2, result.size());
            View_localityphotocount result1 = result.get(0);
            Assert.assertEquals(((piPoint)result1.getLocation()).getX(), 1.1, 0.001);
            Assert.assertEquals(((piPoint)result1.getLocation()).getY(), 2.1, 0.001);
            Assert.assertEquals(1, result1.getPhotocount());
            View_localityphotocount result2 = result.get(1);
            Assert.assertEquals(((piPoint)result2.getLocation()).getX(), 1.0, 0.001);
            Assert.assertEquals(((piPoint)result2.getLocation()).getY(), 2.0, 0.001);
            Assert.assertEquals(2, result2.getPhotocount());
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testget4Countrycode_2_localities_with_1_empty_locality_2_photolocation() {
        try {
            ArrayList<View_localityphotocount> localities = new ArrayList<>();
            View_localityphotocount locality1 = new View_localityphotocount();
            locality1.setLocality("L1");
            locality1.setLocation(createlocation(1.1, 2.1));
            locality1.setPhotocount(1);
            localities.add(locality1);
            View_localityphotocount locality2 = new View_localityphotocount();
            locality2.setLocality("L2");
            locality2.setPhotocount(2);
            locality2.setCountrycode("BE");
            localities.add(locality2);
            doReturn(localities).when(blview_localityphotocount).getLocalities4countrycode(anyString(), anyBoolean());
            ArrayList<View_locality_photolocations> photolocations = new ArrayList<>();
            View_locality_photolocations photolocation1 = new View_locality_photolocations();
            photolocation1.setLocation(createlocation(1.0, 2.0));
            photolocations.add(photolocation1);
            View_locality_photolocations photolocation2 = new View_locality_photolocations();
            photolocation2.setLocation(createlocation(1.1, 2.1));
            photolocations.add(photolocation2);
            doReturn(photolocations).when(blview_locality_photolocations_mock).get4Location(anyString(), anyString());                    
            ArrayList<View_localityphotocount> result = blview_localityphotocount.get4Countrycode("BE", true);
            Assert.assertEquals(2, result.size());
            View_localityphotocount result1 = result.get(0);
            Assert.assertEquals(1.1, ((piPoint)result1.getLocation()).getX(), 0.001);
            Assert.assertEquals(2.1, ((piPoint)result1.getLocation()).getY(), 0.001);
            Assert.assertEquals(1, result1.getPhotocount());
            View_localityphotocount result2 = result.get(1);
            Assert.assertEquals(1.05, ((piPoint)result2.getLocation()).getX(), 0.001);
            Assert.assertEquals(2.05, ((piPoint)result2.getLocation()).getY(), 0.001);
            Assert.assertEquals(2, result2.getPhotocount());
        }
        catch(DBException e) {
        }
    }
    
}
