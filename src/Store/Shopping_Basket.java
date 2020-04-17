package Store;

import java.util.LinkedList;
import java.util.List;

public class Shopping_Basket {
    private List<Product> products;

    public Shopping_Basket() {
        this.products = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product p){
        products.add(p);
    }
}
