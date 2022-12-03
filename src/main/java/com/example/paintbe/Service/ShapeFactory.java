package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.*;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        return switch (shapeType) {
            case "Square" -> new Square();
            case "Rectangle" -> new Rectangle();
            case "RegularPolygon" -> new RegularPolygon();
            case "Triangle" -> new Triangle();
            case "Ellipse" -> new Ellipse();
            case "Circle" -> new Circle();
            case "LineSegment" -> new LineSegment();
            default -> null;
        };
    }
}
