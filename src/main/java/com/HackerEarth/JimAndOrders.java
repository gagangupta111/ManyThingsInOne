package com.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JimAndOrders {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        List<Order> list = new ArrayList<Order>(N);

        Order order = null;
        String[] splitted;
        int i = 0;
        while (i < N) {

            line = br.readLine();
            splitted = line.split("\\s+");
            order = new Order();
            order.id = i + 1;
            order.t = Long.parseLong(splitted[0]);
            order.d = Long.parseLong(splitted[1]);
            order.total_time = order.t + order.d;
            list.add(order);
            i++;

        }

        Collections.sort(list);
        i = 0;

        for (Order item: list){
            System.out.print(item.id + " ");
        }

    }
}

class Order implements Comparable{

    public int id;
    public long t;
    public long d;
    public long total_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (t != order.t) return false;
        return d == order.d;
    }

    @Override
    public int hashCode() {
        int result = (int) (t ^ (t >>> 32));
        result = 31 * result + (int) (d ^ (d >>> 32));
        return result;
    }

    public int compareTo(Object aThat) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == aThat) return EQUAL;

        Order that = (Order)aThat;

        if (this.total_time > that.total_time) return AFTER;
        if (this.total_time < that.total_time) return BEFORE;

        return EQUAL;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", t=" + t +
                ", d=" + d +
                ", total_time=" + total_time +
                '}';
    }
}
