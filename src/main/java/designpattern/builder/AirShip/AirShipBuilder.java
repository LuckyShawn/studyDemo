package designpattern.builder.AirShip;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbitalModule();
    EscapeTower  builderEscapeTower();
}
