package string.test;

/**
 * Created by fuzeqiang(100918) on 2016/8/3 0003.
 */
public class SubStringTest {

    public static void main(String[] args) {
        String limit = "( 0 , 20 )";
        int start = Integer.valueOf(limit.substring(limit.indexOf("(") + 1, limit.indexOf(",")).trim());
        int size = Integer.valueOf(limit.substring(limit.indexOf(",") + 1, limit.indexOf(")")).trim());
        System.out.println("start: " + start + ", size: " + size);
    }
}
