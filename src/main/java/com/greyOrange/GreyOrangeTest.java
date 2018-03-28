package com.greyOrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GreyOrangeTest {

    public static void main(String[] args) throws IOException {

        System.out.println(" " + countOfSequences("1", "1"));

    }

    public static String countOfSequences(String N, String A){

        int numbers  = Integer.valueOf(N);
        int maxNumber = Integer.valueOf(A);

        Set<String> set = new HashSet<>();

        List<String> characterList = new ArrayList<>();
        int reach;
        boolean odd = false;
        if (maxNumber%2 != 0){
            reach = (maxNumber/2)+1;
        }else {
            reach = (maxNumber/2);
        }


        for (int i = 1; i <= reach; i++){

            characterList = new ArrayList<>();
            boolean needOne = numbers%i != 0;
            int howMany = numbers/i;

            for (int j = 0; j < howMany; j++){
                characterList.add( "" + i);
            }

            if (needOne){
                characterList.add("" + numbers%i);
            }

            set.add(getStringRepresentation(characterList));
            set.add(getOppositeStringRepresentation(characterList));
        }

        Set<String> newSet = new HashSet<>();
        for (String str : set){

            newSet.addAll(summation(str));
            newSet.addAll(loosenUp(str));

        }

        set.addAll(newSet);

        int count = 0;

        for (String str : set){

            Set<String> countSet = new HashSet<>();
            permute(str, 0, str.length()-1, countSet);
            count = count + countSet.size();

        }

        return "" + count;
    }

    public static Set<String> loosenUp(String string)
    {

        Set<String> newSet = new HashSet<>();
        String newString = string;


        int length  = string.length();
        int lowestIndex = 0;
        if (length%2 == 0){
            lowestIndex = (length/2)-1;
        }else {
            lowestIndex = (length/2);
        }

        while (!"1".equals(newString.substring(lowestIndex+1, lowestIndex+2))){
            newString = returnLoosenedUpString(newString);
            newSet.add(newString);
        }

        newSet.add(newString);
        return newSet;

    }

    public static String returnLoosenedUpString(String string)
    {


        int length  = string.length();
        int lowestIndex = 0;
        if (length%2 == 0){
            lowestIndex = (length/2)-1;
        }else {
            lowestIndex = (length/2);
        }

        List<String> characterList;
        int index = string.length()-1;
        while (index > lowestIndex){

            characterList = new ArrayList<>();
            int thisInt = Integer.parseInt(string.substring(index, index+1));
            if (thisInt > 1){

                if (index == string.length()-1){

                    String first = string.substring(0, string.length()-2);
                    int howMany = thisInt/1;

                    for (int j = 0; j < howMany; j++){
                        characterList.add( "" + 1);
                    }
                    return first + getStringRepresentation(characterList);

                }else {

                    String first = string.substring(0,  index-1);
                    int howMany = thisInt/1;

                    for (int j = 0; j < howMany; j++){
                        characterList.add( "" + 1);
                    }

                    String second = string.substring(index+1, string.length()-1);
                    return first + getStringRepresentation(characterList) + second;

                }

            }

            index--;
        }

        return "";

    }

    public static Set<String> summation(String string)
    {

        Set<String> newSet = new HashSet<>();

        String newString = string;
        while (newString.length() > 2){

            newSet.add(string);
            newString = getSummedUpString(newString);

        }

        newSet.add(newString);
        return newSet;

    }

    public static String getSummedUpString(String string)
    {

        if (string.length() == 2){
            return string;
        }

        String s = string.substring(0, string.length()-2);
        int a = Integer.parseInt(string.substring(string.length()-2, string.length()-1));
        int b = Integer.parseInt(string.substring(string.length()-1, string.length()-0));

        String newString = s + (a + b);
        return newString;

    }


    public static String getStringRepresentation(List<String> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(String ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public static String getOppositeStringRepresentation(List<String> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(int i = list.size()-1; i >= 0; i--)
        {
            builder.append(list.get(i));
        }
        return builder.toString();
    }

    private static void permute(String str, int l, int r, Set<String> set)
    {
        if (l == r)
            set.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r, set);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}

