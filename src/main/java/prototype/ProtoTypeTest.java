package prototype;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class ProtoTypeTest {
    public static void main(String[] args){
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + cloneShape.getType());

        cloneShape =  ShapeCache.getShape("2");
        System.out.println("Shape : " + cloneShape.getType());

        cloneShape =  ShapeCache.getShape("3");
        System.out.println("Shape : " + cloneShape.getType());

    }
}
