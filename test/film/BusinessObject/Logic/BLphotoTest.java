package film.BusinessObject.Logic;

import data.gis.shape.piPoint;
import db.SQLTqueue;
import db.SQLreader;
import film.entity.pk.FilmPK;
import film.entity.pk.PhotoPK;
import film.entity.pk.RoutePK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.ISecurityprofile;
import film.logic.Userprofile;
import static film.logic.Userprofile.EDITOR;
import film.logicentity.Photo;
import film.logicentity.Securityprofile;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import sitesecurity.interfaces.logicentity.ISitegroup;

/**
 * @author Franky Laseure
 */
public class BLphotoTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLphoto blphoto = new BLphoto(sqlreader_mock);
    
    public BLphotoTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testhasAccess_noauthorisation_notpublic() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            boolean hasaccess = blphoto.hasAccess(userprofile, photoPK);
            Assert.assertFalse(hasaccess);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testhasAccess_noauthorisation_public() {
        try {
            Photo photo = new Photo();
            photo.setPublic(true);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            boolean hasaccess = blphoto.hasAccess(userprofile, photoPK);
            Assert.assertTrue(hasaccess);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testhasAccess_authorisation_notpublic() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            boolean hasaccess = blphoto.hasAccess(userprofile, photoPK);
            Assert.assertTrue(hasaccess);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withuserprofile_noprivateaccess() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(false);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNull(result);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withuserprofile_privateaccess() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNotNull(result);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withuserprofile_noprivateaccess_publicphoto() {
        try {
            Photo photo = new Photo();
            photo.setPublic(true);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(false);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNotNull(result);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withboolean_noprivateaccess() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(false);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNull(result);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withboolean_privateaccess() {
        try {
            Photo photo = new Photo();
            photo.setPublic(false);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNotNull(result);
        }
        catch(DBException e) {
        }
    }

    @Test
    public void testhasAccess_getPhoto_withboolean_noprivateaccess_publicphoto() {
        try {
            Photo photo = new Photo();
            photo.setPublic(true);
            doReturn(photo).when(blphoto).getPhoto(any(IPhotoPK.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(false);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            PhotoPK photoPK = new PhotoPK();
            Photo result = blphoto.getPhoto(userprofile, photoPK);
            Assert.assertNotNull(result);
        }
        catch(DBException e) {
        }
    }
   
    @Test
    public void testupdateCopyPrevGeolocation() {
        try {
            Photo photo = new Photo("TST001", 2);
            photo.setReversegeocode("test");
            piPoint location = new piPoint();
            location.setX(1);
            location.setY(2);
            photo.setLocation(location);
            photo.setExactlocation(true);
            Photo prevphoto = new Photo("TST001", 1);
            prevphoto.setReversegeocode("testprev");
            prevphoto.setFormattedaddress("prefformatted");
            prevphoto.setStreetnumber("10");
            location = new piPoint();
            location.setX(3);
            location.setY(4);
            prevphoto.setLocation(location);
            prevphoto.setLocationradius(0.02);
            prevphoto.setExactlocation(false);
            prevphoto.setRoutePK(new RoutePK("BE", "1000", "Brussels", "Brussels", "A"));
            ArrayList<Photo> photos = new ArrayList<>();
            photos.add(prevphoto);
            photos.add(photo);
            doReturn(photos).when(blphoto).getPhotos4photo_film(anyBoolean(), any(FilmPK.class), anyBoolean());
            doNothing().when(blphoto).updatePhoto(any(SQLTqueue.class), any(Photo.class));
            blphoto.updateCopyPrevGeolocation(transactionqueue, photo);
            RoutePK routepk = photo.getRoutePK();
            Assert.assertEquals(routepk.getCountrycode(), "BE");
            Assert.assertEquals(routepk.getLocality(), "Brussels");
            Assert.assertEquals(routepk.getPostalcode(), "1000");
            Assert.assertEquals(routepk.getRoutecode(), "A");
            Assert.assertEquals(routepk.getSublocalityPK().getSublocality(), "Brussels");
            Assert.assertEquals(routepk.getSublocality(), "Brussels");
            piPoint resultlocation = (piPoint)photo.getLocation();
            Assert.assertEquals(photo.getLocationradius(), 0.02, 0.001);
            Assert.assertEquals(resultlocation.getX(), 3, 0.0001);
            Assert.assertEquals(resultlocation.getY(), 4, 0.0001);
            Assert.assertEquals(photo.getReversegeocode(), "testprev");
            Assert.assertEquals(photo.getFormattedaddress(), "prefformatted");
            Assert.assertEquals(photo.getStreetnumber(), "10");
        }
        catch(DataException | DBException e) {
        }
    }

    @Test
    public void testupdateCopyPrevGeolocation_notfound() {
        try {
            Photo photo = new Photo("TST001", 2);
            photo.setReversegeocode("test");
            piPoint location = new piPoint();
            location.setX(1);
            location.setY(2);
            photo.setLocation(location);
            photo.setExactlocation(true);
            Photo prevphoto = new Photo("TST001", 1);
            ArrayList<Photo> photos = new ArrayList<>();
            photos.add(prevphoto);
            photos.add(photo);
            doReturn(photos).when(blphoto).getPhotos4photo_film(anyBoolean(), any(FilmPK.class), anyBoolean());
            doNothing().when(blphoto).updatePhoto(any(SQLTqueue.class), any(Photo.class));
            boolean result = blphoto.updateCopyPrevGeolocation(transactionqueue, photo);
            Assert.assertFalse(result);
        }
        catch(DataException | DBException e) {
        }
    }

    @Test
    public void testcopyPhotoGeolocation() {
        try {
            Photo photo = new Photo("TST001", 2);
            photo.setReversegeocode("test");
            piPoint location = new piPoint();
            location.setX(1);
            location.setY(2);
            photo.setLocation(location);
            photo.setExactlocation(true);
            Photo sourcephoto = new Photo("TST001", 1);
            sourcephoto.setReversegeocode("testprev");
            sourcephoto.setFormattedaddress("prefformatted");
            sourcephoto.setStreetnumber("10");
            location = new piPoint();
            location.setX(3);
            location.setY(4);
            sourcephoto.setLocation(location);
            sourcephoto.setLocationradius(0.02);
            sourcephoto.setExactlocation(false);
            sourcephoto.setRoutePK(new RoutePK("BE", "1000", "Brussels", "Brussels", "A"));
            doReturn(photo).doReturn(sourcephoto).when(blphoto).getPhoto(any(PhotoPK.class));
            doNothing().when(blphoto).updatePhoto(any(SQLTqueue.class), any(Photo.class));
            boolean result = blphoto.copyPhotoGeolocation(transactionqueue, photo, sourcephoto.getPrimaryKey());
            Assert.assertTrue(result);
        }
        catch(DataException | DBException e) {
        }
    }

    @Test
    public void testcopyPhotoGeolocation_sourcenotfound() {
        try {
            Photo photo = new Photo("TST001", 2);
            photo.setReversegeocode("test");
            piPoint location = new piPoint();
            location.setX(1);
            location.setY(2);
            photo.setLocation(location);
            photo.setExactlocation(true);
            doReturn(photo).doReturn(null).when(blphoto).getPhoto(any(PhotoPK.class));
            doNothing().when(blphoto).updatePhoto(any(SQLTqueue.class), any(Photo.class));
            boolean result = blphoto.copyPhotoGeolocation(transactionqueue, photo, new PhotoPK("TST001", 1));
            Assert.assertFalse(result);
        }
        catch(DataException | DBException e) {
        }
    }
}
