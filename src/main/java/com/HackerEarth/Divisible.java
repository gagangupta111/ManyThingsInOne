package com.HackerEarth;

public class Divisible {

    public static int lcm_of_array_elements(int[] element_array)
    {

        int lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {

            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                if (element_array[i] == 0) {
                    return 0;
                } else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }

        }

    }

    private static int gcd(int a, int b)
    {

        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;

    }

    private static int gcd(int[] input)
    {

        int result = input[0];
        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;

    }

    public static void main(String[] args)
    {

        int[] element_array = {2,3};
        int[] more = {630};

        int lcm = lcm_of_array_elements(element_array);
        System.out.println(lcm);
        int hcf  = gcd(more);
        System.out.println(hcf);

        int count = 0;
        for ( int i = 1; ; i++ ){

            if ((lcm*i) > hcf){
                break;
            }

            if ( hcf % (lcm*i) == 0){
                System.out.println(" found: " + (lcm*i) );
                count++;
            }

        }

        System.out.println(count);

    }

}
