package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        VCSSyncPreconditionsDTOMap vcsSyncPreconditionsDTOMap = new VCSSyncPreconditionsDTOMap();
        vcsSyncPreconditionsDTOMap.messageCode = "messageCode";

        List<CheckedOutFile> checkedOutFiles = new ArrayList<>();
        CheckedOutFile file  = new CheckedOutFile();
        file.id = 10;
        file.name = "name";
        file.path = "path";
        file.userName = "username";
        checkedOutFiles.add(file);

        file  = new CheckedOutFile();
        file.id = 11;
        file.name = "name1";
        file.path = "path1";
        file.userName = "username1";
        checkedOutFiles.add(file);

        vcsSyncPreconditionsDTOMap.messageData = new HashMap<>();
        vcsSyncPreconditionsDTOMap.messageData.put("oldHost", "oldHost");
        vcsSyncPreconditionsDTOMap.messageData.put("oldRepo", "oldRepo");
        vcsSyncPreconditionsDTOMap.messageData.put("checkedOutFiles", checkedOutFiles);

        String json  = mapper.writeValueAsString(vcsSyncPreconditionsDTOMap);
        System.out.println("json" + json);

        VCSSyncPreconditionsDTONoMap noMapFromJson = mapper.readValue(json, VCSSyncPreconditionsDTONoMap.class);
        System.out.println("noMapFromJson" + mapper.writeValueAsString(vcsSyncPreconditionsDTOMap));

        VCSSyncPreconditionsDTONoMap noMap = new VCSSyncPreconditionsDTONoMap();
        noMap.messageCode = "messageCode";

        noMap.messageData = new MessageData();
        noMap.messageData.oldHost = "oldHost";
        noMap.messageData.oldRepo = "oldHost";
        noMap.messageData.checkedOutFiles = checkedOutFiles;

        System.out.println( "noMap"  + mapper.writeValueAsString(noMap) );

    }

}


class CheckedOutFile {
    public long id;
    public String name;
    public String path;
    public String userName;
}


class MessageData {

    public String oldHost;
    public String oldRepo;
    public List<CheckedOutFile> checkedOutFiles;

}


class VCSSyncPreconditionsDTONoMap {

    public String messageCode;
    public MessageData messageData;

}


class VCSSyncPreconditionsDTOMap {

    public String messageCode;
    public Map<Object, Object> messageData;

}
