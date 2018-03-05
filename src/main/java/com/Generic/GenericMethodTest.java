package com.Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {

    // generic method printArray
    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static < A > void printArray( List<A> inputArray ) {
        // Display array elements
        for(A element : inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        List<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(13);
        list.add(18);
        list.add(20);

        System.out.println("Array integerArray contains:");
        printArray(intArray);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArray(charArray);   // pass a Character array

        System.out.println("\nArrayList contains:");
        printArray(list);   // pass a Character array
    }
}