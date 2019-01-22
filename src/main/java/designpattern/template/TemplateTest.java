package designpattern.template;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class TemplateTest {
    public static void main(String[] args){
        Game game = new FootBall();
        game.play();

        game = new Basketball();
        game.play();
    }
}
