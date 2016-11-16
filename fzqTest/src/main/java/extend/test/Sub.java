package extend.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fuzeqiang(100918) on 2016/11/2 0002.
 */
public class Sub extends Super{
    public static void main(String[] args) {
        Method[] methods1 = Super.class.getMethods();
        Method[] methods2 = Sub.class.getMethods();
        Method m = null;
        for (Method method : methods1) {
            if ("test".equals(method.getName())) {
                System.out.println(method.hashCode());
                m = method;
                break;
            }
        }
        for (Method method : methods2) {
            if ("test".equals(method.getName())) {
                System.out.println(method.hashCode());
                System.out.println(m.equals(method));
                System.out.println(m == method);
                try {
                    method.invoke(new Sub(), null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
