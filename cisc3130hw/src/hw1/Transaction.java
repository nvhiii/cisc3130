package abccompany;
public class Transaction {
    int transactionnumber;

    public Transaction(int transactionnumber) {
        super();
        this.transactionnumber = transactionnumber;
    }

    //getter
    public int getTransactionnumber() {
        return transactionnumber;
    }

    //toString method
    @Override
    public String toString() {
        return "TRANSACTION "+getTransactionnumber();
    }
}
