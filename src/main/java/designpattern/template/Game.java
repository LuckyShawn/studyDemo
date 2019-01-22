package designpattern.template;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模版
    public void play(){
        //初始化
        initialize();
        //开始
        startPlay();
        //结束
        endPlay();
    }
}
