package com.hansel;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;

class NodeMap{

    private String miniName;
    private Map<String, ClassValue> map;

    public NodeMap(String miniName, Map<String, ClassValue> map) {
        this.miniName = miniName;
        this.map = map;
    }

    public String getMiniName() {
        return miniName;
    }

    public void setMiniName(String miniName) {
        this.miniName = miniName;
    }

    public Map<String, ClassValue> getMap() {
        return map;
    }

    public void setMap(Map<String, ClassValue> map) {
        this.map = map;
    }
}


public class FirstSolution {

    private static final String FILENAME = "android.support.v4.text.LayoutManager -> android.support.v4.d.p:\n" +
            "int getLayoutDirectionFromLocale() -> a\n" +
            "\tint getLayoutDirectionFromFirstChar() -> b\n" +
            "\tint getLayoutDirectionFromLocator() -> c\n" +
            "android.support.v4.text.SupportManager -> android.support.v4.d.q:\n" +
            "\tint getSupportDirection() -> a\n" +
            "\tint getSupportLocation(int) -> b\n" +
            "\tint getName() -> c\n" +
            "android.support.v7.block.Moderator -> android.support.v7.d.q:\n" +
            "\tvoid showDialog() -> a\n" +
            "\tvoid showName() -> b\n" +
            "\tvoid showDialog(String) -> a\n" +
            "\tvoid showDialog() ->a:";

    private static String inputString = "android.support.v4.text.LayoutManager.getLayoutDirectionFromLocale(Class1,Class2)\n" +
            "android.support.v4.text.LayoutManager.getLayoutDirectionFromLocator()\n" +
            "android.support.v7.block.Moderator.showDialog(String, String)\n";

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader inputFile = null;
        BufferedReader string = null;

        try {

            inputFile = new BufferedReader(new InputStreamReader(new ByteArrayInputStream( FILENAME.getBytes() ) ) );
            string = new BufferedReader(new InputStreamReader(new ByteArrayInputStream( inputString.getBytes() ) ) );
            String sCurrentLine;
            String toBeMatched;

            while ((toBeMatched = string.readLine()) != null) {

                System.out.println("toBeMatched : " + toBeMatched);

                while ((sCurrentLine = inputFile.readLine()) != null) {
                    System.out.println(sCurrentLine);
                }

                inputFile.reset();

            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (inputFile != null)
                    inputFile.close();

                if (fr != null)
                    fr.close();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }

        System.out.println(" Done Reading! ");

        }
}