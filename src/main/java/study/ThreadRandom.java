package study;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @Author: yang.xiao
 * @Description:
 * @Date: 2018/11/5 0005 8:52
 **/
public class ThreadRandom {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        Random r = ThreadLocalRandom.current();

        System.out.println(r.nextInt());

    }
}
