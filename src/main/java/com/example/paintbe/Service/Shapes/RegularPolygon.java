package com.example.paintbe.Service.Shapes;

import org.json.JSONException;
import org.json.JSONObject;

public class RegularPolygon extends Polygon{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void fromJson(JSONObject object){
        try{
            super.fromJson(object);
            this.setRadius(object.getInt("radius"));
        }catch (JSONException ignored){}

    }

}
