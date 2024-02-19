public class Checking extends Superclass {
    private double interestRate;

    public Checking() {
        super();
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() - amount < 0) {
            super.withdrawal(amount + 30);
            System.out.println("Overdraft fee of $30 charged.");
        } else {
            super.withdrawal(amount);
        }
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
}
