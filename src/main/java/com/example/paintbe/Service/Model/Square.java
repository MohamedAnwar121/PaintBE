package com.example.paintbe.Service.Model;

import org.json.JSONException;
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
        try {
            super.fromJson(object);
            this.setSideLength(object.getInt("height"));
        } catch (JSONException ignored) {
        }
    }
}
