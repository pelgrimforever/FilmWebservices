/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.3.2016 19:49
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import data.gis.shape.piPoint;
import general.exception.DBException;
import db.SQLparameters;
import db.SQLreader;
import film.logicview.View_localityphotocount;
import film.BusinessObject.view.Bview_localityphotocount;
import film.conversion.entity.EMview_localityphotocount;
import film.conversion.entity.EMview_publiclocalityphotocount;
import film.logicview.View_locality_photolocations;
import java.util.ArrayList;
import java.util.Iterator;

public class BLview_localityphotocount extends Bview_localityphotocount {
//Metacoder: NO AUTHOMATIC UPDATE
	
    private BLview_locality_photolocations blview_locality_photolocations;
    
    public BLview_localityphotocount(SQLreader sqlreader) {
        super(sqlreader);
        blview_locality_photolocations = new BLview_locality_photolocations(sqlreader);
    }

    @Override
    public ArrayList getView_localityphotocounts() throws DBException {
        return viewio.getEntities(EMview_publiclocalityphotocount.SQLSelectAll);
    }
    
    public ArrayList<View_localityphotocount> get4Countrycode(String countrycode, boolean loggedin) throws DBException {
        ArrayList<View_localityphotocount> result = new ArrayList<>();
        ArrayList<View_localityphotocount> localities = getLocalities4countrycode(countrycode, loggedin);
        View_localityphotocount lastlocality = new View_localityphotocount();
        for(View_localityphotocount locality: localities)
            lastlocality = combineLocalities(locality, lastlocality, result);
        calculate_locations_from_locality_with_empty_location_field(result);
        return result;
    }

    public ArrayList<View_localityphotocount> getLocalities4countrycode(String countrycode, boolean loggedin) throws DBException {
        Object[][] parameter = { { "countrycode", countrycode } };
        SQLparameters parameters = new SQLparameters(parameter);
        String sql = EMview_publiclocalityphotocount.SQLSelect4countrycode;
        if(loggedin)
            sql = EMview_localityphotocount.SQLSelect4countrycode;
        ArrayList<View_localityphotocount> localities = viewio.getEntities(sql, parameters);
        return localities;
    }
    
    private View_localityphotocount combineLocalities(View_localityphotocount locality, View_localityphotocount lastlocality, ArrayList<View_localityphotocount> result) {
        if(locality.getLocality().equals(lastlocality.getLocality())) {
            lastlocality.setPhotocount(locality.getPhotocount() + lastlocality.getPhotocount());
            if(lastlocality.getLocation()==null) lastlocality.setLocation(locality.getLocation());
        } else
            result.add(locality);
        return locality;
    }    

    private void calculate_locations_from_locality_with_empty_location_field(ArrayList<View_localityphotocount> result) throws DBException {
        for(View_localityphotocount locality: result)
            calculate_location_from_locality_with_empty_location_field(locality);
    }

    private void calculate_location_from_locality_with_empty_location_field(View_localityphotocount locality) throws DBException {
        piPoint NE;
        piPoint SW;
        ArrayList photolocations;
        View_locality_photolocations photolocation;
        piPoint mappoint;
        piPoint center;
        if(locality.getLocation()==null)
            calculate_locality_from_photo_locations(locality);
    }

    private void calculate_locality_from_photo_locations(View_localityphotocount locality) throws DBException {
        View_locality_photolocations photolocation;
        piPoint mappoint;
        piPoint center;
        piPoint NE = null;
        piPoint SW = null;
        ArrayList<View_locality_photolocations> photolocations = blview_locality_photolocations.get4Location(locality.getCountrycode(), locality.getLocality());
        Iterator<View_locality_photolocations> photolocationsI = photolocations.iterator();
        if(photolocationsI.hasNext()) {
            photolocation = photolocationsI.next();
            NE = (piPoint)photolocation.getLocation().simplify();
            SW = NE.abstractclone();
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
