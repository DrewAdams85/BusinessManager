import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
   private static ArrayList<Client> clientList = new ArrayList<>();
   private static String[] clientData;
   
   public static ArrayList<Client> loadClientData() {
      String fileName = "/Users/Kent/Documents/GIT/BusinessManager/BusinessManager/ClientDatabase.txt";
		String fName, lName, address, city, state, zip, phone;
      boolean seniorDiscount = false;
      
      try {
         ReadFile file = new ReadFile(fileName);
         clientData = file.openFile();
         
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
      
      return clientList;
      
   }

}