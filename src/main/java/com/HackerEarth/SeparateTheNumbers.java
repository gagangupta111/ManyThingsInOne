package com.HackerEarth;

public class SeparateTheNumbers {

    public static void main(String[] args) throws Exception {

        String s = "66666666666666666666666666666666";
        long x = 0;
        long y = 0;
        long smallest = 0;
        boolean isDone  = false;
        boolean isBeautiful = true;

        if (s.length() <= 1){
            System.out.println("NO");
            return;
        }

        for (int i = 1; i < s.length();i++) {

            isBeautiful = true;
            String substring = s.substring(0, i);
            x = Long.parseLong(substring);
            isDone = false;

            for (int j = i;j < s.length();) {

                if (!isDone)
                    smallest = x;

                    isDone =  true;
                    y = x + 1;
                    String to = "" + y;

                    if ( (j+to.length()) > s.length()){
                        System.out.println("NO");
                        return;

                    }

                    String sub = s.substring(j, j + to.length());
                    if (sub.equals(to)){

                        j = j + to.length();
                        x = y;

                    }else {

                        isBeautiful = false;
                        break;

                    }
            }

            if (isBeautiful){
                System.out.println("YES " + smallest);
                break;
            }

        }

        if (!isBeautiful){
            System.out.println("NO");
        }

    }

}
