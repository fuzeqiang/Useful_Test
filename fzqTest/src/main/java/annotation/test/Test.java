package annotation.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/15 0015.
 */
@MyAnnotation("fzq")
public class Test {
    public static void main(String[] args) {
//        Annotation[] annotations = Test.class.getAnnotations();
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation.annotationType());
//        }
        Test t1 = new Test();
        Test t2 = new Test();
        Method[] m1s = t1.getClass().getMethods();
        Method[] m2s = t2.getClass().getMethods();
        for (Method method : m1s) {
            System.out.println(method.getName() + ":" +method.hashCode());
        }
        for (Method method : m2s) {
            System.out.println(method.getName() + ":" + method.hashCode());
        }
    }

    public static void test1() {}

    public void test2(){}
}
