package assignment2_jab422;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main class of the Hardware Store database manager. It provides a
 * console for a user to use the commands to run the program.
 *
 * @author Jacob Benavente
 * @version 1.0
 * @since 2/22/210
 */
public class MainApp {

    // This object will allow us to interact with the methods of the class HardwareStore
    public static HardwareStore hardwareStore;
	//HardwareStore hardwareStore = new HardwareStore();
    private static final Scanner CONSOLE_INPUT = new Scanner(System.in); // Used to read from System's standard input

    /**
     * Default constructor. Initializes a new object of type HardwareStore
     *
     * @throws IOException
     */
    public MainApp() throws IOException {
        hardwareStore = new HardwareStore();
    }

    /**
     * Shows all items in the inventory.
     */
    public void showAllItems() {
       hardwareStore.displayItems();
    }

    /**
     * This method will add items quantity with given number. If the item does
     * not exist, it will call another method to add it.
     *
     */
    public void addItemQuantity() {

    	System.out.println("Would you like to add a new item or update quantity of an item?\n"
    			+ "\t1.Add\n\t2.Update." );
    	String choice = CONSOLE_INPUT.nextLine();
    	switch(choice) {
    	case "1":
    		System.out.print("Would you like to add a new Hardware Item or a new Appliance?\n\t1. Hardware Item.\n\t2. Appliance\n");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int itemC = CONSOLE_INPUT.nextInt();
    		if(itemC == 1) {
    			System.out.println("Enter new Id Number. ");
    			String idNumber = CONSOLE_INPUT.next();
    			if (!idNumber.matches("[A-Za-z0-9]{5}")) {
    				System.out.println("Invalid ID Number: not proper format. "
    						+ "ID Number must be 5 alphanumeric characters.\n");
    				return;
    			}
    	        int itemIndex = hardwareStore.findItem(idNumber);
    	        if (itemIndex == -1) {
    	            System.out.println("Item does not exist. Creating item.\n");
    	            
    	        }
    	        else {
    	        	System.out.println("Item ID already exists.\n");
    	        	return;
    	        }
    			//Name
    			System.out.println("Enter name for the new item. ");
    			String holder = CONSOLE_INPUT.next();
        		String name1 = CONSOLE_INPUT.nextLine();
        		String name2 = holder + name1;
                //Quantity
    			System.out.println("\nPlease type the quantity of the item.");
    			while(!CONSOLE_INPUT.hasNextInt()) {
    				System.out.println("Please enter a valid input.");
    				CONSOLE_INPUT.next();
    			}
                int quantity = CONSOLE_INPUT.nextInt();
                while(quantity < 0) {
                	System.out.println("Please enter a positive number. ");
                	while(!CONSOLE_INPUT.hasNextInt()) {
                		System.out.println("Please enter a valid input. ");
                		CONSOLE_INPUT.next();
                	}
                	quantity = CONSOLE_INPUT.nextInt();
                }
                //Price
                System.out.println("\nPlease type the price of the item.");
                while(!CONSOLE_INPUT.hasNextFloat()) {
        			System.out.println("Please enter a valid input.");
        			CONSOLE_INPUT.next();
        		}
        		float priceHolder = CONSOLE_INPUT.nextFloat();
        		while(priceHolder < 0) {
        			System.out.print("Please enter a positive number. \n");
        			while(!CONSOLE_INPUT.hasNextFloat()) {
        				System.out.println("Please enter a valid input. ");
        				CONSOLE_INPUT.next();
        			}
        			priceHolder = CONSOLE_INPUT.nextFloat();
        		}
                String category = null;
                System.out.println("\nPlease select the category of item.");
                System.out.println("1: Door&Window\n2: Cabinet&Furniture\n3: Fasteners\n4: Structural\n5: Other");
    			while(!CONSOLE_INPUT.hasNextInt()) {
    				System.out.println("Please enter a valid input.");
    				CONSOLE_INPUT.next();
    			}
    			int selection = CONSOLE_INPUT.nextInt();
                switch (selection) {
                    case 1:
                        category = "Door&Window";
                        break;
                    case 2:
                        category = "Cabinet&Furniture";
                        break;
                    case 3:
                        category = "Fasteners";
                        break;
                    case 4:
                        category = "Structural";
                        break;
                    case 5:
                        category = "Other";
                        break;
                    default:
                        System.out.println("Invalid category number.");
                        return;
                }
                String typeI = "SmallHardwareItem";
                SmallHardwareItem small = new SmallHardwareItem(idNumber, name2, quantity, priceHolder, category, typeI);
                hardwareStore.addNewItem(small);
    		}
    		else if(itemC == 2) {
    			System.out.println("Enter new Id Number. ");
    			String idNumber = CONSOLE_INPUT.next();
    			if (!idNumber.matches("[A-Za-z0-9]{5}")) {
    				System.out.println("Invalid ID Number: not proper format. "
    						+ "ID Number must be 5 alphanumeric characters.\n");
            		return;
    			}
    	        int itemIndex = hardwareStore.findItem(idNumber);
    	        if (itemIndex == -1) {
    	            System.out.println("Item does not exist. Creating item.\n");
    	            
    	        }
    	        else {
    	        	System.out.println("Item ID already exists.\n");
    	        	return;
    	        }
    			//Name
    			System.out.println("Enter name for the new item. ");
    			String holder = CONSOLE_INPUT.next();
        		String name1 = CONSOLE_INPUT.nextLine();
        		String name2 = holder + name1;
                //Quantity
    			System.out.println("\nPlease type the quantity of the item.");
                //int quantity = CONSOLE_INPUT.nextInt();
    			//System.out.println("\nPlease type the quantity of the item.");
    			while(!CONSOLE_INPUT.hasNextInt()) {
    				System.out.println("Please enter a valid input.");
    				CONSOLE_INPUT.next();
    			}
                int quantity2 = CONSOLE_INPUT.nextInt();
                while(quantity2 < 0) {
                	System.out.println("Please enter a positive number. ");
                	while(!CONSOLE_INPUT.hasNextInt()) {
                		System.out.println("Please enter a valid input. ");
                		CONSOLE_INPUT.next();
                	}
                	quantity2 = CONSOLE_INPUT.nextInt();
                }
                //Price
                System.out.println("\nPlease type the price of the item.");
                while(!CONSOLE_INPUT.hasNextFloat()) {
        			System.out.println("Please enter a valid input.");
        			CONSOLE_INPUT.next();
        		}
        		float priceHolder2 = CONSOLE_INPUT.nextFloat();
        		while(priceHolder2 < 0) {
        			System.out.print("Please enter a positive number. \n");
        			while(!CONSOLE_INPUT.hasNextFloat()) {
        				System.out.println("Please enter a valid input. ");
        				CONSOLE_INPUT.next();
        			}
        			priceHolder2 = CONSOLE_INPUT.nextFloat();
        		}
                String type = null;
                System.out.println("\nPlease select the type of item.");
                System.out.println("1: Refrigerators\n2: Washers&Dryers\n3: Ranges&Ovens\n4: Small Appliances.");
    			while(!CONSOLE_INPUT.hasNextInt()) {
    				System.out.println("Please enter a valid input.");
    				CONSOLE_INPUT.next();
    			}
    			int selection = CONSOLE_INPUT.nextInt();
                switch (selection) {
                    case 1:
                        type = "Refrigerators";
                        break;
                    case 2:
                        type = "Washers&Dryers";
                        break;
                    case 3:
                        type = "Ranges&Ovens";
                        break;
                    case 4:
                        type = "Small Appliances";
                        break;
                    default:
                        System.out.println("Invalid category number.");
                        return;
                }
                System.out.println("Please enter brand. ");
                String holder1 = CONSOLE_INPUT.next();
        		String brand1 = CONSOLE_INPUT.nextLine();
        		String brand2 = holder1 + brand1;
                String typeN = type;
                String typeI = "Appliances";
                Appliances appl = new Appliances(idNumber, name2, quantity2, priceHolder2, typeN, brand2, typeI);
                hardwareStore.addNewItem(appl);
    		}
    		else System.out.print("Invalid option.\n");
    		break;
    	
    	case "2":
    		System.out.println("Please input the ID of item");
    		String idNumber = CONSOLE_INPUT.nextLine();
    		int itemIndex = hardwareStore.findItem(idNumber);
    	       if (itemIndex != -1) { // If item exists in the database
    	    	   System.out.println("Item found in database. Please enter quantity to add.");
    	    	   int quantity = CONSOLE_INPUT.nextInt();
    	    	   if (quantity <= 0) {
    	    		   System.out.println("Invalid quantity. "
    	    				   + "The addition amount must be larger than 0.\n");
    	    		   return;
    	    	   }
    	    	   hardwareStore.addQuantity(itemIndex, quantity); 
    	       }
    	       else {
    	    	   System.out.println("Item ID does not exist.\n");
    	       }
    	}

    }

    /**
     * This method will remove the given quantity of an item with given number.
     * If the item does not exist, it will show an appropriate message.
     */
    public void removeItemQuantity() {

        System.out.println("Please input the ID of item");
        String idNumber = CONSOLE_INPUT.nextLine();
        if (!idNumber.matches("[A-Za-z0-9]{5}")) {
            System.out.println("Invalid ID Number: not proper format. "
                    + "ID Number must be at least 5 alphanumeric characters.");
            return;
        }

        int itemIndex = hardwareStore.findItem(idNumber);
        if (itemIndex == -1) {
            System.out.println("Item does not exist.\n");
            return;
        } else {
            hardwareStore.removeItem(itemIndex);
        }
    }

    /**
     * This method can search item by a given name (part of name.
     * Case-insensitive.) Will display all items with the given name.
     */
    public void searchItemByName() {

        System.out.println("Please input the name of item.\n");
        String name = CONSOLE_INPUT.nextLine();
        hardwareStore.getMatchingItemsByName(name);
    }

    /**
     * This method displays all users in the arrayList of user.
     */
    public void showAllUser() {
    	hardwareStore.displayUsers();
    }
    
    /**
     * This method will add a user to the arrayList of users.
     */
    public void addUser() {
    	System.out.println("Would you like to add a new Employee or Customer ?\n\t1.Employee\n\t2.Customer\n" );
    	String choice = CONSOLE_INPUT.nextLine();
    	switch(choice) {
    	case "1":
    		System.out.println("Please enter the new Employee's ID Number. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int employeeID = CONSOLE_INPUT.nextInt();
	        int userIndex = hardwareStore.findUser(employeeID);
	        if (userIndex == -1) {
	            System.out.println("User does not exist. Creating item.\n");
	            
	        }
	        else {
	        	System.out.println("User ID already exists.\n");
	        	return;
	        }
    		System.out.println("Please enter the new Employee's first name. ");
    		String fName = CONSOLE_INPUT.next();
    		System.out.println("Please enter the new Employee's last name. ");
    		String lName = CONSOLE_INPUT.next();
    		System.out.println("Please enter the new Employee's Social Security Number. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int ssn = CONSOLE_INPUT.nextInt();
    		int length = (int) Math.log10(ssn) + 1;
    		if(length != 9) {
    			System.out.println("Not a valid SSN.");
    			return;
    		}
    		System.out.println("Please enter the New Employee's Monthly Salary. ");
    		while(!CONSOLE_INPUT.hasNextFloat()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		float priceHolder3 = CONSOLE_INPUT.nextFloat();
    		while(priceHolder3 < 0) {
    			System.out.print("Please enter a positive number. \n");
    			while(!CONSOLE_INPUT.hasNextFloat()) {
    				System.out.println("Please enter a valid input. ");
    				CONSOLE_INPUT.next();
    			}
    			priceHolder3 = CONSOLE_INPUT.nextFloat();
    		}
    		String userT1 = "Employee";
    		Employee em = new Employee(employeeID, fName, lName, ssn, priceHolder3, userT1);
    		hardwareStore.addNewUser(em);
    		break;
    	case "2":
    		System.out.println("Please enter the new Customer's ID Number. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int customerID = CONSOLE_INPUT.nextInt();
	        int userIndex2 = hardwareStore.findUser(customerID);
	        if (userIndex2 == -1) {
	            System.out.println("User does not exist. Creating item.\n");
	            
	        }
	        else {
	        	System.out.println("User ID already exists.\n");
	        	return;
	        }
    		System.out.println("Please enter the new Customer's first name. ");
    		String fNameC = CONSOLE_INPUT.next();
    		System.out.println("Please enter the new Customer's last name. ");
    		String lNameC = CONSOLE_INPUT.next();
    		System.out.println("Please enter the new Customer's phone number. ");
    		String pNumber = CONSOLE_INPUT.next();
    		if(pNumber.length() != 10 || pNumber.contains("[A-Za-Z]")){
    			System.out.println("Not a valid Phone Number.\n");
    			return;
    		}
    		System.out.println("Please enter the new Customer's address. ");
    		String holder = CONSOLE_INPUT.next();
    		String addy1 = CONSOLE_INPUT.nextLine();
    		String addy2 = holder + addy1;
    		String userT = "Customer";
    		Customer cust = new Customer(customerID, fNameC, lNameC, pNumber, addy2, userT);
    		hardwareStore.addNewUser(cust);
    		break;
    	default:
    		System.out.println("Invalid choice.\n");
    		break;
    	}
    }
    
    /**
     * This method will update an entry in the arrayList of users.
     */
    public void updateUserInfo() {
    	
    	System.out.println("Would you like to update a Customer's informaton or an Employee?\n\t1. Customer\n\t2. Employee ");
    	String decision = CONSOLE_INPUT.nextLine();
    	switch(decision) {
    	case "1":
    		System.out.println("Please enter their ID Number. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int idNumber = CONSOLE_INPUT.nextInt();
    		int userIndex = hardwareStore.findUser(idNumber);
    	       if (userIndex != -1) { // If item exists in the database
    	    	   System.out.println("Item found in database.");
    	    	   System.out.println("Please enter new ID Number. ");
    	    		while(!CONSOLE_INPUT.hasNextInt()) {
    	    			System.out.println("Please enter a valid input.");
    	    			CONSOLE_INPUT.next();
    	    		}
    	    	   int nIdNumber = CONSOLE_INPUT.nextInt();
    	    	   System.out.println("Please enter new first name. ");
    	    	   String nFname = CONSOLE_INPUT.next();
    	    	   System.out.println("Please enter new last name. ");
    	    	   String nLname = CONSOLE_INPUT.next();
    	    	   System.out.println("Please enter new phone number. ");
    	    	   String nPnumber = CONSOLE_INPUT.next();
    	    	   if(nPnumber.length() != 10 || nPnumber.contains("[A-Za-Z]")){
    	    		   System.out.println("Not a valid Phone Number.\n");
    	    		   return;
    	    	   }
    	    	   System.out.println("Please enter new address. ");
    	    	   String holder = CONSOLE_INPUT.next();
    	    	   String addy1 = CONSOLE_INPUT.nextLine();
    	    	   String nAddress = holder + addy1;
    	    	   hardwareStore.updateUserCustomer(userIndex, nIdNumber, nFname, nLname, nPnumber, nAddress);
    	       }
    	       else {
    	    	   System.out.print("Customer does not exist\n");
    	       }
    	       break;
    	case "2":
    		System.out.println("Please enter their ID Number. ");
    		int idNumberE = CONSOLE_INPUT.nextInt();
    		int userIndexE = hardwareStore.findUser(idNumberE);
    	       if (userIndexE != -1) { // If item exists in the database
    	    	   System.out.println("Item found in database.");
    	    	   System.out.println("Please enter new ID Number. ");
    	    	   while(!CONSOLE_INPUT.hasNextInt()) {
    	    		   System.out.println("Please enter a valid input.");
    	    		   CONSOLE_INPUT.next();
    	    	   }
    	    	   int nIdNumber = CONSOLE_INPUT.nextInt();
    	    	   System.out.println("Please enter new first name. ");
    	    	   String nFname = CONSOLE_INPUT.next();
    	    	   System.out.println("Please enter new last name. ");
    	    	   String nLname = CONSOLE_INPUT.next();
    	    	   System.out.println("Please enter Social Security Number. ");
    	    	   while(!CONSOLE_INPUT.hasNextInt()) {
    	    		   System.out.println("Please enter a valid input.");
    	    		   CONSOLE_INPUT.next();
    	    	   }
    	    	   int nSsn = CONSOLE_INPUT.nextInt();
    	    	   int length = (int) Math.log10(nSsn) + 1;
    	    	   if(length != 9) {
    	    		   System.out.println("Not a valid SSN.");
    	    		   return;
    	    	   }
    	    	   System.out.println("Please enter new monthly salary. ");
    	    		while(!CONSOLE_INPUT.hasNextFloat()) {
    	    			System.out.println("Please enter a valid input.");
    	    			CONSOLE_INPUT.next();
    	    		}
    	    		float priceHolder3 = CONSOLE_INPUT.nextFloat();
    	    		while(priceHolder3 < 0) {
    	    			System.out.print("Please enter a positive number. \n");
    	    			while(!CONSOLE_INPUT.hasNextFloat()) {
    	    				System.out.println("Please enter a valid input. ");
    	    				CONSOLE_INPUT.next();
    	    			}
    	    			priceHolder3 = CONSOLE_INPUT.nextFloat();
    	    		}
    	    	   hardwareStore.updateUserEmployee(userIndexE, nIdNumber, nFname, nLname, nSsn, priceHolder3);
    	       }
    	       else {
    	    	   System.out.print("Employee does not exist\n");
    	       }
    		break;
    	default:
    		System.out.println("Invalid choice.\n");
    		return;
    	}
    	
    }
    
    /**
     * This method will complete a transaction for the arrayList of transactions.
     */
    public void completeTransaction() {
    	if((hardwareStore.containsEmployees() && hardwareStore.containsCustomer() && hardwareStore.containsItems())) {
    		hardwareStore.displayItems();
    		System.out.println("\n\n");
    		hardwareStore.displayUsers();
    		int quantity;
    		boolean subQuan = false;
    		System.out.println("\nPlease enter item ID for sold item.");
    		String sItem = CONSOLE_INPUT.next();
    		int itemIndex = hardwareStore.findItem(sItem);
    		if (itemIndex != -1) { // If item exists in the database
   	    	   System.out.println("Item found in database. Please enter quantity that has sold. ");
       			while(!CONSOLE_INPUT.hasNextInt()) {
       				System.out.println("Please enter a valid input.");
       				CONSOLE_INPUT.next();
       			}
       			int quan = CONSOLE_INPUT.nextInt();
       			quantity = quan;
       			if (quan <= 0) {
    	   		   System.out.println("Invalid quantity. "
    	   				   + "The addition amount must be larger than 0.\n");
    	   		   return;
       			}
       			if(quantity > hardwareStore.getItem(itemIndex).getQuantity()) {
       				System.out.println("Too large to input. Pick a size smaller than what is in inventory\n");
       				return;
       			}
       			else {
       				subQuan = true;
       			}
       			 
   	       	}
    		else {
    		   System.out.println("Item ID does not exist. ");
    		   return;
    		}
    		System.out.println("Please enter customer id. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int customerID = CONSOLE_INPUT.nextInt();
	        int userIndex2 = hardwareStore.findUser(customerID);
	        if (userIndex2 == -1) {
	            System.out.println("User does not exist.\n");
	            return;
	        }
    		System.out.println("Please enter employee id. ");
    		while(!CONSOLE_INPUT.hasNextInt()) {
    			System.out.println("Please enter a valid input.");
    			CONSOLE_INPUT.next();
    		}
    		int employeeID = CONSOLE_INPUT.nextInt();
	        int userIndex = hardwareStore.findUser(employeeID);
	        if (userIndex == -1) {
	            System.out.println("User does not exist.\n");
	            return;
	        }
	        if(subQuan == true) {
	        	hardwareStore.removeQuantity(itemIndex, quantity);
	        }
    		Transaction trans = new Transaction(sItem, null, quantity, customerID, employeeID);
    		hardwareStore.addTransaction(trans);	
    		
    	}
    	else {
    		System.out.print("Not enough data to complete transaction.");
    	}
    }
    
    /**
     * This method will display all transactions in the arrayList of transactions.
     */
    public void showAllTransactions() {
    	hardwareStore.displayTransactions();
    }
    
    /**
     * This method will begin the user interface console. Main uses a loop to
     * continue executing commands until the user types '6'.
     *
     * @param args this program expects no command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws IOException {

        MainApp app = new MainApp();

        String welcomeMessage = "\nWelcome to the Hardware Store database. Choose one of the following functions:\n\n"
                + "\t1. Show all existing items records in the databse (sorted by ID number).\n"
                + "\t2. Add a new item (or quantity) to the database.\n"
                + "\t3. Delete an item from a database.\n"
                + "\t4. Search for an item (given its name or part of its name).\n"
                + "\t5. Show a list of all users in the database.\n"
                + "\t6. Add new user to the database.\n"
                + "\t7. Update user info (given their id).\n"
                + "\t8. Complete a sale transaction.\n"
                + "\t9. Show completed sale transactions.\n"
                + "\t10. Exit program.\n";

        System.out.println(welcomeMessage);
        boolean flag = true;
        String selection = CONSOLE_INPUT.next();
        CONSOLE_INPUT.nextLine();

        while (flag) {

            switch (selection) {
                case "1":
                    app.showAllItems();
                    break;
                case "2":
                    app.addItemQuantity();
                    break;
                case "3":
                    app.removeItemQuantity();
                    break;
                case "4":
                    app.searchItemByName();
                    break;
                case "5":
                	app.showAllUser();
                	break;
                case "6":
                	app.addUser();
                	break;
                case "7":
                	app.updateUserInfo();
                	break;
                case "8":
                	app.completeTransaction();
                	break;
                case "9":
                	app.showAllTransactions();
                	break;
                case "10":
                	System.out.print("Saving database...");
                	hardwareStore.serializeList();
                	System.out.println("Done!");
                	flag = false;
                	return;
                case "h":
                    System.out.println(welcomeMessage);
                    break;
                default:
                    System.out.println("That is not a recognized command. Please enter another command or 'h' to list the commands.");
                    break;

            }

            System.out.println("Please enter another command or 'h' to list the commands.\n");
            selection = CONSOLE_INPUT.next();

            CONSOLE_INPUT.nextLine();
        }

        CONSOLE_INPUT.close();
    }
    
}