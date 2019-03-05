package designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Description 单例模式防止破解
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class SingletonBreak implements Serializable {
    private static SingletonBreak singletonBreak;

    private SingletonBreak(){
        //若创建对象时不为空，抛出异常
        if(singletonBreak != null){
            throw new RuntimeException("创建对象错误！");
        }
    }

    public static synchronized SingletonBreak getInstance(){
        if(singletonBreak == null){
            singletonBreak = new SingletonBreak();
        }
        return singletonBreak;
    }

    //反序列化时，如果定义了readResolve()，直接返回此方法指定的对象，而不需要单独再创建爱你新对象
    private Object readResolve() throws ObjectStreamException{
        return singletonBreak;
    }
}
