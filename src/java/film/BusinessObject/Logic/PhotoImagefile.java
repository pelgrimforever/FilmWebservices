/**
 * @author Franky Laseure
 */
package film.BusinessObject.Logic;

import BusinessObject.BusinessLogic;
import static BusinessObject.BusinessLogic.FILEROOT;
import BusinessObject.Filewriter;
import data.interfaces.db.Filedata;
import file.Filereader;
import static film.BusinessObject.Logic.BLphoto.CROPPEDPATH;
import static film.BusinessObject.Logic.BLphoto.FILEEXTENTION;
import static film.BusinessObject.Logic.BLphoto.SMALLPATH;
import static film.BusinessObject.Logic.BLphoto.SMALL_HEIGHT;
import static film.BusinessObject.Logic.BLphoto.SMALL_WIDTH;
import static film.BusinessObject.Logic.BLphoto.THUMBNAILPATH;
import static film.BusinessObject.Logic.BLphoto.THUMBNAIL_HEIGHT;
import static film.BusinessObject.Logic.BLphoto.THUMBNAIL_WIDTH;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.IPhoto;
import film.logicentity.Photo;
import general.exception.DBException;
import graphic.jpeg.Graphicfile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class PhotoImagefile {

    public final static String THUMBNAILPATH = "thumbnail" + File.separator;
    public final static String SMALLPATH = "small" + File.separator;
    public final static String CROPPEDPATH = "cropped" + File.separator;
    public final static String FILEEXTENTION = "jpg";

    public final static int SMALL_WIDTH = 800;
    public final static int SMALL_HEIGHT = 600;
    public final static int THUMBNAIL_WIDTH = 200;
    public final static int THUMBNAIL_HEIGHT = 200;
    
    private Filereader filereader = new Filereader();
    private Filewriter filewriter = new Filewriter();

    public String getImagePath(IPhotoPK photoPK, String subpath) {
        return BLfilm.getRootImagePath(photoPK.getFilmPK()).append(subpath).toString();
    }

    public String getFilename(IPhotoPK photoPK) {
        return new StringBuffer(Photo.getFileName(photoPK)).append(".").append(FILEEXTENTION).toString();
    }

    public String getFilename(IPhotoPK photoPK, String format) {
        if(format.length()==1)
            return new StringBuffer(Photo.getFileName(photoPK)).append(format).append(".").append(FILEEXTENTION).toString();
        else
            return new StringBuffer(Photo.getFileName(photoPK)).append("_").append(format).append(".").append(FILEEXTENTION).toString();
    }

    public Filedata getThumbnailfiledata(IPhotoPK photoPK) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, THUMBNAILPATH);
        String filename = getFilename(photoPK);
        return filereader.getFiledata(filepath, filename);
    }

    public File getThumbnailFile(IPhotoPK photoPK) {
        String filepath = getImagePath(photoPK, THUMBNAILPATH);
        String filename = getFilename(photoPK);
        return new File(BusinessLogic.FILEROOT + filepath + filename);
    }
    
    public void addThumbnailImageBase64(Photo photo) throws DBException {
        try {
            BufferedImage bi = ImageIO.read(getThumbnailFile(photo.getPrimaryKey()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            photo.setImagebase64("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(baos.toByteArray()));
        }
        catch(IOException e) {
        }
    }
    
    public File getSmallFile(IPhotoPK photoPK) {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK);
        return new File(BusinessLogic.FILEROOT + filepath + filename);
    }
    
    public Filedata getThumbnailfiledata(IPhotoPK photoPK, String format) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, THUMBNAILPATH);
        String filename = getFilename(photoPK, format);
        return filereader.getFiledata(filepath, filename);
    }
    
    private String getSmallfilepath(IPhotoPK photoPK) {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK);
        return FILEROOT + filepath + filename;
    }


    public Filedata getSmallfiledata(IPhotoPK photoPK) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK);
        return filereader.getFiledata(filepath, filename);
    }

    public Filedata getSmallfiledata(IPhotoPK photoPK, String format) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK, format);
        return filereader.getFiledata(filepath, filename);
    }

    public Filedata getCroppedfiledata(IPhotoPK photoPK) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, CROPPEDPATH);
        String filename = getFilename(photoPK);
        return filereader.getFiledata(filepath, filename);
    }

    public Filedata getCroppedfiledata(IPhotoPK photoPK, String format) throws IOException, FileNotFoundException {
        String filepath = getImagePath(photoPK, CROPPEDPATH);
        String filename = getFilename(photoPK, format);
        return filereader.getFiledata(filepath, filename);
    }

    public Filedata getRootfiledata(IPhotoPK photoPK) throws IOException, FileNotFoundException {
        String filepath = BLfilm.getRootImagePath(photoPK.getFilmPK()).toString();
        String filename = getFilename(photoPK);
        return filereader.getFiledata(filepath, filename);
    }

    public void backupImages_deletebigfiles(
            IPhotoPK photoPK, 
            String rootfilename, 
            String croppedfilename, 
            String croppedfilename_format, 
            String croppedfilename_composition) {
        String filepath = BLfilm.getRootImagePath(photoPK.getFilmPK()).toString();
        filewriter.deleteFile(filepath, rootfilename);
        filepath = getImagePath(photoPK, CROPPEDPATH);
        filewriter.deleteFile(filepath, croppedfilename);
        if(croppedfilename_format!=null)
            filewriter.deleteFile(filepath, croppedfilename_format);
        if(croppedfilename_composition!=null)
            filewriter.deleteFile(filepath, croppedfilename_composition);
    }

    public String copy_cropped_to_backupdir(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getCroppedfiledata(photoPK);
        String croppedfilename = image.getFilename();
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
        return croppedfilename;
    }

    public void copy_cropped_and_backup(IPhoto photo, Filedata rootimage, String backupdir) throws IOException, FileNotFoundException {
        IPhotoPK photoPK = photo.getPrimaryKey();
        String croppedpath = getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
        filewriter.saveFile(rootimage, croppedpath);
        croppedpath = getImagePath(photoPK, CROPPEDPATH);
        filewriter.saveFileAbsolutepath(rootimage, backupdir + getImagePath(photoPK, CROPPEDPATH));
    }

    public void copy_small_to_backupdir(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getSmallfiledata(photoPK);
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
    }

    public void copy_root_resizetosmall_and_backup(Filedata rootimage, IPhoto photo, String backupdir) throws IOException {
        Graphicfile gf = rootimage.getGraphicfile();
        gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
        String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
        gf.saveImage(smallpath, rootimage.getFilename());
        smallpath = backupdir + getImagePath(photo.getPrimaryKey(), SMALLPATH);
        gf.saveImage(smallpath, rootimage.getFilename());
    }

    public void copy_thumbnail_to_backupdir(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getThumbnailfiledata(photoPK);
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
    }

    public void copy_root_resizetothumbnail_and_backup(Filedata rootimage, IPhoto photo, String backupdir) throws IOException {
        Graphicfile gf = rootimage.getGraphicfile();
        gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
        String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
        gf.saveImage(thumbnailpath, rootimage.getFilename());
        thumbnailpath = backupdir + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
        gf.saveImage(thumbnailpath, rootimage.getFilename());
    }

    public String backupImage_composition_cropped(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getCroppedfiledata(photoPK, "COMPOSITION");
        String croppedfilename_composition = image.getFilename();
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
        return croppedfilename_composition;
    }

    public void backupImage_composition_small(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getSmallfiledata(photoPK, "COMPOSITION");
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
    }

    public void backupImage_composition_thumbnail(IPhotoPK photoPK, String backupdir) throws IOException {
        Filedata image = getThumbnailfiledata(photoPK, "COMPOSITION");
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
    }

    public String backupImage_formatH(
            IPhoto photo, 
            String backupdir)
            throws IOException {
        IPhotoPK photoPK = photo.getPrimaryKey();
        Filedata image;
        image = getCroppedfiledata(photoPK, photo.getFormat());
        String croppedfilename_format = image.getFilename();
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
        image = getSmallfiledata(photoPK, photo.getFormat());
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
        image = getThumbnailfiledata(photoPK, photo.getFormat());
        filewriter.saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
        return croppedfilename_format;
    }

    public String writeRootimage(Photo photo, String filename, Filedata root) throws IOException {
        String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
        String newfilename = filename + "." + FILEEXTENTION;
        filewriter.saveFileAs(root, rootpath, newfilename);
        return newfilename;
    }

    public String writeCroppedimage(Photo photo, String filename, Filedata cropped) throws IOException {
        String croppedpath = getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
        String newfilename = filename + "." + FILEEXTENTION;
        filewriter.saveFileAs(cropped, croppedpath, newfilename);
        return newfilename;
    }

    public void resizeImage_to_small_thumbnail(Filedata cropped, Photo photo, String newfilename) throws IOException {
        Graphicfile gf = cropped.getGraphicfile();
        gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
        String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
        gf.saveImage(smallpath, newfilename);
        gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
        String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
        gf.saveImage(thumbnailpath, newfilename);
    }

    public void write_rotatedimage(Graphicfile gf, Photo photo, String newfilename, HashMap photoproperties) throws IOException {
        float rotation = (Float)photoproperties.get("rotation");
        int rotationfactor = (int)rotation;
        while(rotationfactor<0) rotationfactor += 360;
        while(rotationfactor>360) rotationfactor -= 360;
        switch(rotationfactor) {
            case 90:
                gf.rotateRight();
                break;
            case 180:
                gf.rotate180();
                break;
            case 270:
                gf.rotateLeft();
                break;
        }
        String croppedpath = FILEROOT + getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
        gf.saveImage(croppedpath, newfilename);
    }

    public void write_resizethumbnail(Graphicfile gf, Photo photo, String newfilename) throws IOException {
        gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
        String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
        gf.saveImage(thumbnailpath, newfilename);
    }

    public void write_resizesmall(Graphicfile gf, Photo photo, String newfilename) throws IOException {
        gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
        String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
        gf.saveImage(smallpath, newfilename);
    }

}
