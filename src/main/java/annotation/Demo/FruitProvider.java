package annotation.Demo;

import java.lang.annotation.*;

/**
 * @author Shawn
 * @title: FruitProvider
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/1/26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /*供应商编号*/
    public int id() default -1;
    /*供应商名称*/
    public String name() default "";
    /*供应商地址*/
    public String address() default "";
}
