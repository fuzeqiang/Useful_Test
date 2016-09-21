package designpattern.test.adapter;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class Adapter extends Target{

    private Adaptee adaptee = new Adaptee();

    public void doService() {
        //get standard data
        adaptee.service();

        //exchange standard data to target
        //...

        super.doService();
    }

}
