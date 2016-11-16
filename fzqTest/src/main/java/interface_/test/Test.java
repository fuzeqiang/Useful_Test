package interface_.test;

import java.lang.reflect.Method;

/**
 * Created by fuzeqiang(100918) on 2016/11/2 0002.
 */
public class Test implements Interface{
    public static void main(String[] args) {
//        Interface inerface = new Interface() {
//        };
//        System.out.println(inerface.getClass().getSuperclass());
//        System.out.println(Test.class.getSuperclass());
//        System.out.println(Test.class.getInterfaces()[0].getName());
//        System.out.println(Interface.class);
//        System.out.println(boolean.class.getSuperclass());
//        System.out.println(Annotation.class.getInterfaces()[0].getName());
//        System.out.println(Abstract.class.getSuperclass());
//        System.out.println(Interface.class.getMethods().length);
//        for (Method method : Abstract.class.getMethods()) {
//            System.out.println(method.getName());
//        }
        test();
        System.gc();
    }

    public static void test() {
        Test1 test1 = new Test1();
        System.out.println(test1);
    }

}
