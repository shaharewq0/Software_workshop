package store_System;

public class Member implements System_Role {
    private static Member instance=null;
    private Member(){
        instance=new Member();
    }

    public static Member getInstace(){
        if(instance == null){
            instance=new Member();
        }
        return instance;
    }
}
