package classtest.javassist;

import javassist.*;

import java.io.IOException;

/**
 * Created by fuzeqiang(100918) on 2016/8/1 0001.
 */
public class JavassistGenerator {

    public static void main(String[] args) throws IOException {
        int count = 0;
        for (int n = 0; n < 10; n++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                createClass("classtest" + n + ".javassist" + i + ".Programmer" + count++);
//                createClass("");
            }
            System.out.print((System.currentTimeMillis() - start) + ", ");
        }

    }

    public static ClassPool pool = ClassPool.getDefault();
    public static void createClass(String className) {
        //创建Programmer类
        CtClass cc= pool.makeClass(className);
        //定义code方法
        CtMethod method = null;
        try {
            method = CtNewMethod.make("public void code(){}", cc);
            //插入方法代码
            method.insertBefore("System.out.println(\"Just Coding.....\");");
            cc.addMethod(method);
            //保存生成的字节码
            cc.writeFile("d://temp");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
