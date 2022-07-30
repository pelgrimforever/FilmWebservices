/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IGeography_columns;
import film.logicview.Geography_columns;
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
public class JSONGeography_columns {
    
    public static JSONArray toJSONArray(ArrayList geography_columnss) {
        JSONArray jsongeography_columnss = new JSONArray();
        Iterator geography_columnssI = geography_columnss.iterator();
        while(geography_columnssI.hasNext()) {
            jsongeography_columnss.add(JSONGeography_columns.toJSON((Geography_columns)geography_columnssI.next()));
        }
        return jsongeography_columnss;
    }

    public static JSONObject toJSON(IGeography_columns geography_columns) {
        JSONObject json = new JSONObject();
        json.put("f_table_catalog", geography_columns.getF_table_catalog());
        json.put("f_table_schema", geography_columns.getF_table_schema());
        json.put("f_table_name", geography_columns.getF_table_name());
        json.put("f_geography_column", geography_columns.getF_geography_column());
        json.put("coord_dimension", geography_columns.getCoord_dimension());
        json.put("srid", geography_columns.getSrid());
        json.put("type", geography_columns.getType());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static Geography_columns toGeography_columns(JSONObject json) {
        Geography_columns geography_columns = new Geography_columns();
        geography_columns.setF_table_catalog(JSONConversion.getString(json, "f_table_catalog"));
        geography_columns.setF_table_schema(JSONConversion.getString(json, "f_table_schema"));
        geography_columns.setF_table_name(JSONConversion.getString(json, "f_table_name"));
        geography_columns.setF_geography_column(JSONConversion.getString(json, "f_geography_column"));
        geography_columns.setCoord_dimension(JSONConversion.getint(json, "coord_dimension"));
        geography_columns.setSrid(JSONConversion.getint(json, "srid"));
        geography_columns.setType(JSONConversion.getString(json, "type"));
        return geography_columns;
    }

    public static Geography_columnssearch toGeography_columnssearch(JSONObject json) {
        Geography_columnssearch geography_columnssearch = new Geography_columnssearch();
        geography_columnssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        geography_columnssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        geography_columnssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("f_table_catalog");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.f_table_catalog(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_table_schema");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.f_table_schema(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_table_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.f_table_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_geography_column");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.f_geography_column(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("coord_dimension");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.coord_dimension(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("srid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.srid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("type");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geography_columnssearch.type(valuearray, compareoperator, andor);
        }
        return geography_columnssearch;
    }
}

