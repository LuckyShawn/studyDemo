package designpattern.adapter;

import designpattern.adapter.impl.Mp4Player;
import designpattern.adapter.impl.VlcPlayer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = new VlcPlayer();
        }else if("mp4".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = new Mp4Player();
        }
    }


    @Override
    public void play(String playType, String fileName) {
        if(playType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(playType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
