package designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 明星动态代理类
 * @Author shawn
 * @create 2019/3/6 0006
 */
public class StarHandler implements InvocationHandler {

    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;

        System.out.println("签合同1");
        System.out.println("签合同2");
        System.out.println("签合同3");
        if(method.getName().equalsIgnoreCase("sing")){
            object = method.invoke(realStar,args);
        }
        System.out.println("收尾款");
        return object;
    }
}
