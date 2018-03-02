package com.HackerEarth;

public class CamelCase {

    public static void main(String[] args){

        String s = "uChangesInTheEditorA";
        int count = 0;

        for (int i = 0; i < s.length(); i++){

            if (((int)s.charAt(i) >= 65 ) && ((int)s.charAt(i) <= 90 )){
                count++;
            }

        }


        if (((int)s.charAt(0) >= 97 ) && ((int)s.charAt(0) <= 122 )){
            count++;
        }

        System.out.println(count);
    }

}
