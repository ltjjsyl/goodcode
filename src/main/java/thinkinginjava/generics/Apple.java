import thinkinginjava.generics.Fruit;

public class Apple extends Fruit {
    private  static int a;
    private String b = "sub";

    static {
        System.out.println(" static init");
    }
    {
        System.out.println(" non-static init");
    }

    public Apple(){
        System.out.println(b);
        System.out.println(" construct init");
    }

}
