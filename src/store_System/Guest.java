package store_System;

public class Guest implements System_Role {
    private static Guest instance=null;
    private Guest(){
        instance=new Guest();
    }

    public static Guest getInstace(){
        if(instance == null){
            instance=new Guest();
        }
        return instance;
    }

}
