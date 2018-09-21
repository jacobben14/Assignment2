package assignment2_jab422;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class is used to represent a database interface for a list of
 * <CODE>item</CODE>'s. It using a plain-text file "database.txt" to store and
 * write item objects in readable text form. It contains an
 * <CODE>ArrayList</CODE> called <CODE>itemList</CODE> to store the database in
 * a runtime friendly data structure. The <CODE>itemList</CODE> is written to
 * "database.txt" at the end of the <CODE>HardwareStore</CODE> object's life by
 * calling <CODE>writeDatabase()</CODE>. This class also provides methods for
 * adding, removing, and searching for items in the list.
 *
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 *
 */
public class HardwareStore {

    private ArrayList<Item> itemList;
    private ArrayList<User> userList;
    private ArrayList<Transaction> transactionList;
    Item item;
    Customer customer;
    Employee employee;

    /**
     * This constructor creates an empty ArrayList and then calls the 
     * <CODE>readDatabase()</CODE> method to populate items previously stored. 
     *
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	public HardwareStore() throws IOException {
        itemList = new ArrayList<Item>();
        userList = new ArrayList<User>();
        transactionList = new ArrayList<Transaction>();      
       
        try {
        	FileInputStream itemFis = new FileInputStream("item.ser");
        	ObjectInputStream itemOis = new ObjectInputStream(itemFis);
        	itemList = (ArrayList<Item>) itemOis.readObject();
        	itemFis.close();
        	itemOis.close();
        	
        	FileInputStream userFis = new FileInputStream("user.ser");
        	ObjectInputStream userOis = new ObjectInputStream(userFis);
        	userList = (ArrayList<User>) userOis.readObject();
        	userFis.close();
        	userOis.close();
        	
        	FileInputStream tranFis = new FileInputStream("transaction.ser");
        	ObjectInputStream tranOis = new ObjectInputStream(tranFis);
        	transactionList = (ArrayList<Transaction>) tranOis.readObject();
        	tranFis.close();
        	tranOis.close();
        	
        }catch(FileNotFoundException fileNotFound) {
        	itemList = new ArrayList<Item>();
            userList = new ArrayList<User>();
            transactionList = new ArrayList<Transaction>();
        }catch(IOException IoE) {
        	IoE.printStackTrace();
        	return;
        }catch(ClassNotFoundException classNotFound) {
        	System.out.println("Class not found.");
        	classNotFound.printStackTrace();
        	return;
        }
        
    }

    
    public void serializeList() {
    	try {
    		FileOutputStream itemFos = new FileOutputStream("item.ser");
    		ObjectOutputStream itemOos = new ObjectOutputStream(itemFos);
    		for(int i = 0; i < itemList.size(); i++) {
    			itemOos.writeObject(itemList);
    		}
    		itemFos.close();
    		itemOos.close();
    		
    		FileOutputStream userFos = new FileOutputStream("user.ser");
    		ObjectOutputStream userOos = new ObjectOutputStream(userFos);
    		for(int i = 0; i < userList.size(); i++) {
    			userOos.writeObject(userList);
    		}
    		userFos.close();
    		userOos.close();
    		
    		FileOutputStream transactionFos = new FileOutputStream("transaction.ser");
    		ObjectOutputStream transactionOos = new ObjectOutputStream(transactionFos);
    		for(int i = 0; i < transactionList.size(); i++) {
    			transactionOos.writeObject(transactionList);
    		}
    		transactionFos.close();
    		transactionOos.close();
    		
    	}catch(IOException IoE) {
    		IoE.printStackTrace();
    	}
    }
    
    /**
     * This method is used to add a item to the itemList ArrayList.
     *
     * @param item an object of type Item to help add to the item arrayList
     */
    public void addNewItem(Item item) {
        //If passed all the checks, add the item to the list
        itemList.add(item);
        Collections.sort(itemList);
        System.out.println("Item has been added.\n");
    }
    
    
    /**
     * Add a certain quantity of the given item index.
     * Preconditions: 1. Item exists.
     * @param itemIndex the index of the item in the itemList
     * @param quantity  the quantity to add
     */
    public void addQuantity(int itemIndex, int quantity) {
        Item temp = getItem(itemIndex);
        temp.setQuantity(temp.getQuantity() + quantity);
        System.out.println("Quantity updated.\n");
    }
    
    
    
    /**
     * Remove a certain quantity of the given item index.
     * Preconditions: 1. Item exists.
     * @param itemIndex the index of the item in the itemList
     * @param quantity  the quantity to remove
     */
    public void removeQuantity(int itemIndex, int quantity) {
    	Item temp = getItem(itemIndex);
    	temp.setQuantity(temp.getQuantity() - quantity);
    	System.out.println("Quantity updated.\n");
    }

    
    /**
     * Removes a certain quantity of the given item index. 
     * Preconditions: 1. Item exists. 2. Quantity to remove smaller than current quantity.
     * @param itemIndex the index of the item in the itemList that is being removed.
     */
    public void removeItem(int itemIndex) {
        Item temp = getItem(itemIndex);
        itemList.remove(temp);
        System.out.println("Item removed.\n");
    }

    /**
     * Returns all the items that (partially) match the given name.
     * @param name the name to match.
     * @return a string containing a table of the matching items.
     */
    public void getMatchingItemsByName(String name) {

    	boolean flag = false;
    	
    	for(Item itemMan:itemList) {
    		if(itemMan.getName().contains(name)) {
    			System.out.print("Items with the name or similar to the name "+name+" are: ");
				System.out.println(itemMan.getName()+" - "+itemMan.getQuantity()+" $"+itemMan.getPrice());
				flag = true;
    		}
    	}
    	if(!flag) {System.out.println("Name cannot be found.");}
    }


    /**
     * This method can be used to find a item in the Arraylist of items.
     *
     * @param idNumber a <CODE>String</CODE> that represents the ID number of
     * the item that to be searched for.
     * @return the <CODE>int</CODE> index of the items in the Arraylist of
     * items, or -1 if the search failed.
     */
    public int findItem(String idNumber) {

        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            String temp = itemList.get(i).getIdNumber();
            if (idNumber.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    
    /**
     * This method can be used to find a user in the Arraylist of users.
     *
     * @param idNumber a <CODE>String</CODE> that represents the ID number of
     * the User that to be searched for.
     * @return the <CODE>int</CODE> index of the items in the Arraylist of
     * items, or -1 if the search failed.
     */
    public int findUser(int idNumber) {

        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            int temp = userList.get(i).getidNumber();
            if (idNumber == temp) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * This method is used to retrieve the Item object from the
     * <CODE>itemList</CODE> at a given index.
     *
     * @param i the index of the desired <CODE>Item</CODE> object.
     * @return the <CODE>Item</CODE> object at the index or null if the index is
     * invalid.
     */
    public Item getItem(int i) {
        if (i < itemList.size() && i >= 0) {
            return itemList.get(i);
        } else {
            System.out.println("Invalid Index.\n");
            return null;
        }
    }

    
    /**
     * This method is used to display all users in the ArrayList of users.
     */
    public void displayUsers() {
    	Iterator<User> itUser = userList.iterator();
    	if(!itUser.hasNext()) {
    		System.out.println("There are currently no users.");
    		return;
    	}
		System.out.println(" ------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%12s|%12s|%12s|%12s|%12s|%16s|%15s|%15s|\n","USER", "ID#","FIRST NAME","LAST NAME","SSN","MONTHLY SALARY", "PHONE#", "ADDRESS");
		System.out.println(" ------------------------------------------------------------------------------------------------------------------");
    	while(itUser.hasNext()) {
    		User user = itUser.next();
    		if(user.getType().equals("Customer")) {
    			Customer cust = (Customer) user;
    			cust.getFormattedInfo();
    		}
    		else if(user.getType().equals("Employee")) {
    			Employee emp = (Employee) user;
    			emp.getFormattedInfo();
    		}
    		else {
    			User us = (User) user;
    			us.getFormattedInfo();
    		}
    	}
    	System.out.println(" ------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * This method is used to display all items in the ArrayList of items.
     */
    public void displayItems() {
    	 Iterator<Item> i = itemList.iterator();
         if(!i.hasNext()) {
         	System.out.println("Empty. No items.");
         	return;
         }
         System.out.println(" ----------------------------------------------------------------------------------------------------------------------------");
         System.out.format("|%17s|%12s|%17s|%12s|%12s|%17s|%12s|%17s|\n","ITEM TYPE", "ID#","NAME","QUANTITY","PRICE","      TYPE","BRAND", "CATEGORY");
         System.out.println(" ----------------------------------------------------------------------------------------------------------------------------");
         while(i.hasNext()) {
         	Item item = i.next();
         	if(item.getItemType().equals("Appliances")) {

         		Appliances app = (Appliances) item;
         		app.getFormattedInfo();
         	}
         	else if(item.getItemType().equals("SmallHardwareItem")) {
         		SmallHardwareItem smallHw = (SmallHardwareItem) item;
         		smallHw.getFormattedInfo();
         	}
         	else {
         		Item it = (Item) item;
         		it.getFormattedInfo();
         	}
         }
         System.out.println(" ----------------------------------------------------------------------------------------------------------------------------");
    }
    
    
    /**
     * This method is used to display all transactions in the ArrayList of transactions.
     */
    public void displayTransactions() {
    	Iterator<Transaction> tIt = transactionList.iterator();
    	if(!tIt.hasNext()) {
    		System.out.println("No completed transactions.");
    		return;
    	}
		System.out.println(" -----------------------------------------------------------------------------");
		System.out.format("|%12s|%15s|%15s|%15s|%15s|\n","ITEM ID#", "DATE","QUANTITY","CUSTOMER ID#","EMPLOYEE ID#");
		System.out.println(" -----------------------------------------------------------------------------");
    	while(tIt.hasNext()) {
    		Transaction temp = tIt.next();
    		temp.getFormattedInfo();
    	}
    	System.out.println(" -----------------------------------------------------------------------------"); 
    }
    
    
    /**
     * This method is used to add a new user into the arrayList of users and sorts it afterwards
     * @param user the new user that is being added to the arrayList
     */
    public void addNewUser(User user) {
    	userList.add(user);
    	Collections.sort(userList);
    }

    /**
     * This method is used to get a user from the arrayList of Users.
     * 
     * @param u index location
     * @return the index location of the user you are trying to obtain from the arrayList of users, or returns null if failed to find user.
     */
    public User getUser(int u) {
    	if(u < userList.size() && u >=0) {
    		return userList.get(u);
    	} else {
    		System.out.println("Invalid Index.\n");
    		return null;
    	}
    }
    
    
    /**
     * This method is used to update the User customer in an arrayList of users.
     * 
     * @param userIndex variable passed to update a Customer with a setter
     * @param idNumber variable passed to update a Customer with a setter
     * @param fName variable passed to update a Customer with a setter
     * @param lName variable passed to update a Customer with a setter
     * @param pNumber variable passed to update a Customer with a setter
     * @param address variable passed to update a Customer with a setter
     */
    public void updateUserCustomer(int userIndex, int idNumber, String fName, String lName, String pNumber, String address) {
    	User temp = getUser(userIndex);
    	temp.setIdNumber(idNumber);
    	temp.setFname(fName);
    	temp.setLname(lName);
    	temp.updateRemainingC(pNumber, address, temp);
    }
    
    /**
     * This method is used to update the User empolyee in an ArrayList of users.
     * 
     * @param userIndex variable passed to update an Employee with a setter.
     * @param idNumber variable passed to update an Employee with a setter.
     * @param fName variable passed to update an Employee with a setter.
     * @param lName variable passed to update an Employee with a setter.
     * @param ssn variable passed to update an Employee with a setter.
     * @param monthS variable passed to update an Employee with a setter.
     */
    public void updateUserEmployee(int userIndex, int idNumber, String fName, String lName, int ssn, float monthS) {
    	User temp = getUser(userIndex);
    	temp.setIdNumber(idNumber);
    	temp.setFname(fName);
    	temp.setLname(lName);
    	temp.updatingRemainingE(ssn, monthS, temp);
    	
    }

    
    /**
     * This method is used to help determine if an Employee is in the arrayList of users.
     * 
     * @return true if contains an employee in the arrayList of users, or false if does not contain an employee
     */
    public boolean containsEmployees() {
    	Iterator<User> emIt = userList.iterator();
    	while(emIt.hasNext()) {
    		User user = emIt.next();
    		if(user.getType().equals("Employee")){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * This method is used to help determine if a Customer is in the arrayList of users.
     * 
     * @return true if contains an customer in the arrayList of users, or false if does not contain an customer.
     */
    public boolean containsCustomer() {
    	Iterator<User> cuIt = userList.iterator();
    	while(cuIt.hasNext()) {
    		User user = cuIt.next();
    		if(user.getType().equals("Customer")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * This method is used to help determine if an Item is in the arrayList of Items.
     * 
     * @return true if contains an Item in the arrayList of Items, or false if does not contain an Item.
     */
    public boolean containsItems() {
    	Iterator<Item> itemIt = itemList.iterator();
    	while(itemIt.hasNext()) {
    		Item item = itemIt.next();
    		if(item.getItemType().contains("Appliances") || item.getItemType().contains("SmallHardwareItem")) {
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * This method is used to add a new transaction into the arrayList of transactions.
     * 
     * @param tran object of transaction to help add new transaction into arrayList of transaction.
     */
    public void addTransaction(Transaction tran) {
    	transactionList.add(tran);
    	Collections.sort(transactionList);
    }

}
