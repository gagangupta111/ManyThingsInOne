package com.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPublisher {

    public static void main(String args[])
    {

        Publisher publisher = new Publisher(" P1");
        List<Observer> list = new ArrayList<>();
        Observer observer;
        for (int i = 0; i < 10; i++){
            observer = new Observer("O" + i);
            observer.setPublisher(publisher);
            list.add(observer);
        }
        publisher.setObservers(list);

        publisher.sendNotification();

    }

}

interface PublisherInterface{

    public void sendNotification();

}

class Publisher implements PublisherInterface{

    private List<Observer> observers;
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher(List<Observer> observers, String name) {
        this.observers = observers;
        this.name = name;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void sendNotification(){

        for (Observer observer : observers){

            observer.notification(" Publisher " + name + " sent you this message! ");

        }

    }
}

interface ObserverInterface{

    public void notification(String message);

}

class Observer{

    private Publisher publisher;
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    public Observer(Publisher publisher, String name) {
        this.publisher = publisher;
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void notification(String message){

        System.out.println(" Notification recieved for Observer " + name + " as: " + message);

    }

}
