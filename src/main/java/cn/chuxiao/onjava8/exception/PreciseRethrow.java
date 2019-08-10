package cn.chuxiao.onjava8.exception;

class BaseException extends Exception {
}

class DerivedException extends BaseException {
}

class DerivedException1 extends BaseException {
}
public class PreciseRethrow {
    //要求捕获的BaseException必须是DerivedException，编译器会检查
    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }

    //这种方式是不允许的
//    void catcher1() throws DerivedException1{
//        try {
//            throw new DerivedException();
//        } catch (BaseException e) {
//            throw e;
//        }
//    }

    public static void main(String[] args) {
        try {
            new PreciseRethrow().catcher();
        } catch (DerivedException e) {
            e.printStackTrace();
        }
    }
}

