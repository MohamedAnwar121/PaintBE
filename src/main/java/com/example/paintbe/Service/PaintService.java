package com.example.paintbe.Service;

import com.example.paintbe.Repository.db.CRUDRepository;
import com.example.paintbe.Service.Model.Shape;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PaintService {

    /*private final ShapeFactory shapeFactory;
    private CRUDRepository dataBaseDriver;

    @Autowired
    public PaintService(ShapeFactory shapeFactory, CRUDRepository dataBaseDriver, StackDriver stackDriver) {
        this.shapeFactory = shapeFactory;
        this.dataBaseDriver = dataBaseDriver;
    }

    public void addNewShapeWithOperation(String shapeString, String operation) {
        *//*JSONObject shape = new JSONObject(shapeString);


        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<root>" + XML.toString(shape) + "</root>\n";

        File file = new File("SaveInXML.xml");
        try {
            FileWriter myWriter = new FileWriter("SaveInXML.xml");
            myWriter.write(xml);
            myWriter.close();
        } catch (IOException ignored) {
        }

        JSONObject json = XML.toJSONObject(xml);
        System.out.println(json.getJSONObject("root"));*//*


        Shape shapeObject = shapeFactory.getShape(shape);
        dataBaseDriver.add(shapeObject);

    }

    public void executeOperation(String operation) {

    }

    public String getLastID() {
        return dataBaseDriver.getByIndex(dataBaseDriver.getDataBaseSize() - 1).getId();
    }

    public ArrayList<Shape> getDataBase() {
        return dataBaseDriver.getDataBase();
    }*/


}
