import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
   
   private static int menu = 0;
   private static int subMenu = 0;
   private static ArrayList<Client> clientList = new ArrayList<>();
   
   public static void mainMenu(Scanner input) {
   do {
			System.out.println("Menu: \n" 
					+ " 1) Client Menu \n"
					+ " 2) Job Menu \n" 
					+ " 3) Print Invoice \n" 
					+ " 0) Exit\n");
			System.out.print("Menu Option: ");
			menu = input.nextInt();
         input.nextLine();
         
			System.out.println();
			switch (menu) {
			case 1:
				clientMenu(input);
				System.out.println();
				break;
			case 2:
				jobMenu(input);
            System.out.println();
			case 3:
				//printInvoice(input);
				System.out.println();
				break;
			case 4:
				System.out.println("Exit to main menu");
				break;
         case 0:
            System.out.println("Goodbye");
            break;
			default:
				System.out.printf("Invalid selection%n");
			}
		}while (menu != 0);
   }
   
   public static void clientMenu(Scanner input) {
      String fName, lName, address, city, state, zip, phone, selection;
      boolean seniorDiscount = false;
      do {
					System.out.println("Client Sub Menu: \n"
							+ "1) Create Client \n" 
							+ "2) Edit Client Info \n"
							+ "3) View Client Info \n" 
                     + "4) Main Menu\n"
							+ "0) Exit");
					System.out.println();
					System.out.printf("Sub Menu Option: ");
					subMenu = input.nextInt();
               input.nextLine();
               
					System.out.println();
					switch (subMenu) {
					case 1:
                  System.out.print("Clients full name: "); 
                  fName = input.nextLine();
                  System.out.print("Clients last name: "); 
                  lName = input.nextLine();
                  System.out.print("Clients address: ");
                  address = input.nextLine();
                  System.out.print("Clients city: ");
                  city = input.nextLine();
                  System.out.print("Clients state: ");
                  state = input.nextLine();
                  System.out.print("Clients Zip: ");
                  zip = input.nextLine();
                  System.out.print("Clients phone number: ");
                  phone = input.nextLine();
                  System.out.print("Does this client get a senior discoiunt?(y/n): ");
                  selection = input.next();
                  if(selection.equals("y"))
                     seniorDiscount = true;
                  
                  clientList.add(new Client(fName, lName, address, city, state, zip, phone, seniorDiscount));
                  
						System.out.println();
						break;
					case 2:
                  editClientMenu(input);
						System.out.println();
						break;
					case 3:
                  viewClientMenu(input);
						System.out.println();
						break;
					case 4:
						System.out.printf("%nMain Menu%n");
                  mainMenu(input);
						break;
               case 0:
                  System.out.println("Goodbye");
                  break;
					default:
						System.out.printf("Invalid selection%n");
					}
				} while(subMenu != 0);
   }
   
   public static void editClientMenu(Scanner input) {
      int clientIndex;
      do {
         System.out.println("What client would you like to edit?");
         for(int i = 0; i < clientList.size() ;i++) {
            System.out.printf("%d %s %s%n", i+1, clientList.get(i).getFName(), clientList.get(i).getLName());
         }
         System.out.println("0) Exit\n");
         System.out.print("Selection: ");
         subMenu = input.nextInt();
         input.nextLine();
         
         clientIndex = subMenu-1;
         
         editClientSubMenu(input, clientIndex);
         
         
      } while(subMenu != 0);
   }
   
   public static void editClientSubMenu(Scanner input, int clientIndex) {
      String selection;
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
         input.nextLine();
         
         switch(subMenu) {
            case 1:
               System.out.print("Enter New First Name: ");
               clientList.get(clientIndex).setFName(input.nextLine());
               break;
            case 2:
               System.out.print("Enter New Last Name: ");
               clientList.get(clientIndex).setLName(input.nextLine());
               break;
            case 3:
               System.out.print("Enter New Address: ");
               clientList.get(clientIndex).setAddress(input.nextLine());
               System.out.println();
               System.out.print("Enter New City: ");
               clientList.get(clientIndex).setCity(input.nextLine());
               System.out.println();
               System.out.print("Enter New State: ");
               clientList.get(clientIndex).setState(input.nextLine());
               System.out.println();
               System.out.print("Enter New Zip: ");
               clientList.get(clientIndex).setZip(input.nextLine());
               System.out.println();
               break;
            case 4:
               System.out.print("Enter New Phone Number: ");
               clientList.get(clientIndex).setPhone(input.next());
               break;
            case 5:
               System.out.print("Does This Client Recieve A Senior Discount?(y/n): ");
               selection = input.next();
               
              
               if(selection.equals("y"))
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
   
   public static void viewClientMenu(Scanner input) {
      int clientIndex;
      System.out.println("What client would you like to view?");
      for(int i = 0; i < clientList.size() ;i++) {
         System.out.printf("%d) %s %s%n", i+1, clientList.get(i).getFName(), clientList.get(i).getLName());
      }
      System.out.println("0) Return To Client Menu");
      subMenu = input.nextInt();
      input.nextLine();
         
      clientIndex = subMenu-1;
      System.out.println();
         
      if(subMenu != 0){
         printClientInfo(clientIndex);
         clientMenu(input);
      } else {
         clientMenu(input);
      }
   }
   
   public static void printClientInfo(int clientIndex) {
      System.out.println("Info for: " + clientList.get(clientIndex).getFName() + " " + 
            clientList.get(clientIndex).getLName() + "\n" + 
            "Address: " + clientList.get(clientIndex).getAddress() + "\n" + 
            "City: " + clientList.get(clientIndex).getCity() + "\n" + 
            "State: " + clientList.get(clientIndex).getState() + "\n" + 
            "Zip: " + clientList.get(clientIndex).getZip() + "\n" + 
            "Phone Number: " + clientList.get(clientIndex).getPhone() + "\n" + 
            "Senior Discount: " + clientList.get(clientIndex).getSeniorDiscount() + "\n");
   }
   
   public static void jobMenu(Scanner input) {
		while (subMenu != 4) {
			System.out
					.println("Job Sub Menu: \n" 
							+ "1) Create Job \n"
							+ "2) Edit Job Info \n" 
							+ "3) View Job Info \n"
							+ "4) Exit");
			System.out.println();
			System.out.printf("Sub Menu Option: ");
			subMenu = input.nextInt();
			input.nextLine();
			System.out.println();
			switch (subMenu) {
			case 1:
				createJobMenu(input, menu);
				System.out.println();
				break;
			case 2:
				editJobSubMenu(input, menu);
				break;
			case 3:
				//viewClientJobMenu(input, menu);
				break;
			case 4:
				System.out.printf("Exit to Job Menu:");
				jobMenu(input);
				break;
			default:
				System.out.printf("Invalid selection%n");
			}
		}
		System.out.println();

	}

	public static void createJobMenu(Scanner input, int clientIndex) {
		String title, date, hours, selection;
		double price = 0, pricePerHour = 0, totalHours = 0;
		boolean hourlyJob = false;
		
		do {
			System.out.println("For which client would you like to add a job?");
			for (int i = 0; i < clientList.size(); i++) {
				System.out.printf("%d %s %s%n", i + 1, clientList.get(i)
						.getFName(), clientList.get(i).getLName());
			}
			System.out.println("0) Return To Job Menu");
			subMenu = input.nextInt();
			input.nextLine();
			clientIndex = subMenu - 1;
			System.out.println();
			System.out.print("Enter a title for the Job: ");
			title = input.nextLine();
			System.out.print("Enter Job Date: ");
			date = input.nextLine();
			System.out.println("Enter Hours: ");
			hours = input.next();
			System.out.print("Is it an Hourly Job: (y/n)");
			selection = input.next();
			if (selection.equals("y")){
				hourlyJob = true;
				System.out.print("Enter Price Per Hour: ");
				pricePerHour = input.nextDouble();
				System.out.print("Entetr Total Hours");
				totalHours = input.nextDouble();
				clientList.get(clientIndex).addJob(date, title, pricePerHour, totalHours);
			}	
			else{
				System.out.print("Enter Price: ");
				price = input.nextDouble();
				clientList.get(clientIndex).addJob(date, title, price);
			}

		} while (subMenu != 0);
	}

	public static void editJobSubMenu(Scanner input, int clientIndex) {
		do {
			System.out.println("What job would you like to edit?");
			System.out.println("1) Title");
			System.out.println("2) Date");
			System.out.println("3) Price");
			System.out.println("4) Price Per Hour");
			System.out.println("5) Return to Client Menu");
			System.out.println("0) Exit");
			System.out.print("Sub Menu Option: ");

			subMenu = input.nextInt();
			input.nextLine();

			switch (subMenu) {
			case 1:
				System.out.print("Enter New Title: ");
				break;
			case 2:
				System.out.print("Enter New Last Name: ");
				clientList.get(clientIndex).setLName(input.next());
				break;
			case 3:
				System.out.print("Enter New Address: ");
				clientList.get(clientIndex).setAddress(input.nextLine());
				System.out.println();
				System.out.print("Enter New City: ");
				clientList.get(clientIndex).setCity(input.nextLine());
				System.out.println();
				System.out.print("Enter New State: ");
				clientList.get(clientIndex).setState(input.nextLine());
				System.out.println();
				System.out.print("Enter New Zip: ");
				clientList.get(clientIndex).setZip(input.nextLine());
				System.out.println();
				break;
			case 4:
				System.out.print("Enter New Phone Number: ");
				clientList.get(clientIndex).setPhone(input.next());
				break;
			case 5:
				System.out
						.print("Does This Client Recieve A Senior Discount?(y/n): ");
				if (input.next() == "y")
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

		} while (subMenu != 0);
		System.exit(0);
	}

	public static void viewClientJobMenu(Scanner input) {
		int clientIndex;
		do {
			System.out.println("For which client would you like to add a job?");
			for (int i = 0; i < clientList.size(); i++) {
				System.out.printf("%d %s %s%n", i + 1, clientList.get(i)
						.getFName(), clientList.get(i).getLName());
			}
			System.out.println("0) Return To Job Menu");
			subMenu = input.nextInt();
			input.nextLine();
			clientIndex = subMenu - 1;
			System.out.println();

			if (subMenu != 0) {
				//createJobMenu(clientIndex);
			} else {
				jobMenu(input);
			}

		} while (subMenu != 0);

		System.exit(0);
	}

}
