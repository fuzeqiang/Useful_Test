package annotation.test.auth;

/**
 * Created by fuzeqiang(100918) on 2016/7/15 0015.
 */
public class Service {

    @AuthInfo(Priority.ADMIN)
    public void admin() {
        System.out.println("just admin invoked");
    }

    @AuthInfo(Priority.MANAGER)
    public void manager() {
        System.out.println("admin or manager invoked");
    }

    @AuthInfo(Priority.USER)
    public void user() {
        System.out.println("admin, manager or user invoked");
    }

    @AuthInfo
    public void guest() {
        System.out.println("everyone can invoke");
    }

}
