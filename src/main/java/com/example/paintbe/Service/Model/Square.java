package com.example.paintbe.Service.Model;

import org.json.JSONObject;

public class Square extends Polygon {
    private int sideLength;

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void fromJson(JSONObject object) {
        super.fromJson(object);
        if (object.has("height")) this.setSideLength(object.getInt("height"));
    }
}
