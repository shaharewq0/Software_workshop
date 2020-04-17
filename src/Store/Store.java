package Store;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private String name;
    private List<Product> products;

    public Store(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean addProduct(Product p){
        if(products.contains(p)){
            return false;
        }
        products.add(p);
        return true;
    }

    public List<Product> findProductByName(String name){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p:products) {
            if(p.getName().equals(name)){
                toReturn.add(p);
            }
        }
        return toReturn;
    }

    public List<Product> findProductByCategory(String category){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p:products) {
            if(p.getCategory().equals(category)){
                toReturn.add(p);
            }
        }
        return toReturn;
    }

    public List<Product> findProductByKeyWord(String KeyWord){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p:products) {
            if(p.getKeywords().contains(KeyWord)){
                toReturn.add(p);
            }
        }
        return toReturn;
    }
}
