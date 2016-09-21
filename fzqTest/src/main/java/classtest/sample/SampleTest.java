package classtest.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fuzeqiang(100918) on 2016/8/1 0001.
 */
public class SampleTest {
    public static void main(String[] args) {
        File file = new File(".");
        try {
            String path = file.getCanonicalPath() + "/fzqTest\\target\\classes\\classtest\\sample/Programmer.class";
            InputStream is = new FileInputStream(path);
            byte[] re = new byte[1024];
            int count = is.read(re);

            MyClassLoader loader = new MyClassLoader();
            Class clazz = loader.defineMyClass(re, 0, count);

            System.out.println(clazz.getCanonicalName());
            Object obj = clazz.newInstance();

            clazz.getMethod("code", null).invoke(obj, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
