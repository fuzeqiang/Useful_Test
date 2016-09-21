package designpattern.test.chain;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public abstract class ChainHandler {

    protected ChainHandler handler;

    public abstract void handle(String request);

    public ChainHandler getHandler() {
        return handler;
    }

    public void setHandler(ChainHandler handler) {
        this.handler = handler;
    }

}
