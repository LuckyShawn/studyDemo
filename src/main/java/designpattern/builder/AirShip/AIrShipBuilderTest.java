package designpattern.builder.AirShip;

/**
 * @Description 测试类
 * StringBuilder使用建造者模式
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class AIrShipBuilderTest {
    public static void main(String[] args){
        //获得装配这和构建者
        AirShipDirector airShipDirector = new ShawnAirShipDirector(new ShawnAirShipBuilder());
        AirShip airShip = airShipDirector.directAirShip();
        System.out.println(airShip.toString());
        //AirShip{orbitalModule=OrbitalModule{name='shawn牌轨道仓'}, engine=Engine{name='shawn牌发动机'}, escapeTower=EscapeTower{name='shawn牌逃逸仓'}}
        airShip.launch();

        StringBuilder sb = new StringBuilder();
    }
}
