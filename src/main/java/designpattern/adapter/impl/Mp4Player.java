package designpattern.adapter.impl;

import designpattern.adapter.AdvancedMediaPlayer;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/21 0021
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
