/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IRaster_columns;
import film.logicview.Raster_columns;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONRaster_columns {
    
    public static JSONArray toJSONArray(ArrayList raster_columnss) {
        JSONArray jsonraster_columnss = new JSONArray();
        Iterator raster_columnssI = raster_columnss.iterator();
        while(raster_columnssI.hasNext()) {
            jsonraster_columnss.add(JSONRaster_columns.toJSON((Raster_columns)raster_columnssI.next()));
        }
        return jsonraster_columnss;
    }

    public static JSONObject toJSON(IRaster_columns raster_columns) {
        JSONObject json = new JSONObject();
        json.put("r_table_catalog", raster_columns.getR_table_catalog());
        json.put("r_table_schema", raster_columns.getR_table_schema());
        json.put("r_table_name", raster_columns.getR_table_name());
        json.put("r_raster_column", raster_columns.getR_raster_column());
        json.put("srid", raster_columns.getSrid());
        json.put("scale_x", raster_columns.getScale_x());
        json.put("scale_y", raster_columns.getScale_y());
        json.put("blocksize_x", raster_columns.getBlocksize_x());
        json.put("blocksize_y", raster_columns.getBlocksize_y());
        json.put("same_alignment", raster_columns.getSame_alignment());
        json.put("regular_blocking", raster_columns.getRegular_blocking());
        json.put("num_bands", raster_columns.getNum_bands());
        if(raster_columns.getExtent()!=null) {
            json.put("extent", GISConversion.toJSON(raster_columns.getExtent()));
        }
        json.put("spatial_index", raster_columns.getSpatial_index());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static Raster_columns toRaster_columns(JSONObject json) {
        Raster_columns raster_columns = new Raster_columns();
        raster_columns.setR_table_catalog(JSONConversion.getString(json, "r_table_catalog"));
        raster_columns.setR_table_schema(JSONConversion.getString(json, "r_table_schema"));
        raster_columns.setR_table_name(JSONConversion.getString(json, "r_table_name"));
        raster_columns.setR_raster_column(JSONConversion.getString(json, "r_raster_column"));
        raster_columns.setSrid(JSONConversion.getint(json, "srid"));
        raster_columns.setScale_x(JSONConversion.getdouble(json, "scale_x"));
        raster_columns.setScale_y(JSONConversion.getdouble(json, "scale_y"));
        raster_columns.setBlocksize_x(JSONConversion.getint(json, "blocksize_x"));
        raster_columns.setBlocksize_y(JSONConversion.getint(json, "blocksize_y"));
        raster_columns.setSame_alignment(JSONConversion.getboolean(json, "same_alignment"));
        raster_columns.setRegular_blocking(JSONConversion.getboolean(json, "regular_blocking"));
        raster_columns.setNum_bands(JSONConversion.getint(json, "num_bands"));
        raster_columns.setExtent(GISConversion.topiShape((JSONObject)json.get("extent")));
        raster_columns.setSpatial_index(JSONConversion.getboolean(json, "spatial_index"));
        return raster_columns;
    }

    public static Raster_columnssearch toRaster_columnssearch(JSONObject json) {
        Raster_columnssearch raster_columnssearch = new Raster_columnssearch();
        raster_columnssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        raster_columnssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        raster_columnssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("r_table_catalog");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.r_table_catalog(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_table_schema");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.r_table_schema(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_table_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.r_table_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("r_raster_column");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.r_raster_column(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("srid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.srid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("scale_x");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.scale_x(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("scale_y");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.scale_y(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("blocksize_x");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.blocksize_x(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("blocksize_y");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.blocksize_y(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("same_alignment");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            raster_columnssearch.same_alignment(value);
        }
        field = (JSONObject)fss.get("regular_blocking");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            raster_columnssearch.regular_blocking(value);
        }
        field = (JSONObject)fss.get("num_bands");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            raster_columnssearch.num_bands(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("spatial_index");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            raster_columnssearch.spatial_index(value);
        }
        return raster_columnssearch;
    }
}

