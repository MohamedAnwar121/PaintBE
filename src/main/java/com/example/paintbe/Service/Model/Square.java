package com.example.paintbe.Service.Model;

import org.json.JSONObject;

public class Square extends Polygon{

    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void fromJson(JSONObject object) {
        super.fromJson(object);
        if (object.has("height")) this.setSideLength(object.getDouble("height"));
    }

    @Override
    public Square clone() {
        return (Square) super.clone();
    }
}
