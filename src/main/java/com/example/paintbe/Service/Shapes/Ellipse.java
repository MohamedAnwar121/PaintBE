package com.example.paintbe.Service.Shapes;

import org.json.JSONObject;

public class Ellipse extends EllipticalShape{
    private int radiusX;
    private int radiusY;


    public int getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    @Override
    public void fromJson(JSONObject object){
        super.fromJson(object);
        this.setRadiusX(object.getInt("radiusX"));
        this.setRadiusY(object.getInt("radiusY"));
    }
}
