public class Test {
    public static void main(String[] args) {
        Superclass bankAccount = new Superclass();
        bankAccount.setFirstName("John");
        bankAccount.setLastName("Doe");
        bankAccount.setAccountID(123456);
        bankAccount.deposit(1000);
        bankAccount.withdrawal(500);
        bankAccount.accountSummary();

        System.out.println("-------------------------");

        Checking checkingAccount = new Checking();
        checkingAccount.setFirstName("Jane");
        checkingAccount.setLastName("Smith");
        checkingAccount.setAccountID(987654);
        checkingAccount.deposit(2000);
        checkingAccount.withdrawal(2500); // This will trigger overdraft
        checkingAccount.displayAccount();
    }
}
