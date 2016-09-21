package designpattern.test.chain;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class Client {

    public static void main(String[] args) {
        ChainHandler handler1 = new Handler1();
        ChainHandler handler2 = new Handler2();
        ChainHandler handler3 = new Handler3();
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.handle("do a test");
    }

}
