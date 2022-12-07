package com.example.paintbe.Service.Shapes;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Shape implements Cloneable {
    private double x;
    private double y;
    private String fill = "white";
    private String stroke = "grey";
    private double strokeWidth = 2;
    private boolean draggable = false;
    private String id;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void fromJson(JSONObject object) {

        this.setX(object.getDouble("x"));
        this.setY(object.getDouble("y"));
        this.setStroke(object.getString("stroke"));
        this.setFill(object.getString("fill"));
        this.setStrokeWidth(object.getInt("strokeWidth"));
        this.setDraggable(object.getBoolean("draggable"));
        this.setId(String.valueOf(this.hashCode()));

    }


    @Override
    public Shape clone() {
        try {
            Shape clone = (Shape) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
