package com.DesignPattern.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility {

    public static void main(String args[])
    {

        Request request = new Request(Request.ERROR);
        List<Logger> loggers = new ArrayList<>();

        loggers.add(new Logger(Request.INFO, request, "info"));
        loggers.add(new Logger(Request.DEBUG, request, "debug"));
        loggers.add(new Logger(Request.ERROR, request, "error"));

        LogAll.loggers = loggers;
        LogAll.logAllLoggers();

    }

}

class LogAll{

    public static List<Logger> loggers;

    public static void logAllLoggers(){

        for (Logger logger : loggers){
            if (logger.getLevel() >= logger.getRequest().getLevel()){
                logger.log();
            }
        }

    }

}


class Request{

    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;

    private final int level;

    public Request() {
        level = INFO;
    }

    public Request(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}

class Logger{

    private final int level;
    private final Request request;
    private final String name;

    public Logger(int level, Request request, String name) {
        this.level = level;
        this.request = request;
        this.name = name;
    }

    public void log(){
        System.out.println(" Logged " + name + " for request level " + request.getLevel());
    }

    public int getLevel() {
        return level;
    }

    public Request getRequest() {
        return request;
    }

    public String getName() {
        return name;
    }
}
