package designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @Description 动态创建代理类调用明星唱歌方法
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class Client {
    public static void main(String[] args){
        Star star = new RealStar();
        StarHandler starHandler = new StarHandler(star);
        //通过类加载器，明星接口，动态代理处理器
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandler);
        proxy.sing();
    }
}
