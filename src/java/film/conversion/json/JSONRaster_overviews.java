/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IRaster_overviews;
import film.logicview.Raster_overviews;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONRaster_overviews {
    
    public static JSONArray toJSONArray(ArrayList raster_overviewss) {
        JSONArray jsonraster_overviewss = new JSONArray();
        Iterator raster_overviewssI = raster_overviewss.iterator();
        while(raster_overviewssI.hasNext()) {
            jsonraster_overviewss.add(JSONRaster_overviews.toJSON((Raster_overviews)raster_overviewssI.next()));
        }
        return jsonraster_overviewss;
    }

    public static JSONObject toJSON(IRaster_overviews raster_overviews) {
        JSONObject json = new JSONObject();
        json.put("o_table_catalog", raster_overviews.getO_table_catalog());
        json.put("o_table_schema", raster_overviews.getO_table_schema());
        json.put("o_table_name", raster_overviews.getO_table_name());
        json.put("o_raster_column", raster_overviews.getO_raster_column());
        json.put("r_table_catalog", raster_overviews.getR_table_catalog());
        json.put("r_table_schema", raster_overviews.getR_table_schema());
        json.put("r_table_name", raster_overviews.getR_table_name());
        json.put("r_raster_column", raster_overviews.getR_raster_column());
        json.put("overview_factor", raster_overviews.getOverview_factor());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static Raster_overviews toRaster_overviews(JSONObject json) {
        Raster_overviews raster_overviews = new Raster_overviews();
        raster_overviews.setO_table_catalog(JSONConversion.getString(json, "o_table_catalog"));
        raster_overviews.setO_table_schema(JSONConversion.getString(json, "o_table_schema"));
        raster_overviews.setO_table_name(JSONConversion.getString(json, "o_table_name"));
        raster_overviews.setO_raster_column(JSONConversion.getString(json, "o_raster_column"));
        raster_overviews.setR_table_catalog(JSONConversion.getString(json, "r_table_catalog"));
        raster_overviews.setR_table_schema(JSONConversion.getString(json, "r_table_schema"));
        raster_overviews.setR_table_name(JSONConversion.getString(json, "r_table_name"));
        raster_overviews.setR_raster_column(JSONConversion.getString(json, "r_raster_column"));
        raster_overviews.setOverview_factor(JSONConversion.getint(json, "overview_factor"));
        return raster_overviews;
    }

    public static Raster_overviewssearch toRaster_overviewssearch(JSONObject json) {
        Raster_overviewssearch raster_overviewssearch = new Raster_overviewssearch();
        raster_overviewssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        raster_overviewssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        raster_overviewssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("o_table_catalog");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.o_table_catalog(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("o_table_schema");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.o_table_schema(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("o_table_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.o_table_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("o_raster_column");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.o_raster_column(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_table_catalog");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.r_table_catalog(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_table_schema");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.r_table_schema(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_table_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.r_table_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_raster_column");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.r_raster_column(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("overview_factor");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_overviewssearch.overview_factor(valuearray, operators, andor);
        }
        return raster_overviewssearch;
    }
}

