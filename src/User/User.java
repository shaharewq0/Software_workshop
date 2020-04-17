package User;

import Store.Shopping_Basket;
import Store.Shopping_Cart;
import Store.Store;
import Store.Product;
import service.System;
import store_System.Guest;
import store_System.Member;
import store_System.Registered;
import store_System.System_Role;

import java.util.List;

public class User {
    private System_Role system_role;
    private Shopping_Cart cart;

    public User(){
        system_role=Guest.getInstace();
    }

    public boolean register(int ID, String password){
        if(system_role == Guest.getInstace()){
            boolean reg = System.getInstance().register(ID,password);
            if (reg){
                system_role = Registered.getInstace();
                return true;
            }
        }
        return false;
    }

    public boolean login(int ID, String password){
           if(system_role == Registered.getInstace()){
               boolean log = System.getInstance().login(ID,password);
               if(log){
                   system_role = Member.getInstace();
                   return true;
               }
           }
           return false;
    }

    public Store storeDetails(String name){
        return System.getInstance().getDetails(name);
    }

    public List<Product> getProductsFromStore(String name){
        return System.getInstance().getProductsFromStore(name);
    }

    public List<Product> searchProductByName(String name){
        return System.getInstance().searchProductsByName(name);
    }

    public List<Product> searchProductByCategory(String category){
        return System.getInstance().searchProductsByCategory(category);
    }

    public List<Product> searchProductByKeyword(String keyword){
        return System.getInstance().searchProductsByKeyWord(keyword);
    }

//    public List<Product> watchShoppingCart(){
//
//    }
}
