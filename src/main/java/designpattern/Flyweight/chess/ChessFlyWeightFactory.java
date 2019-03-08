package designpattern.Flyweight.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 享元工厂：创建并管理享元对象，享元池一般设计成键值对（HashMap）
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class ChessFlyWeightFactory {
    //享元池
    private static final Map<String,ConcreteChess> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color,String shape){
        if(map.get(color)!=null){
            return map.get(color);
        }else{
            ConcreteChess concreteChess = new ConcreteChess(color,shape);
            concreteChess.setShape(shape);
            map.put(color,concreteChess);
            return concreteChess;
        }
    }

}
