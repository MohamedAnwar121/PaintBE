package com.example.paintbe.Service.Shapes;

import org.json.JSONException;
import org.json.JSONObject;

public class Rectangle extends Polygon{
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void fromJson(JSONObject object){
        try{
            super.fromJson(object);
            this.setHeight(object.getInt("height"));
            this.setWidth(object.getInt("width"));
        }catch (JSONException ignored){}
    }
}
