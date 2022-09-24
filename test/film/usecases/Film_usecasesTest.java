package film.usecases;

import db.SQLTwriter;
import db.SQLreader;
import film.BusinessObject.Logic.BLfilm;
import film.BusinessObject.Logic.BLphoto;
import film.interfaces.logicentity.IFilm;
import film.interfaces.logicentity.ISecurityprofile;
import film.logic.Userprofile;
import static film.logic.Userprofile.EDITOR;
import film.logicentity.Film;
import film.logicentity.Securityprofile;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import sitesecurity.interfaces.logicentity.ISitegroup;

/**
 * @author Franky Laseure
 */
public class Film_usecasesTest {
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="sqlwriter")
    private SQLTwriter sqlwriter_mock = new SQLTwriter();
    @Mock(name="blfilm")
    private BLfilm blfilm_mock = new BLfilm(sqlreader_mock);
    @Mock(name="blphoto")
    private BLphoto blphoto_mock = new BLphoto(sqlreader_mock);
    @Spy
    @InjectMocks
    private Film_usecases film_usecases_notauthorised = new Film_usecases(false);
    @Spy
    @InjectMocks
    private Film_usecases film_usecases_authorised = new Film_usecases(true);
    
    public Film_usecasesTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testupdateFilm_LoadGPSproperties_not_authorised() {
        try {
            blfilm_mock.setAuthenticated(false);
            doReturn(false).when(blfilm_mock).isAuthorised_for_edit(any(Userprofile.class), any(IFilm.class));
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            film.logic.Userprofile userprofile = new film.logic.Userprofile(sitegroups, profiles);
            Film film = new Film();
            ArrayList<film.logicentity.GPSTrackpoint> gpstrackpoints = new ArrayList<>();
            film_usecases_notauthorised.updateFilm_LoadGPSproperties(userprofile, film, gpstrackpoints);
            verify(film_usecases_notauthorised, times(0)).updateFilm_LoadGPSproperties_authorised(any(film.logic.Userprofile.class), any(Film.class), any(ArrayList.class));
        }
        catch(DBException | DataException e) {
        }        
    }
}
