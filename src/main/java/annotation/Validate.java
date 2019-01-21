package annotation;

import java.lang.annotation.*;

/**
 * @Description 验证注解
 * @Author shawn
 * @create 2019/1/16 0016
 */
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {


        public int min() default 1;

        public int max() default 10;

        public boolean isNotNull() default true;
}

