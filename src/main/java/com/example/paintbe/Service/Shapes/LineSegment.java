package com.example.paintbe.Service.Shapes;

import org.json.JSONObject;
import java.util.ArrayList;

public class LineSegment extends Shape{

    private ArrayList<Integer> points;
    private boolean closed;

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
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
        super.fromJson(object);
        this.setClosed(object.getBoolean("closed"));

        this.setPoints((ArrayList<Integer>) object.
                getJSONArray("points")
                .toList()
                .stream()
                .map(ob -> (Integer) ob)
                .toList());
    }
}
