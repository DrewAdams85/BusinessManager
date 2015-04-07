public class Client {
   private String fName, lName, address, phone;
   
   public Client(String fName, String lName, String address, String phone) {
      this.fName = fName;
      this.lName = lName;
      this.address = address;
      this.phone = phone;
   }
   
   public String getFName() {
      return fName;
   }
   
   public void setFName(String fName) {
      this.fName = fName;
   }
   
   public String getLName() {
      return lName;
   }
   
   public void setLName(String LName) {
      this.lName = lName;
   }
   
   public String address() {
      return address;
   }
   
   public void address(String address) {
      this.address = address;
   }
   
   public String phone() {
      return phone;
   }
   
   public void phone(String phone) {
      this.phone = phone;
   }
   
}