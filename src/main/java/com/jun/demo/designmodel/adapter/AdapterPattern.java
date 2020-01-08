package com.jun.demo.designmodel.adapter;

/**
 * @author Jun
 * @date 2019/12/17 上午9:26
 */
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play(MediaEnum.MP3.getValue(), "我是Mp3");
        audioPlayer.play(MediaEnum.MP4.getValue(), "我是Mp4");
        audioPlayer.play(MediaEnum.VLC.getValue(), "我是vlc");
        audioPlayer.play(MediaEnum.AVI.getValue(), "我是avi");
    }
}

class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (MediaEnum.MP3.getValue().equals(audioType)) {
            System.out.println("Player mp3 " + fileName);
            return;
        }
        if (MediaEnum.MP4.getValue().equals(audioType) || MediaEnum.VLC.getValue().equals(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
            return;
        }
        System.out.println("invalid media " + audioType + "format not supported ");
    }
}

class MediaAdapter implements MediaPlayer {

    private AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if (MediaEnum.MP4.getValue().equals(audioType)) {
            advanceMediaPlayer = new Mp4Player();
        }
        if (MediaEnum.VLC.getValue().equals(audioType)) {
            advanceMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (MediaEnum.MP4.getValue().equals(audioType)) {
            advanceMediaPlayer.playMp4(fileName);
        }
        if (MediaEnum.VLC.getValue().equals(audioType)) {
            advanceMediaPlayer.playVlc(fileName);
        }
    }
}

class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 " + fileName);
    }
}

class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}

interface AdvanceMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

interface MediaPlayer {
    void play(String audioType, String fileName);
}

enum MediaEnum {
    MP4("Mp4"),
    AVI("avi"),
    MP3("Mp3"),
    VLC("Vlc");
    private String value;

    MediaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}