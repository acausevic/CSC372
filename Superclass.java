public class Superclass {
 private String firstName;
 private String lastName;
 private int accountID;
 private double balance;

 public Superclass() {
     this.balance = 0.0;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public void setAccountID(int accountID) {
     this.accountID = accountID;
 }

 public String getFirstName() {
     return firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public int getAccountID() {
     return accountID;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public void withdrawal(double amount) {
     balance -= amount;
 }

 public void accountSummary() {
     System.out.println("Account Holder: " + firstName + " " + lastName);
     System.out.println("Account ID: " + accountID);
     System.out.println("Balance: $" + balance);
 }
}
