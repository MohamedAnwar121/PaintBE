package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;
import org.springframework.stereotype.Service;
import org.json.*;

import java.util.ArrayList;

@Service
public class PaintService {

    private final ShapeFactory shapeFactory;

    private ArrayList<Shape> DataBase;

    public PaintService(){
        shapeFactory = new ShapeFactory();
        DataBase = new ArrayList<>();
    }

    public void addNewShape(String shapeString){
        JSONObject shape = new JSONObject(shapeString);
        Shape shapeObject = shapeFactory.getShape(shape.getString("className"));
        shapeObject.setX(shape.getJSONObject("attrs").getInt("x"));


        DataBase.add(shapeObject);
    }

    public ArrayList<Shape> getDataBase() {
        return DataBase;
    }
}
