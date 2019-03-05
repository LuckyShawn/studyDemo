package designpattern.builder.AirShip;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class ShawnAirShipDirector implements AirShipDirector {

    private ShawnAirShipBuilder shawnAirShipBuilder;

    public ShawnAirShipDirector(ShawnAirShipBuilder shawnAirShipBuilder){
        this.shawnAirShipBuilder = shawnAirShipBuilder;
    }

    @Override
    public AirShip directAirShip() {
        //装配成飞船对象
        AirShip airShip = new AirShip(
                shawnAirShipBuilder.builderEngine(),
                shawnAirShipBuilder.builderOrbitalModule(),
                shawnAirShipBuilder.builderEscapeTower());
        return airShip;
    }
}
