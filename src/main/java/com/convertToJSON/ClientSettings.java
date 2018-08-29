package com.convertToJSON;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientSettings {

    public static void main(String[] args) throws IOException {

        ClientSettings_Strings clientSettings = new ClientSettings_Strings();
        clientSettings.integer = 100;
        clientSettings.list = new ArrayList<String>();
        clientSettings.list.add("String1");
        clientSettings.list.add("String2");

        ObjectMapper objectMapper = new ObjectMapper();
        String json1 = objectMapper.writeValueAsString(clientSettings);
        System.out.println(json1);

        ClientSettings_Objects clientSettings_Objects = new ClientSettings_Objects();
        clientSettings_Objects.integer = 100;
        clientSettings_Objects.list = new ArrayList<FileExtension>();
        clientSettings_Objects.list.add(new FileExtension("String1"));
        clientSettings_Objects.list.add(new FileExtension("String2"));

        String json2 = objectMapper.writeValueAsString(clientSettings_Objects);
        System.out.println(json2);

        ClientSettings_Objects objects = objectMapper.readValue(json1, ClientSettings_Objects.class);
        System.out.println(objectMapper.writeValueAsString(objects));

    }


    static class ClientSettings_Strings {

        public int integer;
        public List<String> list;

    }

    static class ClientSettings_Objects {

        public int integer;
        public List<FileExtension> list;

    }

    static class FileExtension{

        public FileExtension(String fileExt) {
            this.fileExt = fileExt;
        }

        public String fileExt;

    }

}
