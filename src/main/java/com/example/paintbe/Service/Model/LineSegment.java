package com.example.paintbe.Service.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LineSegment extends Shape {

    private ArrayList<Double> points;
    private boolean closed;
    private String lineCap;
    private String lineJoin;

    public ArrayList<Double> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Double> points) {
        this.points = points;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getLineCap() {
        return lineCap;
    }

    public void setLineCap(String lineCap) {
        this.lineCap = lineCap;
    }

    public String getLineJoin() {
        return lineJoin;
    }

    public void setLineJoin(String lineJoin) {
        this.lineJoin = lineJoin;
    }

    @Override
    public void fromJson(JSONObject object) {
        try {
            super.fromJson(object);
            this.setClosed(object.getBoolean("closed"));
            this.setLineCap(object.getString("lineCap"));
            this.setLineJoin(object.getString("lineJoin"));
            this.setPoints((ArrayList<Double>) object.
                    getJSONArray("points")
                    .toList()
                    .stream()
                    .map(ob -> (Double) ob)
                    .toList());
        } catch (JSONException ignored) {}
    }
}
