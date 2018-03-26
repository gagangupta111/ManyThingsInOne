package com.DesignPattern.command;

public class CommandDesign {

    public static void main(String[] args){

        System.out.println(" Hello! ");

        Command add = new AdditionCommand();
        Command sub = new SubtractionCommand();
        Command mul = new MultiplyCommand();

        int a = 100;
        int b = 50;
        WorkItOut workItOut = new WorkItOutDemo(add);
        System.out.println(workItOut.execute(a,b));

        workItOut = new WorkItOutDemo(sub);
        System.out.println(workItOut.execute(a,b));

        workItOut = new WorkItOutDemo(mul);
        System.out.println(workItOut.execute(a,b));

        System.out.println(" Hello! ");

    }

}

interface WorkItOut{

    public int execute(int a, int b);

}

class WorkItOutDemo implements WorkItOut{

    private Command command;

    public WorkItOutDemo(Command command) {
        this.command = command;
    }

    @Override
    public int execute(int a, int b) {
        return command.execute(a,b);
    }

}

interface Command{

    public int execute(int a, int b);

}

class AdditionCommand implements Command{


    @Override
    public int execute(int a, int b) {
        return a+b;
    }

}

class MultiplyCommand implements Command{

    @Override
    public int execute(int a, int b) {
        return a*b;
    }

}

class SubtractionCommand implements Command{


    @Override
    public int execute(int a, int b) {
        return a-b;
    }

}
