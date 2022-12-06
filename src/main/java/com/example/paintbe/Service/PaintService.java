package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;
import org.springframework.stereotype.Service;
import org.json.*;

import java.util.ArrayList;
import java.util.Stack;

@Service
public class PaintService {

    private final ShapeFactory shapeFactory;
    private DataBaseDriver dataBaseDriver;
    private StackDriver stackDriver;

    public PaintService(){
        shapeFactory = new ShapeFactory();
        dataBaseDriver = new DataBaseDriver();
        stackDriver = new StackDriver();
    }

    public void addNewShape(String shapeString){
        JSONObject shape = new JSONObject(shapeString);
        Shape shapeObject = shapeFactory.getShape(shape);
        dataBaseDriver.add(shapeObject);

        //Triplet<Shape, ArrayList<Shape>, String> triplet;

        //stackDriver.push((Stack<Object>) stackDriver.getUndo(),shapeObject.clone());
    }

    public String getLastID(){
        return dataBaseDriver.getByIndex(dataBaseDriver.getDataBaseSize() - 1).getId();
    }

    public ArrayList<Shape> getDataBase(){
        return dataBaseDriver.getDataBase();
    }

    /*public void dataBaseDriver(String operation,String id,String shapeString){
        new Operation(operation,DataBase.get)
    }*/

}
