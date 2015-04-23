/************************************
 * Created by Kent Allen and Drew Adams
 * 4/01/2015
 ************************************/
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class BusinessManagerApp {
   
      
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
      loadClientData()
      
      Menu.mainMenu(input, clientList);
	}
   
   public static ArrayList<Client> loadClientData() {
      String fileName = "/ClientDatabase.txt";
		String fName, lName, address, city, state, zip, phone;
      boolean seniorDiscount;
      
      ArrayList<Client> clientList = new ArrayList<>();
      
      try {
         ReadFile file = new ReadFile(fileName);
         String[] clientData = file.openFile();
         
      } catch(IOException e) {
         System.out.println(e.getMessage());
      }
      
      for (int i = 0; i < clientData.length; i += 8) {
         fName = clientData[i];
         lName = clientData[i+1];
         address = clientData[i+2];
         city = clientData[i+3];
         state = clientData[i+4];
         zip = clientData[i+5];
         phone = clientData[i+6];
         
         if (clientData[i+7].equals("true"))
            seniorDiscount = true;
         else if (clientData[i+7].equals("false"))
            seniorDiscount = false;
            
         clientList.add(new Client(fName, lName, address, city, state, zip, phone, seniorDiscount));
      }
      
      
      
   }
   
}