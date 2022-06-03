/*
 * BLphototags.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
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

/**
 * Business Logic Entity class BLphototags
 *
 * Class for manipulating data- and database objects
 * for Entity Phototags and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLphototags extends Bphototags {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Phototags as default Entity
     */
    public BLphototags() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Phototags as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLphototags(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Phototags Entity objects for Photo
     * @throws general.exception.CustomException
     */
    @Override
    public ArrayList getPhototagss4photo(IPhotoPK photoPK) throws CustomException {
        return this.getEntities(EMphototags.SQLSelect4phototags_photo_sorted, photoPK.getSQLprimarykey());
    }

    /**
     * try to insert Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertPhototags(IPhototags phototags) throws DBException, DataException {
        trans_insertPhototags(phototags);
        super.Commit2DB();
    }
    
    /**
     * try to insert Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertPhototags(IPhototags phototags) throws DBException, DataException {
        trans_insertPhototags(phototags);
        super.Commit2DB();
    }
    
    /**
     * try to update Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updatePhototags(IPhototags phototags) throws DBException, DataException {
        trans_updatePhototags(phototags);
        super.Commit2DB();
    }
    
    /**
     * try to update Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdatePhototags(IPhototags phototags) throws DBException, DataException {
        trans_updatePhototags(phototags);
        super.Commit2DB();
    }
    
    /**
     * try to delete Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deletePhototags(IPhototags phototags) throws DBException {
        trans_deletePhototags(phototags);
        super.Commit2DB();
    }

    /**
     * try to delete Phototags object in database
     * commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     */
    public void securedeletePhototags(IPhototags phototags) throws DBException {
        trans_deletePhototags(phototags);
        super.Commit2DB();
    }

    public void insertGraphicfileMetatags(Graphicfile graphicfile, IPhoto photo) throws DataException, DBException {
        ArrayList tags = graphicfile.getMetadataTaglist();
        Tag tag;
        PhototagsPK phototagPK;
        Phototags phototag;
        HashMap tagnames = new HashMap();
        for(int i=0; i<tags.size(); i++) {
            tag = (Tag)tags.get(i);
            if(!tagnames.containsKey(tag.getName())) {
                tagnames.put(tag.getName(), tag.getName());
                phototagPK = new PhototagsPK();
                phototagPK.setPhotoPK(photo.getPrimaryKey());
                phototagPK.setTag(tag.getName());
                phototag = new Phototags(phototagPK);
                phototag.setTagformat(tag.getType());
                phototag.setTagvalue(tag.getValue());
                super.insertPhototags(phototag);
            }
        }
    }

    /**
     * try to insert Phototags object in database
     * do not commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertPhototags(IPhototags phototags) throws DBException, DataException {
        super.checkDATA(phototags);
        super.insertPhototags((Phototags)phototags);
    }
    
    /**
     * try to update Phototags object in database
     * do not commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updatePhototags(IPhototags phototags) throws DBException, DataException {
        super.checkDATA(phototags);
        super.updatePhototags((Phototags)phototags);
    }
    
    /**
     * try to delete Phototags object in database
     * do not commit transaction
     * @param phototags: Phototags Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deletePhototags(IPhototags phototags) throws DBException {
        super.deletePhototags((Phototags)phototags);
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
