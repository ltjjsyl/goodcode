package cn.chuxiao.annotations.example3;

@Simple
public class SimpleTest {
    @Simple
    int i;

    @Simple
    public SimpleTest() {
    }

    @Simple
    public static void main(String[] args) {
        @Simple
        SimpleTest st = new SimpleTest();
        st.foo();
    }

    @Simple
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }

    @Simple
    public void bar(String s, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }
}