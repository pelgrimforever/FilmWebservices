package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import file.Filereader;
import film.entity.pk.PhotoPK;
import film.interfaces.entity.pk.IPhotoPK;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class PhotoImagefileTest {
    
    private Filereader filereader = new Filereader();
    @Spy
    @InjectMocks
    private PhotoImagefile photoimagefile = new PhotoImagefile();
    
    public PhotoImagefileTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testgetImagePath() {
        IPhotoPK photoPK = new PhotoPK("TST001", 1);
        String subpath = "cropped";
        String result = photoimagefile.getImagePath(photoPK, subpath);
        Assert.assertEquals(result.toString(), "photos/TST-001/cropped");
    }

    @Test
    public void testgetFilename() {
        IPhotoPK photoPK = new PhotoPK("TST001", 1);
        String result = photoimagefile.getFilename(photoPK);
        Assert.assertEquals(result.toString(), "TST-001_01.jpg");
    }
    
}
