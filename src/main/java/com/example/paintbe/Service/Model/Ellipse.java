package com.example.paintbe.Service.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Ellipse extends EllipticalShape {
    private double radiusX;
    private double radiusY;

    public double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

    @Override
    public void fromJson(JSONObject object) {
        try {
            super.fromJson(object);
            this.setRadiusX(object.getInt("radiusX"));
            this.setRadiusY(object.getInt("radiusY"));
        } catch (JSONException ignored) {
        }
    }

}
