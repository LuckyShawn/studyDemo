package designpattern.Flyweight.chess;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/8 0008
 */
public class Client {
    private static final String[] color = {"black","white","green"};
    public static void main(String[] args){

        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black","circle");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black","circle");
        ChessFlyWeight chess3 = ChessFlyWeightFactory.getChess("white","circle");
        ChessFlyWeight chess4 = ChessFlyWeightFactory.getChess("white","circle");
        ChessFlyWeight chess5 = ChessFlyWeightFactory.getChess("white","square");
        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println(chess3);
        System.out.println(chess4);
        System.out.println(chess5);

        System.out.println("增加外部状态的处理===========");
        for (int i = 0; i < 10; i++) {
            ChessFlyWeightFactory.getChess(getColor(),"circle").display(new Coordinate(getRandomX(), getRandomY()));
        }
    }

    private static String getColor(){
        return color[(int)(Math.random()*color.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
