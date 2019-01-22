package designpattern.template;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class FootBall extends Game {
    @Override
    void initialize() {
        System.out.println("篮球游戏初始化");
    }

    @Override
    void startPlay() {
        System.out.println("篮球游戏开始");
    }

    @Override
    void endPlay() {
        System.out.println("篮球游戏结束");
    }
}
