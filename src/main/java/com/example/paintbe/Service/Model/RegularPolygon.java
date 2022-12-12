package com.example.paintbe.Service.Model;

import org.json.JSONObject;

public class RegularPolygon extends Polygon {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void fromJson(JSONObject object) {
        super.fromJson(object);
        if (object.has("radius")) this.setRadius(object.getInt("radius"));
    }

}
