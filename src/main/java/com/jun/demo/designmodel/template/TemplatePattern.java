package com.jun.demo.designmodel.template;

/**
 * @author Jun
 * @date 2019/12/17 上午11:03
 */
public class TemplatePattern {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();
        System.out.println("------------------------");
        game = new Cricket();
        game.play();
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football game initial");
    }

    @Override
    void startPlay() {
        System.out.println("Football game start");
    }

    @Override
    void endPlay() {
        System.out.println("Football game end");
    }
}

class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket game initial");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game initial");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game end");
    }
}

/**
 * 游戏模板
 */
abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}