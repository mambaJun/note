package com.jun.demo.designmodel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2019/12/17 上午11:14
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        OctalObserver octalObserver = new OctalObserver(subject);
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        new IntegerObserver(subject);

        System.out.println("------------------------------");
        subject.setState(10);
        System.out.println("------------------------------");
        subject.setState(15);
    }
}

class IntegerObserver extends Observer {

    public IntegerObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Integer String：" + Integer.valueOf(subject.getState()));
    }
}

class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String：" + Integer.toOctalString(subject.getState()));
    }
}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String：" + Integer.toBinaryString(subject.getState()));
    }
}

abstract class Observer {
    protected Subject subject;

    public abstract void update();
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}