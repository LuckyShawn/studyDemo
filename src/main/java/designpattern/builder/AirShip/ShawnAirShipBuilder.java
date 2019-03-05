package designpattern.builder.AirShip;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class ShawnAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine builderEngine() {
        return new Engine("shawn牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        return new OrbitalModule("shawn牌轨道仓");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        return new EscapeTower("shawn牌逃逸仓");
    }
}
