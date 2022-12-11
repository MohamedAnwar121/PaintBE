package com.example.paintbe.Service.Model;

import org.json.JSONObject;

import java.util.UUID;

public abstract class Shape implements Cloneable {
    private double x;
    private double y;
    private String fill = "white";
    private String stroke = "grey";
    private double scaleX;
    private double scaleY;
    private double strokeWidth = 2;
    private boolean draggable = false;
    private String id = UUID.randomUUID().toString();

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

    public double getScaleX() {
        return scaleX;
    }

    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
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
        this.setScaleX(object.getDouble("scaleX"));
        this.setScaleY(object.getDouble("scaleY"));
    }

    public void generateUniqueID(){
        UUID uuid = UUID.randomUUID();
        String least = Long.toString(uuid.getMostSignificantBits());
        String most = Long.toString(uuid.getLeastSignificantBits());
        if (least.charAt(0) == '-') least = least.substring(1);
        if (most.charAt(0) == '-') most = most.substring(1);
        id =  least + most;
    }

    /*public JSONObject toJson(){
        JSONObject json =  new JSONObject();
        json.put("x",this.getX());
        json.put("y",this.getY());
        json.put("fill",this.getFill());
    }*/

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
