package Store;

import java.util.LinkedList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private int basePrice;
    List<String> keywords;
    private int amount;
    private int rating;

    public Product(String name, String category, int basePrice, List<String> keywords, int amount, int rating) {
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
        this.keywords = keywords;
        this.amount = amount;
        this.rating=rating;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public int getAmount() {
        return amount;
    }

    public void buy(){
        amount--;
    }
}
