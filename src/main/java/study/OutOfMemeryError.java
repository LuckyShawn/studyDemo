package study;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2019/1/10 0010
 */
public class OutOfMemeryError {
    public static void main(String[] args){
        List l = new LinkedList();
        List l1 = new LinkedList();
        List l2 = new LinkedList();
        List l3 = new LinkedList();
        // Enter infinite loop which will add a String to the list: l on each
        // iteration.
        do {
            l.add(new String("Hello, World"));
            l1.add(new String("Hi!"));
            l2.add(new String("Hi!!!"));
            l3.add(new String("Hi!!!!"));
        } while (true);
    }
}
