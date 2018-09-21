package assignment2_jab422;
/**
 * This class is a very simple representation of a transaction. There are only getter
 * methods and no setter methods and as a result an transaction cannot be mutated once
 * initialized. 
 *
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */

import java.io.Serializable;
import java.sql.Date;

public class Transaction implements Serializable, Comparable <Transaction> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemId;
	private Date sDate;
	private int sQuantity;
	private int customerId;
	private int employeeId;
	
	/**
	 * This constructor initalizes the Transaction object. The constructor provides no
	 * user input validation. That should be handled by the class that creates an object.
	 * 
	 * @param itemId a String that represents the item ID.
	 * @param sDate a Date that represents the sales date.
	 * @param sQuantity a int that represents the quantity sold.
	 * @param customerId a int that represents the customer who purchased it.
	 * @param employeeId a int that represents the employee who sold it.
	 */
	public Transaction(String itemId, Date sDate, int sQuantity, int customerId, int employeeId) {
		this.itemId = itemId;
		this.sDate = sDate;
		this.sQuantity = sQuantity;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}
	
	/**
     * This method returns the item ID for the transaction.
     *
     * @return a <b><CODE>String</CODE></b> that is the items ID Number.
     */
	public String getItemId() {
		return itemId;
	}

	/**
     * This method returns the date that the transaction was completed.
     *
     * @return a <b><CODE>String</CODE></b> that is the transactions sales date.
     */
	public Date getsDate() {
		return sDate;
	}

	/**
     * This method returns the quantity which was sold from the item.
     *
     * @return a <b><CODE>int</CODE></b> that is the quantity.
     */
	public int getsQuantity() {
		return sQuantity;
	}

	/**
     * This method returns the Customers ID Number.
     *
     * @return a <b><CODE>int</CODE></b> that is the Customers ID Number.
     */
	public int getCustomerId() {
		return customerId;
	}

	/**
     * This method returns the Employee ID Number.
     *
     * @return a <b><CODE>int</CODE></b> that is the Employee ID Number.
     */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * This method helps display the items in a formatted manner.
	 */
	public void getFormattedInfo() {

		System.out.format("|%12s|%15s|%15s|%15s|%15s|\n", this.itemId, this.sDate, this.sQuantity, this.customerId, this.employeeId);
		
	}

	/**
	 * This method is used to compare 
	 * 
	 * @param o Object that is being compared
	 * 
	 */
	@Override
	public int compareTo(Transaction o) {
		return this.itemId.compareTo(o.getItemId());
	}
	
}
