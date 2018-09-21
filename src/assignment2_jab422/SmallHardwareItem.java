package assignment2_jab422;
/**
 * This class is a representation of a small hardware item of type Item.
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */

public class SmallHardwareItem extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	
	/**
	 * This constructor initalizes the SmallHardwareItem object. The constructor provides no
	 * user input validation. That should be handled by the class that creates an object.
	 * 
	 * @param idNumber a String that represents the ID string of length 5.
	 * @param name a String that represents a name.
	 * @param quantity a int that represents quantity.
	 * @param price a float that represents price.
	 * @category a String that represents the items category.
	 * @param itemType a String that represents the item's type of Appliances SmallHardwareItem.
	 */
	public SmallHardwareItem(String idNumber, String name, int quantity, float price, String category, String itemType) {
		super(idNumber, name, quantity, price, itemType);
		this.category = category;
	}

	/**
	 * This method returns the item's type of category.
	 * 
	 * @return a String that is the item's type of category.
	 * 
	 */
	public String getCategory() {
		return category;
	}

    /**
     * This method returns the item's ID Number.
     *
     * @return a <b><CODE>String</CODE></b> that is the item's ID Number.
     */
	@Override
	public String getIdNumber() {
		return idNumber;
		
	}

    /**
     * This method returns the item's name.
     *
     * @return a <b><CODE>String</CODE></b> that is the item's name.
     */
	@Override
	public String getName() {
		return name;
		
	}

    /**
     * This method returns the item's quantity.
     *
     * @return a <b><CODE>String</CODE></b> that is the item's quantit.
     */
	@Override
	public int getQuantity() {
		return quantity;
		
	}

	/**
     * This method returns the item's price.
     *
     * @return a <b><CODE>String</CODE></b> that is the item's price.
     */
	@Override
	public float getPrice() {
		return price;
		
	}
	
	/**
	 * This method is used to compare 
	 * 
	 * @param o Object that is being compared
	 * 
	 */
	@Override
	public int compareTo(Item o) {
		return this.idNumber.compareTo(o.getIdNumber());
	}

	/**
	 * This method returns the item's type of name.
	 * 
	 * @return a String that is the item's type of name.
	 * 
	 */
	@Override
	public String getItemType() {
		return itemType;
	}
	
	
	/**
	 * This method helps display the items in a formatted manner.
	 */
	@Override
	public void getFormattedInfo() {
		System.out.format("|%12s|%12s|%17s|%12s|%12s|%17s|%12s|%17s|\n", this.itemType, this.idNumber, this.name, this.quantity, "$"+this.price, "N/A", "N/A", this.category);
	}
}
