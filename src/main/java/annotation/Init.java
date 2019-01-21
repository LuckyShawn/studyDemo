package annotation;

import java.lang.annotation.*;
/**
 * @Description 注解赋值
 * @Author shawn
 * @create 2019/1/16 0016
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {

    public String value() default "";


}
