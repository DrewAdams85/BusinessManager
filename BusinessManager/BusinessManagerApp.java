/***************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 **************************************/
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class BusinessManagerApp {

	public static void main(String[] args) throws IOException {
		int menu;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome To Business Manager!\n\n"
				+ "This Program Allows You To:\n\n"
				+ "Create And Manage Clients\n" 
				+ "Log Jobs Done For Clients\n"
				+ "Print Formatted Invoices\n"
				+ "View And Edit Any Information\n\n");
      
      do {
		   System.out.print("Please Enter 1 To Start Business Manager: ");
         
		   menu = input.nextInt();
		   input.nextLine();
		   System.out.println();

		   switch (menu) {
            case 1:
			      Menu.mainMenu(input);
               break;
            default:
               System.out.println("Invalid Selection");
         }
      } while (menu != 0);

	}
}