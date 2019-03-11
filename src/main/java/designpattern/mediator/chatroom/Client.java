package designpattern.mediator.chatroom;

/**
 * @Description jack和shawn通过ChatRoom(聊天室中介者)进行通信
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class Client {
    public static void main(String[] args){
        User jack = new User("jack");
        User shawn = new User("shawn");

        jack.sendMessage("hello everybody!");
        shawn.sendMessage("Hi!");
    }
}
