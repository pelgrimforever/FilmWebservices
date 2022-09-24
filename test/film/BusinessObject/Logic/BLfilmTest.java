package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import film.entity.pk.FilmPK;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.logicentity.IFilm;
import film.logic.Userprofile;
import film.logicentity.Film;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLfilmTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLfilm blfilm = new BLfilm(sqlreader_mock);
    
    public BLfilmTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testgetRootImagePath() {
        IFilmPK filmPK = new FilmPK("TST001");
        StringBuffer result = BLfilm.getRootImagePath(filmPK);
        Assert.assertEquals(result.toString(), "photos/TST-001/");
    }
    
    @Test
    public void testgetGroups() {
        try {
            ArrayList<Film> filmgroup = new ArrayList<>();
            filmgroup.add(new Film("TST001"));
            filmgroup.add(new Film("TST002"));
            filmgroup.add(new Film("TSS001"));
            doReturn(filmgroup).when(blfilm).getEntities(anyString());
            ArrayList<String> results = blfilm.getGroups();
            Assert.assertEquals(results.size(), 2);
            Assert.assertEquals(results.get(0), "TST");
            Assert.assertEquals(results.get(1), "TSS");
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testupdateFilm() {
        try {
            Film film = new Film("TST001");
            doReturn(true).when(blfilm).isAuthorised_for_edit(any(Userprofile.class), any(IFilm.class));
            blfilm.updateFilm(transactionqueue, film);
            Assert.assertTrue(film.getBackup());
        }
        catch(DBException | DataException e) {
        }
    }
}
