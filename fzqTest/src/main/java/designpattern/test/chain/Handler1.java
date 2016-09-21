package designpattern.test.chain;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class Handler1 extends ChainHandler{
    @Override
    public void handle(String request) {
        System.out.println(request);
        if (request.contains(" ")) {
            request = request.replaceAll(" ", "");
        }

        ChainHandler handler = getHandler();
        if (null != handler) {
            handler.handle(request);
        }
    }
}
