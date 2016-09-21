package designpattern.test.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzeqiang(100918) on 2016/8/25 0025.
 */
public class ConcreteTopic implements Topic{

    private List<Watcher> watchers = new ArrayList<Watcher>();

    public void addWatcher(Watcher watcher) {
        this.watchers.add(watcher);
    }

    public void removeWatcher(Watcher watcher) {
        this.watchers.remove(watcher);
    }

    public void notifyWatcher() {
        for (Watcher watcher : this.watchers) {
            watcher.update();
        }
    }
}
