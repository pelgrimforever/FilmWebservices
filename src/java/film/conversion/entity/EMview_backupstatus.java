/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import data.interfaces.db.View;
import film.conversion.entity.def.EMview_backupstatus_default;
import film.logicview.View_backupstatus;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_backupstatus extends EMview_backupstatus_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by id";
    public static final String WhereImagebackup = " imagebackupcount > 0 ";
    public static final String WhereBackup = " backupcount > 0 ";
    public static final String WhereAllBackup = WhereImagebackup + "or" + WhereBackup;

    public static final String SQLSelectAll = "select * from view_backupstatus " + OrderBy;
    public static final String SQLSelect4Imagebackup = "select * from view_backupstatus where " + WhereImagebackup + OrderBy;
    public static final String SQLSelect4Backup = "select * from view_backupstatus where " + WhereBackup + OrderBy;
    public static final String SQLSelect4AllBackup = "select * from view_backupstatus where " + WhereAllBackup + OrderBy;

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_backupstatus view_backupstatus = (View_backupstatus)super.mapResultSet2Entity(dbresult);
        return view_backupstatus;
    }    
    
}

