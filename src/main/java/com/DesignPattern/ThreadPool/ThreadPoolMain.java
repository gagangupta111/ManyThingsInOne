package com.DesignPattern.ThreadPool;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadPoolMain {

    public static void main(String[] args){

        ReusablePoolInterface<ReusableInterface> poolInterface = new ReusablePool();

        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ReusableInterface reusableInterface = poolInterface.checkOut();
            System.out.println(reusableInterface.toString());

        }

    }

}

interface ReusableInterface {

    public int getID();

    public void setID(int id);

    public boolean isClosed();

    public void expire(boolean close);

}

class ReusableClass implements ReusableInterface {

    private int id;
    private String name;
    private boolean close = false;

    public void setClose(boolean close) {
        this.close = close;
    }

    public ReusableClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public boolean isClosed() {
        return this.close;
    }

    @Override
    public void expire(boolean close) {
        this.close = close;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReusableClass that = (ReusableClass) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {

        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;

    }

    @Override
    public String toString() {

        return "ReusableClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }

}

interface ReusablePoolInterface<T>{

    public T checkOut();

    public void checkIn(T t);

    public void expire(ReusableInterface reusableInterface);

}

class ReusablePool implements ReusablePoolInterface<ReusableInterface> {

    private Map<ReusableInterface, Long> locked = new ConcurrentHashMap<>();
    private Map<ReusableInterface, Long> unLocked = new ConcurrentHashMap<>();
    private long expirationTime =  30000;
    private static volatile int count = 0;

    public ReusablePool() {

        ReusableInterface thread;
        for (int i = 0; i < 10; i++){

            thread = new ReusableClass(i, i + "th_Name");
            unLocked.put(thread, System.currentTimeMillis());
            count = count + 1;

        }

    }

    private ReusableInterface create(){

        ReusableInterface reusableInterface =  new ReusableClass(count, count + "th_Name");
        count++;
        return reusableInterface;

    }

    public void expire(ReusableInterface thread){

        thread.expire(true);

    }

    private boolean validate(ReusableInterface thread){

        if (thread.isClosed()){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public ReusableInterface checkOut() {

        Set<ReusableInterface> keys = unLocked.keySet();
        long currentTime = System.currentTimeMillis();
        long threadTime;

        System.out.printf("LockedSize : " + locked.size() );
        System.out.printf("UnLockedSize : " + unLocked.size() );

        for (ReusableInterface thread : keys){

            threadTime = unLocked.get(thread);
            if (currentTime - threadTime > expirationTime){

                thread.expire(true);
                unLocked.remove(thread);

            }else {

                if (validate(thread)){
                    unLocked.remove(thread);
                    locked.put(thread, System.currentTimeMillis());
                    return thread;
                }else {
                    thread.expire(true);
                    unLocked.remove(thread);
                }

            }

        }

        ReusableInterface thread = create();
        locked.put(thread, System.currentTimeMillis());

        return thread;

    }

    @Override
    public void checkIn(ReusableInterface reusableInterface) {

        locked.remove(reusableInterface);
        unLocked.put(reusableInterface, System.currentTimeMillis());

    }
}
