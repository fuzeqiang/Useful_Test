package classtest.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fuzeqiang(100918) on 2016/8/1 0001.
 * destination class:
 * public class Hello {
 *     public String hello$Impl() {
 *         return "hello";
 *     }
 *
 *     public String hello () {
 *         long start = System.currentTimeMillis();
 *         String re = hello$Impl();
 *         System.out.println("cost time: " + (System.currentTimeMillis() - start));
 *         return re;
 *     }
 * }
 *
 */
public class ChangeHello {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        for (int n = 0; n < 20; n++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                changeMethod2();
            }
            System.out.print((System.currentTimeMillis() - start) + ",");
        }
    }

    public static ClassPool pool = ClassPool.getDefault();
    public static void changeMethod2() throws NotFoundException, CannotCompileException, IOException {
        CtClass ctClass = pool.get("classtest.javassist.HelloWorld");
        ctClass.defrost();
        //修改hello方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("sayHello");
        StringBuilder methodBody = new StringBuilder();
        methodBody.append("{")
                .append("System.out.println(\"HelloWorld!\");")
                .append("}");
        ctMethod.setBody(methodBody.toString());

        ctClass.writeFile();
    }

//    public static void main(String[] args) {
//        try {
//            //获取源类
//            ClassPool pool = ClassPool.getDefault();
//            CtClass ctClass = pool.get("classtest.javassist.Hello");
//
//            //设置父类
//            ctClass.setSuperclass(pool.get("classtest.javassist.Super"));
//
//            //修改hello方法
//            CtMethod ctMethod = ctClass.getDeclaredMethod("hello");
//            ctMethod.setName("hello$Impl");
//
//            CtMethod newMethod = CtNewMethod.copy(ctMethod, "hello", ctClass, null);
//            StringBuilder methodBody = new StringBuilder();
//            methodBody.append("{")
//                    .append("long start = System.currentTimeMillis();\n")
//                    .append("String re = hello$Impl($$);\n")
//                    .append("System.out.println(\"cost time: \" + (System.currentTimeMillis() - start));\n")
//                    .append("return re;\n")
//                    .append("}");
//            newMethod.setBody(methodBody.toString());
//            ctClass.addMethod(newMethod);//add new method
//
//            ctClass.writeFile();
//
//            Hello hello = (Hello) ctClass.toClass().newInstance();
//            Method[] methods = hello.getClass().getMethods();
//            for (Method method : methods) {
//                if (method.getName().equals("test")) {
//                    method.invoke(hello, null);
//                }
//            }
//            hello.hello();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (CannotCompileException e) {
//            e.printStackTrace();
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

}
