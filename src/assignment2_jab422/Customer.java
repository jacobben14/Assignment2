package assignment2_jab422;

/**
 * This class is a representation of a Customer of type User.
 * 
 * @author jacob
 * @version 1.0
 * @since 2/22/210
 */

public class Customer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pNumber;
	private String address;
	
	/**
	 * This constructor initalizes the Customer object. The constructor provides no
	 * user input validation. That should be handled by the class that creates an object.
	 * 
	 * @param idNumber a String that represents the user ID.
	 * @param fName a String that represents the first name.
	 * @param lName a String that represents the last name.
	 * @param pNumber a String that represents the phone number.
	 * @param address a String that represents the address.
	 * @param userType a String that repsents the type of user.
	 */
	public Customer(int idNumber, String fName, String lName, String pNumber, String address, String userType) {
		super(idNumber, fName, lName, userType);
		this.pNumber = pNumber;
		this.address = address;
	}

	/**
     * This method returns the user's ID Number.
     *
     * @return a <b><CODE>String</CODE></b> that is the user's ID Number.
     */
	@Override
	public int getidNumber() {
		return idNumber;
	}

	/**
     * This method returns the users first name.
     *
     * @return a <b><CODE>String</CODE></b> that is the user's first name.
     */
	@Override
	public String getFname() {
		return fName;
	}

	/**
     * This method returns the users last name.
     *
     * @return a <b><CODE>String</CODE></b> that is the user's last name.
     */
	@Override
	public String getLname() {
		return lName;
	}

	/**
	 * This method is used to compare 
	 * 
	 * @param o Object that is being compared
	 * 
	 */
	@Override
	public int compareTo(User o) {
		return this.idNumber - o.getidNumber();
	}

	/**
     * This method returns the users type.
     *
     * @return a <b><CODE>String</CODE></b> that is the users type.
     */
	public String getType() {
		return userType;
	}

	
	/**
	 * This method helps display the items in a formatted manner.
	 */
	@Override
	public void getFormattedInfo() {
		System.out.format("|%12s|%12s|%12s|%12s|%12s|%16s|%15s|%15s|\n",this.userType, this.idNumber, this.fName, this.lName,"N/A","N/A", this.pNumber, this.address);
	}

	/**
     * This method set the user's ID number.
     *
     *  @param idNumber a <b><CODE>int</CODE></b> that represents the id number.
     */
	@Override
	public int setIdNumber(int idNumber) {
		return this.idNumber = idNumber;
	}

	/**
     * This method set the user's first name.
     *
     *  @param fName a <b><CODE>String</CODE></b> that represents the first name.
     */
	@Override
	public String setFname(String fName) {
		return this.fName = fName;
	}

	/**
     * This method set the user's last name.
     *
     *  @param lName a <b><CODE>String</CODE></b> that represents the last name.
     */
	@Override
	public String setLname(String lName) {
		return this.lName = lName;
	}

	/**
     * This method set the user's phone number.
     *
     *  @param pNumber a <b><CODE>String</CODE></b> that represents the phone number.
     */
	public String setPnumber(String pNumber) {
		return this.pNumber = pNumber;
	}
	
	/**
     * This method set the user's address.
     *
     *  @param address a <b><CODE>String</CODE></b> that represents the address.
     */
	public String setAddress(String address) {
		return this.address = address;
	}

}
