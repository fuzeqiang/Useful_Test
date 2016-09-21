package designpattern.test.chain;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class Handler3 extends ChainHandler{
    @Override
    public void handle(String request) {
        System.out.println(request);
        if (request.contains("test")) {
            request = "test";
        }

        ChainHandler handler = getHandler();
        if (null != handler) {
            handler.handle(request);
        }
        System.out.println(request);
    }
}
