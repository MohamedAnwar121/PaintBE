package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;
import org.json.JSONObject;

import java.util.ArrayList;

public interface IDataBaseDriver {

    void update(JSONObject newShapeJSONObject);

    ArrayList<Shape> getDataBase();
    Shape getByID(String id);

    Shape getByIndex(int index);

    int getDataBaseSize();

    void delete(String id);

    void add(Shape shape);

}
