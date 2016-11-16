package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by fuzeqiang(100918) on 2016/11/14 0014.
 */
public class Test {

    public static void main(String[] args) {
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(5);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0 ; i < 10; i++) {
            pool.execute(new Task());
//            pool.schedule(new ScheduleTask(), i, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }

    final static class ScheduleTask implements Runnable{
        public void run() {
            System.out.println("schedule task - " + Thread.currentThread().getName());
        }
    }

    final static class Task implements Runnable {

        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("normal task - " + Thread.currentThread().getName());
        }

    }
}
