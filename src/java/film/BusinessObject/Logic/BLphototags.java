/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IPhototags;
import film.logicentity.Phototags;
import film.BusinessObject.table.Bphototags;
import film.conversion.entity.EMphototags;
import film.entity.pk.PhototagsPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.IPhoto;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import graphic.jpeg.Graphicfile;
import graphic.jpeg.Tag;
import java.util.ArrayList;
import java.util.HashMap;

public class BLphototags extends Bphototags {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLphototags(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLphototags(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getPhototagss4photo(IPhotoPK photoPK) throws DBException {
        return this.getEntities(EMphototags.SQLSelect4phototags_photo_sorted, photoPK.getSQLprimarykey());
    }

    public void insertGraphicfileMetatags(SQLTqueue transactionqueue, Graphicfile graphicfile, IPhoto photo) throws DataException, DBException {
        ArrayList<Tag> tags = graphicfile.getMetadataTaglist();
        PhototagsPK phototagPK;
        Phototags phototag;
        HashMap tagnames = new HashMap();
        for(Tag tag: tags) {
            if(!tagnames.containsKey(tag.getName())) {
                tagnames.put(tag.getName(), tag.getName());
                phototagPK = new PhototagsPK();
                phototagPK.setPhotoPK(photo.getPrimaryKey());
                phototagPK.setTag(tag.getName());
                phototag = new Phototags(phototagPK);
                phototag.setTagformat(tag.getType());
                phototag.setTagvalue(tag.getValue());
                insertPhototags(transactionqueue, phototag);
            }
        }
    }

    public Tag findTag(ArrayList taglist, String tagname) {
        Tag tag;
        Tag tagresult = null;
        for(int i=0; i<taglist.size(); i++) {
            tag = (Tag)taglist.get(i);
            if(tag.getName().equals(tagname)) {
                tagresult = tag;
            }
        }
        return tagresult;
    }
}
