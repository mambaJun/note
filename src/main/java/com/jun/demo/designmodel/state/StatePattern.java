package com.jun.demo.designmodel.state;

import lombok.Data;

/**
 * @author Jun
 * @date 2019/12/16 下午4:08
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}

@Data
class Context {
    private State state;
}


class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state ");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State ";
    }
}

class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is start state ");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State ";
    }
}

interface State {
    void doAction(Context context);
}
