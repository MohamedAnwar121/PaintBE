package com.example.paintbe.Service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SaveService {

    /**
     * @param jsonStage get konva stage from front end as jsonString
     * @param fileType user selects type of file to save dataIn (Xml or JSON)
     * @return created file which was selected
     */
    public File save(String jsonStage, String fileType) {
        JSONObject json = new JSONObject(jsonStage);
        return switch (fileType){
            case "JSON" -> constructJSONFile(json);
            case "XMl" -> constructXMLFile(json);
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
