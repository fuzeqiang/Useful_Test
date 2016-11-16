package thread.test;

/**
 * Created by fuzeqiang(100918) on 2016/10/24 0024.
 */
public class Test extends Thread{
    public void run() {
        System.out.println("Thread");
        int sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            if (0 == i % 1000){
                System.out.println(i);
            }
            sum = sum + i;
        }
        System.out.println(System.currentTimeMillis() - start);
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        test.interrupt();
//        System.out.println("1");
//        test.start();
//        System.out.println("2");
        int x[] = new int[]{};
//        int x[3] = {1, 2, 3};
    }
}
