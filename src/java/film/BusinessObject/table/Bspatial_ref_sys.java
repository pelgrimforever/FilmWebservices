/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMspatial_ref_sys;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.logicentity.Spatial_ref_sys;

public abstract class Bspatial_ref_sys extends TableBusinessrules {

    public Bspatial_ref_sys(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMspatial_ref_sys()));
    }

    public Bspatial_ref_sys(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMspatial_ref_sys()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISpatial_ref_sys newSpatial_ref_sys() {
    	return new Spatial_ref_sys();
    }
    
    public ISpatial_ref_sys newSpatial_ref_sys(int srid) {
        return new Spatial_ref_sys(srid);
    }

    public ISpatial_ref_sys newSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) {
        return new Spatial_ref_sys((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    public ISpatial_ref_sysPK newSpatial_ref_sysPK() {
        return new Spatial_ref_sysPK();
    }

    public ISpatial_ref_sysPK newSpatial_ref_sysPK(int srid) {
        return new Spatial_ref_sysPK(srid);
    }

    public ArrayList<Spatial_ref_sys> getSpatial_ref_syss() throws DBException {
        return (ArrayList<Spatial_ref_sys>)tableio.getEntities(EMspatial_ref_sys.SQLSelectAll);
    }

    public Spatial_ref_sys getSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return (Spatial_ref_sys)tableio.getEntity((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    public ArrayList<Spatial_ref_sys> searchspatial_ref_syss(ISpatial_ref_syssearch search) throws DBException {
        return (ArrayList<Spatial_ref_sys>)tableio.search(search);
    }

    public ArrayList<Spatial_ref_sys> searchspatial_ref_syss(ISpatial_ref_syssearch search, String orderby) throws DBException {
        return (ArrayList<Spatial_ref_sys>)tableio.search(search, orderby);
    }

    public boolean getSpatial_ref_sysExists(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return tableio.getEntityExists((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    public Spatial_ref_sys getEntity(String sql) throws DBException {
        return (Spatial_ref_sys)tableio.getEntity(sql);
    }
    
    public Spatial_ref_sys getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Spatial_ref_sys)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Spatial_ref_sys> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Spatial_ref_sys> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Spatial_ref_sys> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Spatial_ref_sys> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSpatial_ref_sys(SQLTqueue transactionqueue, ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, spatial_ref_sys);
    }

    public void insertupdateSpatial_ref_sys(SQLTqueue transactionqueue, ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
    	checkDATA(spatial_ref_sys);
        if(this.getSpatial_ref_sysExists(spatial_ref_sys.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, spatial_ref_sys);
        } else {
            tableio.insertEntity(transactionqueue, spatial_ref_sys);
        }
    }

    public void updateSpatial_ref_sys(SQLTqueue transactionqueue, ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
    	checkDATA(spatial_ref_sys);
        tableio.updateEntity(transactionqueue, spatial_ref_sys);
    }

    public void deleteSpatial_ref_sys(SQLTqueue transactionqueue, ISpatial_ref_sys spatial_ref_sys) throws DBException {
        cascadedeleteSpatial_ref_sys(transactionqueue, spatial_ref_sys.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, spatial_ref_sys);
    }

    private void checkDATA(ISpatial_ref_sys spatial_ref_sys) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(spatial_ref_sys.getAuth_name()!=null && spatial_ref_sys.getAuth_name().length()>ISpatial_ref_sys.SIZE_AUTH_NAME) {
            message.append("Auth_name is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_AUTH_NAME).append("\n");
        }
        if(spatial_ref_sys.getSrtext()!=null && spatial_ref_sys.getSrtext().length()>ISpatial_ref_sys.SIZE_SRTEXT) {
            message.append("Srtext is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_SRTEXT).append("\n");
        }
        if(spatial_ref_sys.getProj4text()!=null && spatial_ref_sys.getProj4text().length()>ISpatial_ref_sys.SIZE_PROJ4TEXT) {
            message.append("Proj4text is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_PROJ4TEXT).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSpatial_ref_sys(SQLTqueue transactionqueue, ISpatial_ref_sysPK spatial_ref_sysPK) {
    }


    public ArrayList<Spatial_ref_sys> getSpatial_ref_syss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMspatial_ref_sys.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Spatial_ref_sys>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSpatial_ref_sys(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Spatial_ref_sys.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
