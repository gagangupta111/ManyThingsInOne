package com.DesignPattern;

public class Strategy {

    public static void main(String args[]) {

        System.out.println(" Strategy Design Pattern! ");

        StrategyInterface strategy = new MultiplyStrategy();
        StrategyOperation strategyOperation = new StrategyOperation(strategy);

        int result  = strategyOperation.operation(12, 12);
        System.out.println(" Using MultiplyStrategy on 12, 12. Result is : " + result);

        // addition strategy.
        strategy = new SumStrategy();
        strategyOperation.setStrategyInterface(strategy);
        result  = strategyOperation.operation(12, 12);
        System.out.println(" Using SumStrategy on 12, 12. Result is : " + result);

    }

}

class StrategyOperation{

    private StrategyInterface strategyInterface;

    public StrategyOperation(StrategyInterface strategyInterface) {
        this.strategyInterface = strategyInterface;
    }

    public void setStrategyInterface(StrategyInterface strategyInterface) {
        this.strategyInterface = strategyInterface;
    }

    public int operation(int a, int b){

        return strategyInterface.operation(a, b);

    }

}


interface StrategyInterface{

    public int operation(int a, int b);

}

class SumStrategy implements StrategyInterface{

    @Override
    public int operation(int a, int b) {

        return a + b;

    }

}

class MultiplyStrategy implements StrategyInterface{

    @Override
    public int operation(int a, int b) {

        return a * b;

    }

}


