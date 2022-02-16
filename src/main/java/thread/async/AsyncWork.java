package thread.async;

/**
 * @author Shawn
 * @title: AsyncWork
 * @projectName studyDemo
 * @description: TODO
 * @date 2022/1/13
 */
public class AsyncWork implements Runnable{
    private int a;
    private String s;
    public static int getResult() {
        return result;
    }

    public static void setResult(int result) {
        AsyncWork.result = result;
    }
    //异步执行必须要加上volatile，否则自旋的时候不会自动刷新内存，且System.out.println会影响内存可见性
    private static volatile int result = 0;

    public AsyncWork(int a, String s) {
        this.a = a;
        this.s = s;
    }

    @Override
    public void run() {

            System.out.println("开始记录日志");
            while(result != 1){ }
            System.out.println("a:"+a);
            System.out.println("s:"+s);
            System.out.println("日志记录完成");

    }
}
