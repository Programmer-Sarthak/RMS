package surplus;

public class MathLogic {
    private static int totalPrice = 0;
    private  int price = 0 ;
    private  String statement = "";
    private  int quantity = 0;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void totalBill(int price, int quantity) {
        int num = price * quantity;


        totalPrice += num;
    }

    public void totalBillStatement(String fname,int price, int quantity) {
        statement += "\n" + fname +  " Qty." + quantity + " Rs." + price;
    }
}
