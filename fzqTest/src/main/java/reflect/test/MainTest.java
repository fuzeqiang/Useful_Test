package reflect.test;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/15 0015.
 */
public class MainTest {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Method[] methods1 = test1.getClass().getMethods();
        Method[] methods2 = test2.getClass().getMethods();
        for (Method method : methods1) {
            System.out.println(method.getName() + ":  " + method.hashCode());
        }
        for (Method method : methods2) {
            System.out.println(method.getName() + ":  " + method.hashCode());
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
