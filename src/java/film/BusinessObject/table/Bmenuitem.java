/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMmenuitem;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMenuitemsearch;
import film.logicentity.Menuitem;

/**
 * @author Franky Laseure
 */
public abstract class Bmenuitem extends TableBusinessrules {

    public Bmenuitem(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMmenuitem()));
    }

    public Bmenuitem(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMmenuitem()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IMenuitem newMenuitem() {
    	return new Menuitem();
    }
    
    public IMenuitem newMenuitem(java.lang.String mainmenu, java.lang.String menu, java.lang.String menuitem) {
        return new Menuitem(mainmenu, menu, menuitem);
    }

    public IMenuitem newMenuitem(IMenuitemPK menuitemPK) {
        return new Menuitem((MenuitemPK)menuitemPK);
    }

    public IMenuitemPK newMenuitemPK() {
        return new MenuitemPK();
    }

    public IMenuitemPK newMenuitemPK(java.lang.String mainmenu, java.lang.String menu, java.lang.String menuitem) {
        return new MenuitemPK(mainmenu, menu, menuitem);
    }

    public ArrayList<Menuitem> getMenuitems() throws DBException {
        return (ArrayList<Menuitem>)tableio.getEntities(EMmenuitem.SQLSelectAll);
    }

    public Menuitem getMenuitem(IMenuitemPK menuitemPK) throws DBException {
        return (Menuitem)tableio.getEntity((MenuitemPK)menuitemPK);
    }

    public ArrayList<Menuitem> searchmenuitems(IMenuitemsearch search) throws DBException {
        return (ArrayList<Menuitem>)tableio.search(search);
    }

    public ArrayList<Menuitem> searchmenuitems(IMenuitemsearch search, String orderby) throws DBException {
        return (ArrayList<Menuitem>)tableio.search(search, orderby);
    }

    public boolean getMenuitemExists(IMenuitemPK menuitemPK) throws DBException {
        return tableio.getEntityExists((MenuitemPK)menuitemPK);
    }

    public Menuitem getEntity(String sql) throws DBException {
        return (Menuitem)tableio.getEntity(sql);
    }
    
    public Menuitem getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Menuitem)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Menuitem> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Menuitem> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Menuitem> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Menuitem> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertMenuitem(SQLTqueue transactionqueue, IMenuitem menuitem) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, menuitem);
    }

    public void insertupdateMenuitem(SQLTqueue transactionqueue, IMenuitem menuitem) throws DBException, DataException {
    	checkDATA(menuitem);
        if(this.getMenuitemExists(menuitem.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, menuitem);
        } else {
            tableio.insertEntity(transactionqueue, menuitem);
        }
    }

    public void updateMenuitem(SQLTqueue transactionqueue, IMenuitem menuitem) throws DBException, DataException {
    	checkDATA(menuitem);
        tableio.updateEntity(transactionqueue, menuitem);
    }

    public void deleteMenuitem(SQLTqueue transactionqueue, IMenuitem menuitem) throws DBException {
        cascadedeleteMenuitem(transactionqueue, menuitem.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, menuitem);
    }

    private void checkDATA(IMenuitem menuitem) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Menuitem.Mainmenu - Menu.Mainmenu
        //foreign key Menuitem.Menu - Menu.Menu
        //Primary key
        if(menuitem.getTabpanel()!=null && menuitem.getTabpanel().length()>IMenuitem.SIZE_TABPANEL) {
            message.append("Tabpanel is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_TABPANEL).append("\n");
        }
        if(menuitem.getEditpanel()!=null && menuitem.getEditpanel().length()>IMenuitem.SIZE_EDITPANEL) {
            message.append("Editpanel is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_EDITPANEL).append("\n");
        }
        if(menuitem.getServlet()!=null && menuitem.getServlet().length()>IMenuitem.SIZE_SERVLET) {
            message.append("Servlet is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_SERVLET).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteMenuitem(SQLTqueue transactionqueue, IMenuitemPK menuitemPK) {
    }

    public void delete4menu(SQLTqueue transactionqueue, IMenuPK menuPK) {
        tableio.addStatement(transactionqueue, EMmenuitem.SQLDelete4menu, menuPK.getSQLprimarykey());
    }

    public ArrayList<Menuitem> getMenuitems4menu(IMenuPK menuPK) throws CustomException {
        return tableio.getEntities(EMmenuitem.SQLSelect4menu, menuPK.getSQLprimarykey());
    }

    public ArrayList<Menuitem> getMenuitems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmenuitem.SQLSelect);
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
        return (ArrayList<Menuitem>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delMenuitem(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Menuitem.table);
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
