/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date dateobj = new Date();
	private static int menu = 0;
   private static ArrayList<Client> clientList = LoadData.loadClientData();

	public static void mainMenu(Scanner input) {
		do {
			System.out
					.println("Main Menu: \n" 
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
				ClientMenu.clientMenu(input, clientList);
				System.out.println();
				break;
			case 2:
				JobMenu.jobMenu(input, clientList);
				System.out.println();
				break;
			case 3:
				printInvoice(input);
				System.out.println();
				break;
			case 4:
				System.out.println("Exit to main menu");
				break;
			case 0:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid selection");
			}
		} while (menu != 0);

		System.exit(0);
	}

	public static void printInvoice(Scanner input) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		int clientIndex;

		System.out.println("Print Invoice For Client: ");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.printf("%d) %s %s%n", i + 1, clientList.get(i)
					.getFName(), clientList.get(i).getLName());
		}
		System.out.println("0) Main Menu\n");
		System.out.print("Menu Option: ");
		menu = input.nextInt();
		clientIndex = menu - 1;
		input.nextLine();
		System.out.println();

		if (menu == 0) {
			mainMenu(input);
		}

		Invoice.printInvoice(clientList.get(clientIndex),
				df.format(dateobj.getTime()));
	}
}
