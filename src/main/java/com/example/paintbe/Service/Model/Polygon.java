package com.example.paintbe.Service.Model;

import org.json.JSONObject;

public abstract class Polygon extends Shape {
    private int sides;

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public void fromJson(JSONObject object) {
        super.fromJson(object);
        if (object.has("sides")) this.setSides(object.getInt("sides"));
    }
}
