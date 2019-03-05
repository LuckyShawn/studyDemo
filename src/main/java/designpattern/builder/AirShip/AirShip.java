package designpattern.builder.AirShip;

/**
 * @Description 飞船类
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class AirShip {
    private OrbitalModule orbitalModule;  //轨道舱
    private Engine engine; //发动机
    private EscapeTower escapeTower;  //逃逸塔


    public void launch(){
        System.out.println("发射！");
    }

    public AirShip(Engine engine,OrbitalModule orbitalModule, EscapeTower escapeTower) {
        this.orbitalModule = orbitalModule;
        this.engine = engine;
        this.escapeTower = escapeTower;
    }

    public AirShip() {
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }
    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public EscapeTower getEscapeTower() {
        return escapeTower;
    }
    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }

    @Override
    public String toString() {
        return "AirShip{" +
                "orbitalModule=" + orbitalModule +
                ", engine=" + engine +
                ", escapeTower=" + escapeTower +
                '}';
    }
}

class OrbitalModule{
    private String name;

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrbitalModule{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Engine {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                '}';
    }
}

class EscapeTower{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EscapeTower(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "EscapeTower{" +
                "name='" + name + '\'' +
                '}';
    }
}
