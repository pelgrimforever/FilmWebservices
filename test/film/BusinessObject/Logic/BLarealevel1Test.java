package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import film.BusinessObject.table.Barealevel1;
import film.entity.pk.Arealevel1PK;
import film.interfaces.logicentity.IArealevel1;
import film.logicentity.Arealevel1;
import general.exception.DBException;
import general.exception.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLarealevel1Test {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLarealevel1 blarealevel1 = new BLarealevel1(sqlreader_mock);
    
    public BLarealevel1Test() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testinsertArealevel1_withname() {
        try {
            IArealevel1 arealevel1 = new Arealevel1(new Arealevel1PK("country", "al1code"));
            arealevel1.setName("al1name");
            blarealevel1.insertArealevel1(transactionqueue, arealevel1);
            Assert.assertEquals(arealevel1.getName(), "al1name");
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void testinsertArealevel1_withoutname() {
        try {
            IArealevel1 arealevel1 = new Arealevel1(new Arealevel1PK("country", "al1code"));
            blarealevel1.insertArealevel1(transactionqueue, arealevel1);
            Assert.assertEquals(arealevel1.getName(), "al1code");
        }
        catch(DBException | DataException e) {
        }
    }
}
