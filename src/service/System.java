package service;

import Store.Store;
import Store.Product;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class System {
    List<Pair<Integer, String>> registered = new LinkedList<>();
    List<Pair<Integer, String>> logedin = new LinkedList<>();
    List<Store> stores = new LinkedList<>();
    private static System instance = null;

    private System() {
        instance = new System();
    }

    public static System getInstance() {
        if (instance == null) {
            instance = new System();
        }
        return instance;
    }

    public boolean register(int id, String password) {
        if (contains(id, registered) != null) {
            return false;
        }
        registered.add(new Pair<>(id, password));
        return true;
    }

    public boolean login(int id, String password) {
        if (contains(id, logedin) != null) {
            return false;
        }
        if (contains(id, registered) == null) {
            return false;
        }
        Pair<Integer, String> account = contains(id, registered);
        if (!account.getValue().equals(password)) {
            return false;
        }
        logedin.add(account);
        return true;
    }

    private Pair<Integer, String> contains(int id, List<Pair<Integer, String>> toSearch) {
        for (Pair<Integer, String> existing : toSearch) {
            if (existing.getKey() == id) {
                return existing;
            }
        }
        return null;
    }

    public Store getDetails(String name) {
        for (Store s : stores) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public List<Product> getProductsFromStore(String name) {
        for (Store s : stores) {
            if (s.getName().equals(name)) {
                return s.getProducts();
            }
        }
        return null;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> toReturn = new LinkedList<Product>();
        for (Store s : stores) {
            List<Product> add = s.findProductByName(name);
            concat(toReturn,add);
        }
        return toReturn;
    }

    public List<Product> searchProductsByCategory(String category) {
        List<Product> toReturn = new LinkedList<Product>();
        for (Store s : stores) {
            List<Product> add = s.findProductByCategory(category);
            concat(toReturn,add);
        }
        return toReturn;
    }

    public List<Product> searchProductsByKeyWord(String Keyword) {
        List<Product> toReturn = new LinkedList<Product>();
        for (Store s : stores) {
            List<Product> add = s.findProductByKeyWord(Keyword);
            concat(toReturn,add);
        }
        return toReturn;
    }

    private void concat(List<Product> a, List<Product> b){
        for (Product p: b) {
            if(!a.contains(p)){
                a.add(p);
            }
        }
    }

    public List<Product> filterByPrice (List<Product> base , int min, int max){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p: base) {
            if(p.getBasePrice()>= min & p.getBasePrice()<=max){
                toReturn.add(p);
            }
        }
        return toReturn;
    }

    public List<Product> filterByRating (List<Product> base , int min, int max){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p: base) {
            if(p.getRating()>= min & p.getRating()<=max){
                toReturn.add(p);
            }
        }
        return toReturn;
    }

    public List<Product> filterByCategory (List<Product> base , String category){
        List<Product> toReturn = new LinkedList<Product>();
        for (Product p: base) {
            if(p.getCategory().equals(category)){
                toReturn.add(p);
            }
        }
        return toReturn;
    }
}
