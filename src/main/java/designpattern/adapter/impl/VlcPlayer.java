package designpattern.adapter.impl;

import designpattern.adapter.AdvancedMediaPlayer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
