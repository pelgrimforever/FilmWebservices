/*
 * EMtree7subject.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMtree7subject_default;
import film.logicentity.Tree7subject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMtree7subject
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMtree7subject extends EMtree7subject_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by tree7id";

    public static final String SQLWheretree7subject_step1 = "parentsubjectid = subjectid";
    public static final String SQLSelect4tree7subject_step1 = "select * from tree7subject where " + SQLWheretree7subject_step1 + OrderBy;

    public static final String SQLWhere4parent = "parentsubjectid = :tree7subject.subjectid: and parentsubjectid <> subjectid";
    public static final String SQLSelect4parent = "select * from tree7subject where " + SQLWhere4parent + OrderBy;

    public static final String SQLWherechildren4tree7id = " tree7id like :liketree7id: and tree7id <> :tree7id:";
    public static final String SQLSelectchildren4tree7id = "select * from tree7subject where " + SQLWherechildren4tree7id + OrderBy;

    public static final String SQLSelectMostused = "select tree7subject.tree7id, tree7subject.subjectid, tree7subject.subject, tree7subject.treestep, tree7subject.parentsubjectid, count(phototree7subject.*) as usedcount from tree7subject "
            + "inner join phototree7subject on tree7subject.subjectid = phototree7subject.subjectid "
            + "group by tree7subject.tree7id, tree7subject.subjectid, tree7subject.subject, tree7subject.treestep, tree7subject.parentsubjectid "
            + "order by usedcount desc "
            + "limit 20";

    /**
     * Map ResultSet Field values to Tree7subject
     * @param dbresult: Database ResultSet
     * @return Tree7subject
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tree7subject tree7subject = (Tree7subject)super.mapResultSet2Entity(dbresult);
        return tree7subject;
    }    
    
}

