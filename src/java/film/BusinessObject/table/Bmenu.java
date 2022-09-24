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
import film.conversion.entity.EMmenu;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMenusearch;
import film.logicentity.Menu;

public abstract class Bmenu extends TableBusinessrules {

    public Bmenu(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMmenu()));
    }

    public Bmenu(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMmenu()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IMenu newMenu() {
    	return new Menu();
    }
    
    public IMenu newMenu(java.lang.String mainmenu, java.lang.String menu) {
        return new Menu(mainmenu, menu);
    }

    public IMenu newMenu(IMenuPK menuPK) {
        return new Menu((MenuPK)menuPK);
    }

    public IMenuPK newMenuPK() {
        return new MenuPK();
    }

    public IMenuPK newMenuPK(java.lang.String mainmenu, java.lang.String menu) {
        return new MenuPK(mainmenu, menu);
    }

    public ArrayList<Menu> getMenus() throws DBException {
        return (ArrayList<Menu>)tableio.getEntities(EMmenu.SQLSelectAll);
    }

    public Menu getMenu(IMenuPK menuPK) throws DBException {
        return (Menu)tableio.getEntity((MenuPK)menuPK);
    }

    public ArrayList<Menu> searchmenus(IMenusearch search) throws DBException {
        return (ArrayList<Menu>)tableio.search(search);
    }

    public ArrayList<Menu> searchmenus(IMenusearch search, String orderby) throws DBException {
        return (ArrayList<Menu>)tableio.search(search, orderby);
    }

    public boolean getMenuExists(IMenuPK menuPK) throws DBException {
        return tableio.getEntityExists((MenuPK)menuPK);
    }

    public Menu getEntity(String sql) throws DBException {
        return (Menu)tableio.getEntity(sql);
    }
    
    public Menu getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Menu)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Menu> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Menu> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Menu> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Menu> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertMenu(SQLTqueue transactionqueue, IMenu menu) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, menu);
    }

    public void insertupdateMenu(SQLTqueue transactionqueue, IMenu menu) throws DBException, DataException {
    	checkDATA(menu);
        if(this.getMenuExists(menu.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, menu);
        } else {
            tableio.insertEntity(transactionqueue, menu);
        }
    }

    public void updateMenu(SQLTqueue transactionqueue, IMenu menu) throws DBException, DataException {
    	checkDATA(menu);
        tableio.updateEntity(transactionqueue, menu);
    }

    public void deleteMenu(SQLTqueue transactionqueue, IMenu menu) throws DBException {
        cascadedeleteMenu(transactionqueue, menu.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, menu);
    }

    private void checkDATA(IMenu menu) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Menu.Mainmenu - Mainmenu.Mainmenu
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteMenu(SQLTqueue transactionqueue, IMenuPK menuPK) {
        BLmenuitem blmenuitem = new BLmenuitem(this);
        blmenuitem.setAuthenticated(isAuthenticated());
        blmenuitem.delete4menu(transactionqueue, menuPK);
    }

    public void delete4mainmenu(SQLTqueue transactionqueue, IMainmenuPK mainmenuPK) {
        tableio.addStatement(transactionqueue, EMmenu.SQLDelete4mainmenu, mainmenuPK.getSQLprimarykey());
    }

    public ArrayList<Menu> getMenus4mainmenu(IMainmenuPK mainmenuPK) throws CustomException {
        return tableio.getEntities(EMmenu.SQLSelect4mainmenu, mainmenuPK.getSQLprimarykey());
    }
    public Menu getMenuitem(IMenuitemPK menuitemPK) throws CustomException {
        MenuPK menuPK = new MenuPK(menuitemPK.getMainmenu(), menuitemPK.getMenu());
        return this.getMenu(menuPK);
    }


    public ArrayList<Menu> getMenus(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmenu.SQLSelect);
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
        return (ArrayList<Menu>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delMenu(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Menu.table);
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
