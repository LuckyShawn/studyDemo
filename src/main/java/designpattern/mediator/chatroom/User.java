package designpattern.mediator.chatroom;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/11 0011
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }

}
