package com.example.paintbe.Service.Shapes;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class LineSegment extends Shape{

    private ArrayList<Double> points;
    private boolean closed;

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

    @Override
    public void fromJson(JSONObject object){
        try{
            super.fromJson(object);
            this.setClosed(object.getBoolean("closed"));

            this.setPoints((ArrayList<Double>) object.
                    getJSONArray("points")
                    .toList()
                    .stream()
                    .map(ob -> (Double) ob)
                    .toList());
        }catch (JSONException ignored){}

    }


}
