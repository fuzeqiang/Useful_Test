package designpattern.test.watcher;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public interface Topic {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatcher();

}
