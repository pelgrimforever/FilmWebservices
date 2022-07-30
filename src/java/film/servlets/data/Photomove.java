package film.servlets.data;

import static BusinessObject.BusinessLogic.FILEROOT;
import film.BusinessObject.Logic.BLfilm;
import static film.BusinessObject.Logic.BLphoto.CROPPEDPATH;
import static film.BusinessObject.Logic.BLphoto.FILEEXTENTION;
import static film.BusinessObject.Logic.BLphoto.SMALLPATH;
import static film.BusinessObject.Logic.BLphoto.THUMBNAILPATH;
import film.BusinessObject.Logic.BLphototags;
import film.entity.pk.FilmPK;
import film.entity.pk.FilmtypePK;
import film.logicentity.Phototree7subject;
import film.usecases.Film_usecases;
import film.usecases.Photo_usecases;
import film.usecases.Phototags_usecases;
import film.usecases.Phototree7subject_usecases;
import general.exception.CustomException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name = "Photomove", urlPatterns = {"/Photomove"})
public class Photomove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Photomove</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Move files</h1>");
            try {
                String oldfilmid = "*****";
                int startphotoid = 0;
                String filmgroupid = "CFE";
                String uploadtype = "DIG";
                FilmPK filmPK = new FilmPK(oldfilmid);
                Photo_usecases photousecases = new Photo_usecases(true);
                Film_usecases filmusecases = new Film_usecases(true);
                Phototree7subject_usecases phototree7subject_usecases = new Phototree7subject_usecases(true);
                Phototags_usecases phototags_usecases = new Phototags_usecases(true);
                ArrayList<film.logicentity.Photo> photos = photousecases.getPhotos4photo_film(true, filmPK, false);
                film.logicentity.Photo photo;
                int start = 0;
                while(((film.logicentity.Photo)photos.get(start)).getPrimaryKey().getId()<startphotoid) {
                    start++;
                }
                film.logicentity.Photo newphoto;
                File check;
                for(int i=start; i<photos.size(); i++) {
                    photo = (film.logicentity.Photo)photos.get(i);
                    //rename files and change record id's
                    //last photo for this group
                    film.logicentity.Photo lastphoto = photousecases.getLastPhotoinGroup(filmgroupid);
                    //last photo for this group with uploadtype (film.type)
                    film.logicentity.Photo lastphotofortype = photousecases.getLastPhotoinGroupAndType(filmgroupid, uploadtype);
                    if(lastphotofortype==null || (lastphotofortype!=null && lastphotofortype.getPrimaryKey().getId()==99)) {
                        //the combination group, film.type doesn't exist or is at 99
                        String groupid;
                        if(lastphotofortype==null) {
                            if(lastphoto==null) {
                                //this group does not exist yet for any film.type
                                groupid = "000";
                            } else {
                                //this group already exists for another film.type, create new one
                                String filmid = lastphoto.getPrimaryKey().getFilm();
                                groupid = filmid.substring(3, 6);
                                int groupnumber = Integer.valueOf(groupid).intValue() + 1;
                                groupid = String.valueOf(groupnumber);
                                while(groupid.length()<3) groupid = "0" + groupid;
                            }
                        } else {
                            //99 is reached within last group for film.type, start new one
                            String filmid = lastphoto.getPrimaryKey().getFilm();
                            groupid = filmid.substring(3, 6);
                            int groupnumber = Integer.valueOf(groupid).intValue() + 1;
                            groupid = String.valueOf(groupnumber);
                            while(groupid.length()<3) groupid = "0" + groupid;
                        }
                        film.logicentity.Film film = new film.logicentity.Film(filmgroupid + groupid);
                        film.setPublic(false);
                        film.setFilmtypePK(new FilmtypePK(uploadtype));
                        filmusecases.insertFilm(film);
                        newphoto = new film.logicentity.Photo(filmgroupid + groupid, 0);
                    } else {
                        newphoto = new film.logicentity.Photo(lastphotofortype.getPrimaryKey().getFilm(), lastphotofortype.getPrimaryKey().getId()+1);
                    }
                    String filename = photo.getFileName(photo.getPrimaryKey());
                    String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
                    String originalfilename = FILEROOT + rootpath + filename + "." + FILEEXTENTION;
                    String croppedpath = FILEROOT + photousecases.getImagePath(photo.getPrimaryKey(), CROPPEDPATH) + filename + "." + FILEEXTENTION;
                    String smallpath = FILEROOT + photousecases.getImagePath(photo.getPrimaryKey(), SMALLPATH) + filename + "." + FILEEXTENTION;
                    String thumbnailpath = FILEROOT + photousecases.getImagePath(photo.getPrimaryKey(), THUMBNAILPATH) + filename + "." + FILEEXTENTION;
                    Path original = FileSystems.getDefault().getPath(originalfilename);
                    Path originalcropped = FileSystems.getDefault().getPath(croppedpath);
                    Path originalsmall = FileSystems.getDefault().getPath(smallpath);
                    Path originalthumb = FileSystems.getDefault().getPath(thumbnailpath);
                    
                    String newfilename = newphoto.getFileName(newphoto.getPrimaryKey());
                    String newrootpath = BLfilm.getRootImagePath(newphoto.getPrimaryKey().getFilmPK()).toString();
                    String renamefilename = FILEROOT + newrootpath + newfilename + "." + FILEEXTENTION;
                    String newcroppedpath = FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), CROPPEDPATH) + newfilename + "." + FILEEXTENTION;
                    String newsmallpath = FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), SMALLPATH) + newfilename + "." + FILEEXTENTION;
                    String newthumbnailpath = FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), THUMBNAILPATH) + newfilename + "." + FILEEXTENTION;
                    Path target = FileSystems.getDefault().getPath(renamefilename);
                    Path targetcropped = FileSystems.getDefault().getPath(newcroppedpath);
                    Path targetsmall = FileSystems.getDefault().getPath(newsmallpath);
                    Path targetthumb = FileSystems.getDefault().getPath(newthumbnailpath);
            out.println(originalfilename + " -> " + renamefilename + "<br>");
            out.println(croppedpath + " -> " + targetcropped + "<br>");
            out.println(smallpath + " -> " + targetsmall + "<br>");
            out.println(originalfilename + " -> " + targetthumb + "<br>");

                    check = new File(FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), CROPPEDPATH));
                    if(!check.exists()) check.mkdirs();
                    check = new File(FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), SMALLPATH));
                    if(!check.exists()) check.mkdirs();
                    check = new File(FILEROOT + photousecases.getImagePath(newphoto.getPrimaryKey(), THUMBNAILPATH));
                    if(!check.exists()) check.mkdirs();

                    Files.move(original, target, StandardCopyOption.REPLACE_EXISTING);
                    Files.move(originalcropped, targetcropped, StandardCopyOption.REPLACE_EXISTING);
                    Files.move(originalsmall, targetsmall, StandardCopyOption.REPLACE_EXISTING);
                    Files.move(originalthumb, targetthumb, StandardCopyOption.REPLACE_EXISTING);
                    
                    //SQL statements
                    ArrayList phototree7subjects = phototree7subject_usecases.getPhototree7subjects4photo(photo.getPrimaryKey());
                    Iterator<Phototree7subject> phototree7subjectsI = phototree7subjects.iterator();
                    ArrayList phototags = phototags_usecases.getPhototagss4photo(photo.getPrimaryKey());
                    Iterator<film.logicentity.Phototags> phototagsI = phototags.iterator();
                    Phototree7subject subject;
                    film.logicentity.Phototags phototag;
                    
                    newphoto.setBackup(photo.getBackup());
                    newphoto.setComposition(photo.getComposition());
                    newphoto.setCreatorPK(photo.getCreatorPK());
                    newphoto.setDescription(photo.getDescription());
                    newphoto.setFormat(photo.getFormat());
                    newphoto.setImagebackup(photo.getImagebackup());
                    newphoto.setPhotodate(photo.getPhotodate());
                    newphoto.setPhototime(photo.getPhototime());
                    newphoto.setPublic(photo.getPublic());
                    newphoto.setRotation(photo.getRotation());
                    
                    photousecases.insertPhoto(newphoto);
                    while(phototree7subjectsI.hasNext()) {
                        subject = phototree7subjectsI.next();
                        subject.getPrimaryKey().setFilm(newphoto.getPrimaryKey().getFilm());
                        subject.getPrimaryKey().setId(newphoto.getPrimaryKey().getId());
                        phototree7subject_usecases.insertPhototree7subject(subject);
                    }
                    while(phototagsI.hasNext()) {
                        phototag = phototagsI.next();
                        phototag.getPrimaryKey().setFilm(newphoto.getPrimaryKey().getFilm());
                        phototag.getPrimaryKey().setId(newphoto.getPrimaryKey().getId());
                        phototag.getAll();
                        phototags_usecases.insertPhototags(phototag);
                    }
                }
            }
            catch(CustomException e) {
                
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
