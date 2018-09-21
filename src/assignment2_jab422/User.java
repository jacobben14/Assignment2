package assignment2_jab422;
/**
 * 
 * This class is a very simple representation of a User.
 * 
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */

import java.io.Serializable;

public abstract class User implements Serializable, Comparable <User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int idNumber;
	protected String fName;
	protected String lName;
	protected String userType;
	Customer custom;
	Employee emp;
	
	public abstract int getidNumber();
	public abstract String getFname();
	public abstract String getLname();
	public abstract String getType();
	public abstract void getFormattedInfo();
	public abstract int setIdNumber(int idNumber);
	public abstract String setFname(String fName);
	public abstract String setLname(String lName);
	
	/**
	 * This super constructor initalizes the User object. The constructor provides no
	 * user input validation. That should be handled by the class that creates an object.
	 * 
	 * @param idNumber a int that represents the ID number.
	 * @param fName a String that represents the first name.
	 * @param lName a String that represents the last name.
	 * @param userType a String that represents the user type. 
	 */
	public User(int idNumber, String fName, String lName, String userType) {
		this.idNumber = idNumber;
		this.fName = fName;
		this.lName = lName;
		this.userType = userType;
	}
	
	/**
	 * This method is used to set the updated values for the Customer.
	 * 
	 * @param pNumber a String that sets the phone number.
	 * @param address a String that sets the address.
	 * @param temp a User that helps locate the user in which we are trying to set the values for.
	 */
	public void updateRemainingC(String pNumber, String address, User temp) {
		custom = (Customer) temp;
		custom.setPnumber(pNumber);
		custom.setAddress(address);
	}
	
	/**
	 * This method is used to set the updated values for the Employee.
	 * 
	 * @param ssn a int that sets the SSN.
	 * @param monthS a float that sets the monthly salaray.
	 * @param temp a User that helps locate the user in which we are trying to set the values for.
	 */
	public void updatingRemainingE(int ssn, float monthS, User temp) {
		emp = (Employee) temp;
		emp.setSsn(ssn);
		emp.setMonthS(monthS);
	}
}
