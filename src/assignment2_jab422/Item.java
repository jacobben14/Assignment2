package assignment2_jab422;
/**
 * This class is a very simple representation of a hardware item. There are only getter
 * methods and no setter methods and as a result an item cannot be mutated once
 * initialized. 
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */

import java.io.Serializable;

/**
 * This class is a very simple representation of a hardware item. There are only getter
 * methods and no setter methods and as a result an item cannot be mutated once
 * initialized. An item object can also call the two override methods
 * <CODE>toString()</CODE> and <CODE>equals()</CODE>
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */
public abstract class Item implements Serializable, Comparable <Item> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String idNumber;
    protected String name;
    protected int quantity;
    protected float price;
    protected String itemType;
    
    public abstract String getIdNumber();
    public abstract String getName();
    public abstract int getQuantity();
    public abstract float getPrice();
    public abstract String getItemType();
    public abstract void getFormattedInfo();
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    
    /**
     * This constructor initializes the item object. The constructor provides no
     * user input validation. That should be handled by the class that creates a
     * item object.
     *
     * @param idNumber a <b><CODE>String</CODE></b> that represents the ID
     *                 random string of length 5 – can contain letters and numbers
     *
     * @param name a <b><CODE>String</CODE></b> that represents the name.
     *
     * @param category a <b><CODE>String</CODE></b> that represents the category.
     *                 Door&Window, Cabinet& Furniture, Fasteners, Structural, Other.
     *
     * @param quantity a <b><CODE>int</CODE></b> that represents the quantity
     *
     * @param price an <b><CODE>float</CODE></b> that represents the price
     * @param itemType a String that represents the type of item.
     *
     */
    public Item(String idNumber, String name, int quantity, float price, String itemType) {
        this.idNumber = idNumber;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.itemType = itemType;
    }

}