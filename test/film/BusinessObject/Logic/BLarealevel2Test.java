package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import film.entity.pk.Arealevel1PK;
import film.entity.pk.Arealevel2PK;
import film.interfaces.logicentity.IArealevel1;
import film.interfaces.logicentity.IArealevel2;
import film.logicentity.Arealevel1;
import film.logicentity.Arealevel2;
import general.exception.DBException;
import general.exception.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLarealevel2Test {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLarealevel2 blarealevel2 = new BLarealevel2(sqlreader_mock);
    
    public BLarealevel2Test() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testinsertArealevel1_withname() {
        try {
            IArealevel2 arealevel2 = new Arealevel2(new Arealevel2PK("country", "al1code", "al2code"));
            arealevel2.setName("al2name");
            blarealevel2.insertArealevel2(transactionqueue, arealevel2);
            Assert.assertEquals(arealevel2.getName(), "al2name");
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void testinsertArealevel1_withoutname() {
        try {
            IArealevel2 arealevel2 = new Arealevel2(new Arealevel2PK("country", "al1code", "al2code"));
            blarealevel2.insertArealevel2(transactionqueue, arealevel2);
            Assert.assertEquals(arealevel2.getName(), "al2code");
        }
        catch(DBException | DataException e) {
        }
    }
}
