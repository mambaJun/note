package com.jun.demo.designmodel.strategy;

/**
 * @author Jun
 * @date 2019/12/16 下午3:58
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new OperationAdd());
        System.out.println(context.executeStrategy(10,5));

        context.setStrategy(new OperationMultiply());
        System.out.println(context.executeStrategy(10,5));

        context.setStrategy(new OperationSubstract());
        System.out.println(context.executeStrategy(10,5));
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOpration(num1, num2);
    }
}

class OperationMultiply implements Strategy {
    @Override
    public int doOpration(int num1, int num2) {
        return num1 * num2;
    }
}

class OperationSubstract implements Strategy {

    @Override
    public int doOpration(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationAdd implements Strategy {

    @Override
    public int doOpration(int num1, int num2) {
        return num1 + num2;
    }
}

interface Strategy {
    int doOpration(int num1, int num2);
}
