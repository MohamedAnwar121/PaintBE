package com.example.paintbe.Service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SaveService {


    public File save(String jsonStageAndType) {

        JSONObject jsonObject = new JSONObject(jsonStageAndType);
        String fileType = jsonObject.getString("fileType");

        System.out.println(fileType);
        JSONObject json = new JSONObject(jsonObject.getString("jsonStage"));
        System.out.println(json);
        return switch (fileType){
            case "JSON" -> constructJSONFile(json);
            case "XML" -> constructXMLFile(json);
            default -> null;
        };
    }

    private File constructXMLFile(JSONObject json){
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<root>" + XML.toString(json) + "</root>\n";

        File file = new File("SaveInXML.xml");
        try {
            FileWriter myWriter = new FileWriter("SaveInXML.xml");
            myWriter.write(xml);
            myWriter.close();
        } catch (IOException ignored) {}

        return file;
    }

    private File constructJSONFile(JSONObject json){
        File file = new File("SaveInJSON.json");
        try {
            FileWriter myWriter = new FileWriter("SaveInJSON.json");
            myWriter.write(json.toString());
            myWriter.close();
        } catch (IOException ignored) {}
        return file;
    }


}
