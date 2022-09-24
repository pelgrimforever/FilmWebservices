package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import film.entity.pk.Arealevel2PK;
import film.entity.pk.Arealevel3PK;
import film.interfaces.logicentity.IArealevel2;
import film.interfaces.logicentity.IArealevel3;
import film.logicentity.Arealevel2;
import film.logicentity.Arealevel3;
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
public class BLarealevel3Test {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLarealevel3 blarealevel3 = new BLarealevel3(sqlreader_mock);
    
    public BLarealevel3Test() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testinsertArealevel1_withname() {
        try {
            IArealevel3 arealevel3 = new Arealevel3(new Arealevel3PK("country", "al1code", "al2code", "al3code"));
            arealevel3.setName("al3name");
            blarealevel3.insertArealevel3(transactionqueue, arealevel3);
            Assert.assertEquals(arealevel3.getName(), "al3name");
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void testinsertArealevel1_withoutname() {
        try {
            IArealevel3 arealevel3 = new Arealevel3(new Arealevel3PK("country", "al1code", "al2code", "al3code"));
            blarealevel3.insertArealevel3(transactionqueue, arealevel3);
            Assert.assertEquals(arealevel3.getName(), "al3code");
        }
        catch(DBException | DataException e) {
        }
    }
}
