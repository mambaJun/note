package com.jun.demo.designmodel.adopt;

/**
 * @author jun
 * @date 2019/12/11 上午11:35
 */
public class Adopt {
}

class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {

    }
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

interface MediaPlayer{
    public void play(String audioType, String fileName);
}
