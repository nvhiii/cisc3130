package abccompany;

public class Payment extends abccompany.Transaction {
    private double amount; // # of payment transactions

    public Payment(int transnum, double amount) {
        super(transnum);
        this.amount = amount;
    }

    // getter
    public double getAmount() {
        return amount;
    }

    // overriding toString
    @Override
    public String toString() {
        return super.toString() + "\tPAYMENT\t$" + getAmount() +"\n";
    }

}