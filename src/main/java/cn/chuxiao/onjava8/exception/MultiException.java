package cn.chuxiao.onjava8.exception;

public class MultiException {
    public static void main(String[] args) {
        try(
                Closer1 c1 = new Closer1();
                Closer2 c2 = new Closer2();
        ) {
            System.out.println("In body");
        } catch(CloseException1 e) {
            System.out.println("Caught1: " + e);
        }catch (CloseException2 e) {
            //关闭是同时抛出多个异常，只会抛出第一个，其他的可通过e.getSuppressed()获得
            System.out.println("Caught2: " + e);
            Throwable[] s = e.getSuppressed();
            for(Throwable t : s){
                System.out.println(t);
            }
        }
    }
}


class CloseException1 extends Exception {
    @Override
    public String toString() {
        return "CloseException1";
    }
}
class CloseException2 extends Exception {
    @Override
    public String toString() {
        return "CloseException2";
    }
}

class Closer1 implements AutoCloseable {
    String name = getClass().getSimpleName();
    Closer1() {
        System.out.println("Creating1 " + name);
    }
    @Override
    public void close() throws CloseException1 {
        System.out.println("Closing1 " + name);
        throw new CloseException1();
    }
}

class Closer2 implements AutoCloseable {
    String name = getClass().getSimpleName();
    Closer2() {
        System.out.println("Creating2 " + name);

    }
    @Override
    public void close() throws CloseException2 {
        System.out.println("Closing2 " + name);
        throw new CloseException2();
    }
}


