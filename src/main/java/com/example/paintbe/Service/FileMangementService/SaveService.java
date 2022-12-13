package com.example.paintbe.Service.FileMangementService;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SaveService {

    public File createFile(String json) {

        JSONObject jsonObject = new JSONObject(json);
        String fileType = jsonObject.getString("fileType");
        String fileName = jsonObject.getString("fileName");

        JSONObject jsonStage = new JSONObject(jsonObject.getString("jsonStage"));

        return switch (fileType){
            case "JSON" -> constructJSONFile(jsonStage,fileName);
            case "XML" -> constructXMLFile(jsonStage,fileName);
            default -> null;
        };
    }

    private File constructXMLFile(JSONObject data,String fileName){
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<root>" + XML.toString(data) + "</root>\n";

        File file = new File(fileName.concat(".xml"));
        try {
            FileWriter myWriter = new FileWriter(fileName.concat(".xml"));
            myWriter.write(xml);
            myWriter.close();
        } catch (IOException ignored) {}

        return file;
    }

    private File constructJSONFile(JSONObject json,String fileName){
        File file = new File(fileName.concat(".json"));
        System.out.println(file.getName());
        try {
            FileWriter myWriter = new FileWriter(fileName.concat("json"));
            myWriter.write(json.toString());
            myWriter.close();
        } catch (IOException ignored) {}
        return file;
    }
}

