package film.servlets.film;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IFilm;
import film.interfaces.servlet.IFilmOperation;
import film.interfaces.searchentity.IFilmsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Film_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Film_backup", urlPatterns={"/film.Film_backup"})
public class Film_backup extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Film_usecases filmusecases = new Film_usecases(authenticated);
        try {
            switch(this.operation) {
                case IFilmOperation.BACKUP_PHOTOIMAGE:
                    backup(filmusecases);
                    break;
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    private void backup(Film_usecases filmusecases) throws CustomException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        filmusecases.backupPhotos(filmPK);
    }
    
    @Override
    public String getServletInfo() {
        return "film_backup";
    }

}

