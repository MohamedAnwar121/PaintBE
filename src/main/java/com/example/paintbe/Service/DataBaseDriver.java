package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataBaseDriver implements IDataBaseDriver{
    private ArrayList<Shape> DataBase;

    public DataBaseDriver(){
        DataBase = new ArrayList<>();
    }

    @Override
    public void update(JSONObject shapeJSONObject) {
        Shape shape = this.getByID(shapeJSONObject.getString("id"));
        shape.fromJson(shapeJSONObject);
    }

    @Override
    public Shape getByID(String id) {
        for (Shape shape : DataBase){
            if (shape.getId().equals(id)){
                return shape;
            }
        }
        return null;
    }

    public ArrayList<Shape> getDataBase() {
        return DataBase;
    }

    @Override
    public Shape getByIndex(int index) {
        return DataBase.get(index);
    }

    @Override
    public int getDataBaseSize() {
        return DataBase.size();
    }

    @Override
    public void delete(String id) {
        Shape shape = this.getByID(id);
        if (shape != null) DataBase.remove(shape);
    }

    @Override
    public void add(Shape shape) {
        DataBase.add(shape);
    }
}
