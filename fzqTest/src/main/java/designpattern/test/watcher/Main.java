package designpattern.test.watcher;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class Main {
    public static void main(String[] args) {
        ConcreteTopic topic = new ConcreteTopic();
        Watcher watcher1 = new Watcher1();
        Watcher watcher2= new Watcher2();
        topic.addWatcher(watcher1);
        topic.addWatcher(watcher2);

        topic.notifyWatcher();
    }

}
