package com.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line  = br.readLine();
        int K = Integer.parseInt(line);

        Stack<String> stack = new Stack<String>();
        Map<String, Integer> openingBrackets = new HashMap<String, Integer>();
        openingBrackets.put("(", 1);
        openingBrackets.put("{", 2);
        openingBrackets.put("[", 3);

        Map<String, Integer> closingBrackets = new HashMap<String, Integer>();
        closingBrackets.put(")", 1);
        closingBrackets.put("}", 2);
        closingBrackets.put("]", 3);

        outerLoop:
        for (int  i = 0; i < K; i++){

            stack = new Stack<String>();
            line = br.readLine();
            String[] split = line.split("");

            for (int k = 0; k < split.length; k++){

                if (openingBrackets.get(split[k]) != null){

                    stack.add(split[k]);

                }else if (closingBrackets.get(split[k]) != null){

                    if (stack.isEmpty()){
                        System.out.println("NO");
                        continue outerLoop;
                    }

                    String key = stack.pop();
                    int cl = closingBrackets.get(split[k]);
                    int op = openingBrackets.get(key);

                    if (cl == op){
                        continue ;
                    }else {
                        System.out.println("NO");
                        continue outerLoop;
                    }

                }

            }

            if (!stack.isEmpty()){
                System.out.println("NO");
                continue outerLoop;
            }
            System.out.println("YES");

        }

    }
}
