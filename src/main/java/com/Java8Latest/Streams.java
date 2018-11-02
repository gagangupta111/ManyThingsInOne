package com.Java8Latest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello!");

        for (int i = 0; i < 100; i++){

            List<Integer> list = getlist(99000 + i);
            Instant startDate = Instant.now();
            long sumIterator = sumIterator(list);
            Instant endDate = Instant.now();
            Duration timeElapsed1 = Duration.between(startDate, endDate);

            startDate = Instant.now();
            long sumStream = sumStream(list);
            endDate = Instant.now();
            Duration timeElapsed2 = Duration.between(startDate, endDate);
            if (sumIterator != sumStream){
                System.out.println("Wrong calculation");
            }

            if (timeElapsed1.toMillis() - timeElapsed2.toMillis() > 0){
                System.out.println("sumIterator is taking more time than sumStream by " + (timeElapsed1.toMillis() - timeElapsed2.toMillis()));
            }

            if (timeElapsed2.toMillis() - timeElapsed1.toMillis() > 0){
                System.out.println("sumStream is taking more time than sumIterator by " + (timeElapsed2.toMillis() - timeElapsed1.toMillis()));
            }

            System.out.println("=================================================");

        }
    }

    private static List<Integer> getlist(int max){
        Random random = new Random();
        return Stream.generate(() -> {
            return random.nextInt();
        }).limit(10).collect(Collectors.toList());
    }

    private static int sumStream(List<Integer> list) throws InterruptedException {
        Thread.sleep(1000);
        return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
    }

    private static int sumIterator(List<Integer> list) throws InterruptedException {
        Thread.sleep(1000);
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }


}
