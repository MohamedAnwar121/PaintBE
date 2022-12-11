package com.example.paintbe.Service.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Circle extends EllipticalShape {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void fromJson(JSONObject object) {
        try {
            super.fromJson(object);
            this.radius = object.getInt("radius");
        } catch (JSONException ignored) {
        }
    }



    @Override
    public Circle clone() {
        super.clone();
        return (Circle) super.clone();
    }
}
