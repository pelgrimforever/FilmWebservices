/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMphototags_default;
import film.logicentity.Phototags;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMphototags extends EMphototags_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by tag";
    public static final String SQLSelect4phototags_photo_sorted = "select * from phototags where " + SQLWherephoto + OrderBy;

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Phototags phototags = (Phototags)super.mapResultSet2Entity(dbresult);
        return phototags;
    }    
    
}

