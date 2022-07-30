/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMroute_default;
import film.logicentity.Route;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMroute extends EMroute_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by route.countrycode, route.postalcode, route.locality, route.sublocality, route.routecode";
    public static final String SQLWherelocalityPK = "countrycode = :locality.countrycode: and postalcode = :locality.postalcode: and locality = :locality.locality:";
    public static final String SQLSelect4localityPK = "select * from route where " + SQLWherelocalityPK + OrderBy;

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Route route = (Route)super.mapResultSet2Entity(dbresult);
        return route;
    }    
    
}

