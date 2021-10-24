/*
 * BLviewdescriptions.java
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLview;
import film.conversion.entity.EMviewdescriptions;
import film.logicview.Viewdescriptions;

/**
 * Business Logic for viewdescriptions
 * @author Franky Laseure
 */
public class BLviewdescriptions extends BLview {
	
    /**
     * Constructor
     */
    public BLviewdescriptions() {
        super(new Viewdescriptions(), new EMviewdescriptions());
    }
    
}
