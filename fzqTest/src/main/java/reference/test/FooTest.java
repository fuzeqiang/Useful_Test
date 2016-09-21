package reference.test;

/**
 * Created by fuzeqiang(100918) on 2016/8/26 0026.
 */
public class FooTest {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setFoo("aa");
        test(foo);
        System.out.println(foo.getFoo());
    }

    static Foo foo1 = new Foo();

    public static Foo test(Foo foo) {
        System.out.println(foo.getFoo());
        foo = foo1;
        foo.setFoo("bb");
        return foo;
    }

}
