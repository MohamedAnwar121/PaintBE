package com.example.paintbe.Service.Shapes;

import org.json.JSONObject;

public abstract class Shape {
    private int x;
    private int y;
    private String fill;
    private String stroke;
    private int strokeWidth;
    private boolean draggable;
    private String id;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
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
        this.setX(object.getInt("x"));
        this.setY(object.getInt("y"));
        this.setStroke(object.getString("stroke"));
        this.setFill(object.getString("fill"));
        this.setStrokeWidth(object.getInt("strokeWidth"));
        this.setDraggable(object.getBoolean("draggable"));
        //this.setId(object.getString("id"));
    }


}
