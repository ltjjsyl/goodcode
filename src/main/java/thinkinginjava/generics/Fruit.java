package thinkinginjava.generics;

public class Fruit {

    private  static int a;
    private String b = "dddd";

    static {
        System.out.println("super static init");
    }
    {
        System.out.println("super non-static init");
    }

    public Fruit(){
        System.out.println(b);
        System.out.println("super construct init");
    }
}
