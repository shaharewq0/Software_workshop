package Store;

import java.util.LinkedList;
import java.util.List;

public class Shopping_Cart {
    private List<Shopping_Basket> baskets;

    public Shopping_Cart() {
        this.baskets =  new LinkedList<>();
    }

    public void add(Shopping_Basket basket){
        baskets.add(basket);
    }

    public List<Shopping_Basket> getBaskets() {
        return baskets;
    }

//    public List<Product>
}
