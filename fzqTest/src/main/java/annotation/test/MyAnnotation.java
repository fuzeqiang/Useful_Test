package annotation.test;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/7/15 0015.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface MyAnnotation {
    String value() default "hello";
}
