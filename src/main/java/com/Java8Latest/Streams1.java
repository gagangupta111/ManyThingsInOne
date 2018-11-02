package com.Java8Latest;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams1 {

    public static void main(String[] args){

        System.out.println("Hello!");
        List<String> strings = Stream.generate(() -> {
            return "test" ;
        }).limit(10).collect(Collectors.toList());

        Random random = new Random();
        List<Integer> integerList = Stream.generate(() -> {
            return random.nextInt();
        }).limit(10).collect(Collectors.toList());

        List<Various> variousList = Stream.generate(() -> {
            return new Various(random.nextInt(5000), random.nextInt(5000), "" + random.nextInt(), random.nextDouble());
        }).limit(10).collect(Collectors.toList());




        strings.stream().forEach(s -> {
            System.out.println(s);
        });

        integerList.stream().forEach(integer -> {
            System.out.println(integer);
        });

        variousList.stream().forEach(various -> {
            System.out.println(various);
        });

        variousList.stream().limit(5).forEach(various -> {
            System.out.println(various);
        });

        variousList.removeIf(various -> various.getValue()%5 == 0);
        System.out.println("=========================================");
        variousList.stream().forEach(various -> {
            System.out.println(various);
        });

        System.out.println("=========================================");
        List<String> list = variousList.stream().map(various -> various.toString()).collect(Collectors.toList());
        list.forEach(s -> {
            System.out.println(s);
        });

        DoubleSummaryStatistics statistics = variousList.parallelStream().mapToDouble(value -> {
           return value.getAmount();
        }).summaryStatistics();

        System.out.println("=========================================");
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());

        System.out.println("=========================================");
        variousList.stream().map(value -> {
            return new Integer(value.getValue());
        }).forEach(integer -> System.out.println(integer));

        System.out.println("=========================================");
        variousList.stream().sorted().forEach(various -> System.out.println(various));

        System.out.println("=========================================");
        variousList.stream().sorted(new Comparator<Various>() {
            @Override
            public int compare(Various o1, Various o2) {
                if (o1.getKey() > o2.getKey()){
                    return 1;
                }else if (o1.getKey() < o2.getKey()){
                    return -1;
                }else return 0;
            }
        }).forEach(various -> System.out.println(various));

        double sum = variousList.stream().mapToDouble(value -> value.getAmount()).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("=========================================");
        variousList.stream().collect(Collectors.toMap(Various::getKey, Various::getAmount))
                .forEach((integer, aDouble) -> System.out.println(" Key : " + integer + " Value : " + aDouble));


    }

}

class Various implements Comparable{

    private int key;
    private int value;
    private String name;
    private double amount;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Various(int key, int value, String name, double amount) {
        this.key = key;
        this.value = value;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Various various = (Various) o;
        return getKey() == various.getKey() &&
                getValue() == various.getValue() &&
                Double.compare(various.getAmount(), getAmount()) == 0 &&
                Objects.equals(getName(), various.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getKey(), getValue(), getName(), getAmount());
    }

    @Override
    public String toString() {
        return "Various{" +
                "key=" + key +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Various various = (Various)o;
        if (this.getAmount() > various.getAmount()){
            return 1;
        }else if (this.getAmount() < various.getAmount()){
            return -1;
        }else return 0;
    }
}

