package com.example.paintbe.Service.Shapes;

import org.json.JSONObject;

public class Circle extends EllipticalShape{

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void fromJson(JSONObject object) {
        super.fromJson(object);
        this.radius = object.getInt("radius");
    }
}
