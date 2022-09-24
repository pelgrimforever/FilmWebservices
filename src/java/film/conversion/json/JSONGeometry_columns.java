/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IGeometry_columns;
import film.logicview.Geometry_columns;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONGeometry_columns {
    
    public static JSONArray toJSONArray(ArrayList geometry_columnss) {
        JSONArray jsongeometry_columnss = new JSONArray();
        Iterator geometry_columnssI = geometry_columnss.iterator();
        while(geometry_columnssI.hasNext()) {
            jsongeometry_columnss.add(JSONGeometry_columns.toJSON((Geometry_columns)geometry_columnssI.next()));
        }
        return jsongeometry_columnss;
    }

    public static JSONObject toJSON(IGeometry_columns geometry_columns) {
        JSONObject json = new JSONObject();
        json.put("f_table_catalog", geometry_columns.getF_table_catalog());
        json.put("f_table_schema", geometry_columns.getF_table_schema());
        json.put("f_table_name", geometry_columns.getF_table_name());
        json.put("f_geometry_column", geometry_columns.getF_geometry_column());
        json.put("coord_dimension", geometry_columns.getCoord_dimension());
        json.put("srid", geometry_columns.getSrid());
        json.put("type", geometry_columns.getType());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static Geometry_columns toGeometry_columns(JSONObject json) {
        Geometry_columns geometry_columns = new Geometry_columns();
        geometry_columns.setF_table_catalog(JSONConversion.getString(json, "f_table_catalog"));
        geometry_columns.setF_table_schema(JSONConversion.getString(json, "f_table_schema"));
        geometry_columns.setF_table_name(JSONConversion.getString(json, "f_table_name"));
        geometry_columns.setF_geometry_column(JSONConversion.getString(json, "f_geometry_column"));
        geometry_columns.setCoord_dimension(JSONConversion.getint(json, "coord_dimension"));
        geometry_columns.setSrid(JSONConversion.getint(json, "srid"));
        geometry_columns.setType(JSONConversion.getString(json, "type"));
        return geometry_columns;
    }

    public static Geometry_columnssearch toGeometry_columnssearch(JSONObject json) {
        Geometry_columnssearch geometry_columnssearch = new Geometry_columnssearch();
        geometry_columnssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        geometry_columnssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        geometry_columnssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("f_table_catalog");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.f_table_catalog(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_table_schema");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.f_table_schema(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_table_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.f_table_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("f_geometry_column");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.f_geometry_column(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("coord_dimension");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.coord_dimension(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("srid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.srid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("type");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            geometry_columnssearch.type(valuearray, compareoperator, andor);
        }
        return geometry_columnssearch;
    }
}

