package classtest.sample;

/**
 * Created by fuzeqiang(100918) on 2016/8/1 0001.
 */
public class MyClassLoader extends ClassLoader{

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }

}
