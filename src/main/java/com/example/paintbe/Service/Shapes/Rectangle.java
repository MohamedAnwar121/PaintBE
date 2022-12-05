package com.example.paintbe.Service.Shapes;

import org.json.JSONObject;

public class Rectangle extends Polygon{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void fromJson(JSONObject object){
        super.fromJson(object);
        this.setHeight(object.getInt("height"));
        this.setWidth(object.getInt("width"));
    }
}
