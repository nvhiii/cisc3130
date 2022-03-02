package abccompany;

import java.util.ArrayList;

public class Customer {
    // properties of customer
    private String cname;
    private int cnum;
    private double balancedue;
    private ArrayList<abccompany.Transaction> transactions; // stores all the transactions

    //constructor used while comparisons
    public Customer(int cnum){
        this.cnum = cnum;
    }

    // constructor
    public Customer(String cname, int cnum, double balancedue) {
        super();
        this.cname = cname;
        this.cnum = cnum;
        this.balancedue = balancedue;
        this.transactions = new ArrayList<>();
    }

    //adding each transaction into arraylist
    public void addTranscation(abccompany.Transaction trans) {
        transactions.add(trans);
    }

    //updating balance due with all transactions
    public void updateBalanceDue(){
        for(abccompany.Transaction trans:transactions){
            if (trans instanceof abccompany.Order) { //checking if this is order
                abccompany.Order order = (abccompany.Order) trans;
                balancedue = balancedue + order.getTotalcost(); //adding due
            } else if (trans instanceof abccompany.Payment) { //checking if this is payment
                abccompany.Payment payment = (abccompany.Payment) trans;
                balancedue = balancedue - payment.getAmount(); //deducing due
            }
        }
    }



    //Overriding equal method
    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Customer){
            Customer cust = (Customer) obj;
            return getCnum()== cust.getCnum();
        }
        return false;
    }

    //getters for each property of customer
    public String getCname() {
        return cname;
    }

    public int getCnum() {
        return cnum;
    }

    public double getBalancedue() {
        return balancedue;
    }

    public ArrayList<abccompany.Transaction> getTransactions() {
        return transactions;
    }

    //Overriding toString
    @Override
    public String toString() {
        return "Customer [cname=" + cname + ", cnum=" + cnum + ", balancedue=" + balancedue + "]";
    }

    // balance sheet printing method
    public String Print() {
        String output = "";
        output = output + getCname()+"\t"+getCnum()+"\n\n\t\t\t"+"PREVIOUS BALANCE \t$"+getBalancedue()+"\n\n";

        for(abccompany.Transaction trans:transactions){
            output = output+trans.toString();
        }
        output = output + "\n\n\t\t\t"+"BALANCE DUE\t$"+getBalancedue()+"\n";
        return output;
    }



}