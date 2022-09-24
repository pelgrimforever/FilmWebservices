package film.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import film.BusinessObject.table.Btree7subject;
import film.entity.pk.Tree7subjectPK;
import film.interfaces.logicentity.ISecurityprofile;
import film.logic.Userprofile;
import static film.logic.Userprofile.EDITOR;
import film.logicentity.Securityprofile;
import film.logicentity.Tree7subject;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import sitesecurity.interfaces.logicentity.ISitegroup;

/**
 * @author Franky Laseure
 */
public class BLtree7subjectTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Spy
    @InjectMocks
    private BLtree7subject bltree7subject = new BLtree7subject(sqlreader_mock);
    
    public BLtree7subjectTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
        try {
            doNothing().when((Btree7subject)bltree7subject).insertTree7subject(any(SQLTqueue.class), any(Tree7subject.class));
            doNothing().when((Btree7subject)bltree7subject).updateTree7subject(any(SQLTqueue.class), any(Tree7subject.class));
        }
        catch(DBException | DataException e) {
        }
    }

    @Test
    public void testinsertTree7subject_noparent_emptytoplist() {
        try {
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            Tree7subject tree7subject = new Tree7subject(new Tree7subjectPK());
            ArrayList<Tree7subject> allstep1 = new ArrayList();
            doReturn(allstep1).when(bltree7subject).getAllStep1();
            bltree7subject.insertTree7subject(transactionqueue, userprofile, tree7subject);
            Assert.assertFalse(tree7subject.getPrimaryKey().getSubjectid()==0);
            Assert.assertTrue(tree7subject.getTree7subjectparentsubjectidPK().equals(tree7subject.getPrimaryKey()));
            Assert.assertEquals(tree7subject.getTree7id(), "1");
            Assert.assertEquals(tree7subject.getTreestep(), 1);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void testinsertTree7subject_noparent_withtoplist() {
        try {
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            Tree7subject tree7subject = new Tree7subject(new Tree7subjectPK());
            Tree7subject top1 = new Tree7subject(new Tree7subjectPK(20000));
            top1.setTree7id("1");
            ArrayList<Tree7subject> allstep1 = new ArrayList();
            allstep1.add(top1);
            doReturn(allstep1).when(bltree7subject).getAllStep1();
            bltree7subject.insertTree7subject(transactionqueue, userprofile, tree7subject);
            Assert.assertFalse(tree7subject.getPrimaryKey().getSubjectid()==0);
            Assert.assertTrue(tree7subject.getTree7subjectparentsubjectidPK().equals(tree7subject.getPrimaryKey()));
            Assert.assertEquals(tree7subject.getTree7id(), "2");
            Assert.assertEquals(tree7subject.getTreestep(), 1);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test(expected = DataException.class)
    public void testinsertTree7subject_withchild_as_parent() throws DataException {
        try {
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            Tree7subject tree7subject = new Tree7subject(new Tree7subjectPK());
            Tree7subjectPK parent_tree7subjectPK = new Tree7subjectPK(10000);
            tree7subject.setTree7subjectparentsubjectidPK(parent_tree7subjectPK);
            tree7subject.setTree7id("11");
            Tree7subject parent = new Tree7subject(parent_tree7subjectPK);
            parent.setTree7id("112");
            doReturn(parent).when(bltree7subject).getTree7subject(any(Tree7subjectPK.class));
            bltree7subject.insertTree7subject(transactionqueue, userprofile, tree7subject);
        }
        catch(DBException e) {
        }
    }
    
    @Test(expected = DataException.class)
    public void testinsertTree7subject_notree7id_fullbranch() throws DataException {
        try {
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            Tree7subject tree7subject = new Tree7subject(new Tree7subjectPK());
            Tree7subjectPK parent_tree7subjectPK = new Tree7subjectPK(10000);
            tree7subject.setTree7subjectparentsubjectidPK(parent_tree7subjectPK);
            Tree7subject parent = new Tree7subject(parent_tree7subjectPK);
            parent.setTree7id("1");
            doReturn(parent).when(bltree7subject).getTree7subject(any(Tree7subjectPK.class));
            Tree7subject child1 = new Tree7subject(new Tree7subjectPK(10001));
            Tree7subject child2 = new Tree7subject(new Tree7subjectPK(10002));
            Tree7subject child3 = new Tree7subject(new Tree7subjectPK(10003));
            Tree7subject child4 = new Tree7subject(new Tree7subjectPK(10004));
            Tree7subject child5 = new Tree7subject(new Tree7subjectPK(10005));
            Tree7subject child6 = new Tree7subject(new Tree7subjectPK(10006));
            Tree7subject child7 = new Tree7subject(new Tree7subjectPK(10007));
            ArrayList<Tree7subject> children = new ArrayList<>();
            children.add(child1);
            children.add(child2);
            children.add(child3);
            children.add(child4);
            children.add(child5);
            children.add(child6);
            children.add(child7);
            doReturn(children).when(bltree7subject).getTree7subjects4tree7subjectParentsubjectid(any(Tree7subjectPK.class));
            bltree7subject.insertTree7subject(transactionqueue, userprofile, tree7subject);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void testinsertTree7subject_notree7id_emptybranch() {
        try {
            ArrayList<ISitegroup> sitegroups = new ArrayList<>();
            ArrayList<ISecurityprofile> profiles = new ArrayList<>();
            Securityprofile profile = new Securityprofile(EDITOR);
            profile.setPrivateaccess(true);
            profiles.add(profile);
            Userprofile userprofile = new Userprofile(sitegroups, profiles);
            Tree7subject tree7subject = new Tree7subject(new Tree7subjectPK());
            Tree7subjectPK parent_tree7subjectPK = new Tree7subjectPK(10000);
            tree7subject.setTree7subjectparentsubjectidPK(parent_tree7subjectPK);
            Tree7subject parent = new Tree7subject(parent_tree7subjectPK);
            parent.setTree7id("1");
            doReturn(parent).when(bltree7subject).getTree7subject(any(Tree7subjectPK.class));
            ArrayList<Tree7subject> children = new ArrayList<>();
            doReturn(children).when(bltree7subject).getTree7subjects4tree7subjectParentsubjectid(any(Tree7subjectPK.class));
            bltree7subject.insertTree7subject(transactionqueue, userprofile, tree7subject);
            Assert.assertFalse(tree7subject.getPrimaryKey().getSubjectid()==0);
            Assert.assertTrue(tree7subject.getTree7subjectparentsubjectidPK().equals(parent_tree7subjectPK));
            Assert.assertEquals(tree7subject.getTree7id(), "11");
            Assert.assertEquals(tree7subject.getTreestep(), 2);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
