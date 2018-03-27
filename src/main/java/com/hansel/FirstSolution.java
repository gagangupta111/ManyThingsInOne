package com.hansel;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NodeMap{

    private String miniName;
    private Map<String, NodeMap> map;

    public NodeMap(String miniName, Map<String, NodeMap> map) {
        this.miniName = miniName;
        this.map = map;
    }

    public String getMiniName() {
        return miniName;
    }

    public void setMiniName(String miniName) {
        this.miniName = miniName;
    }

    public Map<String, NodeMap> getMap() {
        return map;
    }

    public void setMap(Map<String, NodeMap> map) {
        this.map = map;
    }

}

public class FirstSolution {

    private static Map<String, NodeMap> map = new HashMap<>();

    private static final String FILENAME = "android.support.v4.text.LayoutManager -> android.support.v4.d.p\n" +
            "int getLayoutDirectionFromLocale() -> a\n" +
            "\tint getLayoutDirectionFromFirstChar() -> b\n" +
            "\tint getLayoutDirectionFromLocator() -> c\n" +
            "android.support.v4.text.SupportManager -> android.support.v4.d.q\n" +
            "\tint getSupportDirection() -> a\n" +
            "\tint getSupportLocation(int) -> b\n" +
            "\tint getName() -> c\n" +
            "android.support.v7.block.Moderator -> android.support.v7.d.q\n" +
            "\tvoid showDialog() -> a\n" +
            "\tvoid showName() -> b\n" +
            "\tvoid showDialog(String) -> a\n" +
            "\tvoid showDialog() ->a:";

    private static String inputString = "android.support.v4.text.LayoutManager.getLayoutDirectionFromLocale()";

    private static String findFunctionName(String inputString){

        return inputString.substring(inputString.lastIndexOf(".")+1, inputString.indexOf("("));

    }

    private static String findClassName(String inputString){

        return inputString.substring(inputString.lastIndexOf(".")+1, inputString.indexOf("("));

    }

    private static String findMiniClassName(String inputString){

        return inputString.substring(inputString.lastIndexOf(".")+1, inputString.indexOf("("));

    }

    private static String findMiniFunctionName(String inputString){

        return inputString.substring(inputString.lastIndexOf(" "), inputString.length());

    }

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader inputFile = null;
        BufferedReader string = null;

        List<String> list = new ArrayList<>();

        try {

            inputFile = new BufferedReader(new InputStreamReader(new ByteArrayInputStream( FILENAME.getBytes() ) ) );
            string = new BufferedReader(new InputStreamReader(new ByteArrayInputStream( inputString.getBytes() ) ) );
            String sCurrentLine;
            String toBeMatched;
            boolean flag = false;

            while ((toBeMatched = string.readLine()) != null) {

                flag = false;
                int firstIndex = toBeMatched.indexOf("(");
                int lastIndex = toBeMatched.indexOf(")");

                if ( firstIndex == -1 || lastIndex == -1){
                    System.out.println("Wrong input");
                    return;
                }

                String finalString = "";
                String toBeMatchedfunctionName = findFunctionName(toBeMatched);
                String toBeMatchedClassName = findMiniFunctionName(toBeMatched);

                NodeMap nodeMap = map.get(toBeMatchedClassName);

                if ( nodeMap != null){

                    finalString = finalString + nodeMap.getMiniName();
                    Map<String, NodeMap> map = nodeMap.getMap();

                    if (map.get(toBeMatchedfunctionName) != null){
                        finalString = finalString + "." + map.get(toBeMatchedfunctionName);
                        flag = true;
                    }

                }
                if (flag == false){

                    finalString = "";
                    NodeMap classNodeMap = null;
                    Map<String, NodeMap> functionNodeMap = new HashMap<>();

                    while ((sCurrentLine = inputFile.readLine()) != null) {

                        if (sCurrentLine.contains(toBeMatchedClassName)){

                            String miniClassName = sCurrentLine.substring(sCurrentLine.lastIndexOf(" "), sCurrentLine.length()-1);
                            finalString = finalString + miniClassName;

                            while ((sCurrentLine = inputFile.readLine()) != null && sCurrentLine.contains("(")) {

                                String newFunctionName = findFunctionName(sCurrentLine);
                                String miniFunctionName = findMiniFunctionName(sCurrentLine);
                                functionNodeMap.put(newFunctionName, new NodeMap(miniFunctionName, null));

                                if (sCurrentLine.contains(toBeMatchedfunctionName)){
                                    finalString = finalString + miniFunctionName;
                                }

                            }

                            classNodeMap = new NodeMap(miniClassName, functionNodeMap);
                            map.put(toBeMatchedClassName, classNodeMap);
                            break;

                        }

                    }

                }

                list.add(finalString);

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

        for (String str : list){

            System.out.println(str);

        }

        System.out.println(" Done Reading! ");

        }
}