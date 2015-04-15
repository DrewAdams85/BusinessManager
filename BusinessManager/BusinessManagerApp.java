/************************************
* Created by Kent Allen and Drew Adams
* 4/01/2015
************************************/
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class BusinessManagerApp {
   public static void main(String[] args) {
      DateFormat df = new SimpleDateFormat("MM/dd/yy");
      Date dateobj = new Date();
      
      //Test Code
      Client kentAllen = new Client("Kent", "Allen", "9261 S. Falcon Way, Sandy, UT, 84093", 
         "801-661-7945", true);
      kentAllen.addJob("4/14/2015", "Mowing", 25);
      kentAllen.addJob("4/17/2015", "Spring Cleanup", 25d, 5);
      Invoice.printInvoice(kentAllen, df.format(dateobj.getTime()));
      //End Test Code
      
   }
}
