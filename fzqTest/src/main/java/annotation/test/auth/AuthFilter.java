package annotation.test.auth;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fuzeqiang(100918) on 2016/7/15 0015.
 */
public class AuthFilter {

    public void filter(User user, Method method, Object[] params) {
        AuthInfo authInfo = method.getAnnotation(AuthInfo.class);
        Priority methodPriority = authInfo.value();
        if (user.getPriority().getIndex() <= methodPriority.getIndex()) {
            try {
                method.invoke(new Service(), params);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw  new Exception("auth failed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        User user = new User();
//        user.setPriority(Priority.ADMIN);
        user.setPriority(Priority.MANAGER);
//        user.setPriority(Priority.USER);
//        user.setPriority(Priority.GUEST);

        Method[] methods = Service.class.getDeclaredMethods();
        AuthFilter authFilter = new AuthFilter();
        for (Method method : methods) {
            authFilter.filter(user, method, null);
        }
    }

}
