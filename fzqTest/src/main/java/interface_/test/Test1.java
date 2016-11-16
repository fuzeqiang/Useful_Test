package interface_.test;

/**
 * Created by fuzeqiang(100918) on 2016/11/3 0003.
 */
public class Test1 {
    public void finalize() {
        System.out.println(Thread.currentThread().getName() + ": test obj is release");
    }
}
