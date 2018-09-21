package assignment2_jab422;

/**
 * This class is a representation of an Employee of type User.
 * 
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */

public class Employee extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ssn;
	private float monthS;
	
	/**
	 * This constructor initalizes the Employee object. The constructor provides no
	 * user input validation. That should be handled by the class that creates an object.
	 * 
	 * @param idNumber a String that represents the user ID.
	 * @param fName a String that represents the first name.
	 * @param lName a String that represents the last name.
	 * @param ssn a String that represents the SSN.
	 * @param monthS a String that represents the monthly salary.
	 * @param userType a String that repsents the type of user.
	 */
	public Employee(int idNumber, String fName, String lName, int ssn, float monthS, String userType) {
		super(idNumber, fName, lName, userType);
		this.ssn = ssn;
		this.monthS = monthS;
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
     * This method returns the users SSN.
     *
     * @return a <b><CODE>int</CODE></b> that is the user's SSN.
     */
	public int getSsn() {
		return ssn;
	}
	
	/**
     * This method returns the users monthly salary.
     *
     * @return a <b><CODE>float</CODE></b> that is the user's monthly salary.
     */
	public float getMonthS() {
		return monthS;
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
		System.out.format("|%12s|%12s|%12s|%12s|%12s|%16s|%15s|%15s|\n", this.userType, this.idNumber, this.fName, this.lName, this.ssn, this.monthS, "N/A", "N/A");		
	}
	
	/**
     * This method set the user's SSN.
     *
     *  @param ssn a <b><CODE>int</CODE></b> that represents the SSN.
     */
	public int setSsn(int ssn) {
		return this.ssn = ssn;
	}
	
	/**
     * This method set the user's monthly salary.
     *
     *  @param monthS a <b><CODE>float</CODE></b> that represents the monthly salary.
     */
	public float setMonthS(float monthS) {
		return this.monthS = monthS;
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
}
