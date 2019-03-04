package designpattern.singleton;

/**
 * @Description 枚举类型的单例模式
 * 调用效率高，避免了使用反射破解，但是没有懒加载效果
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public enum SingletonEnum {

    //这个枚举元素本身就是单例对象
    INSTANCE;
    //添加自己需要的操作
    public void whateverMethod() {
    }
}
