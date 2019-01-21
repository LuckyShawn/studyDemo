package designpattern.adapter;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class AdapterTest {
    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","光辉岁月.mp3");
        audioPlayer.play("mp4","变形金刚4.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
