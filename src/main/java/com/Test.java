package com;

public class Test
{

    public String getDescription(Object obj){ return obj.toString(); }

    public static void main(String args[])
    {

        if ( ((Integer)22).equals((Integer)22 )){
            System.out.println("Yes");
        }

        System.out.println((Integer) 222  );
        System.out.println((Integer) 222  );

        double d = 0.1 * 111;
        double e = 0.3;

        if (d == e){
            System.out.println("true");
        }

        System.out.println(d);
        System.out.println(e);
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();

    }

}

class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
