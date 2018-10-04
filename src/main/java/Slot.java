import java.util.ArrayList;

public class Slot {

    private String code;
    private ArrayList<Product> products;
    private double price;

    public Slot(String code, ArrayList<Product> products, double price) {
        this.code = code;
        this.products = products;
        this.price = price;

    }

    public String getCode() {
        return code;
    }

    public int stock() {
        return products.size();
    }

}
