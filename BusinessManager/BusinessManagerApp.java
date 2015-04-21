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
   
      
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
      Menu.mainMenu(input);
		

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