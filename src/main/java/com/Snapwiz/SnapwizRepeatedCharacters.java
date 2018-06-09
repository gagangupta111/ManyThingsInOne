package com.Snapwiz;

import java.util.*;

class StringInteger implements Comparable{

    public String string;
    public Integer integer;

    public StringInteger(String string, Integer integer) {
        this.string = string;
        this.integer = integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringInteger that = (StringInteger) o;

        if (string != null ? !string.equals(that.string) : that.string != null) return false;
        return integer != null ? integer.equals(that.integer) : that.integer == null;
    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (integer != null ? integer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StringInteger{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        StringInteger stringInteger = (StringInteger)o;

        if (this.integer > stringInteger.integer){
            return -1;
        }else if (this.integer < stringInteger.integer){
            return 1;
        }else {
            return 0;
        }

    }
}

public class SnapwizRepeatedCharacters {

    public static void main(String[] args){

        String string = "bcduteuytutuytrutetueturtuetutuey";
        System.out.println(findRepeatedCharacter(string));

    }

    public static char findRepeatedCharacter(String string){

        List<StringInteger> list = new ArrayList<StringInteger>();
        Map<String, StringInteger> map = new HashMap<String, StringInteger>();
        char[] array = string.toCharArray();

        for (char ch : array){

            StringInteger stringInteger = map.get("" + ch);
            if ( stringInteger == null){

                stringInteger = new StringInteger("" + ch , new Integer(1));
                list.add(stringInteger);
                map.put("" + ch, stringInteger);

            }else {

                list.remove(stringInteger);
                map.remove(stringInteger.string);
                stringInteger.integer = stringInteger.integer + 1;
                list.add(stringInteger);
                map.put(stringInteger.string, stringInteger);

            }

        }

        Collections.sort(list);

        List<String> characters = new ArrayList<String>();
        Integer integer = list.get(0).integer;
        for (StringInteger stringInteger : list){

            if (stringInteger.integer == integer){
                characters.add(stringInteger.string);
            }else {
                break;
            }

        }

        for (char ch: array){
            String str = "" + ch;
            if (characters.contains(str))
            return ch;
        }

        return ' ';

    }


}
