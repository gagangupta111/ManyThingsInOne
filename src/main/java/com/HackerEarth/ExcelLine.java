package com.HackerEarth;

public class ExcelLine {

    public static void main(String[] args){

        System.out.println("Hello !");

        String x1 = "1", y1 = "AB", x2 = "2", y2 = "BB";
        int x, y, A, B, C, D;
        x = 0;
        y = 0;
        A = Integer.parseInt(x1);
        B = toNumber(y1);
        C = Integer.parseInt(x2);;
        D = toNumber(y2);

        int s = (D - C) * x + (A - C) * y + (C * B - A * D);
        if (s < 0)
            System.out.println("The points are NOT collinear");
        else if (s > 0)
            System.out.println("The points are NOT collinear");
        else
            System.out.println("The points are collinear");


        System.out.println(toNumber("AA"));


    }

    public static int toNumber(String name) {
        int number = 0;
        for (int i = 0; i < name.length(); i++) {
            number = number * 26 + (name.charAt(i) - ('A' - 1));
        }
        return number;
    }

}
