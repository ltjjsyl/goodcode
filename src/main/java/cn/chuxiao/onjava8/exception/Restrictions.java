package cn.chuxiao.onjava8.exception;

import java.io.IOException;

public class Restrictions {

    public Restrictions() throws IOException {

    }
    public void test() throws IOException {

    }
}

class Restrictions1 extends Restrictions {

    //子类构造器异常能超过基类构造器中的异常，必须包含基类构造器的异常
    public Restrictions1() throws IOException{
        super();

    }

    //子类方法的异常不能超过基类方法中的异常
    @Override
    public void test() {

    }
}


class  ErrorCode extends Exception {

}