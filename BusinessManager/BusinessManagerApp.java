/************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 ************************************/
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BusinessManagerApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int menu = 0;
		int subMenu = 0;

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
						System.out.println();
						break;
					case 2:
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
		// End Test Code

	}
}
