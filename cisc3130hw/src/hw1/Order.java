package abccompany;

public class Order extends abccompany.Transaction {

    private String item;
    private int quantity;
    private double itemcost;


    public Order(int transnum, String item, int quantity, double itemcost) {
        super(transnum);
        this.item = item;
        this.quantity = quantity;
        this.itemcost = itemcost;
    }

    //getters and override(s)
    public double getItemcost() {
        return itemcost;
    }

    public double getTotalcost() {
        return itemcost*quantity;
    }

    public String getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }

    //overriding toString
    @Override
    public String toString() {
        return super.toString()+"\t"+getItem()+" ORDERED\t$"+getTotalcost()+"\n";
    }


}
