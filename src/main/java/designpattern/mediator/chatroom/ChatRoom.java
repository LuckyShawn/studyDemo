package designpattern.mediator.chatroom;

import java.util.Date;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}
