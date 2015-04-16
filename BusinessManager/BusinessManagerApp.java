/************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 ************************************/
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class BusinessManagerApp {
   private static int menu = 0;
   private static int subMenu = 0;
   private static ArrayList<Client> clientList = new ArrayList<>();
      
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		

		while (menu != 4) {
			System.out.println("Menu: \n" 
					+ " 1) Client Menu \n"
					+ " 2) Job Menu \n" 
					+ " 3) Invoice Menu \n" 
					+ " 4) Exit");
			System.out.println();
			System.out.printf("Menu Option: ");
			menu = input.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
				clientMenu(input);
				System.out.println();
				break;
			case 2:
				while (subMenu != 4) {
					System.out.println("Job Sub Menu: \n" 
							+ "1) Create Job \n"
							+ "2) Edit Job Info \n" 
							+ "3) View Job Info \n"
							+ "4) Exit");
					System.out.println();
					System.out.printf("Sub Menu Option: ");
					subMenu = input.nextInt();
					System.out.println();
					switch (subMenu) {
					case 1:
						System.out.println();
						break;
					case 2:
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					case 4:
						System.out.printf("%nExit to main menu%n");
						break;
					default:
						System.out.printf("Invalid selection%n");
					}
				}
				System.out.println();
				break;
			case 3:
				while (subMenu != 4) {
					System.out.println("Invoice Sub Menu: \n"
							+ "1) Create Invoice \n"
							+ "2) Edit Invoice Info \n"
							+ "3) View Invoice Info \n" 
							+ "4) Exit");
					System.out.println();
					System.out.printf("Sub Menu Option: ");
					subMenu = input.nextInt();
					System.out.println();
					switch (subMenu) {
					case 1:
						System.out.println();
						break;
					case 2:
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					case 4:
						System.out.printf("%nExit to main menu%n");
						break;
					default:
						System.out.printf("Invalid selection%n");
					}
				}
				System.out.println();
				break;
			case 4:
				System.out.println("Exit to main menu");
				break;

			default:
				System.out.printf("Invalid selection%n");
			}
		}

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();

		// Test Code
		Client kentAllen = new Client("Analynn", "Allen", "9261 S. Falcon Way",
				"Sandy", "UT", "84093", "801-661-7945", false);
		kentAllen.addJob("4/14/2015", "Mowing", 25);
		kentAllen.addJob("4/17/2015", "Spring Cleanup", 25d, 5);
		Invoice.printInvoice(kentAllen, df.format(dateobj.getTime()));
		// End Test Code blah

	}
   
   public static void clientMenu(Scanner input) {
      String fName, lName, address, city, state, zip, phone, selection;
      boolean seniorDiscount = false;
      while (subMenu != 4) {
					System.out.println("Client Sub Menu: \n"
							+ "1) Create Client \n" 
							+ "2) Edit Client Info \n"
							+ "3) View Client Info \n" 
							+ "4) Exit");
					System.out.println();
					System.out.printf("Sub Menu Option: ");
					subMenu = input.nextInt();
					System.out.println();
					switch (subMenu) {
					case 1:
                  System.out.print("Clients first name: "); 
                  fName = input.next();
                  System.out.print("Clients last name: "); 
                  lName = input.next();
                  System.out.print("Clients address: ");
                  address = input.next();
                  System.out.print("Clients city: ");
                  city = input.next();
                  System.out.print("Clients state: ");
                  state = input.next();
                  System.out.print("Clients Zip: ");
                  zip = input.next();
                  System.out.print("Clients phone number: ");
                  phone = input.next();
                  System.out.print("Does this client get a senior discoiunt?(y/n): ");
                  selection = input.next();
                  if(selection == "y")
                     seniorDiscount = true;
                  
                  clientList.add(new Client(fName, lName, address, city, state, zip, phone, seniorDiscount));
                  
						System.out.println();
						break;
					case 2:
                  editClientMenu(input);
						System.out.println();
						break;
					case 3:
						System.out.println();
						break;
					case 4:
						System.out.printf("%nMain Menu%n");
						break;
					default:
						System.out.printf("Invalid selection%n");
					}
				}
   }
   
   public static void editClientMenu(Scanner input) {
      int clientIndex;
      do {
         System.out.println("What client would you like to edit?");
         for(int i = 0; i < clientList.size() ;i++) {
            System.out.printf("%d %s %s%n", i+1, clientList.get(i).getFName(), clientList.get(i).getLName());
         }
         System.out.println("0) Exit");
         subMenu = input.nextInt();
         clientIndex = subMenu-1;
         
         editClientSubMenu(input, clientIndex);
         
         
      } while(subMenu != 0);
   }
   
   public static void editClientSubMenu(Scanner input, int clientIndex) {
      
      do {
         System.out.println("What would you like to edit?");
         System.out.println("1) First Name");
         System.out.println("2) Last Name");
         System.out.println("3) Address");
         System.out.println("4) Phone Number");
         System.out.println("5) Senior Discount");
         System.out.println("6) Return to Client Menu");
         System.out.println("0) Exit");
         System.out.print("Sub Menu Option: ");
         
         subMenu = input.nextInt();
         
         switch(subMenu) {
            case 1:
               System.out.print("Enter New First Name: ");
               clientList.get(clientIndex).setFName(input.next());
               break;
            case 2:
               System.out.print("Enter New Last Name: ");
               clientList.get(clientIndex).setLName(input.next());
               break;
            case 3:
               System.out.print("Enter New Address: ");
               clientList.get(clientIndex).setAddress(input.next());
               System.out.print("Enter New City: ");
               clientList.get(clientIndex).setCity(input.next());
               System.out.print("Enter New State: ");
               clientList.get(clientIndex).setState(input.next());
               System.out.print("Enter New Zip: ");
               clientList.get(clientIndex).setZip(input.next());
               break;
            case 4:
               System.out.print("Enter New Phone Number: ");
               clientList.get(clientIndex).setPhone(input.next());
               break;
            case 5:
               System.out.print("Does This Client Recieve A Senior Discount?(y/n): ");
               if(input.next() == "y")
                  clientList.get(clientIndex).setSeniorDiscount(true);
               else
                  clientList.get(clientIndex).setSeniorDiscount(false);
               break;
            case 6:
               clientMenu(input);
               break;
            case 0:
               System.out.println("Good Bye");
               break;
            default:
               System.out.println("Invalid Selection");      
         }
         
         
      } while(subMenu != 0);
      System.exit(0);
   }
}
