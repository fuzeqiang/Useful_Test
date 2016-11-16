package number.test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fuzeqiang(100918) on 2016/11/15 0015.
 */
public class NumberTest {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(COUNT_BITS) + "   count_bit");
        System.out.println(Integer.toBinaryString(CAPACITY) + "   capacity");
        System.out.println(Integer.toBinaryString(RUNNING) + "   running");
        System.out.println(Integer.toBinaryString(SHUTDOWN) + "   shutdown");
        System.out.println(Integer.toBinaryString(STOP) + "   stop");
        System.out.println(Integer.toBinaryString(TIDYING) + "   tidying");
        System.out.println( Integer.toBinaryString(TERMINATED) + "   terminated");
    }

}
