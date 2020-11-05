/*
 * BLview_localityphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.3.2016 19:49
 *
 */

package film.BusinessObject.Logic;

import data.gis.shape.piPoint;
import general.exception.DBException;
import data.interfaces.db.View;
import film.logicview.View_localityphotocount;
import film.BusinessObject.view.Bview_localityphotocount;
import film.interfaces.BusinessObject.IBLview_localityphotocount;
import film.logicview.View_locality_photolocations;
import film.logicview.View_publiclocalityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Business Logic Entity class BLview_localityphotocount
 *
 * Class for manipulating data- and database objects
 * for View View_localityphotocount and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_localityphotocount extends Bview_localityphotocount implements IBLview_localityphotocount {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_localityphotocount as default Entity
     */
    public BLview_localityphotocount() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_localityphotocount) throws SQLException {
        
    }
    
    /**
     * get all View_publiclocalityphotocount objects from database
     * prevent from getting private data
     * @return ArrayList of View_localityphotocount objects
     * @throws DBException
     */
    @Override
    public ArrayList getView_localityphotocounts() throws DBException {
        return getMapper().loadViewVector(this, View_publiclocalityphotocount.SQLSelectAll);
    }
    
    public ArrayList get4Countrycode(String countrycode, boolean loggedin) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode } };
        String sql = View_publiclocalityphotocount.SQLSelect4countrycode;
        if(loggedin) {
            sql = View_localityphotocount.SQLSelect4countrycode;
        }
        ArrayList localities = getMapper().loadViewVector(this, sql, parameter);
        ArrayList result = new ArrayList();
        Iterator<View_localityphotocount> localitiesI = localities.iterator();
        View_localityphotocount locality;
        View_localityphotocount lastlocality = new View_localityphotocount();
        while(localitiesI.hasNext()) {
            locality = localitiesI.next();
            if(locality.getLocality().equals(lastlocality.getLocality())) {
                lastlocality.setPhotocount(locality.getPhotocount() + lastlocality.getPhotocount());
                if(lastlocality.getLocation()==null) lastlocality.setLocation(locality.getLocation());
            } else {
                result.add(locality);
            }
            lastlocality = locality;
        }
        
        //calculate locations from locality with empty location field
        BLview_locality_photolocations blview_locality_photolocations = new BLview_locality_photolocations();
        localitiesI = result.iterator();
        ArrayList photolocations;
        View_locality_photolocations photolocation;
        piPoint mappoint, NE, SW, center;
        while(localitiesI.hasNext()) {
            locality = localitiesI.next();
            if(locality.getLocation()==null) {
                //calculate locality from photo locations
                NE = null;
                SW = null;
                photolocations = blview_locality_photolocations.get4Location(locality.getCountrycode(), locality.getLocality());
                Iterator<View_locality_photolocations> photolocationsI = photolocations.iterator();
                if(photolocationsI.hasNext()) {
                    photolocation = photolocationsI.next();
                    NE = (piPoint)photolocation.getLocation().simplify();
                    SW = (piPoint)photolocation.getLocation().simplify();
                }
                while(photolocationsI.hasNext()) {
                    photolocation = photolocationsI.next();
                    mappoint = (piPoint)photolocation.getLocation().simplify();
                    if(NE.getX()<mappoint.getX()) {
                        NE.setX(mappoint.getX());
                    }
                    if(NE.getY()<mappoint.getY()) {
                        NE.setY(mappoint.getY());
                    }
                    if(SW.getX()>mappoint.getX()) {
                        SW.setX(mappoint.getX());
                    }
                    if(SW.getY()>mappoint.getY()) {
                        SW.setY(mappoint.getY());
                    }
                }
                if(NE!=null) {
                    center = new piPoint();
                    center.setX((NE.getX() + SW.getX())/2);
                    center.setY((NE.getY() + SW.getY())/2);
                    locality.setLocation(center);
                }
            }
        }
        return result;
    }
    
    
}
