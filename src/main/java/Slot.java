import java.util.ArrayList;

public class Slot {

    private SlotCode code;
    private double price;
    private ArrayList<Product> products;

    public Slot(SlotCode code, double price) {
        this.code = code;
        this.price = price;
        products = new ArrayList<>();
    }

    public SlotCode getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfProducts(){
        return products.size();
    }

    public void addProduct(Product product){

        if (getNumberOfProducts() > 0){
            Product firstProduct = products.get(0);
            if (product.getClass() == firstProduct.getClass()){
                products.add(product);
            }
        }
        else {
            products.add(product);
        }
    }

    public Product returnProduct(){
        return products.remove(0);
    }

}
